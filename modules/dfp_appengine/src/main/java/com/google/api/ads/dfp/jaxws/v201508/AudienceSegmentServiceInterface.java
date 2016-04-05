
package com.google.api.ads.dfp.jaxws.v201508;

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
 *       Provides operations for creating, updating and retrieving {@link AudienceSegment} objects.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "AudienceSegmentServiceInterface", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AudienceSegmentServiceInterface {


    /**
     * 
     *         Creates new {@link RuleBasedFirstPartyAudienceSegment} objects.
     *         
     *         @param segments first-party audience segments to create
     *         @return created first-party audience segments
     *       
     * 
     * @param segments
     * @return
     *     returns java.util.List<com.google.api.ads.dfp.jaxws.v201508.FirstPartyAudienceSegment>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
    @RequestWrapper(localName = "createAudienceSegments", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfacecreateAudienceSegments")
    @ResponseWrapper(localName = "createAudienceSegmentsResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfacecreateAudienceSegmentsResponse")
    public List<FirstPartyAudienceSegment> createAudienceSegments(
        @WebParam(name = "segments", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
        List<FirstPartyAudienceSegment> segments)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Gets an {@link AudienceSegmentPage} of {@link AudienceSegment} objects that satisfy the given
     *         {@link Statement#query}. The following fields are supported for filtering:
     *         
     *         <table>
     *         <tr>
     *         <th scope="col">PQL Property</th>
     *         <th scope="col">Object Property</th>
     *         </tr>
     *         <tr>
     *         <td>{@code id}</td>
     *         <td>{@link AudienceSegment#id}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code name}</td>
     *         <td>{@link AudienceSegment#name}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code status}</td>
     *         <td>{@link AudienceSegment#status}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code type}</td>
     *         <td>{@link AudienceSegment#type}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code size}</td>
     *         <td>{@link AudienceSegment#size}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code dataProviderName}</td>
     *         <td>{@link AudienceSegmentDataProvider#name}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code approvalStatus}</td>
     *         <td>{@link ThirdPartyAudienceSegment#approvalStatus}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code cost}</td>
     *         <td>{@link ThirdPartyAudienceSegment#cost}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code startDateTime}</td>
     *         <td>{@link ThirdPartyAudienceSegment#startDateTime}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code endDateTime}</td>
     *         <td>{@link ThirdPartyAudienceSegment#endDateTime}</td>
     *         </tr>
     *         </table>
     *         
     *         @param filterStatement a Publisher Query Language statement used to filter a set of audience
     *         segments
     *         @return the audience segments that match the given filter
     *       
     * 
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
    @RequestWrapper(localName = "getAudienceSegmentsByStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfacegetAudienceSegmentsByStatement")
    @ResponseWrapper(localName = "getAudienceSegmentsByStatementResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfacegetAudienceSegmentsByStatementResponse")
    public AudienceSegmentPage getAudienceSegmentsByStatement(
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Performs the given {@link AudienceSegmentAction} on the set of segments identified by the given
     *         statement.
     *         
     *         @param action {@link AudienceSegmentAction} to perform
     *         @param filterStatement a Publisher Query Language statement used to filter a set of audience
     *         segments
     *         @return {@link UpdateResult} indicating the result
     *       
     * 
     * @param filterStatement
     * @param action
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201508.UpdateResult
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
    @RequestWrapper(localName = "performAudienceSegmentAction", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfaceperformAudienceSegmentAction")
    @ResponseWrapper(localName = "performAudienceSegmentActionResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfaceperformAudienceSegmentActionResponse")
    public UpdateResult performAudienceSegmentAction(
        @WebParam(name = "action", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
        AudienceSegmentAction action,
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Updates the given {@link RuleBasedFirstPartyAudienceSegment} objects.
     *         
     *         @param segments first-party audience segments to update
     *         @return updated first-party audience segments
     *       
     * 
     * @param segments
     * @return
     *     returns java.util.List<com.google.api.ads.dfp.jaxws.v201508.FirstPartyAudienceSegment>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
    @RequestWrapper(localName = "updateAudienceSegments", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfaceupdateAudienceSegments")
    @ResponseWrapper(localName = "updateAudienceSegmentsResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508", className = "com.google.api.ads.dfp.jaxws.v201508.AudienceSegmentServiceInterfaceupdateAudienceSegmentsResponse")
    public List<FirstPartyAudienceSegment> updateAudienceSegments(
        @WebParam(name = "segments", targetNamespace = "https://www.google.com/apis/ads/publisher/v201508")
        List<FirstPartyAudienceSegment> segments)
        throws ApiException_Exception
    ;

}
