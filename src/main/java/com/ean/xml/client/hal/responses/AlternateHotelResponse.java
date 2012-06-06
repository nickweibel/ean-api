
package com.ean.xml.client.hal.responses;

import com.ean.xml.client.hal.base.properties.Amenities;
import com.ean.xml.client.hal.base.properties.HotelInfo;
import com.ean.xml.client.hal.base.rates.LowestRateInfo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlternateHotelResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlternateHotelResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelInfo" type="{http://v3.properties.wsapi.ean.com/}HotelInfo" minOccurs="0"/>
 *         &lt;element name="Amenities" type="{http://v3.properties.wsapi.ean.com/}Amenities" minOccurs="0"/>
 *         &lt;element name="LowestRateInfo" type="{http://v3.properties.wsapi.ean.com/}LowestRateInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlternateHotelResponse", propOrder = {
    "hotelInfo",
    "amenities",
    "lowestRateInfo"
})
public class AlternateHotelResponse {

    @XmlElement(name = "HotelInfo")
    protected HotelInfo hotelInfo;
    @XmlElement(name = "Amenities")
    protected Amenities amenities;
    @XmlElement(name = "LowestRateInfo")
    protected LowestRateInfo lowestRateInfo;

    /**
     * Gets the value of the hotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfo }
     *     
     */
    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Sets the value of the hotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfo }
     *     
     */
    public void setHotelInfo(HotelInfo value) {
        this.hotelInfo = value;
    }

    /**
     * Gets the value of the amenities property.
     * 
     * @return
     *     possible object is
     *     {@link Amenities }
     *     
     */
    public Amenities getAmenities() {
        return amenities;
    }

    /**
     * Sets the value of the amenities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amenities }
     *     
     */
    public void setAmenities(Amenities value) {
        this.amenities = value;
    }

    /**
     * Gets the value of the lowestRateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LowestRateInfo }
     *     
     */
    public LowestRateInfo getLowestRateInfo() {
        return lowestRateInfo;
    }

    /**
     * Sets the value of the lowestRateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowestRateInfo }
     *     
     */
    public void setLowestRateInfo(LowestRateInfo value) {
        this.lowestRateInfo = value;
    }

}
