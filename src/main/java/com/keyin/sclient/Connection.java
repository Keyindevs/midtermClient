package com.keyin.sclient;
import java.net.*;
public class Connection {
    private static String url;
    private static String port;
    private static String path;

    public Connection(String url, String port, String path, String query) {
        Connection.url = url;
        Connection.port = port;
        Connection.path = path;
    }

    public void setUrl(String url) {
        Connection.url = url;
    }

    public void setPort(String port) {
        Connection.port = port;
    }

    public void setPath(String path) {
        Connection.path = path;
    }

    public String getUrl() {
        return url;
    }

    public String getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    // ping server to check if it is online

    public boolean pingServer() {
        int intport = Integer.parseInt(port);
        try {
            if (path == null) {
                path = "";
            }
            URI uri = new URI("http", null, url, intport, path, null, null);
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

    // get list of cities from server

    public static String getCities() {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/cities", null, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == 200) {
                System.out.println("Server is online.");
            } else {
                System.out.println("Server is offline.");
            }
            System.out.println(connection.toString());
            return "fart";
        }
        catch (Exception e) {
            return "Error";
        }
    }



}
