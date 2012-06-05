
package com.ean.xml.client.v3.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPaymentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPaymentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelPaymentRequest" type="{http://v3.hotel.wsapi.ean.com/}HotelPaymentRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPaymentInfo", propOrder = {
    "hotelPaymentRequest"
})
public class GetPaymentInfo {

    @XmlElement(name = "HotelPaymentRequest")
    protected HotelPaymentRequest hotelPaymentRequest;

    /**
     * Gets the value of the hotelPaymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link HotelPaymentRequest }
     *     
     */
    public HotelPaymentRequest getHotelPaymentRequest() {
        return hotelPaymentRequest;
    }

    /**
     * Sets the value of the hotelPaymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelPaymentRequest }
     *     
     */
    public void setHotelPaymentRequest(HotelPaymentRequest value) {
        this.hotelPaymentRequest = value;
    }

}
