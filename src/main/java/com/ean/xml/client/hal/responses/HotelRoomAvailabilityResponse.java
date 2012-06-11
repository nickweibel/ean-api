
package com.ean.xml.client.hal.responses;

import com.ean.xml.client.hal.base.properties.HotelDetails;
import com.ean.xml.client.hal.base.properties.HotelImages;
import com.ean.xml.client.hal.base.properties.PropertyAmenities;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.joda.time.DateTime;

public class HotelRoomAvailabilityResponse
    extends BaseResponse
{
    public HotelRoomAvailabilityResponse() {
        //Do Nothing
    }

    protected long hotelId;
    protected DateTime arrivalDate;
    protected DateTime departureDate;
    protected String hotelName;
    protected String hotelAddress;
    protected String hotelCity;
    protected String hotelStateProvince;
    protected String hotelCountry;
    protected Integer numberOfRoomsRequested;
    protected String checkInInstructions;
    protected String tripAdvisorRating;
    protected String rateKey;
    protected CouponInformationResponse couponInformationResponse;
    protected List<HotelRoomResponse> hotelRoomResponse;
    protected HotelDetails hotelDetails;
    protected PropertyAmenities propertyAmenities;
    protected HotelImages hotelImages;
    protected int size;

    /**
     * Gets the value of the hotelId property.
     * 
     */
    public long getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     */
    public void setHotelId(long value) {
        this.hotelId = value;
    }

    /**
     * Gets the value of the arrivalDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DateTime getArrivalDate() {
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
    public void setArrivalDate(DateTime value) {
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
    public DateTime getDepartureDate() {
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
    public void setDepartureDate(DateTime value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the hotelAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * Sets the value of the hotelAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddress(String value) {
        this.hotelAddress = value;
    }

    /**
     * Gets the value of the hotelCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCity() {
        return hotelCity;
    }

    /**
     * Sets the value of the hotelCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCity(String value) {
        this.hotelCity = value;
    }

    /**
     * Gets the value of the hotelStateProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelStateProvince() {
        return hotelStateProvince;
    }

    /**
     * Sets the value of the hotelStateProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelStateProvince(String value) {
        this.hotelStateProvince = value;
    }

    /**
     * Gets the value of the hotelCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCountry() {
        return hotelCountry;
    }

    /**
     * Sets the value of the hotelCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCountry(String value) {
        this.hotelCountry = value;
    }

    /**
     * Gets the value of the numberOfRoomsRequested property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfRoomsRequested() {
        return numberOfRoomsRequested;
    }

    /**
     * Sets the value of the numberOfRoomsRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfRoomsRequested(Integer value) {
        this.numberOfRoomsRequested = value;
    }

    /**
     * Gets the value of the checkInInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckInInstructions() {
        return checkInInstructions;
    }

    /**
     * Sets the value of the checkInInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckInInstructions(String value) {
        this.checkInInstructions = value;
    }

    /**
     * Gets the value of the tripAdvisorRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripAdvisorRating() {
        return tripAdvisorRating;
    }

    /**
     * Sets the value of the tripAdvisorRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripAdvisorRating(String value) {
        this.tripAdvisorRating = value;
    }

    /**
     * Gets the value of the rateKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateKey() {
        return rateKey;
    }

    /**
     * Sets the value of the rateKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateKey(String value) {
        this.rateKey = value;
    }

    /**
     * Gets the value of the couponInformationResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CouponInformationResponse }
     *     
     */
    public CouponInformationResponse getCouponInformationResponse() {
        return couponInformationResponse;
    }

    /**
     * Sets the value of the couponInformationResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CouponInformationResponse }
     *     
     */
    public void setCouponInformationResponse(CouponInformationResponse value) {
        this.couponInformationResponse = value;
    }

    /**
     * Gets the value of the hotelRoomResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelRoomResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelRoomResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelRoomResponse }
     * 
     * 
     */
    public List<HotelRoomResponse> getHotelRoomResponse() {
        if (hotelRoomResponse == null) {
            hotelRoomResponse = new ArrayList<HotelRoomResponse>();
        }
        return this.hotelRoomResponse;
    }

    /**
     * Gets the value of the hotelDetails property.
     * 
     * @return
     *     possible object is
     *     {@link HotelDetails }
     *     
     */
    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    /**
     * Sets the value of the hotelDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelDetails }
     *     
     */
    public void setHotelDetails(HotelDetails value) {
        this.hotelDetails = value;
    }

    /**
     * Gets the value of the propertyAmenities property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyAmenities }
     *     
     */
    public PropertyAmenities getPropertyAmenities() {
        return propertyAmenities;
    }

    /**
     * Sets the value of the propertyAmenities property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyAmenities }
     *     
     */
    public void setPropertyAmenities(PropertyAmenities value) {
        this.propertyAmenities = value;
    }

    /**
     * Gets the value of the hotelImages property.
     * 
     * @return
     *     possible object is
     *     {@link HotelImages }
     *     
     */
    public HotelImages getHotelImages() {
        return hotelImages;
    }

    /**
     * Sets the value of the hotelImages property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelImages }
     *     
     */
    public void setHotelImages(HotelImages value) {
        this.hotelImages = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(int value) {
        this.size = value;
    }

}
