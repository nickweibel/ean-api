/**
 * Created with IntelliJ IDEA.
 * User: ejelinek
 * Date: 6/11/12
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ean.xml.service;

import com.ean.xml.client.hal.requests.HotelBaseRequest;
import com.ean.xml.client.hal.requests.HotelRoomAvailabilityRequest;
import com.ean.xml.client.hal.requests.RequestType;
import com.ean.xml.client.hal.responses.BaseResponse;
import com.ean.xml.client.hal.translator.HotelRoomAvailabilityTranslator;
import com.ean.xml.client.hal.translator.Translator;
import com.ean.xml.util.EanLogger;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Properties;

public class V3Requestor {
    private Properties properties = new Properties();
    private EanLogger logger = EanLogger.getInstance();
    private Translator translator;
    private HotelBaseRequest baseRequest;
    private RequestType requestType;
    private String path = "";


    public V3Requestor(HotelBaseRequest request) {
        try {
            baseRequest = request;
            setObjects(request);
            properties.load(ClassLoader.getSystemResourceAsStream("request.properties"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            logger.logException(ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.logException(ex);
        }
    }

    public BaseResponse executeGet() {
        Document requestDocument = translator.createRequestDocument(baseRequest);


        Document xDoc = null;
        URI url = null;
        HttpResponse response = null;
        InputStream input = null;
        try {
            url = URIUtils.createURI("http",
                    properties.getProperty("eanApi.host"),
                    Integer.getInteger(properties.getProperty("eanApi.port", "-1")),
                    path,
                    URLEncoder.encode(getParams() + requestDocument.getXMLEncoding(), "UTF-8"),
                    null);
        } catch (UnsupportedEncodingException ex) {
            logger.logException(ex);
        } catch (URISyntaxException ex) {
            logger.logException(ex);
        }

        HttpClient client = new DefaultHttpClient();
        HttpUriRequest httpRequest = new HttpGet(url);
        httpRequest.addHeader("Accept-Encoding", "gzip,deflate");
        httpRequest.addHeader("Accept", "application/xml");

        try {
            response = client.execute(httpRequest);

            if (response != null && response.getHeaders("Content-Encoding").length > 0) {
                input = decompress(response);

                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder builder = new StringBuilder(
                        Integer.getInteger(response.getHeaders("Content-Length")[0].getValue()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                xDoc = DocumentHelper.parseText(builder.toString());
            }

        } catch (ClientProtocolException e) {
            logger.logException(e);
        } catch (IOException e) {
            logger.logException(e);
        } catch (DocumentException e) {
            logger.logException(e);
        }

        return translator.createResponseObject(xDoc);
    }
    public Document executePost(HotelBaseRequest hotelBaseRequest) {
        return null;
    }

    private InputStream decompress(HttpResponse response) throws IOException {
        InputStream input;
        if(StringUtils.equals("gzip", response.getHeaders("Content-Encoding")[0].getValue())) {
            GzipDecompressingEntity gzip = new GzipDecompressingEntity(response.getEntity());
            input = gzip.getContent();
        }
        else {
            DeflateDecompressingEntity deflate = new DeflateDecompressingEntity(response.getEntity());
            input = deflate.getContent();
        }
        return input;
    }

    private void setObjects(HotelBaseRequest baseRequest) {
        if (baseRequest instanceof HotelRoomAvailabilityRequest) {
            translator = new HotelRoomAvailabilityTranslator();
            requestType = RequestType.AVAIL;
            path = "avail";
        }
    }

    private String getParams() {
        return String.format("minorRev=%s&apiKey=%s&cid=%s&locale=en_US&currencyCode=USD&xml=",
                properties.getProperty("eanApi.minorRev"),
                properties.getProperty("eanApi.apiKey"),
                properties.getProperty("eanApi.cid"));
    }
}
