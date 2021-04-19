
package com.dcits.jsbank.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaccoListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaccoListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BaccoInfo" type="{http://www.jscb.com.cn/wdgl/type/WDGLYCDOrderQuery/}BaccoInfoResponse" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaccoListResponse", propOrder = {
    "baccoInfo"
})
public class BaccoListResponse {

    @XmlElement(name = "BaccoInfo", required = true, nillable = true)
    protected List<BaccoInfoResponse> baccoInfo;

    /**
     * Gets the value of the baccoInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baccoInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaccoInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BaccoInfoResponse }
     * 
     * 
     */
    public List<BaccoInfoResponse> getBaccoInfo() {
        if (baccoInfo == null) {
            baccoInfo = new ArrayList<BaccoInfoResponse>();
        }
        return this.baccoInfo;
    }

}
