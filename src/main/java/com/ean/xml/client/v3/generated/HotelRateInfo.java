
package com.ean.xml.client.v3.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelRateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelRateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomGroup" type="{http://v3.hotel.wsapi.ean.com/}RoomGroup" minOccurs="0"/>
 *         &lt;element name="ChargeableRateInfo" type="{http://v3.hotel.wsapi.ean.com/}BaseRateInfo" minOccurs="0"/>
 *         &lt;element name="ConvertedRateInfo" type="{http://v3.hotel.wsapi.ean.com/}BaseRateInfo" minOccurs="0"/>
 *         &lt;element name="confirmationNumbers" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cancellationPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CancelPolicyInfoList" type="{http://v3.hotel.wsapi.ean.com/}CancelPolicyInfoList" minOccurs="0"/>
 *         &lt;element name="nonRefundable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="priceBreakdown" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="promo" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="rateChange" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="pkgSavingsPercent" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pkgSavingsAmount" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelRateInfo", propOrder = {
    "roomGroup",
    "chargeableRateInfo",
    "convertedRateInfo",
    "confirmationNumbers",
    "cancellationPolicy",
    "cancelPolicyInfoList",
    "nonRefundable"
})
public class HotelRateInfo {

    @XmlElement(name = "RoomGroup")
    protected RoomGroup roomGroup;
    @XmlElement(name = "ChargeableRateInfo")
    protected BaseRateInfo chargeableRateInfo;
    @XmlElement(name = "ConvertedRateInfo")
    protected BaseRateInfo convertedRateInfo;
    protected List<String> confirmationNumbers;
    protected String cancellationPolicy;
    @XmlElement(name = "CancelPolicyInfoList")
    protected CancelPolicyInfoList cancelPolicyInfoList;
    protected Boolean nonRefundable;
    @XmlAttribute
    protected Boolean priceBreakdown;
    @XmlAttribute
    protected Boolean promo;
    @XmlAttribute
    protected Boolean rateChange;
    @XmlAttribute
    protected String pkgSavingsPercent;
    @XmlAttribute
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
