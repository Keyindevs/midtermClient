package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FlightsPage{
    JFrame frame = new JFrame("Client");

    JButton backButton = new JButton("Back");

    public FlightsPage () {
        String flights = Connection.getFlights();
        List<String> flightInformation = getFlightInformation(flights);

        StringBuilder text = new StringBuilder();
        for (String flight : flightInformation) {
            text.append(flight).append("\n");
        }

        JTextArea textArea = new JTextArea(text.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 20, 400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.add(scrollPane);
        panel.add(backButton);
        backButton.setBounds(10, 450, 80, 25);
        backButton.addActionListener(e -> {
            new MainMenu();
            frame.dispose();
        });
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);




    }

    static List<String> getFlightInformation(String flights) {
        List<String> flightInfoList = new java.util.ArrayList<>();

        org.json.JSONArray flightsArray = new org.json.JSONArray(flights);

        for (int i = 0; i < flightsArray.length(); i++) {
            org.json.JSONObject flight = flightsArray.getJSONObject(i);

            String id = flight.getString("id");
            String departureAirport = flight.getString("origin");
            String arrivalAirport = flight.getString("destination");
            String aircraft = flight.getString("aircraft");

            if(!id.toLowerCase().contains("null") &&
                    !departureAirport.toLowerCase().contains("null") &&
                    !arrivalAirport.toLowerCase().contains("null") &&
                    !aircraft.toLowerCase().contains("null") &&
                    !id.toLowerCase().contains("default") &&
                    !departureAirport.toLowerCase().contains("default") &&
                    !arrivalAirport.toLowerCase().contains("default") &&
                    !aircraft.toLowerCase().contains("default")) {
                    flightInfoList.add("Flight Number: " + id + "\n" +
                        "Departure Airport: " + departureAirport + "\n" +
                        "Arrival Airport: " + arrivalAirport + "\n" +
                        "Aircraft: " + aircraft + "\n");
            }

        }
        return flightInfoList;
    }

}
