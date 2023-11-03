package com.keyin.sclient.Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener{

    JFrame frame = new JFrame("Client");
    JButton viewFlightsButton = new JButton("View Flights");
    JButton viewPassengersButton = new JButton("View Passengers");
    JButton viewCitiesButton = new JButton("View Cities");
    JButton viewAirportsButton = new JButton("View Airports");
    JButton viewAircraftButton = new JButton("View Aircraft");

    JButton searchFlightsButton = new JButton("Search Flights");
    JButton searchPassengersButton = new JButton("Search Passengers");
    JButton searchCitiesButton = new JButton("Search Cities");
    JButton searchAirportsButton = new JButton("Search Airports");
    JButton searchAircraftButton = new JButton("Search Aircraft");

    JButton addFlightsButton = new JButton("Add Flights");
    JButton addPassengersButton = new JButton("Add Passengers");
    JButton addCitiesButton = new JButton("Add Cities");
    JButton addAirportsButton = new JButton("Add Airports");
    JButton addAircraftButton = new JButton("Add Aircraft");

    public MainMenu(String IP, String port) {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JLabel(IP + ":" + port));
        panel.add(viewAircraftButton);
        panel.add(searchAircraftButton);
        panel.add(addAircraftButton);
        panel.add(viewAirportsButton);
        panel.add(searchAirportsButton);
        panel.add(addAirportsButton);
        panel.add(viewCitiesButton);
        panel.add(searchCitiesButton);
        panel.add(addCitiesButton);
        panel.add(viewPassengersButton);
        panel.add(searchPassengersButton);
        panel.add(addPassengersButton);
        panel.add(viewFlightsButton);
        panel.add(searchFlightsButton);
        panel.add(addFlightsButton);
        viewAircraftButton.addActionListener(this);
        viewAirportsButton.addActionListener(this);
        viewCitiesButton.addActionListener(this);
        viewPassengersButton.addActionListener(this);
        viewFlightsButton.addActionListener(this);
        searchAircraftButton.addActionListener(this);
        searchAirportsButton.addActionListener(this);
        searchPassengersButton.addActionListener(this);
        searchFlightsButton.addActionListener(this);
        addAircraftButton.addActionListener(this);
        addAirportsButton.addActionListener(this);
        addCitiesButton.addActionListener(this);
        addPassengersButton.addActionListener(this);
        addFlightsButton.addActionListener(this);
        viewAircraftButton.setFocusable(false);
        viewAirportsButton.setFocusable(false);
        viewCitiesButton.setFocusable(false);
        viewPassengersButton.setFocusable(false);
        viewFlightsButton.setFocusable(false);
        searchAircraftButton.setFocusable(false);
        searchAirportsButton.setFocusable(false);
        searchCitiesButton.setFocusable(false);
        searchPassengersButton.setFocusable(false);
        searchFlightsButton.setFocusable(false);
        addAircraftButton.setFocusable(false);
        addAirportsButton.setFocusable(false);
        addCitiesButton.setFocusable(false);
        addPassengersButton.setFocusable(false);
        addFlightsButton.setFocusable(false);
        viewAircraftButton.setFocusable(false);
        viewAirportsButton.setFocusable(false);
        viewCitiesButton.setFocusable(false);
        viewPassengersButton.setFocusable(false);
        viewFlightsButton.setFocusable(false);





        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Menu");
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(600,600);




    }


















    @Override
    public void actionPerformed(ActionEvent e) {
        // if viewCitiesButton is clicked, display the cities page and pass the IP and port to the page
        if (e.getSource() == viewCitiesButton) {
            new CitiesPage();
            frame.dispose();
        }
    }
}
