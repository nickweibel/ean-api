package com.ean.xml.client.hal.translator;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public interface Translator<Req, Doc, Res> {
    public DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");

    public Doc createRequestDocument(Req request);
    public Res createResponseObject(Doc response);
}
