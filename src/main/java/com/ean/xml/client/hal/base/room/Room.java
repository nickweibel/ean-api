
package com.ean.xml.client.hal.base.room;

import com.ean.xml.client.hal.base.customerInfo.SmokingPreference;
import java.util.ArrayList;
import java.util.List;


public class Room {
    protected int numberOfAdults;
    protected Integer numberOfChildren;
    protected List<Integer> childAges;
    protected String firstName;
    protected String lastName;
    protected String bedTypeId;
    protected String bedTypeDescription;
    protected Integer numberOfBeds;
    protected SmokingPreference smokingPreference;
    protected String roomTypeCode;
    protected String rateCode;
    protected String rateKey;
    protected String roomDescription;
    protected Float chargeableRate;

    public Room(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public Room(int numberOfAdults, int numberOfChildren, int... childAges) {
        this.numberOfAdults = numberOfAdults;

        setChildData(numberOfChildren, childAges);
    }

    public Room(String firstName, String lastName, String bedTypeId, int numberOfAdults, int numberOfChildren,
                int... childAges) {
        this.numberOfAdults = numberOfAdults;

        setChildData(numberOfChildren, childAges);

        this.firstName = firstName;
        this.lastName = lastName;
        this.bedTypeId = bedTypeId;
    }

    private void setChildData(int numberOfChildren, int... childAges) {
        this.numberOfChildren = numberOfChildren;

        this.childAges = new ArrayList<Integer>();
        for (int childAge : childAges) {
            this.childAges.add(childAge);
        }
    }


    /**
     * Gets the value of the numberOfAdults property.
     * 
     */
    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * Sets the value of the numberOfAdults property.
     * 
     */
    public void setNumberOfAdults(int value) {
        this.numberOfAdults = value;
    }

    /**
     * Gets the value of the numberOfChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * Sets the value of the numberOfChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfChildren(Integer value) {
        this.numberOfChildren = value;
    }

    /**
     * Gets the value of the childAges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childAges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildAges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getChildAges() {
        if (childAges == null) {
            childAges = new ArrayList<Integer>();
        }
        return this.childAges;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the bedTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedTypeId() {
        return bedTypeId;
    }

    /**
     * Sets the value of the bedTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedTypeId(String value) {
        this.bedTypeId = value;
    }

    /**
     * Gets the value of the bedTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedTypeDescription() {
        return bedTypeDescription;
    }

    /**
     * Sets the value of the bedTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedTypeDescription(String value) {
        this.bedTypeDescription = value;
    }

    /**
     * Gets the value of the numberOfBeds property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    /**
     * Sets the value of the numberOfBeds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfBeds(Integer value) {
        this.numberOfBeds = value;
    }

    /**
     * Gets the value of the smokingPreference property.
     * 
     * @return
     *     possible object is
     *     {@link SmokingPreference }
     *     
     */
    public SmokingPreference getSmokingPreference() {
        return smokingPreference;
    }

    /**
     * Sets the value of the smokingPreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmokingPreference }
     *     
     */
    public void setSmokingPreference(SmokingPreference value) {
        this.smokingPreference = value;
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
     * Gets the value of the roomDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * Sets the value of the roomDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomDescription(String value) {
        this.roomDescription = value;
    }

    /**
     * Gets the value of the chargeableRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getChargeableRate() {
        return chargeableRate;
    }

    /**
     * Sets the value of the chargeableRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setChargeableRate(Float value) {
        this.chargeableRate = value;
    }

}
