
package com.ean.xml.client.hal.base.rates;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomRateDetailsList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomRateDetailsList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomRateDetails" type="{http://v3.properties.wsapi.ean.com/}RoomRateDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomRateDetailsList", propOrder = {
    "roomRateDetails"
})
public class RoomRateDetailsList {

    @XmlElement(name = "RoomRateDetails")
    protected List<RoomRateDetails> roomRateDetails;

    /**
     * Gets the value of the roomRateDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomRateDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomRateDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomRateDetails }
     * 
     * 
     */
    public List<RoomRateDetails> getRoomRateDetails() {
        if (roomRateDetails == null) {
            roomRateDetails = new ArrayList<RoomRateDetails>();
        }
        return this.roomRateDetails;
    }

}
