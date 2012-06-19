
package com.ean.xml.client.hal.requests;

import com.ean.xml.client.hal.base.coupon.CouponData;
import com.ean.xml.client.hal.base.properties.HotelAvailOption;
import com.ean.xml.client.hal.base.room.MultiRoomAvailType;
import com.ean.xml.client.hal.base.rates.RatePlanType;
import com.ean.xml.client.hal.base.room.RoomGroup;
import com.ean.xml.client.hal.base.supplier.SupplierType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

public class HotelRoomAvailabilityRequest extends HotelBaseRequest {
    private long hotelId;
    private DateTime arrivalDate;
    private DateTime departureDate;
    private Integer numberOfBedRooms;
    private SupplierType supplierType;
    private String rateKey;
    private RoomGroup roomGroup;
    private RatePlanType rateType;
    private String rateCode;
    private String roomTypeCode;
    private CouponData couponData;
    private Boolean includeDetails;
    private MultiRoomAvailType multiRoomAvail;
    private List<HotelAvailOption> options;

    public HotelRoomAvailabilityRequest(long hotelId, DateTime arrivalDate, DateTime departureDate, String rateKey,
                                        RoomGroup roomGroup) {
        this.hotelId = hotelId;

        if (arrivalDate == null) {
            this.arrivalDate = DateTime.now().plusDays(2);
        } else {
            this.arrivalDate = arrivalDate;
        }

        if (departureDate == null) {
            this.departureDate = this.arrivalDate.plusDays(2);
        } else {
            this.departureDate = departureDate;
        }

        this.rateKey = rateKey;

        if (roomGroup == null) {
            this.roomGroup = RoomGroup.getDefaultRoomGroup();
        } else {
            this.roomGroup = roomGroup;
        }
    }

    @Override
    public RequestType getType() {
        return RequestType.AVAIL;
    }

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
     * Gets the value of the numberOfBedRooms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfBedRooms() {
        return numberOfBedRooms;
    }

    /**
     * Sets the value of the numberOfBedRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfBedRooms(Integer value) {
        this.numberOfBedRooms = value;
    }

    /**
     * Gets the value of the supplierType property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierType }
     *     
     */
    public SupplierType getSupplierType() {
        return supplierType;
    }

    /**
     * Sets the value of the supplierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierType }
     *     
     */
    public void setSupplierType(SupplierType value) {
        this.supplierType = value;
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
     * Gets the value of the rateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateCode() {
        return rateCode;
    }

    /**
     * Sets the value of the rateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateCode(String value) {
        this.rateCode = value;
    }

    /**
     * Gets the value of the roomTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Sets the value of the roomTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeCode(String value) {
        this.roomTypeCode = value;
    }

    /**
     * Gets the value of the couponData property.
     * 
     * @return
     *     possible object is
     *     {@link CouponData }
     *     
     */
    public CouponData getCouponData() {
        return couponData;
    }

    /**
     * Sets the value of the couponData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CouponData }
     *     
     */
    public void setCouponData(CouponData value) {
        this.couponData = value;
    }

    /**
     * Gets the value of the includeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDetails() {
        return includeDetails;
    }

    /**
     * Sets the value of the includeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDetails(Boolean value) {
        this.includeDetails = value;
    }

    /**
     * Gets the value of the multiRoomAvail property.
     * 
     * @return
     *     possible object is
     *     {@link MultiRoomAvailType }
     *     
     */
    public MultiRoomAvailType getMultiRoomAvail() {
        return multiRoomAvail;
    }

    /**
     * Sets the value of the multiRoomAvail property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiRoomAvailType }
     *     
     */
    public void setMultiRoomAvail(MultiRoomAvailType value) {
        this.multiRoomAvail = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelAvailOption }
     * 
     * 
     */
    public List<HotelAvailOption> getOptions() {
        if (options == null) {
            options = new ArrayList<HotelAvailOption>();
        }
        return this.options;
    }

}
