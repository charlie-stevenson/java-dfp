// Copyright 2016 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package adwords.axis.v201601.campaignmanagement;

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.axis.utils.v201601.SelectorBuilder;
import com.google.api.ads.adwords.axis.utils.v201601.batchjob.BatchJobHelper;
import com.google.api.ads.adwords.axis.utils.v201601.batchjob.BatchJobMutateResponse;
import com.google.api.ads.adwords.axis.utils.v201601.batchjob.MutateResult;
import com.google.api.ads.adwords.axis.v201601.cm.AdGroupCriterionOperation;
import com.google.api.ads.adwords.axis.v201601.cm.ApiException;
import com.google.api.ads.adwords.axis.v201601.cm.BatchJob;
import com.google.api.ads.adwords.axis.v201601.cm.BatchJobError;
import com.google.api.ads.adwords.axis.v201601.cm.BatchJobErrorReason;
import com.google.api.ads.adwords.axis.v201601.cm.BatchJobOperation;
import com.google.api.ads.adwords.axis.v201601.cm.BatchJobProcessingError;
import com.google.api.ads.adwords.axis.v201601.cm.BatchJobServiceInterface;
import com.google.api.ads.adwords.axis.v201601.cm.BatchJobStatus;
import com.google.api.ads.adwords.axis.v201601.cm.BiddableAdGroupCriterion;
import com.google.api.ads.adwords.axis.v201601.cm.Keyword;
import com.google.api.ads.adwords.axis.v201601.cm.KeywordMatchType;
import com.google.api.ads.adwords.axis.v201601.cm.Operator;
import com.google.api.ads.adwords.axis.v201601.cm.Selector;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.selectorfields.v201601.cm.BatchJobField;
import com.google.api.ads.adwords.lib.utils.BatchJobUploadResponse;
import com.google.api.ads.adwords.lib.utils.BatchJobUploadStatus;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.collect.Sets;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 * This code sample illustrates how to perform asynchronous requests using BatchJobService
 * and incremental uploads of operations. It also demonstrates how to cancel a running
 * batch job.
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class AddKeywordsUsingIncrementalBatchJob {

  private static final long NUMBER_OF_KEYWORDS_TO_ADD = 100;
  private static final int KEYWORDS_PER_UPLOAD = 10;
  private static final int MAX_POLL_ATTEMPTS = 5;
  private static final Set<BatchJobStatus> PENDING_STATUSES =
      Sets.newHashSet(
          BatchJobStatus.ACTIVE, BatchJobStatus.AWAITING_FILE, BatchJobStatus.CANCELING);

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.ADWORDS)
        .fromFile()
        .build()
        .generateCredential();

    // Construct an AdWordsSession.
    AdWordsSession session = new AdWordsSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    long adGroupId = Long.parseLong("INSERT_AD_GROUP_ID_HERE");

    AdWordsServices adWordsServices = new AdWordsServices();

    runExample(adWordsServices, session, adGroupId);
  }

  public static void runExample(
      AdWordsServices adWordsServices, AdWordsSession session, Long adGroupId) throws Exception {
    // Get the BatchJobService.
    BatchJobServiceInterface batchJobService =
        adWordsServices.get(session, BatchJobServiceInterface.class);
    
    BatchJobOperation addOp = new BatchJobOperation();
    addOp.setOperator(Operator.ADD);
    addOp.setOperand(new BatchJob());

    BatchJob batchJob = batchJobService.mutate(new BatchJobOperation[] {addOp}).getValue(0);

    System.out.printf("Created BatchJob with ID %d, status '%s' and upload URL %s.%n",
        batchJob.getId(), batchJob.getStatus(), batchJob.getUploadUrl());
    
    // Create a BatchJobHelper for uploading operations.
    BatchJobHelper batchJobHelper = new BatchJobHelper(session);
    BatchJobUploadStatus batchJobUploadStatus = new BatchJobUploadStatus(0, 
        URI.create(batchJob.getUploadUrl().getUrl()));
    
    List<AdGroupCriterionOperation> operations = new ArrayList<AdGroupCriterionOperation>();

    // Create AdGroupCriterionOperations to add keywords, and upload every 10 operations
    // incrementally.
    for (int i = 0; i < NUMBER_OF_KEYWORDS_TO_ADD; i++) {
      // Create Keyword.
      String text = String.format("mars%d", i);

      // Make 10% of keywords invalid to demonstrate error handling.
      if (i % 10 == 0) {
        text = text + "!!!";
      }
      Keyword keyword = new Keyword();
      keyword.setText(text);
      keyword.setMatchType(KeywordMatchType.BROAD);

      // Create BiddableAdGroupCriterion.
      BiddableAdGroupCriterion bagc = new BiddableAdGroupCriterion();
      bagc.setAdGroupId(adGroupId);
      bagc.setCriterion(keyword);

      // Create AdGroupCriterionOperation.
      AdGroupCriterionOperation agco = new AdGroupCriterionOperation();
      agco.setOperand(bagc);
      agco.setOperator(Operator.ADD);

      // Add to the list of operations.
      operations.add(agco);
      
      // If the current list of operations has reached KEYWORDS_PER_UPLOAD or this is the last
      // operation, upload the current list of operations.
      boolean isLastOperation = i == NUMBER_OF_KEYWORDS_TO_ADD - 1;
      if (operations.size() == KEYWORDS_PER_UPLOAD || isLastOperation) {
        BatchJobUploadResponse uploadResponse =
            batchJobHelper.uploadIncrementalBatchJobOperations(
                operations, isLastOperation, batchJobUploadStatus);
        System.out.printf("Uploaded %d operations for batch job with ID %d.%n",
            operations.size(), batchJob.getId());
        
        // Set the batch job upload status and clear the operations list in preparation for the
        // next upload.
        batchJobUploadStatus = uploadResponse.getBatchJobUploadStatus();
        operations.clear();
      }
    }

    // Poll for completion of the batch job using an exponential back off.
    int pollAttempts = 0;
    boolean isPending = true;
    boolean wasCancelRequested = false;
    
    Selector selector =
        new SelectorBuilder()
            .fields(
                BatchJobField.Id,
                BatchJobField.Status,
                BatchJobField.DownloadUrl,
                BatchJobField.ProcessingErrors,
                BatchJobField.ProgressStats)
            .equalsId(batchJob.getId())
            .build();
    do {
      long sleepSeconds = (long) Math.scalb(30, pollAttempts);
      System.out.printf("Sleeping %d seconds...%n", sleepSeconds);
      Thread.sleep(sleepSeconds * 1000);

      batchJob = batchJobService.get(selector).getEntries(0);
      System.out.printf(
          "Batch job ID %d has status '%s'.%n", batchJob.getId(), batchJob.getStatus());

      pollAttempts++;
      isPending = PENDING_STATUSES.contains(batchJob.getStatus());
      
      // Optional: Cancel the job if it has not completed after polling MAX_POLL_ATTEMPTS
      // times.
      if (isPending && !wasCancelRequested && pollAttempts == MAX_POLL_ATTEMPTS) {
        batchJob.setStatus(BatchJobStatus.CANCELING);
        BatchJobOperation batchJobSetOperation = new BatchJobOperation();
        batchJobSetOperation.setOperand(batchJob);
        batchJobSetOperation.setOperator(Operator.SET);
        
        // Only request cancellation once per job.
        wasCancelRequested = true;
        try {
          batchJob =
              batchJobService.mutate(new BatchJobOperation[] {batchJobSetOperation}).getValue(0);
          System.out.printf("Requested cancellation of batch job with ID %d.%n", batchJob.getId());
        } catch (ApiException e) {
          if (e.getErrors() != null
              && e.getErrors().length > 0
              && e.getErrors(0) instanceof BatchJobError) {
            BatchJobError batchJobError = (BatchJobError) e.getErrors(0);
            if (BatchJobErrorReason.INVALID_STATE_CHANGE.equals(batchJobError.getReason())) {
              System.out.printf(
                  "Attempt to cancel batch job with ID %d was rejected because the job already "
                      + "completed or was canceled.",
                  batchJob.getId());
              continue;
            }
          }
          throw e;
        } finally {
          // Reset the poll attempt counter to wait for cancellation.
          pollAttempts = 0;
        }
      }
    } while (isPending && pollAttempts < MAX_POLL_ATTEMPTS);

    if (isPending) {
      throw new TimeoutException(
          "Job is still in pending state after polling " + MAX_POLL_ATTEMPTS + " times.");
    }

    if (batchJob.getProcessingErrors() != null) {
      int errorIndex = 0;
      for (BatchJobProcessingError processingError : batchJob.getProcessingErrors()) {
        System.out.printf(
            "  Processing error [%d]: errorType=%s, trigger=%s, errorString=%s, fieldPath=%s"
                + ", reason=%s%n",
            errorIndex++,
            processingError.getApiErrorType(),
            processingError.getTrigger(),
            processingError.getErrorString(),
            processingError.getFieldPath(),
            processingError.getReason());
      }
    } else {
      System.out.println("No processing errors found.");
    }

    if (batchJob.getDownloadUrl() != null && batchJob.getDownloadUrl().getUrl() != null) {
      BatchJobMutateResponse mutateResponse =
          batchJobHelper.downloadBatchJobMutateResponse(batchJob.getDownloadUrl().getUrl());
      System.out.printf("Downloaded results from %s:%n", batchJob.getDownloadUrl().getUrl());
      for (MutateResult mutateResult : mutateResponse.getMutateResults()) {
        String outcome = mutateResult.getErrorList() == null ? "SUCCESS" : "FAILURE";
        System.out.printf("  Operation [%d] - %s%n", mutateResult.getIndex(), outcome);
      }
    } else {
      System.out.println("No results available for download.");
    }
  }
}
