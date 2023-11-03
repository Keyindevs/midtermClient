package com.keyin.sclient;

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


    public MainMenu(String IP, String port) {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JLabel(IP + ":" + port));
        panel.add(viewAircraftButton);
        panel.add(viewAirportsButton);
        panel.add(viewCitiesButton);
        panel.add(viewPassengersButton);
        panel.add(viewFlightsButton);
        viewAircraftButton.addActionListener(this);
        viewAirportsButton.addActionListener(this);
        viewCitiesButton.addActionListener(this);
        viewPassengersButton.addActionListener(this);
        viewFlightsButton.addActionListener(this);
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
        frame.setSize(420,420);




    }

























    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
