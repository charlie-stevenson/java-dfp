
package com.google.api.ads.dfp.jaxws.v201502;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             An Ad Exchange dynamic allocation creative.
 *           
 * 
 * <p>Java class for AdExchangeCreative complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdExchangeCreative">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.google.com/apis/ads/publisher/v201502}HasHtmlSnippetDynamicAllocationCreative">
 *       &lt;sequence>
 *         &lt;element name="isNativeEligible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdExchangeCreative", propOrder = {
    "isNativeEligible"
})
public class AdExchangeCreative
    extends HasHtmlSnippetDynamicAllocationCreative
{

    protected Boolean isNativeEligible;

    /**
     * Gets the value of the isNativeEligible property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNativeEligible() {
        return isNativeEligible;
    }

    /**
     * Sets the value of the isNativeEligible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNativeEligible(Boolean value) {
        this.isNativeEligible = value;
    }

}
