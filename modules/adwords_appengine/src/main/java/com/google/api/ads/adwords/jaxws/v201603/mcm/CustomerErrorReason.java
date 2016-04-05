
package com.google.api.ads.adwords.jaxws.v201603.mcm;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerError.Reason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomerError.Reason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEMPORARY"/>
 *     &lt;enumeration value="ACCOUNT_NOT_SET_UP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomerError.Reason")
@XmlEnum
public enum CustomerErrorReason {


    /**
     * 
     *                 A temporary server error. The request can be retried.
     *               
     * 
     */
    TEMPORARY,

    /**
     * 
     *                 CustomerService cannot {@link CustomerService#get() get} an account that is not fully set
     *                 up.
     *               
     * 
     */
    ACCOUNT_NOT_SET_UP;

    public String value() {
        return name();
    }

    public static CustomerErrorReason fromValue(String v) {
        return valueOf(v);
    }

}
