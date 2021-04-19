
package com.dcits.jsbank.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dcits.jsbank.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _YCDOrderQueryRequest_QNAME = new QName("http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/", "YCDOrderQueryRequest");
    private final static QName _YCDOrderQueryResponse_QNAME = new QName("http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/", "YCDOrderQueryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dcits.jsbank.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link YCDOrderQueryRequest }
     * 
     */
    public YCDOrderQueryRequest createYCDOrderQueryRequest() {
        return new YCDOrderQueryRequest();
    }

    /**
     * Create an instance of {@link YCDOrderQueryResponse }
     * 
     */
    public YCDOrderQueryResponse createYCDOrderQueryResponse() {
        return new YCDOrderQueryResponse();
    }

    /**
     * Create an instance of {@link BaccoListResponse }
     * 
     */
    public BaccoListResponse createBaccoListResponse() {
        return new BaccoListResponse();
    }

    /**
     * Create an instance of {@link BaccoInfoResponse }
     * 
     */
    public BaccoInfoResponse createBaccoInfoResponse() {
        return new BaccoInfoResponse();
    }

    /**
     * Create an instance of {@link RequestBase }
     * 
     */
    public RequestBase createRequestBase() {
        return new RequestBase();
    }

    /**
     * Create an instance of {@link ExtHeadList }
     * 
     */
    public ExtHeadList createExtHeadList() {
        return new ExtHeadList();
    }

    /**
     * Create an instance of {@link ResponseBase }
     * 
     */
    public ResponseBase createResponseBase() {
        return new ResponseBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YCDOrderQueryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/", name = "YCDOrderQueryRequest")
    public JAXBElement<YCDOrderQueryRequest> createYCDOrderQueryRequest(YCDOrderQueryRequest value) {
        return new JAXBElement<YCDOrderQueryRequest>(_YCDOrderQueryRequest_QNAME, YCDOrderQueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YCDOrderQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/", name = "YCDOrderQueryResponse")
    public JAXBElement<YCDOrderQueryResponse> createYCDOrderQueryResponse(YCDOrderQueryResponse value) {
        return new JAXBElement<YCDOrderQueryResponse>(_YCDOrderQueryResponse_QNAME, YCDOrderQueryResponse.class, null, value);
    }

}
