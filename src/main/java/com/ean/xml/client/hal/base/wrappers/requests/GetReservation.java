
package com.ean.xml.client.hal.base.wrappers.requests;

import com.ean.xml.client.hal.requests.HotelRoomReservationRequest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getReservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelRoomReservationRequest" type="{http://v3.properties.wsapi.ean.com/}HotelRoomReservationRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReservation", propOrder = {
    "hotelRoomReservationRequest"
})
public class GetReservation {

    @XmlElement(name = "HotelRoomReservationRequest")
    protected HotelRoomReservationRequest hotelRoomReservationRequest;

    /**
     * Gets the value of the hotelRoomReservationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link HotelRoomReservationRequest }
     *     
     */
    public HotelRoomReservationRequest getHotelRoomReservationRequest() {
        return hotelRoomReservationRequest;
    }

    /**
     * Sets the value of the hotelRoomReservationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelRoomReservationRequest }
     *     
     */
    public void setHotelRoomReservationRequest(HotelRoomReservationRequest value) {
        this.hotelRoomReservationRequest = value;
    }

}
