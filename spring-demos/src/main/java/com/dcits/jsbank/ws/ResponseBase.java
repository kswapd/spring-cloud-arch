
package com.dcits.jsbank.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SEQ_NO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SERVICE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BANK_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
 *               &lt;minLength value="9"/&gt;
 *               &lt;maxLength value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TRAN_STATUS"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="COMPLETE"/&gt;
 *               &lt;enumeration value="FAIL"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ERROR_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ERROR_MSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RET_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RET_MSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseBase", namespace = "http://www.jscb.com.cn/esb/", propOrder = {
    "seqno",
    "serviceid",
    "bankcode",
    "trandate",
    "trantime",
    "transtatus",
    "errorcode",
    "errormsg",
    "retcode",
    "retmsg"
})
@XmlSeeAlso({
    YCDOrderQueryResponse.class
})
public class ResponseBase {

    @XmlElement(name = "SEQ_NO", required = true)
    protected String seqno;
    @XmlElement(name = "SERVICE_ID", required = true)
    protected String serviceid;
    @XmlElement(name = "BANK_CODE", required = true)
    protected String bankcode;
    @XmlElement(name = "TRAN_DATE", required = true)
    protected String trandate;
    @XmlElement(name = "TRAN_TIME", required = true)
    protected String trantime;
    @XmlElement(name = "TRAN_STATUS", required = true)
    protected String transtatus;
    @XmlElement(name = "ERROR_CODE")
    protected String errorcode;
    @XmlElement(name = "ERROR_MSG")
    protected String errormsg;
    @XmlElement(name = "RET_CODE")
    protected String retcode;
    @XmlElement(name = "RET_MSG")
    protected String retmsg;

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
     * Gets the value of the transtatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSTATUS() {
        return transtatus;
    }

    /**
     * Sets the value of the transtatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSTATUS(String value) {
        this.transtatus = value;
    }

    /**
     * Gets the value of the errorcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORCODE() {
        return errorcode;
    }

    /**
     * Sets the value of the errorcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORCODE(String value) {
        this.errorcode = value;
    }

    /**
     * Gets the value of the errormsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORMSG() {
        return errormsg;
    }

    /**
     * Sets the value of the errormsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORMSG(String value) {
        this.errormsg = value;
    }

    /**
     * Gets the value of the retcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETCODE() {
        return retcode;
    }

    /**
     * Sets the value of the retcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETCODE(String value) {
        this.retcode = value;
    }

    /**
     * Gets the value of the retmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETMSG() {
        return retmsg;
    }

    /**
     * Sets the value of the retmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETMSG(String value) {
        this.retmsg = value;
    }

}
