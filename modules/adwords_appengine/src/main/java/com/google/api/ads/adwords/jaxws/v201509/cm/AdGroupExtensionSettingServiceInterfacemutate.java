
package com.google.api.ads.adwords.jaxws.v201509.cm;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Applies the list of mutate operations (add, remove, and set).
 *             
 *             <p> Beginning in v201509, add and set operations are treated identically. Performing an add
 *             operation on an ad group with an existing ExtensionSetting will cause the operation to be
 *             treated like a set operation. Performing a set operation on an ad group with no
 *             ExtensionSetting will cause the operation to be treated like an add operation.
 *             
 *             @param operations The operations to apply. The same {@link AdGroupExtensionSetting} cannot be
 *             specified in more than one operation.
 *             @return The changed {@link AdGroupExtensionSetting}s.
 *             @throws ApiException Indicates a problem with the request.
 *           
 * 
 * <p>Java class for mutate element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="mutate">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="operations" type="{https://adwords.google.com/api/adwords/cm/v201509}AdGroupExtensionSettingOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operations"
})
@XmlRootElement(name = "mutate")
public class AdGroupExtensionSettingServiceInterfacemutate {

    protected List<AdGroupExtensionSettingOperation> operations;

    /**
     * Gets the value of the operations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdGroupExtensionSettingOperation }
     * 
     * 
     */
    public List<AdGroupExtensionSettingOperation> getOperations() {
        if (operations == null) {
            operations = new ArrayList<AdGroupExtensionSettingOperation>();
        }
        return this.operations;
    }

}
