
package com.dcits.jsbank.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaccoInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaccoInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="channel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="serialNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="productName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="productCode" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orderNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orderType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orderStatus" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="custNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orgCustNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="partyName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="certType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="certNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="phoneNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="address" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="companyName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="govnCertNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="companyNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="taxNum" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="socialCreditCode" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="loanCardNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="registerAdd" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="province" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="city" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="country" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="branchNum" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="recommendNum" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="recommendMobile" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="applyAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="applyTerm" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="loanUseType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveUseType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directUseType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="outAccount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="inAccount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="localFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="houseFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="houseInfo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="marriageFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="spouseName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="spouseCertType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="spouseCertNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="companyGuaranteeFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="spouseGuaranteeFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="emergencyName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="emergencyAddress" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="emergencyPhone" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="emergencyRelation" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="coagencyName1" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="coagencyCustid1" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="coagencyName2" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="coagencyCustid2" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="coagencyName3" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="coagencyCustid3" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="remark" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orderCreatetime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="applyTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="admittanceTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="preApproveTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="comfirmTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="contractTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="custSignDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeSignDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ccmStartDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="loanTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="applyDue" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="comfirmDue" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="contractBuildDue" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="custSignDue" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeSignDue" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="loanDue" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="stockcustFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="firstApproveTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="firstApproveAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="lastApproveTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="lastApproveAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="personalCreditQueryTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="personalCreditQueryResult" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="errorCode" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="errorDescriptionIn" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="errorDescriptionOut" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveRepaymentType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="companyType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="singleUseLimit" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="singleUseTerm" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="singleDayUseLimit" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="strikeRateYear" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveTerm" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orderStatusStr" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveUpdateFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="beginDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dueDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="lilvllFloatingType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="lilvllFloatingRate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="lilvllFloatingPoint" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="strikeRateMonth" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="strikeRateDay" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="baseRate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="adjustRateType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fineFloatRate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="repeatFloatRate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="everyRepayDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fineRatio" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="companyCreditQueryTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveScoringAppRiskLevel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveBusinessRiskLevel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveSynthesizeRiskLevel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveReviewRiskLevel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="approveRiskLevel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="limitCycleFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="preApproveAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="preApproveTerm" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="loanContractNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="loanCustNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="loanCustName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="custAddress" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="custMobile" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="startDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="endDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="rateReal" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeContractNo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="contractAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="contractTerm" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="rateFloatType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="floatInterate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directEntname" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directAccount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directOrgId" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directEntaddress" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directLegalName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeAccount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeOrgId" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeInAccount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeAddress" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeLegalName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeAmountFlag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteePayType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeProportion" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="guaranteeAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vendorName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="brandRemark" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="categoryRemark" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="reguaranteeRate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="wdStatus" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="personalStatusName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="entityStatusName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate1" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate2" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate3" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate4" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate5" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate6" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate7" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate8" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate9" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Obligate10" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaccoInfoResponse", propOrder = {
    "channel",
    "serialNo",
    "productName",
    "productCode",
    "orderNo",
    "orderType",
    "approveType",
    "orderStatus",
    "custNo",
    "orgCustNo",
    "partyName",
    "certType",
    "certNo",
    "phoneNo",
    "address",
    "companyName",
    "govnCertNo",
    "companyNo",
    "taxNum",
    "socialCreditCode",
    "loanCardNo",
    "registerAdd",
    "province",
    "city",
    "country",
    "branchNum",
    "recommendNum",
    "recommendMobile",
    "applyAmount",
    "applyTerm",
    "loanUseType",
    "approveUseType",
    "directUseType",
    "outAccount",
    "inAccount",
    "localFlag",
    "houseFlag",
    "houseInfo",
    "marriageFlag",
    "spouseName",
    "spouseCertType",
    "spouseCertNo",
    "companyGuaranteeFlag",
    "spouseGuaranteeFlag",
    "emergencyName",
    "emergencyAddress",
    "emergencyPhone",
    "emergencyRelation",
    "coagencyName1",
    "coagencyCustid1",
    "coagencyName2",
    "coagencyCustid2",
    "coagencyName3",
    "coagencyCustid3",
    "remark",
    "orderCreatetime",
    "applyTime",
    "admittanceTime",
    "preApproveTime",
    "approveTime",
    "comfirmTime",
    "contractTime",
    "custSignDate",
    "guaranteeSignDate",
    "ccmStartDate",
    "loanTime",
    "applyDue",
    "comfirmDue",
    "contractBuildDue",
    "custSignDue",
    "guaranteeSignDue",
    "loanDue",
    "stockcustFlag",
    "firstApproveTime",
    "firstApproveAmount",
    "lastApproveTime",
    "lastApproveAmount",
    "personalCreditQueryTime",
    "personalCreditQueryResult",
    "errorCode",
    "errorDescriptionIn",
    "errorDescriptionOut",
    "approveRepaymentType",
    "companyType",
    "singleUseLimit",
    "singleUseTerm",
    "singleDayUseLimit",
    "strikeRateYear",
    "approveAmount",
    "approveTerm",
    "orderStatusStr",
    "approveUpdateFlag",
    "beginDate",
    "dueDate",
    "lilvllFloatingType",
    "lilvllFloatingRate",
    "lilvllFloatingPoint",
    "strikeRateMonth",
    "strikeRateDay",
    "baseRate",
    "adjustRateType",
    "fineFloatRate",
    "repeatFloatRate",
    "everyRepayDate",
    "fineRatio",
    "companyCreditQueryTime",
    "approveScoringAppRiskLevel",
    "approveBusinessRiskLevel",
    "approveSynthesizeRiskLevel",
    "approveReviewRiskLevel",
    "approveRiskLevel",
    "limitCycleFlag",
    "preApproveAmount",
    "preApproveTerm",
    "loanContractNo",
    "loanCustNo",
    "loanCustName",
    "custAddress",
    "custMobile",
    "startDate",
    "endDate",
    "rateReal",
    "guaranteeContractNo",
    "contractAmount",
    "contractTerm",
    "rateFloatType",
    "floatInterate",
    "directEntname",
    "directAccount",
    "directOrgId",
    "directEntaddress",
    "directLegalName",
    "guaranteeType",
    "guaranteeName",
    "guaranteeAccount",
    "guaranteeOrgId",
    "guaranteeInAccount",
    "guaranteeAddress",
    "guaranteeLegalName",
    "guaranteeAmountFlag",
    "guaranteePayType",
    "guaranteeProportion",
    "guaranteeAmount",
    "vendorName",
    "brandRemark",
    "categoryRemark",
    "reguaranteeRate",
    "wdStatus",
    "personalStatusName",
    "entityStatusName",
    "obligate1",
    "obligate2",
    "obligate3",
    "obligate4",
    "obligate5",
    "obligate6",
    "obligate7",
    "obligate8",
    "obligate9",
    "obligate10"
})
public class BaccoInfoResponse {

