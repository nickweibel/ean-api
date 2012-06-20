package com.ean.xml.client.hal.translator;

import com.ean.xml.client.hal.requests.BaseRequest;
import com.ean.xml.client.hal.requests.HotelRoomAvailabilityRequest;
import com.ean.xml.client.hal.responses.HotelRoomAvailabilityResponse;
import com.ean.xml.client.hal.util.EanElement;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.bean.BeanElement;
import org.dom4j.tree.DefaultDocument;

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

        Document document = DocumentFactory.getInstance().createDocument(
                new EanElement("HotelRoomAvailabilityRequest"));
//        DefaultDocument document = (DefaultDocument) DocumentHelper.createDocument();
//        EanElement root = (EanElement) document.addElement("HotelRoomAvailabilityRequest");
        EanElement root = (EanElement) document.getRootElement();


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
        EanElement root = (EanElement) DocumentFactory.getInstance().createDocument(
                new EanElement("HotelRoomAvailabilityResponse")).getRootElement();

        response.setCustomerSessionId(document.selectSingleNode("//customerSessionId").getText());
        Node error = document.selectSingleNode("EanWsError");
        if (error != null) {
            response.setEanWsError(root.getEanWsError());
        } else {

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
        }

        return response;
    }
}