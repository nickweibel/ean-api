package com.ean.xml.client.hal.responses;

import com.ean.xml.client.hal.base.request.ServerInfo;

/**
 * Response object for testing the connection between the xml server and the affiliate server.
 */
public class PingResponse extends BaseResponse {
    private String echo;
    private ServerInfo serverInfo;

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

    /**
     * Gets the server information.
     * @return server information.
     */
    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    /**
     * Sets the server information.
     * @param value server information.
     */
    public void setServerInfo(ServerInfo value) {
        this.serverInfo = value;
    }

}
