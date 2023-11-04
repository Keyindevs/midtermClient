package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassengersPage implements ActionListener {
    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");

    public PassengersPage() {
        String passengers = Connection.getPassengers();
        List<String> PassengerInformation = getPassengerInformation(passengers);
        StringBuilder text = new StringBuilder(String.valueOf(PassengerInformation));

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

    private List<String> getPassengerInformation(String passengers) {
        List<String> passengerInfoList = new ArrayList<>();

        JSONArray passengersArray = new JSONArray(passengers);

        for (int i = 0; i < passengersArray.length(); i++) {
            JSONObject passenger = passengersArray.getJSONObject(i);

            String firstName = passenger.getString("firstName");
            String lastName = passenger.getString("lastName");
            String homeTown = passenger.getString("homeTown");
            String flights = passenger.isNull("flights") ? "No flights" : passenger.get("flights").toString();

            if (!firstName.toLowerCase().contains("null") &&
                    !lastName.toLowerCase().contains("null") &&
                    !homeTown.toLowerCase().contains("null") &&
                    !flights.toLowerCase().contains("null") &&
                    !firstName.toLowerCase().contains("default") &&
                    !lastName.toLowerCase().contains("default") &&
                    !flights.toLowerCase().contains("default") &&
                    !homeTown.toLowerCase().contains("default")) {

            String passengerInfo = "First Name: " + firstName + ", Last Name: " + lastName +
                    ", Home Town: " + homeTown + ", Flights: " + flights + "\n";

            passengerInfoList.add(passengerInfo);
        }}

        return passengerInfoList;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
