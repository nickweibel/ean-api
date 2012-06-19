
package com.ean.xml.client.hal.base.rates;

import com.ean.xml.client.hal.base.properties.CancelPolicyInfoList;
import com.ean.xml.client.hal.base.room.RoomGroup;
import java.util.ArrayList;
import java.util.List;

public class HotelRateInfo {

    protected RoomGroup roomGroup;
    protected BaseRateInfo chargeableRateInfo;
    protected BaseRateInfo convertedRateInfo;
    protected List<String> confirmationNumbers;
    protected String cancellationPolicy;
    protected CancelPolicyInfoList cancelPolicyInfoList;
    protected Boolean nonRefundable;
    protected Boolean online;
    protected RatePlanType ratePlanType;
    protected Boolean priceBreakdown;
    protected Boolean promo;
    protected Boolean rateChange;
    protected String pkgSavingsPercent;
    protected String pkgSavingsAmount;

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
     * Gets the value of the chargeableRateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BaseRateInfo }
     *     
     */
    public BaseRateInfo getChargeableRateInfo() {
        return chargeableRateInfo;
    }

    /**
     * Sets the value of the chargeableRateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseRateInfo }
     *     
     */
    public void setChargeableRateInfo(BaseRateInfo value) {
        this.chargeableRateInfo = value;
    }

    /**
     * Gets the value of the convertedRateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BaseRateInfo }
     *     
     */
    public BaseRateInfo getConvertedRateInfo() {
        return convertedRateInfo;
    }

    /**
     * Sets the value of the convertedRateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseRateInfo }
     *     
     */
    public void setConvertedRateInfo(BaseRateInfo value) {
        this.convertedRateInfo = value;
    }

    /**
     * Gets the value of the confirmationNumbers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the confirmationNumbers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfirmationNumbers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConfirmationNumbers() {
        if (confirmationNumbers == null) {
            confirmationNumbers = new ArrayList<String>();
        }
        return this.confirmationNumbers;
    }

    /**
     * Gets the value of the cancellationPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    /**
     * Sets the value of the cancellationPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancellationPolicy(String value) {
        this.cancellationPolicy = value;
    }

    /**
     * Gets the value of the cancelPolicyInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link CancelPolicyInfoList }
     *     
     */
    public CancelPolicyInfoList getCancelPolicyInfoList() {
        return cancelPolicyInfoList;
    }

    /**
     * Sets the value of the cancelPolicyInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelPolicyInfoList }
     *     
     */
    public void setCancelPolicyInfoList(CancelPolicyInfoList value) {
        this.cancelPolicyInfoList = value;
    }

    /**
     * Gets the value of the nonRefundable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNonRefundable() {
        return nonRefundable;
    }

    /**
     * Sets the value of the nonRefundable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNonRefundable(Boolean value) {
        this.nonRefundable = value;
    }

    /**
     * Gets the value of the online property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnline() {
        return online;
    }

    /**
     * Sets the value of the online property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnline(Boolean value) {
        this.online = value;
    }

    /**
     * Gets the value of the ratePlanType property.
     * 
     * @return
     *     possible object is
     *     {@link RatePlanType }
     *     
     */
    public RatePlanType getRatePlanType() {
        return ratePlanType;
    }

    /**
     * Sets the value of the ratePlanType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RatePlanType }
     *     
     */
    public void setRatePlanType(RatePlanType value) {
        this.ratePlanType = value;
    }

    /**
     * Gets the value of the priceBreakdown property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPriceBreakdown() {
        return priceBreakdown;
    }

    /**
     * Sets the value of the priceBreakdown property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPriceBreakdown(Boolean value) {
        this.priceBreakdown = value;
    }

    /**
     * Gets the value of the promo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPromo() {
        return promo;
    }

    /**
     * Sets the value of the promo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPromo(Boolean value) {
        this.promo = value;
    }

    /**
     * Gets the value of the rateChange property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRateChange() {
        return rateChange;
    }

    /**
     * Sets the value of the rateChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRateChange(Boolean value) {
        this.rateChange = value;
    }

    /**
     * Gets the value of the pkgSavingsPercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPkgSavingsPercent() {
        return pkgSavingsPercent;
    }

    /**
     * Sets the value of the pkgSavingsPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPkgSavingsPercent(String value) {
        this.pkgSavingsPercent = value;
    }

    /**
     * Gets the value of the pkgSavingsAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPkgSavingsAmount() {
        return pkgSavingsAmount;
    }

    /**
     * Sets the value of the pkgSavingsAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPkgSavingsAmount(String value) {
        this.pkgSavingsAmount = value;
    }

}
