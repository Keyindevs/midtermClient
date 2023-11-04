package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchAirportsPage {
    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");
    public SearchAirportsPage(String code){
        String airports = Connection.getAirports();
        java.util.List<String> airportNamesAndCities = getAirportNamesAndCities(airports, code);
        List<String> filteredAirportInformation = new ArrayList<>();
        for (String airport : airportNamesAndCities) {
            filteredAirportInformation.add(airport);
        }
        JTextArea textArea = new JTextArea(String.valueOf(filteredAirportInformation));
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


    private List<String> getAirportNamesAndCities(String airports, String code) {
        List<String> airportNamesAndCities = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(airports);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String airportName = jsonObject.getString("name");
            String airportCode = jsonObject.getString("code");
            String city = jsonObject.getString("city");

            if (!airportName.toLowerCase().contains("null") &&
                    !airportCode.toLowerCase().contains("null") &&
                    !city.toLowerCase().contains("null") &&
                    !airportName.toLowerCase().contains("default") &&
                    !airportCode.toLowerCase().contains("default") &&
                    !city.toLowerCase().contains("default") &&
                    airportCode.toLowerCase().contains(code.toLowerCase())) {
                airportNamesAndCities.add(airportName + " - " + city);
            }
        }
        return airportNamesAndCities;
    }

}
