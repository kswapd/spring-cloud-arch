
package com.dcits.jsbank.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for YCDOrderQueryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="YCDOrderQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.jscb.com.cn/esb/}ResponseBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BaccoList" type="{http://www.jscb.com.cn/wdgl/type/WDGLYCDOrderQuery/}BaccoListResponse"/&gt;
 *         &lt;element name="serialNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="channel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tranDateTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="resultCode" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="resultMsg" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="totalSize" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "YCDOrderQueryResponse", propOrder = {
    "baccoList",
    "serialNo",
    "channel",
    "tranDateTime",
    "resultCode",
    "resultMsg",
    "totalSize"
})
public class YCDOrderQueryResponse
    extends ResponseBase
{

    @XmlElement(name = "BaccoList", required = true, nillable = true)
    protected BaccoListResponse baccoList;
    protected String serialNo;
    protected String channel;
    protected String tranDateTime;
    protected String resultCode;
    protected String resultMsg;
    protected String totalSize;

    /**
     * Gets the value of the baccoList property.
     * 
     * @return
     *     possible object is
     *     {@link BaccoListResponse }
     *     
     */
    public BaccoListResponse getBaccoList() {
        return baccoList;
    }

    /**
     * Sets the value of the baccoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaccoListResponse }
     *     
     */
    public void setBaccoList(BaccoListResponse value) {
        this.baccoList = value;
    }

    /**
     * Gets the value of the serialNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * Sets the value of the serialNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNo(String value) {
        this.serialNo = value;
    }

    /**
     * Gets the value of the channel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannel(String value) {
        this.channel = value;
    }

    /**
     * Gets the value of the tranDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranDateTime() {
        return tranDateTime;
    }

    /**
     * Sets the value of the tranDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranDateTime(String value) {
        this.tranDateTime = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultCode(String value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the resultMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * Sets the value of the resultMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultMsg(String value) {
        this.resultMsg = value;
    }

    /**
     * Gets the value of the totalSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalSize() {
        return totalSize;
    }

    /**
     * Sets the value of the totalSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalSize(String value) {
        this.totalSize = value;
    }

}
