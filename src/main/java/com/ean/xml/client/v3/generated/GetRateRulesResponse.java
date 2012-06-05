
package com.ean.xml.client.v3.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRateRulesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRateRulesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelRateRulesResponse" type="{http://v3.hotel.wsapi.ean.com/}HotelRateRulesResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRateRulesResponse", propOrder = {
    "hotelRateRulesResponse"
})
public class GetRateRulesResponse {

    @XmlElement(name = "HotelRateRulesResponse")
    protected HotelRateRulesResponse hotelRateRulesResponse;

    /**
     * Gets the value of the hotelRateRulesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link HotelRateRulesResponse }
     *     
     */
    public HotelRateRulesResponse getHotelRateRulesResponse() {
        return hotelRateRulesResponse;
    }

    /**
     * Sets the value of the hotelRateRulesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelRateRulesResponse }
     *     
     */
    public void setHotelRateRulesResponse(HotelRateRulesResponse value) {
        this.hotelRateRulesResponse = value;
    }

}
