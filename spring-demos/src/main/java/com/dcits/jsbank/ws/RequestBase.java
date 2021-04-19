
package com.dcits.jsbank.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SEQ_NO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SERVICE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CHANNEL_ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SERVER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BANK_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="USER_ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AUTH_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TRAN_DATE"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="8"/&gt;
 *               &lt;maxLength value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TRAN_TIME"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="6"/&gt;
 *               &lt;maxLength value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AUTH_CONTEXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TRAN_TERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EXT_HEAD" type="{http://www.jscb.com.cn/esb/}extHeadList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBase", namespace = "http://www.jscb.com.cn/esb/", propOrder = {
    "seqno",
    "serviceid",
    "channelid",
    "serverid",
    "bankcode",
    "userid",
    "authid",
    "trandate",
    "trantime",
    "authcontext",
    "tranterm",
    "exthead"
})
@XmlSeeAlso({
    YCDOrderQueryRequest.class
})
public class RequestBase {

    @XmlElement(name = "SEQ_NO", required = true)
    protected String seqno;
    @XmlElement(name = "SERVICE_ID", required = true)
    protected String serviceid;
    @XmlElement(name = "CHANNEL_ID", required = true)
    protected String channelid;
    @XmlElement(name = "SERVER_ID")
    protected String serverid;
    @XmlElement(name = "BANK_CODE", required = true)
    protected String bankcode;
    @XmlElement(name = "USER_ID", required = true)
    protected String userid;
    @XmlElement(name = "AUTH_ID")
    protected String authid;
    @XmlElement(name = "TRAN_DATE", required = true)
    protected String trandate;
    @XmlElement(name = "TRAN_TIME", required = true)
    protected String trantime;
    @XmlElement(name = "AUTH_CONTEXT")
    protected String authcontext;
    @XmlElement(name = "TRAN_TERM")
    protected String tranterm;
    @XmlElement(name = "EXT_HEAD")
    protected ExtHeadList exthead;

    /**
     * Gets the value of the seqno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQNO() {
        return seqno;
    }

    /**
     * Sets the value of the seqno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQNO(String value) {
        this.seqno = value;
    }

    /**
     * Gets the value of the serviceid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEID() {
        return serviceid;
    }

    /**
     * Sets the value of the serviceid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEID(String value) {
        this.serviceid = value;
    }

    /**
     * Gets the value of the channelid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANNELID() {
        return channelid;
    }

    /**
     * Sets the value of the channelid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANNELID(String value) {
        this.channelid = value;
    }

    /**
     * Gets the value of the serverid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVERID() {
        return serverid;
    }

    /**
     * Sets the value of the serverid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVERID(String value) {
        this.serverid = value;
    }

    /**
     * Gets the value of the bankcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANKCODE() {
        return bankcode;
    }

    /**
     * Sets the value of the bankcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANKCODE(String value) {
        this.bankcode = value;
    }

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERID() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERID(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the authid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHID() {
        return authid;
    }

    /**
     * Sets the value of the authid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHID(String value) {
        this.authid = value;
    }

    /**
     * Gets the value of the trandate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANDATE() {
        return trandate;
    }

    /**
     * Sets the value of the trandate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANDATE(String value) {
        this.trandate = value;
    }

    /**
     * Gets the value of the trantime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANTIME() {
        return trantime;
    }

    /**
     * Sets the value of the trantime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANTIME(String value) {
        this.trantime = value;
    }

    /**
     * Gets the value of the authcontext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHCONTEXT() {
        return authcontext;
    }

    /**
     * Sets the value of the authcontext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHCONTEXT(String value) {
        this.authcontext = value;
    }

    /**
     * Gets the value of the tranterm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANTERM() {
        return tranterm;
    }

    /**
     * Sets the value of the tranterm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANTERM(String value) {
        this.tranterm = value;
    }

    /**
     * Gets the value of the exthead property.
     * 
     * @return
     *     possible object is
     *     {@link ExtHeadList }
     *     
     */
    public ExtHeadList getEXTHEAD() {
        return exthead;
    }

    /**
     * Sets the value of the exthead property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtHeadList }
     *     
     */
    public void setEXTHEAD(ExtHeadList value) {
        this.exthead = value;
    }

}
