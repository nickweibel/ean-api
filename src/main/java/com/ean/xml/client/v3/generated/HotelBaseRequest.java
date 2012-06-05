
package com.ean.xml.client.v3.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelBaseRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelBaseRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://v3.hotel.wsapi.ean.com/}BaseRequest">
 *       &lt;sequence>
 *         &lt;element name="minorRev" type="{http://v3.hotel.wsapi.ean.com/}HotelMinorRevType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelBaseRequest", propOrder = {
    "minorRev"
})
@XmlSeeAlso({
    HotelInformationRequest.class,
    HotelItineraryRequest.class,
    HotelRateRulesRequest.class,
    AlternatePropertyListRequest.class,
    HotelPaymentRequest.class,
    HotelListRequest.class,
    HotelRoomReservationRequest.class,
    HotelRoomCancellationRequest.class,
    PingRequest.class,
    HotelRoomAvailabilityRequest.class,
    LocationInfoRequest.class
})
public abstract class HotelBaseRequest
    extends BaseRequest
{

    protected Integer minorRev;

    /**
     * Gets the value of the minorRev property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinorRev() {
        return minorRev;
    }

    /**
     * Sets the value of the minorRev property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinorRev(Integer value) {
        this.minorRev = value;
    }

}
