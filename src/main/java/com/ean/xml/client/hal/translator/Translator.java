package com.ean.xml.client.hal.translator;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public interface Translator<Req, Doc, Res> {
    public Doc createRequestDocument(Req request);
    public Res createResponseObject(Doc document);
}
