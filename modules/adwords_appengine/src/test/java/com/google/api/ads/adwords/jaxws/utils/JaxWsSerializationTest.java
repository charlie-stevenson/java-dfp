// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.jaxws.utils;

import static org.junit.Assert.assertNotNull;

import com.google.api.ads.adwords.jaxws.utils.v201509.batchjob.BatchJobMutateRequest;
import com.google.api.ads.adwords.jaxws.v201509.cm.AdGroup;
import com.google.api.ads.adwords.jaxws.v201509.cm.AdGroupOperation;
import com.google.api.ads.adwords.jaxws.v201509.cm.AdvertisingChannelType;
import com.google.api.ads.adwords.jaxws.v201509.cm.Campaign;
import com.google.api.ads.adwords.jaxws.v201509.cm.CampaignOperation;
import com.google.api.ads.adwords.jaxws.v201509.cm.Operator;
import com.google.api.ads.common.lib.soap.jaxb.JaxBSerializer;
import com.google.common.io.CharStreams;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.namespace.QName;

/**
 * Tests for JAX-WS serialization.
 */
@RunWith(JUnit4.class)
public class JaxWsSerializationTest {

  @SuppressWarnings("cast")
  @Test
  public void testSerializeBatchJobMutateRequest() throws IOException, SAXException {
    BatchJobMutateRequest request = new BatchJobMutateRequest();

    CampaignOperation campaignOp = new CampaignOperation();
    campaignOp.setOperator(Operator.ADD);
    Campaign campaign = new Campaign();
    campaign.setId(-1L);
    campaign.setName("Test campaign");
    campaign.setAdvertisingChannelType(AdvertisingChannelType.SEARCH);
    campaignOp.setOperand(campaign);

    request.addOperation(campaignOp);

    AdGroupOperation adGroupOp = new AdGroupOperation();
    adGroupOp.setOperator(Operator.ADD);
    AdGroup adGroup = new AdGroup();
    adGroup.setName("Test ad group");
    adGroup.setCampaignId(campaign.getId());
    adGroupOp.setOperand(adGroup);
    request.addOperation(adGroupOp);

    JaxBSerializer<BatchJobMutateRequest> serializer = new JaxBSerializer<BatchJobMutateRequest>(
        BatchJobMutateRequest.class,
        new QName("https://adwords.google.com/api/adwords/cm/v201509", "mutate"));

    String serializedRequest = serializer.serialize((BatchJobMutateRequest) request);

    assertNotNull("Null serialized request returned", serializedRequest);

    String expectedSerializedRequest = CharStreams.toString(new InputStreamReader(
        JaxWsSerializationTest.class.getResourceAsStream("resources/BatchJobMutate.request.xml")));

    XMLAssert.assertXMLEqual("Serialized request does not match expected value",
        expectedSerializedRequest, serializedRequest);

    serializedRequest = serializer.serialize((BatchJobMutateRequest) request, false);

    expectedSerializedRequest = expectedSerializedRequest.replaceFirst(
        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
    XMLAssert.assertXMLEqual(
        "Serialized request with XML declaration excluded does not match expected value",
        expectedSerializedRequest, serializedRequest);
  }
}

