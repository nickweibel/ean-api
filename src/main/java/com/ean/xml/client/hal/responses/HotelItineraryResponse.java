package com.ean.xml.client.hal.responses;

import com.ean.xml.client.hal.base.itinerary.Itinerary;
import java.util.ArrayList;
import java.util.List;

/**
 * Response with Customer Hotel Itinerary from booking
 */
public class HotelItineraryResponse extends BaseResponse {
    protected List<Itinerary> itinerary;
    protected int size;

    /**
     * Gets the Itinerary List.
     * @return Itinerary List. If list is null it will return an empty list.
     */
    public List<Itinerary> getItinerary() {
        if (itinerary == null) {
            itinerary = new ArrayList<Itinerary>();
        }
        return this.itinerary;
    }

    /**
     * Gets the size.
     * @return size of itinerary list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size.
     * @param value size of itinerary list.
     */
    public void setSize(int value) {
        this.size = value;
    }

}