    protected String channel;
    protected String serialNo;
    protected String productName;
    protected String productCode;
    protected String orderNo;
    protected String orderType;
    protected String approveType;
    protected String orderStatus;
    protected String custNo;
    protected String orgCustNo;
    protected String partyName;
    protected String certType;
    protected String certNo;
    protected String phoneNo;
    protected String address;
    protected String companyName;
    protected String govnCertNo;
    protected String companyNo;
    protected String taxNum;
    protected String socialCreditCode;
    protected String loanCardNo;
    protected String registerAdd;
    protected String province;
    protected String city;
    protected String country;
    protected String branchNum;
    protected String recommendNum;
    protected String recommendMobile;
    protected String applyAmount;
    protected String applyTerm;
    protected String loanUseType;
    protected String approveUseType;
    protected String directUseType;
    protected String outAccount;
    protected String inAccount;
    protected String localFlag;
    protected String houseFlag;
    protected String houseInfo;
    protected String marriageFlag;
    protected String spouseName;
    protected String spouseCertType;
    protected String spouseCertNo;
    protected String companyGuaranteeFlag;
    protected String spouseGuaranteeFlag;
    protected String emergencyName;
    protected String emergencyAddress;
    protected String emergencyPhone;
    protected String emergencyRelation;
    protected String coagencyName1;
    protected String coagencyCustid1;
    protected String coagencyName2;
    protected String coagencyCustid2;
    protected String coagencyName3;
    protected String coagencyCustid3;
    protected String remark;
    protected String orderCreatetime;
    protected String applyTime;
    protected String admittanceTime;
    protected String preApproveTime;
    protected String approveTime;
    protected String comfirmTime;
    protected String contractTime;
    protected String custSignDate;
    protected String guaranteeSignDate;
    protected String ccmStartDate;
    protected String loanTime;
    protected String applyDue;
    protected String comfirmDue;
    protected String contractBuildDue;
    protected String custSignDue;
    protected String guaranteeSignDue;
    protected String loanDue;
    protected String stockcustFlag;
    protected String firstApproveTime;
    protected String firstApproveAmount;
    protected String lastApproveTime;
    protected String lastApproveAmount;
    protected String personalCreditQueryTime;
    protected String personalCreditQueryResult;
    protected String errorCode;
    protected String errorDescriptionIn;
    protected String errorDescriptionOut;
    protected String approveRepaymentType;
    protected String companyType;
    protected String singleUseLimit;
    protected String singleUseTerm;
    protected String singleDayUseLimit;
    protected String strikeRateYear;
    protected String approveAmount;
    protected String approveTerm;
    protected String orderStatusStr;
    protected String approveUpdateFlag;
    protected String beginDate;
    protected String dueDate;
    protected String lilvllFloatingType;
    protected String lilvllFloatingRate;
    protected String lilvllFloatingPoint;
    protected String strikeRateMonth;
    protected String strikeRateDay;
    protected String baseRate;
    protected String adjustRateType;
    protected String fineFloatRate;
    protected String repeatFloatRate;
    protected String everyRepayDate;
    protected String fineRatio;
    protected String companyCreditQueryTime;
    protected String approveScoringAppRiskLevel;
    protected String approveBusinessRiskLevel;
    protected String approveSynthesizeRiskLevel;
    protected String approveReviewRiskLevel;
    protected String approveRiskLevel;
    protected String limitCycleFlag;
    protected String preApproveAmount;
    protected String preApproveTerm;
    protected String loanContractNo;
    protected String loanCustNo;
    protected String loanCustName;
    protected String custAddress;
    protected String custMobile;
    protected String startDate;
    protected String endDate;
    protected String rateReal;
    protected String guaranteeContractNo;
    protected String contractAmount;
    protected String contractTerm;
    protected String rateFloatType;
    protected String floatInterate;
    protected String directEntname;
    protected String directAccount;
    protected String directOrgId;
    protected String directEntaddress;
    protected String directLegalName;
    protected String guaranteeType;
    protected String guaranteeName;
    protected String guaranteeAccount;
    protected String guaranteeOrgId;
    protected String guaranteeInAccount;
    protected String guaranteeAddress;
    protected String guaranteeLegalName;
    protected String guaranteeAmountFlag;
    protected String guaranteePayType;
    protected String guaranteeProportion;
    protected String guaranteeAmount;
    protected String vendorName;
    protected String brandRemark;
    protected String categoryRemark;
    protected String reguaranteeRate;
    protected String wdStatus;
    protected String personalStatusName;
    protected String entityStatusName;
    @XmlElement(name = "Obligate1")
    protected String obligate1;
    @XmlElement(name = "Obligate2")
    protected String obligate2;
    @XmlElement(name = "Obligate3")
    protected String obligate3;
    @XmlElement(name = "Obligate4")
    protected String obligate4;
    @XmlElement(name = "Obligate5")
    protected String obligate5;
    @XmlElement(name = "Obligate6")
    protected String obligate6;
    @XmlElement(name = "Obligate7")
    protected String obligate7;
    @XmlElement(name = "Obligate8")
    protected String obligate8;
    @XmlElement(name = "Obligate9")
    protected String obligate9;
    @XmlElement(name = "Obligate10")
    protected String obligate10;

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
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the orderNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * Sets the value of the orderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNo(String value) {
        this.orderNo = value;
    }

