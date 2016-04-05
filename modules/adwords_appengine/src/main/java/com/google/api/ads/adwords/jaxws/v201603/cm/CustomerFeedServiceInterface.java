
package com.google.api.ads.adwords.jaxws.v201603.cm;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *       Service used to manage customer feed links, and matching functions.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "CustomerFeedServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerFeedServiceInterface {


    /**
     * 
     *         Returns a list of customer feeds that meet the selector criteria.
     *         
     *         @param selector Determines which customer feeds to return. If empty, all
     *         customer feeds are returned.
     *         @return The list of customer feeds.
     *         @throws ApiException Indicates a problem with the request.
     *       
     * 
     * @param selector
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
    @RequestWrapper(localName = "get", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedServiceInterfaceget")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedServiceInterfacegetResponse")
    public CustomerFeedPage get(
        @WebParam(name = "selector", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
        Selector selector)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Adds, sets, or removes customer feeds.
     *         
     *         @param operations The operations to apply.
     *         @return The resulting feeds.
     *         @throws ApiException Indicates a problem with the request.
     *       
     * 
     * @param operations
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedReturnValue
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
    @RequestWrapper(localName = "mutate", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedServiceInterfacemutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedServiceInterfacemutateResponse")
    public CustomerFeedReturnValue mutate(
        @WebParam(name = "operations", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
        List<CustomerFeedOperation> operations)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Returns the list of customer feeds that match the query.
     *         
     *         @param query The SQL-like AWQL query string.
     *         @return A list of CustomerFeed.
     *         @throws ApiException If problems occur while parsing the query or fetching CustomerFeed.
     *       
     * 
     * @param query
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
    @RequestWrapper(localName = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedServiceInterfacequery")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.CustomerFeedServiceInterfacequeryResponse")
    public CustomerFeedPage query(
        @WebParam(name = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
        String query)
        throws ApiException_Exception
    ;

}
