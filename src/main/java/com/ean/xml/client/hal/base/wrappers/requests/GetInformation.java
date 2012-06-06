
package com.ean.xml.client.hal.base.wrappers.requests;

import com.ean.xml.client.hal.requests.HotelInformationRequest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelInformationRequest" type="{http://v3.properties.wsapi.ean.com/}HotelInformationRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInformation", propOrder = {
    "hotelInformationRequest"
})
public class GetInformation {

    @XmlElement(name = "HotelInformationRequest")
    protected HotelInformationRequest hotelInformationRequest;

    /**
     * Gets the value of the hotelInformationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link HotelInformationRequest }
     *     
     */
    public HotelInformationRequest getHotelInformationRequest() {
        return hotelInformationRequest;
    }

    /**
     * Sets the value of the hotelInformationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInformationRequest }
     *     
     */
    public void setHotelInformationRequest(HotelInformationRequest value) {
        this.hotelInformationRequest = value;
    }

}
