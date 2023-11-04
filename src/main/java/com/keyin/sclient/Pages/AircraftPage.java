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

public class AircraftPage implements ActionListener {
    JFrame frame = new JFrame("Client");

    JButton backButton = new JButton("Back");

    public AircraftPage () {
        String aircraft = Connection.getAircraft();
        List<String> aircraftInformation = getAircraftInformation(aircraft);
        StringBuilder text = new StringBuilder();
        for (String aircraftInfo : aircraftInformation) {
            text.append(aircraftInfo).append("\n");
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
        backButton.addActionListener(this);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

    }

    private List<String> getAircraftInformation(String aircraft) {
        List<String> aircraftInfoList = new ArrayList<>();

        JSONArray aircraftArray = new JSONArray(aircraft);

        for (int i = 0; i < aircraftArray.length(); i++) {
            JSONObject aircraftObject = aircraftArray.getJSONObject(i);
            int id = Integer.parseInt(aircraftObject.getString("id"));
            String type = aircraftObject.getString("type");
            String airlineName = aircraftObject.getString("airlineName");
            int capacity = aircraftObject.getInt("numberOfPassengers");
            String airport = aircraftObject.getString("airport");
            String boardedPassengers = aircraftObject.getString("boardedPassengers");

            if (!type.toLowerCase().contains("null") &&
                    !airlineName.toLowerCase().contains("null") &&
                    !airport.toLowerCase().contains("null") &&
                    !boardedPassengers.toLowerCase().contains("null") &&
                    !type.toLowerCase().contains("default") &&
                    !airlineName.toLowerCase().contains("default") &&
                    !airport.toLowerCase().contains("default") &&
                    !boardedPassengers.toLowerCase().contains("default")) {
                aircraftInfoList.add("ID: " + id + " | Type: " + type + " | Airline Name: " + airlineName + " | Capacity: " + capacity + " | Airport: " + airport + " | Boarded Passengers: " + boardedPassengers);
            }
        }

        return aircraftInfoList;
    }


@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new MainMenu();
            frame.dispose();
        }
    }
}
