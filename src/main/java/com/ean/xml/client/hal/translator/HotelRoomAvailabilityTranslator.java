package com.ean.xml.client.hal.translator;

import com.ean.xml.client.hal.base.properties.HotelAvailOption;
import com.ean.xml.client.hal.requests.HotelRoomAvailabilityRequest;
import com.ean.xml.client.hal.responses.HotelRoomAvailabilityResponse;
import com.ean.xml.client.hal.util.XmlParserHelper;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class HotelRoomAvailabilityTranslator implements Translator
        <HotelRoomAvailabilityRequest, Document, HotelRoomAvailabilityResponse> {
    @Override
    public Document createRequestDocument(HotelRoomAvailabilityRequest request) {
        Document document = DocumentHelper.createDocument();

        Element root = document.addElement("HotelRoomAvailabilityRequest");

        XmlParserHelper.addElementLong(root, "hotelId", request.getHotelId());
        XmlParserHelper.addElementString(root, "arrivalDate", request.getArrivalDate().toString(DATE_FORMATTER));
        XmlParserHelper.addElementString(root, "departureDate", request.getDepartureDate().toString(DATE_FORMATTER));
        XmlParserHelper.addRoomGroup(root, request.getRoomGroup());
        XmlParserHelper.addElementString(root, "rateKey", request.getRateKey());

        XmlParserHelper.addElementInteger(root, "numberOfBedRooms", request.getNumberOfBedRooms());
        if (request.getSupplierType() != null) {
            XmlParserHelper.addElementString(root, "supplierType", request.getSupplierType().value());
        }
        XmlParserHelper.addElementString(root, "rateCode", request.getRateCode());
        XmlParserHelper.addElementString(root, "roomTypeCode", request.getRoomTypeCode());

        if (request.isIncludeDetails()) {
            root.addElement("includeDetails").setText("true");
        }

        if (request.getOptions().size() > 0) {
            StringBuilder optionsString = new StringBuilder();

            for (HotelAvailOption option : request.getOptions()) {
                optionsString.append(option.value()).append(',');
            }

            XmlParserHelper.addElementString(root, "options", optionsString.substring(0, optionsString.length() - 1));
        }

        return document;
    }

    @Override
    public HotelRoomAvailabilityResponse createResponseObject(Document response) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
