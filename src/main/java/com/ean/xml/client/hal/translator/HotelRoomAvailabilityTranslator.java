package com.ean.xml.client.hal.translator;

import com.ean.xml.client.hal.requests.BaseRequest;
import com.ean.xml.client.hal.requests.HotelRoomAvailabilityRequest;
import com.ean.xml.client.hal.responses.HotelRoomAvailabilityResponse;
import com.ean.xml.client.hal.util.EanElement;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

/**
 * Translator used to transform requests to xml documents and xml documents to responses.
 */
public class HotelRoomAvailabilityTranslator implements Translator {
    @Override
    public Document createRequestDocument(BaseRequest baseRequest) {
        if (baseRequest == null) {
            return null;
        }

        HotelRoomAvailabilityRequest request = (HotelRoomAvailabilityRequest) baseRequest;

        Document document = DocumentHelper.createDocument();
        EanElement root = (EanElement) document.addElement("HotelRoomAvailabilityRequest");

        root.addHotelId(request.getHotelId());
        root.addArrivalDate(request.getArrivalDate());
        root.addDepartureDate(request.getDepartureDate());
        root.addNumberOfBedRooms(request.getNumberOfBedRooms());
        root.addSupplierType(request.getSupplierType());
        root.addRateKey(request.getRateKey());
        root.addRateCode(request.getRateCode());
        root.addRoomTypeCode(request.getRoomTypeCode());
        root.addIncludeDetails(request.isIncludeDetails());
        root.addHotelAvailOption(request.getOptions());
        root.addRoomGroup(request.getRoomGroup());

        return document;
    }

    @Override
    public HotelRoomAvailabilityResponse createResponseObject(Document document) {
        if (document == null) {
            return null;
        }

        HotelRoomAvailabilityResponse response = new HotelRoomAvailabilityResponse();
        EanElement root = (EanElement) document.getRootElement();

        response.setCustomerSessionId(root.getCustomerSessionId());
        response.setEanWsError(root.getEanWsError());

        response.setSize(root.getSizeAttributePrimitive());
        response.setHotelId(root.getHotelId());
        response.setArrivalDate(root.getArrivalDate());
        response.setDepartureDate(root.getDepartureDate());
        response.setHotelName(root.getHotelName());
        response.setHotelAddress(root.getHotelAddress());
        response.setHotelCity(root.getHotelCity());
        response.setHotelStateProvince(root.getHotelStateProvince());
        response.setHotelCountry(root.getHotelCountry());
        response.setNumberOfRoomsRequested(root.getNumberOfRoomsRequested());
        response.setCheckInInstructions(root.getCheckInInstructions());
        response.setTripAdvisorRating(root.getTripAdvisorRating());
        response.setRateKey(root.getRateKey());
        response.getHotelRoomResponse().addAll(root.getHotelRoomResponseList());
        response.setHotelDetails(root.getHotelDetails());
        response.setPropertyAmenities(root.getPropertyAmenities());
        response.setHotelImages(root.getHotelImages());

        return response;
    }
}