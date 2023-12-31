package com.keyin.sclient;


import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.net.*;
import java.util.*;

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

    /**
     * Sends a GET request to the server
     * this request contains no request parameters
     */
    private static String getRequest(String path) {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), path, null, null);
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
        return getRequest("/cities");
    }

    public static String getCity(String name) {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/city", "name="+name, null);
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

    public static String getPassengerFlights(String name) {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/passenger/flights", "id="+name, null);
            System.out.println(uri);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == 200) {
                System.out.println("Server is online.");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                System.out.println("here");
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response);
                System.out.println("here");
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
                else {
                    cityNamesAndStates.add(cityName + ", " + state + " (duplicate)");
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
        return getRequest("/airports");
    }

    public static List<String> getAircraftOnPremise(String code) {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/airport/aircraft", "code=" + code, null);
            System.out.println(uri);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == 200) {
                System.out.println("Server is online");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                in.close();

                JSONArray jsonArray = new JSONArray(response.toString());

                List<String> aircraftList = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject aircraftObject = jsonArray.getJSONObject(i);
                    String id = aircraftObject.getString("id");
                    String type = aircraftObject.getString("type");
                    String airlineName = aircraftObject.getString("airlineName");
                    String airport = aircraftObject.getString("airport");

                    String formattedAircraft = "ID: " + id + " | Type: " + type + " | Airline Name: " + airlineName + " | Airport: " + airport;
                    aircraftList.add(formattedAircraft);
                }
                System.out.println(aircraftList);
                return aircraftList;
            } else {
                System.out.println("Server is offline");
                return new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static String getFlights(){
        return getRequest("/flights");
    }

    public static String getPlane(String code){
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/airport/aircraft", "code="+code, null);
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
        return getRequest("/aircraft");
    }
    public static String getPassengers(){
        return getRequest("/passengers");
    }

    public static String getPassengerbyLastName(String name){
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/passenger"+name, null, null);
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

                return response.toString();
            } else {
                System.out.println("Server is offline.");
                return "Server Offline";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";

        }}

    public static void addAircraft(String type, String airlineName, int numberOfPassengers, String airport, String id){
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/aircraft", "type="+type+"&airlineName=" + airlineName + "&numberOfPassengers=" + numberOfPassengers + "&airport=" + airport + "&id=" + id, null);
            System.out.println(uri);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCity(String name, String state, int population){
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/city", "name="+name+"&state="+state+"&population="+population, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addAirport(String name, String code, String city) {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/airport", "name="+name+"&code="+code+"&city="+city, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                in.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPassenger(String firstName, String lastName, String homeTown) {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/passenger", "firstName="+firstName+"&lastName="+lastName+"&homeTown="+homeTown, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void addFlight(String orgin, String destination, String aircraft) {
        try {
            URI uri = new URI("http", null, url, Integer.parseInt(port), "/flight", "origin="+orgin+"&destination="+destination+"&aircraft="+aircraft, null);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