    /**
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * Gets the value of the approveType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveType() {
        return approveType;
    }

    /**
     * Sets the value of the approveType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveType(String value) {
        this.approveType = value;
    }

    /**
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderStatus(String value) {
        this.orderStatus = value;
    }

    /**
     * Gets the value of the custNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustNo() {
        return custNo;
    }

    /**
     * Sets the value of the custNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustNo(String value) {
        this.custNo = value;
    }

    /**
     * Gets the value of the orgCustNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgCustNo() {
        return orgCustNo;
    }

    /**
     * Sets the value of the orgCustNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgCustNo(String value) {
        this.orgCustNo = value;
    }

    /**
     * Gets the value of the partyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * Sets the value of the partyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyName(String value) {
        this.partyName = value;
    }

    /**
     * Gets the value of the certType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertType() {
        return certType;
    }

    /**
     * Sets the value of the certType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertType(String value) {
        this.certType = value;
    }

    /**
     * Gets the value of the certNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * Sets the value of the certNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertNo(String value) {
        this.certNo = value;
    }

    /**
     * Gets the value of the phoneNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the value of the phoneNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNo(String value) {
        this.phoneNo = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the govnCertNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovnCertNo() {
        return govnCertNo;
    }

    /**
     * Sets the value of the govnCertNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovnCertNo(String value) {
        this.govnCertNo = value;
    }

    /**
     * Gets the value of the companyNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyNo() {
        return companyNo;
    }

    /**
     * Sets the value of the companyNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyNo(String value) {
        this.companyNo = value;
    }

    /**
     * Gets the value of the taxNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxNum() {
        return taxNum;
    }

    /**
     * Sets the value of the taxNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxNum(String value) {
        this.taxNum = value;
    }

    /**
     * Gets the value of the socialCreditCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    /**
     * Sets the value of the socialCreditCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocialCreditCode(String value) {
        this.socialCreditCode = value;
    }

    /**
     * Gets the value of the loanCardNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanCardNo() {
        return loanCardNo;
    }

    /**
     * Sets the value of the loanCardNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanCardNo(String value) {
        this.loanCardNo = value;
    }

    /**
     * Gets the value of the registerAdd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterAdd() {
        return registerAdd;
    }

    /**
     * Sets the value of the registerAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterAdd(String value) {
        this.registerAdd = value;
    }

    /**
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvince(String value) {
        this.province = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the branchNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchNum() {
        return branchNum;
    }

    /**
     * Sets the value of the branchNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchNum(String value) {
        this.branchNum = value;
    }

    /**
     * Gets the value of the recommendNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendNum() {
        return recommendNum;
    }

    /**
     * Sets the value of the recommendNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendNum(String value) {
        this.recommendNum = value;
    }

    /**
     * Gets the value of the recommendMobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendMobile() {
        return recommendMobile;
    }

    /**
     * Sets the value of the recommendMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendMobile(String value) {
        this.recommendMobile = value;
    }

    /**
     * Gets the value of the applyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyAmount() {
        return applyAmount;
    }

    /**
     * Sets the value of the applyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyAmount(String value) {
        this.applyAmount = value;
    }

    /**
     * Gets the value of the applyTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyTerm() {
        return applyTerm;
    }

    /**
     * Sets the value of the applyTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyTerm(String value) {
        this.applyTerm = value;
    }

    /**
     * Gets the value of the loanUseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanUseType() {
        return loanUseType;
    }

    /**
     * Sets the value of the loanUseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanUseType(String value) {
        this.loanUseType = value;
    }

    /**
     * Gets the value of the approveUseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveUseType() {
        return approveUseType;
    }

    /**
     * Sets the value of the approveUseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveUseType(String value) {
        this.approveUseType = value;
    }

    /**
     * Gets the value of the directUseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectUseType() {
        return directUseType;
    }

    /**
     * Sets the value of the directUseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectUseType(String value) {
        this.directUseType = value;
    }

    /**
     * Gets the value of the outAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutAccount() {
        return outAccount;
    }

    /**
     * Sets the value of the outAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutAccount(String value) {
        this.outAccount = value;
    }

    /**
     * Gets the value of the inAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInAccount() {
        return inAccount;
    }

    /**
     * Sets the value of the inAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInAccount(String value) {
        this.inAccount = value;
    }

    /**
     * Gets the value of the localFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalFlag() {
        return localFlag;
    }

    /**
     * Sets the value of the localFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalFlag(String value) {
        this.localFlag = value;
    }

    /**
     * Gets the value of the houseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseFlag() {
        return houseFlag;
    }

    /**
     * Sets the value of the houseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseFlag(String value) {
        this.houseFlag = value;
    }

    /**
     * Gets the value of the houseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseInfo() {
        return houseInfo;
    }

    /**
     * Sets the value of the houseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseInfo(String value) {
        this.houseInfo = value;
    }

    /**
     * Gets the value of the marriageFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarriageFlag() {
        return marriageFlag;
    }

    /**
     * Sets the value of the marriageFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarriageFlag(String value) {
        this.marriageFlag = value;
    }

    /**
     * Gets the value of the spouseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * Sets the value of the spouseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseName(String value) {
        this.spouseName = value;
    }

    /**
     * Gets the value of the spouseCertType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseCertType() {
        return spouseCertType;
    }

    /**
     * Sets the value of the spouseCertType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseCertType(String value) {
        this.spouseCertType = value;
    }

    /**
     * Gets the value of the spouseCertNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseCertNo() {
        return spouseCertNo;
    }

    /**
     * Sets the value of the spouseCertNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseCertNo(String value) {
        this.spouseCertNo = value;
    }

    /**
     * Gets the value of the companyGuaranteeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyGuaranteeFlag() {
        return companyGuaranteeFlag;
    }

    /**
     * Sets the value of the companyGuaranteeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyGuaranteeFlag(String value) {
        this.companyGuaranteeFlag = value;
    }

    /**
     * Gets the value of the spouseGuaranteeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseGuaranteeFlag() {
        return spouseGuaranteeFlag;
    }

    /**
     * Sets the value of the spouseGuaranteeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseGuaranteeFlag(String value) {
        this.spouseGuaranteeFlag = value;
    }

    /**
     * Gets the value of the emergencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyName() {
        return emergencyName;
    }

    /**
     * Sets the value of the emergencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyName(String value) {
        this.emergencyName = value;
    }

    /**
     * Gets the value of the emergencyAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    /**
     * Sets the value of the emergencyAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyAddress(String value) {
        this.emergencyAddress = value;
    }

    /**
     * Gets the value of the emergencyPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    /**
     * Sets the value of the emergencyPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyPhone(String value) {
        this.emergencyPhone = value;
    }

    /**
     * Gets the value of the emergencyRelation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyRelation() {
        return emergencyRelation;
    }

    /**
     * Sets the value of the emergencyRelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyRelation(String value) {
        this.emergencyRelation = value;
    }

    /**
     * Gets the value of the coagencyName1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoagencyName1() {
        return coagencyName1;
    }

    /**
     * Sets the value of the coagencyName1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoagencyName1(String value) {
        this.coagencyName1 = value;
    }

    /**
     * Gets the value of the coagencyCustid1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoagencyCustid1() {
        return coagencyCustid1;
    }

    /**
     * Sets the value of the coagencyCustid1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoagencyCustid1(String value) {
        this.coagencyCustid1 = value;
    }

    /**
     * Gets the value of the coagencyName2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoagencyName2() {
        return coagencyName2;
    }

    /**
     * Sets the value of the coagencyName2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoagencyName2(String value) {
        this.coagencyName2 = value;
    }

    /**
     * Gets the value of the coagencyCustid2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoagencyCustid2() {
        return coagencyCustid2;
    }

    /**
     * Sets the value of the coagencyCustid2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoagencyCustid2(String value) {
        this.coagencyCustid2 = value;
    }

    /**
     * Gets the value of the coagencyName3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoagencyName3() {
        return coagencyName3;
    }

    /**
     * Sets the value of the coagencyName3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoagencyName3(String value) {
        this.coagencyName3 = value;
    }

    /**
     * Gets the value of the coagencyCustid3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoagencyCustid3() {
        return coagencyCustid3;
    }

    /**
     * Sets the value of the coagencyCustid3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoagencyCustid3(String value) {
        this.coagencyCustid3 = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the orderCreatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderCreatetime() {
        return orderCreatetime;
    }

    /**
     * Sets the value of the orderCreatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderCreatetime(String value) {
        this.orderCreatetime = value;
    }

    /**
     * Gets the value of the applyTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyTime() {
        return applyTime;
    }

    /**
     * Sets the value of the applyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyTime(String value) {
        this.applyTime = value;
    }

    /**
     * Gets the value of the admittanceTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmittanceTime() {
        return admittanceTime;
    }

    /**
     * Sets the value of the admittanceTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmittanceTime(String value) {
        this.admittanceTime = value;
    }

    /**
     * Gets the value of the preApproveTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreApproveTime() {
        return preApproveTime;
    }

    /**
     * Sets the value of the preApproveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreApproveTime(String value) {
        this.preApproveTime = value;
    }

    /**
     * Gets the value of the approveTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveTime() {
        return approveTime;
    }

    /**
     * Sets the value of the approveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveTime(String value) {
        this.approveTime = value;
    }

    /**
     * Gets the value of the comfirmTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComfirmTime() {
        return comfirmTime;
    }

    /**
     * Sets the value of the comfirmTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComfirmTime(String value) {
        this.comfirmTime = value;
    }

    /**
     * Gets the value of the contractTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractTime() {
        return contractTime;
    }

    /**
     * Sets the value of the contractTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractTime(String value) {
        this.contractTime = value;
    }

    /**
     * Gets the value of the custSignDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustSignDate() {
        return custSignDate;
    }

    /**
     * Sets the value of the custSignDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustSignDate(String value) {
        this.custSignDate = value;
    }

    /**
     * Gets the value of the guaranteeSignDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeSignDate() {
        return guaranteeSignDate;
    }

    /**
     * Sets the value of the guaranteeSignDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeSignDate(String value) {
        this.guaranteeSignDate = value;
    }

    /**
     * Gets the value of the ccmStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcmStartDate() {
        return ccmStartDate;
    }

    /**
     * Sets the value of the ccmStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcmStartDate(String value) {
        this.ccmStartDate = value;
    }

    /**
     * Gets the value of the loanTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanTime() {
        return loanTime;
    }

    /**
     * Sets the value of the loanTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanTime(String value) {
        this.loanTime = value;
    }

    /**
     * Gets the value of the applyDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyDue() {
        return applyDue;
    }

    /**
     * Sets the value of the applyDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyDue(String value) {
        this.applyDue = value;
    }

    /**
     * Gets the value of the comfirmDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComfirmDue() {
        return comfirmDue;
    }

    /**
     * Sets the value of the comfirmDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComfirmDue(String value) {
        this.comfirmDue = value;
    }

    /**
     * Gets the value of the contractBuildDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractBuildDue() {
        return contractBuildDue;
    }

    /**
     * Sets the value of the contractBuildDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractBuildDue(String value) {
        this.contractBuildDue = value;
    }

    /**
     * Gets the value of the custSignDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustSignDue() {
        return custSignDue;
    }

    /**
     * Sets the value of the custSignDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustSignDue(String value) {
        this.custSignDue = value;
    }

    /**
     * Gets the value of the guaranteeSignDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeSignDue() {
        return guaranteeSignDue;
    }

    /**
     * Sets the value of the guaranteeSignDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeSignDue(String value) {
        this.guaranteeSignDue = value;
    }

    /**
     * Gets the value of the loanDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanDue() {
        return loanDue;
    }

    /**
     * Sets the value of the loanDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanDue(String value) {
        this.loanDue = value;
    }

    /**
     * Gets the value of the stockcustFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockcustFlag() {
        return stockcustFlag;
    }

    /**
     * Sets the value of the stockcustFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockcustFlag(String value) {
        this.stockcustFlag = value;
    }

    /**
     * Gets the value of the firstApproveTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstApproveTime() {
        return firstApproveTime;
    }

    /**
     * Sets the value of the firstApproveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstApproveTime(String value) {
        this.firstApproveTime = value;
    }

    /**
     * Gets the value of the firstApproveAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstApproveAmount() {
        return firstApproveAmount;
    }

    /**
     * Sets the value of the firstApproveAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstApproveAmount(String value) {
        this.firstApproveAmount = value;
    }

    /**
     * Gets the value of the lastApproveTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastApproveTime() {
        return lastApproveTime;
    }

    /**
     * Sets the value of the lastApproveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastApproveTime(String value) {
        this.lastApproveTime = value;
    }

    /**
     * Gets the value of the lastApproveAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastApproveAmount() {
        return lastApproveAmount;
    }

    /**
     * Sets the value of the lastApproveAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastApproveAmount(String value) {
        this.lastApproveAmount = value;
    }

    /**
     * Gets the value of the personalCreditQueryTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalCreditQueryTime() {
        return personalCreditQueryTime;
    }

    /**
     * Sets the value of the personalCreditQueryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalCreditQueryTime(String value) {
        this.personalCreditQueryTime = value;
    }

    /**
     * Gets the value of the personalCreditQueryResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalCreditQueryResult() {
        return personalCreditQueryResult;
    }

    /**
     * Sets the value of the personalCreditQueryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalCreditQueryResult(String value) {
        this.personalCreditQueryResult = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorDescriptionIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDescriptionIn() {
        return errorDescriptionIn;
    }

    /**
     * Sets the value of the errorDescriptionIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDescriptionIn(String value) {
        this.errorDescriptionIn = value;
    }

    /**
     * Gets the value of the errorDescriptionOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDescriptionOut() {
        return errorDescriptionOut;
    }

    /**
     * Sets the value of the errorDescriptionOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDescriptionOut(String value) {
        this.errorDescriptionOut = value;
    }

    /**
     * Gets the value of the approveRepaymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveRepaymentType() {
        return approveRepaymentType;
    }

    /**
     * Sets the value of the approveRepaymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveRepaymentType(String value) {
        this.approveRepaymentType = value;
    }

    /**
     * Gets the value of the companyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Sets the value of the companyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyType(String value) {
        this.companyType = value;
    }

    /**
     * Gets the value of the singleUseLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleUseLimit() {
        return singleUseLimit;
    }

    /**
     * Sets the value of the singleUseLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleUseLimit(String value) {
        this.singleUseLimit = value;
    }

    /**
     * Gets the value of the singleUseTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleUseTerm() {
        return singleUseTerm;
    }

    /**
     * Sets the value of the singleUseTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleUseTerm(String value) {
        this.singleUseTerm = value;
    }

    /**
     * Gets the value of the singleDayUseLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleDayUseLimit() {
        return singleDayUseLimit;
    }

    /**
     * Sets the value of the singleDayUseLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleDayUseLimit(String value) {
        this.singleDayUseLimit = value;
    }

    /**
     * Gets the value of the strikeRateYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeRateYear() {
        return strikeRateYear;
    }

    /**
     * Sets the value of the strikeRateYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeRateYear(String value) {
        this.strikeRateYear = value;
    }

    /**
     * Gets the value of the approveAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveAmount() {
        return approveAmount;
    }

    /**
     * Sets the value of the approveAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveAmount(String value) {
        this.approveAmount = value;
    }

    /**
     * Gets the value of the approveTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveTerm() {
        return approveTerm;
    }

    /**
     * Sets the value of the approveTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveTerm(String value) {
        this.approveTerm = value;
    }

    /**
     * Gets the value of the orderStatusStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    /**
     * Sets the value of the orderStatusStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderStatusStr(String value) {
        this.orderStatusStr = value;
    }

    /**
     * Gets the value of the approveUpdateFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveUpdateFlag() {
        return approveUpdateFlag;
    }

    /**
     * Sets the value of the approveUpdateFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveUpdateFlag(String value) {
        this.approveUpdateFlag = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(String value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDate(String value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the lilvllFloatingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLilvllFloatingType() {
        return lilvllFloatingType;
    }

    /**
     * Sets the value of the lilvllFloatingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLilvllFloatingType(String value) {
        this.lilvllFloatingType = value;
    }

    /**
     * Gets the value of the lilvllFloatingRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLilvllFloatingRate() {
        return lilvllFloatingRate;
    }

    /**
     * Sets the value of the lilvllFloatingRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLilvllFloatingRate(String value) {
        this.lilvllFloatingRate = value;
    }

    /**
     * Gets the value of the lilvllFloatingPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLilvllFloatingPoint() {
        return lilvllFloatingPoint;
    }

    /**
     * Sets the value of the lilvllFloatingPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLilvllFloatingPoint(String value) {
        this.lilvllFloatingPoint = value;
    }

    /**
     * Gets the value of the strikeRateMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeRateMonth() {
        return strikeRateMonth;
    }

    /**
     * Sets the value of the strikeRateMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeRateMonth(String value) {
        this.strikeRateMonth = value;
    }

    /**
     * Gets the value of the strikeRateDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrikeRateDay() {
        return strikeRateDay;
    }

    /**
     * Sets the value of the strikeRateDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrikeRateDay(String value) {
        this.strikeRateDay = value;
    }

    /**
     * Gets the value of the baseRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseRate() {
        return baseRate;
    }

    /**
     * Sets the value of the baseRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseRate(String value) {
        this.baseRate = value;
    }

    /**
     * Gets the value of the adjustRateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjustRateType() {
        return adjustRateType;
    }

    /**
     * Sets the value of the adjustRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjustRateType(String value) {
        this.adjustRateType = value;
    }

    /**
     * Gets the value of the fineFloatRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFineFloatRate() {
        return fineFloatRate;
    }

    /**
     * Sets the value of the fineFloatRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFineFloatRate(String value) {
        this.fineFloatRate = value;
    }

    /**
     * Gets the value of the repeatFloatRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepeatFloatRate() {
        return repeatFloatRate;
    }

    /**
     * Sets the value of the repeatFloatRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepeatFloatRate(String value) {
        this.repeatFloatRate = value;
    }

    /**
     * Gets the value of the everyRepayDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEveryRepayDate() {
        return everyRepayDate;
    }

    /**
     * Sets the value of the everyRepayDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEveryRepayDate(String value) {
        this.everyRepayDate = value;
    }

    /**
     * Gets the value of the fineRatio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFineRatio() {
        return fineRatio;
    }

    /**
     * Sets the value of the fineRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFineRatio(String value) {
        this.fineRatio = value;
    }

    /**
     * Gets the value of the companyCreditQueryTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyCreditQueryTime() {
        return companyCreditQueryTime;
    }

    /**
     * Sets the value of the companyCreditQueryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyCreditQueryTime(String value) {
        this.companyCreditQueryTime = value;
    }

    /**
     * Gets the value of the approveScoringAppRiskLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveScoringAppRiskLevel() {
        return approveScoringAppRiskLevel;
    }

    /**
     * Sets the value of the approveScoringAppRiskLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveScoringAppRiskLevel(String value) {
        this.approveScoringAppRiskLevel = value;
    }

    /**
     * Gets the value of the approveBusinessRiskLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveBusinessRiskLevel() {
        return approveBusinessRiskLevel;
    }

    /**
     * Sets the value of the approveBusinessRiskLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveBusinessRiskLevel(String value) {
        this.approveBusinessRiskLevel = value;
    }

    /**
     * Gets the value of the approveSynthesizeRiskLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveSynthesizeRiskLevel() {
        return approveSynthesizeRiskLevel;
    }

    /**
     * Sets the value of the approveSynthesizeRiskLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveSynthesizeRiskLevel(String value) {
        this.approveSynthesizeRiskLevel = value;
    }

    /**
     * Gets the value of the approveReviewRiskLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveReviewRiskLevel() {
        return approveReviewRiskLevel;
    }

    /**
     * Sets the value of the approveReviewRiskLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveReviewRiskLevel(String value) {
        this.approveReviewRiskLevel = value;
    }

    /**
     * Gets the value of the approveRiskLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveRiskLevel() {
        return approveRiskLevel;
    }

    /**
     * Sets the value of the approveRiskLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveRiskLevel(String value) {
        this.approveRiskLevel = value;
    }

    /**
     * Gets the value of the limitCycleFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitCycleFlag() {
        return limitCycleFlag;
    }

    /**
     * Sets the value of the limitCycleFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitCycleFlag(String value) {
        this.limitCycleFlag = value;
    }

    /**
     * Gets the value of the preApproveAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreApproveAmount() {
        return preApproveAmount;
    }

    /**
     * Sets the value of the preApproveAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreApproveAmount(String value) {
        this.preApproveAmount = value;
    }

    /**
     * Gets the value of the preApproveTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreApproveTerm() {
        return preApproveTerm;
    }

    /**
     * Sets the value of the preApproveTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreApproveTerm(String value) {
        this.preApproveTerm = value;
    }

    /**
     * Gets the value of the loanContractNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanContractNo() {
        return loanContractNo;
    }

    /**
     * Sets the value of the loanContractNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanContractNo(String value) {
        this.loanContractNo = value;
    }

    /**
     * Gets the value of the loanCustNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanCustNo() {
        return loanCustNo;
    }

    /**
     * Sets the value of the loanCustNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanCustNo(String value) {
        this.loanCustNo = value;
    }

    /**
     * Gets the value of the loanCustName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanCustName() {
        return loanCustName;
    }

    /**
     * Sets the value of the loanCustName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanCustName(String value) {
        this.loanCustName = value;
    }

    /**
     * Gets the value of the custAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustAddress() {
        return custAddress;
    }

    /**
     * Sets the value of the custAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustAddress(String value) {
        this.custAddress = value;
    }

    /**
     * Gets the value of the custMobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustMobile() {
        return custMobile;
    }

    /**
     * Sets the value of the custMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustMobile(String value) {
        this.custMobile = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the rateReal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateReal() {
        return rateReal;
    }

    /**
     * Sets the value of the rateReal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateReal(String value) {
        this.rateReal = value;
    }

    /**
     * Gets the value of the guaranteeContractNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeContractNo() {
        return guaranteeContractNo;
    }

    /**
     * Sets the value of the guaranteeContractNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeContractNo(String value) {
        this.guaranteeContractNo = value;
    }

    /**
     * Gets the value of the contractAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractAmount() {
        return contractAmount;
    }

    /**
     * Sets the value of the contractAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractAmount(String value) {
        this.contractAmount = value;
    }

    /**
     * Gets the value of the contractTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractTerm() {
        return contractTerm;
    }

    /**
     * Sets the value of the contractTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractTerm(String value) {
        this.contractTerm = value;
    }

    /**
     * Gets the value of the rateFloatType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateFloatType() {
        return rateFloatType;
    }

    /**
     * Sets the value of the rateFloatType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateFloatType(String value) {
        this.rateFloatType = value;
    }

    /**
     * Gets the value of the floatInterate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloatInterate() {
        return floatInterate;
    }

    /**
     * Sets the value of the floatInterate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloatInterate(String value) {
        this.floatInterate = value;
    }

    /**
     * Gets the value of the directEntname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectEntname() {
        return directEntname;
    }

    /**
     * Sets the value of the directEntname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectEntname(String value) {
        this.directEntname = value;
    }

    /**
     * Gets the value of the directAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectAccount() {
        return directAccount;
    }

    /**
     * Sets the value of the directAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectAccount(String value) {
        this.directAccount = value;
    }

    /**
     * Gets the value of the directOrgId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectOrgId() {
        return directOrgId;
    }

    /**
     * Sets the value of the directOrgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectOrgId(String value) {
        this.directOrgId = value;
    }

    /**
     * Gets the value of the directEntaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectEntaddress() {
        return directEntaddress;
    }

    /**
     * Sets the value of the directEntaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectEntaddress(String value) {
        this.directEntaddress = value;
    }

    /**
     * Gets the value of the directLegalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectLegalName() {
        return directLegalName;
    }

    /**
     * Sets the value of the directLegalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectLegalName(String value) {
        this.directLegalName = value;
    }

    /**
     * Gets the value of the guaranteeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeType() {
        return guaranteeType;
    }

    /**
     * Sets the value of the guaranteeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeType(String value) {
        this.guaranteeType = value;
    }

    /**
     * Gets the value of the guaranteeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeName() {
        return guaranteeName;
    }

    /**
     * Sets the value of the guaranteeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeName(String value) {
        this.guaranteeName = value;
    }

    /**
     * Gets the value of the guaranteeAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeAccount() {
        return guaranteeAccount;
    }

    /**
     * Sets the value of the guaranteeAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeAccount(String value) {
        this.guaranteeAccount = value;
    }

    /**
     * Gets the value of the guaranteeOrgId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeOrgId() {
        return guaranteeOrgId;
    }

    /**
     * Sets the value of the guaranteeOrgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeOrgId(String value) {
        this.guaranteeOrgId = value;
    }

    /**
     * Gets the value of the guaranteeInAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeInAccount() {
        return guaranteeInAccount;
    }

    /**
     * Sets the value of the guaranteeInAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeInAccount(String value) {
        this.guaranteeInAccount = value;
    }

    /**
     * Gets the value of the guaranteeAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeAddress() {
        return guaranteeAddress;
    }

    /**
     * Sets the value of the guaranteeAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeAddress(String value) {
        this.guaranteeAddress = value;
    }

    /**
     * Gets the value of the guaranteeLegalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeLegalName() {
        return guaranteeLegalName;
    }

    /**
     * Sets the value of the guaranteeLegalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeLegalName(String value) {
        this.guaranteeLegalName = value;
    }

    /**
     * Gets the value of the guaranteeAmountFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeAmountFlag() {
        return guaranteeAmountFlag;
    }

    /**
     * Sets the value of the guaranteeAmountFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeAmountFlag(String value) {
        this.guaranteeAmountFlag = value;
    }

    /**
     * Gets the value of the guaranteePayType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteePayType() {
        return guaranteePayType;
    }

    /**
     * Sets the value of the guaranteePayType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteePayType(String value) {
        this.guaranteePayType = value;
    }

    /**
     * Gets the value of the guaranteeProportion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeProportion() {
        return guaranteeProportion;
    }

    /**
     * Sets the value of the guaranteeProportion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeProportion(String value) {
        this.guaranteeProportion = value;
    }

    /**
     * Gets the value of the guaranteeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeAmount() {
        return guaranteeAmount;
    }

    /**
     * Sets the value of the guaranteeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeAmount(String value) {
        this.guaranteeAmount = value;
    }

    /**
     * Gets the value of the vendorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * Sets the value of the vendorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorName(String value) {
        this.vendorName = value;
    }

    /**
     * Gets the value of the brandRemark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandRemark() {
        return brandRemark;
    }

    /**
     * Sets the value of the brandRemark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandRemark(String value) {
        this.brandRemark = value;
    }

    /**
     * Gets the value of the categoryRemark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryRemark() {
        return categoryRemark;
    }

    /**
     * Sets the value of the categoryRemark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryRemark(String value) {
        this.categoryRemark = value;
    }

    /**
     * Gets the value of the reguaranteeRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReguaranteeRate() {
        return reguaranteeRate;
    }

    /**
     * Sets the value of the reguaranteeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReguaranteeRate(String value) {
        this.reguaranteeRate = value;
    }

    /**
     * Gets the value of the wdStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWdStatus() {
        return wdStatus;
    }

    /**
     * Sets the value of the wdStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWdStatus(String value) {
        this.wdStatus = value;
    }

    /**
     * Gets the value of the personalStatusName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalStatusName() {
        return personalStatusName;
    }

    /**
     * Sets the value of the personalStatusName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalStatusName(String value) {
        this.personalStatusName = value;
    }

    /**
     * Gets the value of the entityStatusName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityStatusName() {
        return entityStatusName;
    }

    /**
     * Sets the value of the entityStatusName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityStatusName(String value) {
        this.entityStatusName = value;
    }

    /**
     * Gets the value of the obligate1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate1() {
        return obligate1;
    }

    /**
     * Sets the value of the obligate1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate1(String value) {
        this.obligate1 = value;
    }

    /**
     * Gets the value of the obligate2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate2() {
        return obligate2;
    }

    /**
     * Sets the value of the obligate2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate2(String value) {
        this.obligate2 = value;
    }

    /**
     * Gets the value of the obligate3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate3() {
        return obligate3;
    }

    /**
     * Sets the value of the obligate3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate3(String value) {
        this.obligate3 = value;
    }

    /**
     * Gets the value of the obligate4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate4() {
        return obligate4;
    }

    /**
     * Sets the value of the obligate4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate4(String value) {
        this.obligate4 = value;
    }

    /**
     * Gets the value of the obligate5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate5() {
        return obligate5;
    }

    /**
     * Sets the value of the obligate5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate5(String value) {
        this.obligate5 = value;
    }

    /**
     * Gets the value of the obligate6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate6() {
        return obligate6;
    }

    /**
     * Sets the value of the obligate6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate6(String value) {
        this.obligate6 = value;
    }

    /**
     * Gets the value of the obligate7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate7() {
        return obligate7;
    }

    /**
     * Sets the value of the obligate7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate7(String value) {
        this.obligate7 = value;
    }

    /**
     * Gets the value of the obligate8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate8() {
        return obligate8;
    }

    /**
     * Sets the value of the obligate8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate8(String value) {
        this.obligate8 = value;
    }

    /**
     * Gets the value of the obligate9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate9() {
        return obligate9;
    }

    /**
     * Sets the value of the obligate9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate9(String value) {
        this.obligate9 = value;
    }

    /**
     * Gets the value of the obligate10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligate10() {
        return obligate10;
    }

    /**
     * Sets the value of the obligate10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligate10(String value) {
        this.obligate10 = value;
    }

}
