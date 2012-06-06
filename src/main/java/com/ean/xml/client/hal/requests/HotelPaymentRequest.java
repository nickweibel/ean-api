
package com.ean.xml.client.hal.requests;

import com.ean.xml.client.hal.requests.HotelBaseRequest;
import com.ean.xml.client.hal.requests.V3HotelPaymentRequest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelPaymentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelPaymentRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://v3.properties.wsapi.ean.com/}HotelBaseRequest">
 *       &lt;all>
 *       &lt;/all>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelPaymentRequest")
@XmlSeeAlso({
    V3HotelPaymentRequest.class
})
public class HotelPaymentRequest
    extends HotelBaseRequest
{


}
