package com.ean.xml.client.hal.requests;

import com.ean.xml.client.hal.base.rates.RatePlanType;
import com.ean.xml.client.hal.base.room.RoomGroup;

public class AlternatePropertyListRequest extends HotelBaseRequest {

    protected long originalHotelId;
    protected String arrivalDate;
    protected String departureDate;
    protected float originalAverageNightlyRate;
    protected RoomGroup roomGroup;
    protected RatePlanType rateType;
    protected Integer priceType;

    /**
     * Gets the value of the originalHotelId property.
     * 
     */
    public long getOriginalHotelId() {
        return originalHotelId;
    }

    /**
     * Sets the value of the originalHotelId property.
     * 
     */
    public void setOriginalHotelId(long value) {
        this.originalHotelId = value;
    }

    /**
     * Gets the value of the arrivalDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the value of the arrivalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalDate(String value) {
        this.arrivalDate = value;
    }

    /**
     * Gets the value of the departureDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureDate(String value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the originalAverageNightlyRate property.
     * 
     */
    public float getOriginalAverageNightlyRate() {
        return originalAverageNightlyRate;
    }

    /**
     * Sets the value of the originalAverageNightlyRate property.
     * 
     */
    public void setOriginalAverageNightlyRate(float value) {
        this.originalAverageNightlyRate = value;
    }

    /**
     * Gets the value of the roomGroup property.
     * 
     * @return
     *     possible object is
     *     {@link RoomGroup }
     *     
     */
    public RoomGroup getRoomGroup() {
        return roomGroup;
    }

    /**
     * Sets the value of the roomGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomGroup }
     *     
     */
    public void setRoomGroup(RoomGroup value) {
        this.roomGroup = value;
    }

    /**
     * Gets the value of the rateType property.
     * 
     * @return
     *     possible object is
     *     {@link RatePlanType }
     *     
     */
    public RatePlanType getRateType() {
        return rateType;
    }

    /**
     * Sets the value of the rateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RatePlanType }
     *     
     */
    public void setRateType(RatePlanType value) {
        this.rateType = value;
    }

    /**
     * Gets the value of the priceType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * Sets the value of the priceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriceType(Integer value) {
        this.priceType = value;
    }

}
