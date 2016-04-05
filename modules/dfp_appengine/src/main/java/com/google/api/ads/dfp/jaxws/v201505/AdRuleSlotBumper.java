
package com.google.api.ads.dfp.jaxws.v201505;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdRuleSlotBumper.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdRuleSlotBumper">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="BEFORE"/>
 *     &lt;enumeration value="AFTER"/>
 *     &lt;enumeration value="BEFORE_AND_AFTER"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdRuleSlotBumper")
@XmlEnum
public enum AdRuleSlotBumper {


    /**
     * 
     *                 Do not show a bumper ad.
     *               
     * 
     */
    NONE,

    /**
     * 
     *                 Show a bumper ad before the slot's other ads.
     *               
     * 
     */
    BEFORE,

    /**
     * 
     *                 Show a bumper ad after the slot's other ads.
     *               
     * 
     */
    AFTER,

    /**
     * 
     *                 Show a bumper before and after the slot's other ads.
     *               
     * 
     */
    BEFORE_AND_AFTER,

    /**
     * 
     *                 The value returned if the actual value is not exposed by the requested API version.
     *               
     * 
     */
    UNKNOWN;

    public String value() {
        return name();
    }

    public static AdRuleSlotBumper fromValue(String v) {
        return valueOf(v);
    }

}
