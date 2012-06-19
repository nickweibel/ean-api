package com.ean.xml.client.hal.requests;

/**
 * Ping request used to test the connection between the XML servers and the Affiliate servers.
 */
public class PingRequest extends HotelBaseRequest {
    private String echo;

    /**
     * Creates a Ping request.
     * @param echo Test string we expect to receive in response.
     */
    public PingRequest(String echo) {
        this.echo = echo;
    }

    /**
     * Gets the Echo test string.
     * @return test string.
     */
    public String getEcho() {
        return echo;
    }

    /**
     * Sets the Echo test string.
     * @param value test string.
     */
    public void setEcho(String value) {
        this.echo = value;
    }
}
