package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import org.json.JSONArray;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.keyin.sclient.Pages.SearchPassengersPage.getPassengerInformation;


public class SearchFlightsPage {

    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");
    public SearchFlightsPage(String lastName){
        String passengers = Connection.getPassengers();
        java.util.List<String> PassengerInformation = getPassengerInformation(passengers);
        List<String> filteredPassengerInformation = new ArrayList<>();
        for (String passengerInfo : PassengerInformation) {
            if (passengerInfo.contains(lastName)) {
                filteredPassengerInformation.add(passengerInfo);
            }
        }
        String flightsTaken = filteredPassengerInformation.get(3);
        String flights = Connection.getFlights();
        List<String> flightInformation = getFlightInformation(flights, flightsTaken);



        JTextArea textArea = new JTextArea();
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

    private List<String> getFlightInformation(String flights, String flightsTaken) {

    }


}
