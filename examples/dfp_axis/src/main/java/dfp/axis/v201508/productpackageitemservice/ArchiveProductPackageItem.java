// Copyright 2015 Google Inc. All Rights Reserved.
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

package dfp.axis.v201508.productpackageitemservice;

import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.dfp.axis.factory.DfpServices;
import com.google.api.ads.dfp.axis.utils.v201508.StatementBuilder;
import com.google.api.ads.dfp.axis.v201508.ProductPackageItem;
import com.google.api.ads.dfp.axis.v201508.ProductPackageItemPage;
import com.google.api.ads.dfp.axis.v201508.ProductPackageItemServiceInterface;
import com.google.api.ads.dfp.axis.v201508.UpdateResult;
import com.google.api.ads.dfp.lib.client.DfpSession;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.collect.Iterables;

import java.util.Arrays;

/**
 * This example archives a product package item. To determine which product 
 * package items exist, run GetAllProductPackageItems.java.
 *
 * Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class ArchiveProductPackageItem {
  
  // Set the ID of the product package item to archive.
  private static final String PRODUCT_PACKAGE_ITEM_ID =
      "INSERT_PRODUCT_PACKAGE_ITEM_ID_HERE";

  public static void runExample(DfpServices dfpServices, DfpSession session,
      long productPackageItemId)
      throws Exception {
    // Get the ProductPackageItemItemService.
    ProductPackageItemServiceInterface productPackageItemService =
        dfpServices.get(session, ProductPackageItemServiceInterface.class);

    // Create a statement to select a single product package item.
    StatementBuilder statementBuilder = new StatementBuilder()
        .where("id = :id")
        .orderBy("id ASC")
        .limit(1)
        .withBindVariableValue("id", productPackageItemId);
    
    // Get the product package item.
    ProductPackageItemPage page =
        productPackageItemService.getProductPackageItemsByStatement(
            statementBuilder.toStatement());

    ProductPackageItem productPackageItemItem = Iterables.getOnlyElement(
        Arrays.asList(page.getResults()));

    System.out.printf("Product package with ID %d will be archived.%n",
        productPackageItemItem.getId());
    
    // Remove limit and offset from statement.
    statementBuilder.removeLimitAndOffset();
    
    // Create action to archive product package items.
    com.google.api.ads.dfp.axis.v201508.ArchiveProductPackageItems action = 
        new com.google.api.ads.dfp.axis.v201508.ArchiveProductPackageItems();
    
    // Perform action.
    UpdateResult result =
        productPackageItemService.performProductPackageItemAction(
            action, statementBuilder.toStatement());

    if (result != null && result.getNumChanges() > 0) {
      System.out.printf("Number of product package items archived: %d%n",
          result.getNumChanges());
    } else {
      System.out.println("No product package items were archived.");
    }
  }

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.DFP)
        .fromFile()
        .build()
        .generateCredential();

    // Construct a DfpSession.
    DfpSession session = new DfpSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    DfpServices dfpServices = new DfpServices();

    runExample(dfpServices, session, Long.parseLong(PRODUCT_PACKAGE_ITEM_ID));
  }
}
