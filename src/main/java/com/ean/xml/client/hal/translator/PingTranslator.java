package com.ean.xml.client.hal.translator;

import com.ean.xml.client.hal.requests.BaseRequest;
import com.ean.xml.client.hal.responses.PingResponse;
import com.ean.xml.client.hal.util.EanElement;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

/**
 * Translator used to transform requests to xml documents and xml documents to responses.
 */
public class PingTranslator implements Translator {
    @Override
    public Document createRequestDocument(BaseRequest request) {
        if (request == null) {
            return null;
        }

        return DocumentHelper.createDocument();
    }

    @Override
    public PingResponse createResponseObject(Document document) {
        if (document == null) {
            return null;
        }

        PingResponse response = new PingResponse();
        EanElement root = (EanElement) document.getRootElement();

        response.setCustomerSessionId(root.getCustomerSessionId());
        response.setEanWsError(root.getEanWsError());

        response.setEcho(root.getEcho());
        response.setServerInfo(root.getServerInfo());

        return response;
    }
}
