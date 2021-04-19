
package com.dcits.jsbank.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for extHeadList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="extHeadList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MAC_INDEX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MAC_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BUSINESS_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PIN_SEED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extHeadList", namespace = "http://www.jscb.com.cn/esb/", propOrder = {
    "macindex",
    "macvalue",
    "businessid",
    "pinseed"
})
public class ExtHeadList {

    @XmlElement(name = "MAC_INDEX")
    protected String macindex;
    @XmlElement(name = "MAC_VALUE")
    protected String macvalue;
    @XmlElement(name = "BUSINESS_ID")
    protected String businessid;
    @XmlElement(name = "PIN_SEED")
    protected String pinseed;

    /**
     * Gets the value of the macindex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACINDEX() {
        return macindex;
    }

    /**
     * Sets the value of the macindex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMACINDEX(String value) {
        this.macindex = value;
    }

    /**
     * Gets the value of the macvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACVALUE() {
        return macvalue;
    }

    /**
     * Sets the value of the macvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMACVALUE(String value) {
        this.macvalue = value;
    }

    /**
     * Gets the value of the businessid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUSINESSID() {
        return businessid;
    }

    /**
     * Sets the value of the businessid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUSINESSID(String value) {
        this.businessid = value;
    }

    /**
     * Gets the value of the pinseed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINSEED() {
        return pinseed;
    }

    /**
     * Sets the value of the pinseed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINSEED(String value) {
        this.pinseed = value;
    }

}
