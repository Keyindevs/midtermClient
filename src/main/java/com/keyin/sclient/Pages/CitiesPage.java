package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class CitiesPage {
    JFrame frame = new JFrame("Client");

    public CitiesPage() {
        String cities = Connection.getCities();
        List<String> cityNamesAndStates = getCityNamesAndStates(cities);

        StringBuilder text = new StringBuilder();
        for (String city : cityNamesAndStates) {
            text.append(city).append("\n");
        }

        JTextArea textArea = new JTextArea(text.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 20, 400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.add(scrollPane);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
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



}
