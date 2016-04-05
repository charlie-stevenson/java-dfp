
package com.google.api.ads.dfp.jaxws.v201508;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Performs actions on {@link Proposal} objects that match the given {@link Statement#query}.
 *             
 *             The following fields are also required when submitting proposals for approval:
 *             <ul>
 *             <li>{@link Proposal#advertiser}</li>
 *             <li>{@link Proposal#primarySalesperson}</li>
 *             <li>{@link Proposal#primaryTraffickerId}</li>
 *             </ul>
 *             
 *             @param proposalAction the action to perform
 *             @param filterStatement a Publisher Query Language statement used to filter a set of proposals
 *             @return the result of the action performed
 *           
 * 
 * <p>Java class for performProposalAction element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="performProposalAction">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="proposalAction" type="{https://www.google.com/apis/ads/publisher/v201508}ProposalAction" minOccurs="0"/>
 *           &lt;element name="filterStatement" type="{https://www.google.com/apis/ads/publisher/v201508}Statement" minOccurs="0"/>
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
    "proposalAction",
    "filterStatement"
})
@XmlRootElement(name = "performProposalAction")
public class ProposalServiceInterfaceperformProposalAction {

    protected ProposalAction proposalAction;
    protected Statement filterStatement;

    /**
     * Gets the value of the proposalAction property.
     * 
     * @return
     *     possible object is
     *     {@link ProposalAction }
     *     
     */
    public ProposalAction getProposalAction() {
        return proposalAction;
    }

    /**
     * Sets the value of the proposalAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProposalAction }
     *     
     */
    public void setProposalAction(ProposalAction value) {
        this.proposalAction = value;
    }

    /**
     * Gets the value of the filterStatement property.
     * 
     * @return
     *     possible object is
     *     {@link Statement }
     *     
     */
    public Statement getFilterStatement() {
        return filterStatement;
    }

    /**
     * Sets the value of the filterStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statement }
     *     
     */
    public void setFilterStatement(Statement value) {
        this.filterStatement = value;
    }

}
