
package com.ean.xml.client.hal.requests;

public abstract class HotelBaseRequest extends BaseRequest {

    private Integer minorRev;
    private RequestType type;

    /**
     *
     * @return
     */
    public RequestType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(RequestType type) {
        this.type = type;
    }

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
