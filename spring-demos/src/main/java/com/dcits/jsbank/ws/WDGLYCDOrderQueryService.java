package com.dcits.jsbank.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.11
 * 2020-11-16T16:23:58.367+08:00
 * Generated source version: 3.2.11
 *
 */
@WebService(targetNamespace = "http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/", name = "WDGLYCDOrderQueryService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface WDGLYCDOrderQueryService {

    @WebMethod(operationName = "YCDOrderQuery", action = "http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/YCDOrderQuery")
    @WebResult(name = "YCDOrderQueryResponse", targetNamespace = "http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/", partName = "YCDOrderQueryResponse")
    public YCDOrderQueryResponse ycdOrderQuery(
        @WebParam(partName = "YCDOrderQueryRequest", name = "YCDOrderQueryRequest", targetNamespace = "http://www.jscb.com.cn/wdgl/WDGLYCDOrderQuery/")
        YCDOrderQueryRequest ycdOrderQueryRequest
    );
}