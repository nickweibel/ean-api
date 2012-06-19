/**
 * Created with IntelliJ IDEA.
 * User: ejelinek
 * Date: 6/12/12
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ean.xml.service;

import com.ean.xml.client.hal.base.room.RoomGroup;
import com.ean.xml.client.hal.requests.HotelRoomAvailabilityRequest;
import com.ean.xml.client.hal.responses.HotelRoomAvailabilityResponse;
import org.joda.time.DateTime;
import org.junit.Test;

public class HotelRoomAvailTest {

    @Test
    public void testHotelRoomAvail() {
        HotelRoomAvailabilityRequest roomAvailabilityRequest = new HotelRoomAvailabilityRequest(
                127092, DateTime.now().plusDays(3), DateTime.now().plusDays(5), null, RoomGroup.getDefaultRoomGroup());

        V3Requestor requestor = new V3Requestor(roomAvailabilityRequest);
        HotelRoomAvailabilityResponse response = (HotelRoomAvailabilityResponse) requestor.executeGet();
        response.getCustomerSessionId();

    }
}
