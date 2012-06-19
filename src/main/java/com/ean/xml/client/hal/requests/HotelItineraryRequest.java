package com.ean.xml.client.hal.requests;

import com.ean.xml.client.hal.base.itinerary.ItineraryQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Request for retrieving the Hotel Itinerary for a booking.
 */
public class HotelItineraryRequest extends HotelBaseRequest {
    private Long itineraryId;
    private String lastName;
    private String email;
    private String affiliateConfirmationId;
    private String affiliateCustomerId;
    private ItineraryQuery itineraryQuery;
    private List<String> confirmationExtras;

    /**
     * Creates a HotelItineraryRequest.
     * @param itineraryId Itinerary id.
     * @param email Customer email address.
     */
    public HotelItineraryRequest(long itineraryId, String email) {
        this.itineraryId = itineraryId;
        this.email = email;
    }

    /**
     * Creates a HotelItineraryRequest.
     * @param affiliateConfirmationId affiliate confirmation id.
     */
    public HotelItineraryRequest(String affiliateConfirmationId) {
        this.affiliateConfirmationId = affiliateConfirmationId;
    }

    /**
     * Gets the ItineraryId.
     * @return Itinerary Id.
     */
    public Long getItineraryId() {
        return itineraryId;
    }

    /**
     * Sets the ItineraryId.
     * @param value Itinerary Id.
     */
    public void setItineraryId(Long value) {
        this.itineraryId = value;
    }

    /**
     * Gets the Last Name.
     * @return customer last night.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Last Name.
     * @param value customer last night.
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the email address.
     * @return customer email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * @param value customer email address.
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the Affiliate Confirmation Id.
     * @return Affiliate Confirmation Id.
     */
    public String getAffiliateConfirmationId() {
        return affiliateConfirmationId;
    }

    /**
     * Sets the Affiliate Confirmation Id.
     * @param value Affilaite Confirmation Id.
     */
    public void setAffiliateConfirmationId(String value) {
        this.affiliateConfirmationId = value;
    }

    /**
     * Gets the Affiliate Customer Id.
     * @return Affiliate Customer Id.
     */
    public String getAffiliateCustomerId() {
        return affiliateCustomerId;
    }

    /**
     * Set the Affiliate Customer Id.
     * @param value Affiliate Customer Id.
     */
    public void setAffiliateCustomerId(String value) {
        this.affiliateCustomerId = value;
    }

    /**
     * Gets the Itinerary Query.
     * @return Itinerary Query.
     */
    public ItineraryQuery getItineraryQuery() {
        return itineraryQuery;
    }

    /**
     * Sets the Itinerary Query.
     * @param value Itinerary Query.
     */
    public void setItineraryQuery(ItineraryQuery value) {
        this.itineraryQuery = value;
    }

    /**
     * Gets the Confirmation Extras.
     * @return Confirmation Extras List, Creates a new List if one does not currently exist.
     */
    public List<String> getConfirmationExtras() {
        if (confirmationExtras == null) {
            confirmationExtras = new ArrayList<String>();
        }
        return this.confirmationExtras;
    }

}
