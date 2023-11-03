package com.keyin.sclient;
import java.net.*;
public class Connection {
    private String url;
    private String port;
    private String path;

    public Connection(String url, String port, String path) {
        this.url = url;
        this.port = port;
        this.path = path;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return this.url;
    }

    public String getPort() {
        return this.port;
    }

    public String getPath() {
        return this.path;
    }

    // ping server to check if it is online

    public boolean pingServer() {
        int intport = Integer.parseInt(this.port);
        try {
            if (this.path == null) {
                this.path = "";
            }
            URI uri = new URI("http", null, this.url, intport, this.path, null, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == 200) {
                System.out.println("Server is online.");
            } else {
                System.out.println("Server is offline.");
            }
            return responseCode == 200;

        } catch (Exception e) {
            return false;
        }
    }



}
