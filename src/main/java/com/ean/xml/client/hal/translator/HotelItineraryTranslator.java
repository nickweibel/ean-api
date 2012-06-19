package com.ean.xml.client.hal.translator;

import com.ean.xml.client.hal.requests.BaseRequest;
import com.ean.xml.client.hal.requests.HotelItineraryRequest;
import com.ean.xml.client.hal.responses.HotelItineraryResponse;
import com.ean.xml.client.hal.util.EanElement;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

/**
 * Translator used to transform requests to xml documents and xml documents to responses.
 */
public class HotelItineraryTranslator implements Translator {
    @Override
    public Document createRequestDocument(BaseRequest baseRequest) {
        if (baseRequest == null) {
            return null;
        }

        HotelItineraryRequest request = (HotelItineraryRequest) baseRequest;

        Document document = DocumentHelper.createDocument();
        EanElement root = (EanElement) document.addElement("HotelItineraryRequest");

//        root.addItineraryId(request.getItineraryId());
//        root.addAffiliateConfirmationId(request.getAffiliateConfirmationId());
//        root.addEmail(request.getEmail());
//        root.addLastName(request.getLastName());
//        root.addConfirmationExtras(request.getConfirmationExtras());
//        root.addItineraryQuery(request.getItineraryQuery());

        return document;
    }

    @Override
    public HotelItineraryResponse createResponseObject(Document document) {
        if (document == null) {
            return null;
        }

        HotelItineraryResponse response = new HotelItineraryResponse();
        EanElement root = (EanElement) document.getRootElement();

        response.setCustomerSessionId(root.getCustomerSessionId());
        response.setEanWsError(root.getEanWsError());

//        response.getItinerary().addAll(root.getItineraryList());

        return response;
    }
}
