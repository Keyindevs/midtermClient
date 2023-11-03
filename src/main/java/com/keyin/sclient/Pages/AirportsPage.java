package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AirportsPage implements ActionListener {
    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");
    public AirportsPage(){
        String airports = Connection.getAirports();
        List<String> airportNamesAndCities = getAirportNamesAndCities(airports);
        StringBuilder text = new StringBuilder();
        for (String airport : airportNamesAndCities) {
            text.append(airport).append("\n");
        }

        JTextArea textArea = new JTextArea(text.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 20, 400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.add(scrollPane);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

    }

    private List<String> getAirportNamesAndCities(String airports) {
        Set<String> uniqueEntries = new HashSet<>();
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
                    !city.toLowerCase().contains("default")) {

                String entry = airportName + " (" + airportCode + ")\n" + city + ", ";
                if (uniqueEntries.add(entry)) {
                    airportNamesAndCities.add(entry);
                }
            }
        }
        airportNamesAndCities.sort(String::compareToIgnoreCase);
        return airportNamesAndCities;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new MainMenu();
            frame.dispose();
        }
    }

}
