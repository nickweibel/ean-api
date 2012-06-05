
package com.ean.xml.client.v3.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseRateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NightlyRatesPerRoom" type="{http://v3.hotel.wsapi.ean.com/}NightlyRatesPerRoom" minOccurs="0"/>
 *         &lt;element name="Surcharges" type="{http://v3.hotel.wsapi.ean.com/}Surcharges" minOccurs="0"/>
 *         &lt;element name="Discounts" type="{http://v3.hotel.wsapi.ean.com/}Discounts" minOccurs="0"/>
 *         &lt;element name="promoDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxNightlyRate" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="averageRate" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="averageBaseRate" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="nightlyRateTotal" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="surchargeTotal" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="discountTotal" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="commissionableUsdTotal" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRateInfo", propOrder = {
    "nightlyRatesPerRoom",
    "surcharges",
    "discounts",
    "promoDescription"
})
public class BaseRateInfo {

    @XmlElement(name = "NightlyRatesPerRoom")
    protected NightlyRatesPerRoom nightlyRatesPerRoom;
    @XmlElement(name = "Surcharges")
    protected Surcharges surcharges;
    @XmlElement(name = "Discounts")
    protected Discounts discounts;
    protected String promoDescription;
    @XmlAttribute
    protected String currencyCode;
    @XmlAttribute
    protected Float maxNightlyRate;
    @XmlAttribute
    protected Float averageRate;
    @XmlAttribute
    protected Float averageBaseRate;
    @XmlAttribute
    protected Float nightlyRateTotal;
    @XmlAttribute
    protected Float surchargeTotal;
    @XmlAttribute
    protected Float discountTotal;
    @XmlAttribute
    protected Float total;
    @XmlAttribute
    protected Float commissionableUsdTotal;

    /**
     * Gets the value of the nightlyRatesPerRoom property.
     * 
     * @return
     *     possible object is
     *     {@link NightlyRatesPerRoom }
     *     
     */
    public NightlyRatesPerRoom getNightlyRatesPerRoom() {
        return nightlyRatesPerRoom;
    }

    /**
     * Sets the value of the nightlyRatesPerRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link NightlyRatesPerRoom }
     *     
     */
    public void setNightlyRatesPerRoom(NightlyRatesPerRoom value) {
        this.nightlyRatesPerRoom = value;
    }

    /**
     * Gets the value of the surcharges property.
     * 
     * @return
     *     possible object is
     *     {@link Surcharges }
     *     
     */
    public Surcharges getSurcharges() {
        return surcharges;
    }

    /**
     * Sets the value of the surcharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link Surcharges }
     *     
     */
    public void setSurcharges(Surcharges value) {
        this.surcharges = value;
    }

    /**
     * Gets the value of the discounts property.
     * 
     * @return
     *     possible object is
     *     {@link Discounts }
     *     
     */
    public Discounts getDiscounts() {
        return discounts;
    }

    /**
     * Sets the value of the discounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Discounts }
     *     
     */
    public void setDiscounts(Discounts value) {
        this.discounts = value;
    }

    /**
     * Gets the value of the promoDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoDescription() {
        return promoDescription;
    }

    /**
     * Sets the value of the promoDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoDescription(String value) {
        this.promoDescription = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the maxNightlyRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMaxNightlyRate() {
        return maxNightlyRate;
    }

    /**
     * Sets the value of the maxNightlyRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMaxNightlyRate(Float value) {
        this.maxNightlyRate = value;
    }

    /**
     * Gets the value of the averageRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAverageRate() {
        return averageRate;
    }

    /**
     * Sets the value of the averageRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAverageRate(Float value) {
        this.averageRate = value;
    }

    /**
     * Gets the value of the averageBaseRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAverageBaseRate() {
        return averageBaseRate;
    }

    /**
     * Sets the value of the averageBaseRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAverageBaseRate(Float value) {
        this.averageBaseRate = value;
    }

    /**
     * Gets the value of the nightlyRateTotal property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNightlyRateTotal() {
        return nightlyRateTotal;
    }

    /**
     * Sets the value of the nightlyRateTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNightlyRateTotal(Float value) {
        this.nightlyRateTotal = value;
    }

    /**
     * Gets the value of the surchargeTotal property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSurchargeTotal() {
        return surchargeTotal;
    }

    /**
     * Sets the value of the surchargeTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSurchargeTotal(Float value) {
        this.surchargeTotal = value;
    }

    /**
     * Gets the value of the discountTotal property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDiscountTotal() {
        return discountTotal;
    }

    /**
     * Sets the value of the discountTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDiscountTotal(Float value) {
        this.discountTotal = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotal(Float value) {
        this.total = value;
    }

    /**
     * Gets the value of the commissionableUsdTotal property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCommissionableUsdTotal() {
        return commissionableUsdTotal;
    }

    /**
     * Sets the value of the commissionableUsdTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCommissionableUsdTotal(Float value) {
        this.commissionableUsdTotal = value;
    }

}
