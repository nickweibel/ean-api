package com.ean.xml.client.hal.translator;

import com.ean.xml.client.hal.requests.BaseRequest;
import com.ean.xml.client.hal.responses.BaseResponse;
import org.dom4j.Document;

/**
 * Translator used to transform requests to xml documents and xml documents to responses.
 */
public interface Translator {
    /**
     * Transforms a request object to an xml document for the call to the xml server.
     * @param request Request object.
     * @return XML Document.
     */
    public Document createRequestDocument(BaseRequest request);

    /**
     * Transforms an XML document into a response object
     * @param document XML Document.
     * @return Response Object.
     */
    public BaseResponse createResponseObject(Document document);
}
