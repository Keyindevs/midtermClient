package com.keyin.sclient.Pages;

import javax.swing.*;
import com.keyin.sclient.Connection;
import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class SearchPassengersPage implements ActionListener {
    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");

    public SearchPassengersPage(String lastName) {
        String passengers = Connection.getPassengers();
        List<String> PassengerInformation = getPassengerInformation(passengers);
        List<String> filteredPassengerInformation = new ArrayList<>();
        for (String passengerInfo : PassengerInformation) {
            if (passengerInfo.contains(lastName)) {
                filteredPassengerInformation.add(passengerInfo);
            }
        }
        JTextArea textArea = new JTextArea(String.valueOf(filteredPassengerInformation));
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
                    !firstName.toLowerCase().contains("test") &&
                    !lastName.toLowerCase().contains("test") &&
                    !flights.toLowerCase().contains("test")) {
                passengerInfoList.add("First name: " + firstName + "\n" +
                        "Last name: " + lastName + "\n" +
                        "Home town: " + homeTown + "\n" +
                        "Flights: " + flights + "\n");
            }
        }
        return passengerInfoList;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new MainMenu();
            frame.dispose();
        }
    }
}
