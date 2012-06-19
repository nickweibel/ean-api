
package com.ean.xml.client.hal.responses;

import com.ean.xml.client.hal.base.errors.EanWsError;
import javax.xml.bind.annotation.XmlElement;

public class BaseResponse {

    protected EanWsError eanWsError;
    protected String customerSessionId;

    /**
     * Gets the value of the eanWsError property.
     * 
     * @return
     *     possible object is
     *     {@link EanWsError }
     *     
     */
    public EanWsError getEanWsError() {
        return eanWsError;
    }

    /**
     * Sets the value of the eanWsError property.
     * 
     * @param value
     *     allowed object is
     *     {@link EanWsError }
     *     
     */
    public void setEanWsError(EanWsError value) {
        this.eanWsError = value;
    }

    /**
     * Gets the value of the customerSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSessionId() {
        return customerSessionId;
    }

    /**
     * Sets the value of the customerSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSessionId(String value) {
        this.customerSessionId = value;
    }

}
