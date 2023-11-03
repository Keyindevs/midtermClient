package com.keyin.sclient;

import org.apache.commons.cli.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import  org.json.JSONObject;
import java.util.Scanner;

public class ClientCLI {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("1", "selection1", true, "Get airports in a city");
        options.addOption("2", "selection2", true, "List aircraft passengers have traveled on");
        options.addOption("3", "selection3", true, "Get airports for an aircraft");
        options.addOption("4", "selection4", true, "Get airports used by a passenger");

        CommandLineParser parser = new DefaultParser();

        //Display
        if (args.length == 0) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("ClientCLI", options);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your selection (Example: 1, 2, 3, 4): ");

            String userInput = scanner.nextLine();

            if ("1".equals(userInput)) {
                System.out.print("Enter a city: ");
                String city = scanner.nextLine();
                getAirportsInCity(city);
            }else if ("2".equals(userInput)) {
                System.out.print("Enter a passenger ID: ");
                int passengerId = Integer.parseInt(scanner.nextLine());
                listAircraftForPassenger(passengerId);
            }else if ("3".equals(userInput)) {
                System.out.print("Enter an aircraft ID: ");
                int aircraftId = Integer.parseInt(scanner.nextLine());
                getAirportsForAircraft(aircraftId);
            }else if ("4".equals(userInput)) {
                System.out.print("Enter a passenger ID: ");
                int passengerId = Integer.parseInt(scanner.nextLine());
                getAirportsUsedByPassenger(passengerId);
            }else {
                System.out.println("Invalid selection.");
            }
            scanner.close();
            return;

        }

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("1")) {
                String city = cmd.getOptionValue("1");
                getAirportsInCity(city);
            }

            if (cmd.hasOption("2")) {
                int passengerId = Integer.parseInt(cmd.getOptionValue("2"));
                listAircraftForPassenger(passengerId);
            }

            if (cmd.hasOption("3")) {
                int aircraftId = Integer.parseInt(cmd.getOptionValue("3"));
                getAirportsForAircraft(aircraftId);
            }

            if (cmd.hasOption("4")) {
                int passengerId = Integer.parseInt(cmd.getOptionValue("4"));
                getAirportsUsedByPassenger(passengerId);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Press Enter to exit...");
        new Scanner(System.in).nextLine();
    }

    public static void getAirportsInCity(String city) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            String serverUrl = "http://localhost:8080/cities?name=" + city;
            HttpGet request = new HttpGet(serverUrl);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String json = EntityUtils.toString(response.getEntity());
                JSONArray airports = new JSONArray(json);

                for (int i = 0; i < airports.length(); i++) {
                    JSONObject airport = airports.getJSONObject(i);
                    System.out.println("Airport: " + airport.getString("name"));
                }
            } else {
                System.out.println("Error: Failed to retrieve data from the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void listAircraftForPassenger(int passengerId) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            String serverUrl = "http://localhost:8080/passenger?id=" + passengerId;
            HttpGet request = new HttpGet(serverUrl);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String json = EntityUtils.toString(response.getEntity());
                JSONObject passengerData = new JSONObject(json);

                if (passengerData.has("aircraftList")) {
                    JSONArray aircraftList = passengerData.getJSONArray("aircraftList");

                    System.out.println("Aircraft traveled by Passenger " + passengerId + ":");
                    for (int i = 0; i < aircraftList.length(); i++) {
                        JSONObject aircraft = aircraftList.getJSONObject(i);
                        System.out.println("Aircraft ID: " + aircraft.getInt("id"));
                        System.out.println("Aircraft Type: " + aircraft.getString("type"));

                    }
                }else{
                    System.out.println("No aircraft data found for Passenger " + passengerId);
                }
            } else {
                System.out.println("Error: Failed to retrieve data from the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void getAirportsForAircraft(int aircraftId) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            String serverUrl = "http://localhost:8080/airport/aircraft?aircraftId=" + aircraftId;
            HttpGet request = new HttpGet(serverUrl);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String json = EntityUtils.toString(response.getEntity());

                JSONArray airportList = new JSONArray(json);
                System.out.println("Airports for Aircraft ID " + aircraftId + ":");

                for (int i = 0; i < airportList.length(); i++) {
                    JSONObject airport = airportList.getJSONObject(i);

                    if (airport.has("name")) {
                        String airportName = airport.getString("name");
                        System.out.println("Airport Name: " + airport.getString("name"));
                    }

                }
            } else {
                System.out.println("Error: Failed to retrieve data from the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void getAirportsUsedByPassenger(int passengerId) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            String serverUrl = "http://localhost:8080/passenger/airports?passengerId=" + passengerId;
            HttpGet request = new HttpGet(serverUrl);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String json = EntityUtils.toString(response.getEntity());
                JSONArray airportList = new JSONArray(json);

                System.out.println("Airports used by Passenger " + passengerId + ":");
                for (int i = 0; i < airportList.length(); i++) {
                    JSONObject airport = airportList.getJSONObject(i);
                    System.out.println("Airport Name: " + airport.getString("name"));

                }
            } else {
                System.out.println("Error: Failed to retrieve data from the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}









