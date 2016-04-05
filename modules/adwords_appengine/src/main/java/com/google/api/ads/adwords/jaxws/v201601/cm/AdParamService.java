
package com.google.api.ads.adwords.jaxws.v201601.cm;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "AdParamService", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201601", wsdlLocation = "https://adwords.google.com/api/adwords/cm/v201601/AdParamService?wsdl")
public class AdParamService
    extends Service
{

    private final static URL ADPARAMSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADPARAMSERVICE_EXCEPTION;
    private final static QName ADPARAMSERVICE_QNAME = new QName("https://adwords.google.com/api/adwords/cm/v201601", "AdParamService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://adwords.google.com/api/adwords/cm/v201601/AdParamService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADPARAMSERVICE_WSDL_LOCATION = url;
        ADPARAMSERVICE_EXCEPTION = e;
    }

    public AdParamService() {
        super(__getWsdlLocation(), ADPARAMSERVICE_QNAME);
    }

    public AdParamService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns AdParamServiceInterface
     */
    @WebEndpoint(name = "AdParamServiceInterfacePort")
    public AdParamServiceInterface getAdParamServiceInterfacePort() {
        return super.getPort(new QName("https://adwords.google.com/api/adwords/cm/v201601", "AdParamServiceInterfacePort"), AdParamServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdParamServiceInterface
     */
    @WebEndpoint(name = "AdParamServiceInterfacePort")
    public AdParamServiceInterface getAdParamServiceInterfacePort(WebServiceFeature... features) {
        return super.getPort(new QName("https://adwords.google.com/api/adwords/cm/v201601", "AdParamServiceInterfacePort"), AdParamServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADPARAMSERVICE_EXCEPTION!= null) {
            throw ADPARAMSERVICE_EXCEPTION;
        }
        return ADPARAMSERVICE_WSDL_LOCATION;
    }

}
