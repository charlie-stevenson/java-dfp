
package com.google.api.ads.dfp.jaxws.v201508;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Performs actions on {@link UserTeamAssociation} objects that match the
 *             given {@link Statement#query}.
 *             
 *             @param userTeamAssociationAction the action to perform
 *             @param filterStatement a Publisher Query Language statement used to filter
 *             a set of user team associations
 *             @return the result of the action performed
 *           
 * 
 * <p>Java class for performUserTeamAssociationAction element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="performUserTeamAssociationAction">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="userTeamAssociationAction" type="{https://www.google.com/apis/ads/publisher/v201508}UserTeamAssociationAction" minOccurs="0"/>
 *           &lt;element name="statement" type="{https://www.google.com/apis/ads/publisher/v201508}Statement" minOccurs="0"/>
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
    "userTeamAssociationAction",
    "statement"
})
@XmlRootElement(name = "performUserTeamAssociationAction")
public class UserTeamAssociationServiceInterfaceperformUserTeamAssociationAction {

    protected UserTeamAssociationAction userTeamAssociationAction;
    protected Statement statement;

    /**
     * Gets the value of the userTeamAssociationAction property.
     * 
     * @return
     *     possible object is
     *     {@link UserTeamAssociationAction }
     *     
     */
    public UserTeamAssociationAction getUserTeamAssociationAction() {
        return userTeamAssociationAction;
    }

    /**
     * Sets the value of the userTeamAssociationAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTeamAssociationAction }
     *     
     */
    public void setUserTeamAssociationAction(UserTeamAssociationAction value) {
        this.userTeamAssociationAction = value;
    }

    /**
     * Gets the value of the statement property.
     * 
     * @return
     *     possible object is
     *     {@link Statement }
     *     
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * Sets the value of the statement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statement }
     *     
     */
    public void setStatement(Statement value) {
        this.statement = value;
    }

}
