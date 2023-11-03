package com.keyin.sclient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static String getUrl() {
        return url;
    }

    public static String getPort() {
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
            if (responseCode == 200) {
                System.out.println("Server is online.");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response);
                return response.toString();
            } else {
                System.out.println("Server is offline.");
                return "Server Offline";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public static List<String> getCityNamesAndStates(String jsonData) {
        List<String> cityNamesAndStates = new ArrayList<>();

        Set<String> uniqueCities = new HashSet<>();
        JSONArray jsonArray = new JSONArray(jsonData);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject cityObject = jsonArray.getJSONObject(i);
            String cityName = cityObject.getString("name");
            String state = cityObject.getString("state");

            // Filter out cities with name or state containing "null" or "default"
            if (!cityName.toLowerCase().contains("null") && !state.toLowerCase().contains("null") &&
                    !cityName.toLowerCase().contains("default") && !state.toLowerCase().contains("default")) {

                // Check if this city is unique (based on name and state)
                String uniqueKey = cityName + state;
                if (!uniqueCities.contains(uniqueKey)) {
                    uniqueCities.add(uniqueKey);
                    cityNamesAndStates.add(cityName + ", " + state);
                }
            }
        }

        return cityNamesAndStates;
    }
    public static List<String> getAirportsInCity(String jsonData, String city) {
        List<String> airportsInCity = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonData);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject airportObject = jsonArray.getJSONObject(i);
            String airportCity = airportObject.getString("city");
            if (airportCity.equals(city)) {
                String airportName = airportObject.getString("name");
                airportsInCity.add(airportName);
            }
        }
        return airportsInCity;
    }
    public static String getAirports() {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/airports", null, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Server is online.");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response);
                return response.toString();
            } else {
                System.out.println("Server is offline.");
                return "Server Offline";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
    public static String getFlights(){
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/flights", null, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Server is online.");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response);
                return response.toString();
            } else {
                System.out.println("Server is offline.");
                return "Server Offline";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
    public static String getAircraft(){
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/aircraft", null, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Server is online.");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response);
                return response.toString();
            } else {
                System.out.println("Server is offline.");
                return "Server Offline";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
    public static String getPassengers(){
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/passengers", null, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Server is online.");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null);
                in.close();

                return response.toString();
            } else {
                System.out.println("Server is offline.");
                return "Server Offline";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";

        }}}