package com.keyin.sclient.Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.keyin.sclient.Connection;
public class MainMenu implements ActionListener{

    JFrame frame = new JFrame("Client");
    JButton viewFlightsButton = new JButton("View Flights");
    JButton viewPassengersButton = new JButton("View Passengers");
    JButton viewCitiesButton = new JButton("View Cities");
    JButton viewAirportsButton = new JButton("View Airports");
    JButton viewAircraftButton = new JButton("View Aircraft");

    JButton searchFlightsButton = new JButton("Search Passenger Planes");
    JButton searchPassengersButton = new JButton("Search Passengers");
    JButton searchCitiesButton = new JButton("Search City");
    JButton searchAirportsButton = new JButton("Search Airports");
    JButton searchAircraftButton = new JButton("On Premise Aircraft");

    JButton addFlightsButton = new JButton("Add Flights");
    JButton addPassengersButton = new JButton("Add Passengers");
    JButton addCitiesButton = new JButton("Add City");
    JButton addAirportsButton = new JButton("Add Airports");
    JButton addAircraftButton = new JButton("Add Aircraft");

    JButton backButton = new JButton("Back");



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
        panel.add(backButton);

        viewAirportsButton.addActionListener(this);
        viewCitiesButton.addActionListener(this);
        viewPassengersButton.addActionListener(this);
        viewFlightsButton.addActionListener(this);
        viewAircraftButton.addActionListener(this);

        searchAircraftButton.addActionListener(this);
        searchAirportsButton.addActionListener(this);
        searchPassengersButton.addActionListener(this);
        searchFlightsButton.addActionListener(this);
        searchCitiesButton.addActionListener(this);

        addAircraftButton.addActionListener(this);
        addAirportsButton.addActionListener(this);
        addCitiesButton.addActionListener(this);
        addPassengersButton.addActionListener(this);
        addFlightsButton.addActionListener(this);

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

        viewAirportsButton.setFocusable(false);
        viewCitiesButton.setFocusable(false);
        viewPassengersButton.setFocusable(false);
        viewFlightsButton.setFocusable(false);
        viewAircraftButton.setFocusable(false);





        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Menu");
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(600,600);




    }

    public MainMenu() {
            String IP = Connection.getUrl();
            String port = Connection.getPort();
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
            viewAirportsButton.addActionListener(this);
            viewAircraftButton.addActionListener(this);
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
            backButton.addActionListener(this);
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
            viewAirportsButton.setFocusable(false);
            viewCitiesButton.setFocusable(false);
            viewPassengersButton.setFocusable(false);
            viewFlightsButton.setFocusable(false);
            backButton.setFocusable(false);
            viewAircraftButton.setFocusable(false);





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
        if (e.getSource() == backButton) {
            new ConnectPage();
            frame.dispose();
        }
        if (e.getSource() == viewCitiesButton) {
            new CitiesPage();
            frame.dispose();
        }
        if (e.getSource() == viewAirportsButton) {
            new AirportsPage();
            frame.dispose();
        }

        if (e.getSource() == viewAircraftButton) {
            new AircraftPage();
            frame.dispose();
        }
        if (e.getSource() == viewPassengersButton) {
            new PassengersPage();
            frame.dispose();
        }
        if (e.getSource() == viewFlightsButton) {
            new FlightsPage();
            frame.dispose();
        }
        if (e.getSource() == searchCitiesButton) {
            String city = JOptionPane.showInputDialog("Enter city name");
            if (city != null) {
                new SearchCityPage(city);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a valid city name.");
            }
        }

        if (e.getSource() == searchAirportsButton) {
            String airport = JOptionPane.showInputDialog("Enter airport code or name");
            if (airport != null) {
                new SearchAirportsPage(airport);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a valid airport code or name.");
            }
        }

        if (e.getSource() == searchAircraftButton) {
            String aircraft = JOptionPane.showInputDialog("Enter Airport Code");
            new SearchAircraftPage(aircraft);
            frame.dispose();
        }

        if (e.getSource() == searchPassengersButton) {
            String lastName = JOptionPane.showInputDialog("Enter passenger last name");
            if (lastName != null) {
                new SearchPassengersPage(lastName);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a valid last name.");
            }

        }

        if (e.getSource() == searchFlightsButton) {
            String firstName = JOptionPane.showInputDialog("Enter passenger Identification");
            String lastName = JOptionPane.showInputDialog("Enter passenger last name");
            String homeTown = JOptionPane.showInputDialog("Enter passenger hometown");
            new SearchPassengersPlanes(firstName, lastName, homeTown);
            frame.dispose();
        }
        if (e.getSource() == addCitiesButton) {
            String name = JOptionPane.showInputDialog("Enter city name");
            String state = JOptionPane.showInputDialog("Enter city state/province");
            int population = Integer.parseInt(JOptionPane.showInputDialog("Enter city population"));
            Connection.addCity(name, state, population);
            JOptionPane.showMessageDialog(frame, "City Added Successfully");
        }
        if (e.getSource() == addAirportsButton) {
String name = JOptionPane.showInputDialog("Enter airport name");
            String code = JOptionPane.showInputDialog("Enter airport code");
            String city = JOptionPane.showInputDialog("Enter city name");
            Connection.addAirport(name, code, city);
            JOptionPane.showMessageDialog(frame, "Airport Added Successfully");
        }
        if (e.getSource() == addAircraftButton) {
            String type = JOptionPane.showInputDialog("Enter aircraft type");
            String airlineName = JOptionPane.showInputDialog("Enter airline name");
            int numberOfPassengers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of passengers"));
            String airport = JOptionPane.showInputDialog("Enter airport code");
            String id = JOptionPane.showInputDialog("Enter aircraft id");
            Connection.addAircraft(type, airlineName, numberOfPassengers, airport, id);
            JOptionPane.showMessageDialog(frame, "Aircraft Added Successfully");
        }
        if (e.getSource() == addPassengersButton) {
            String firstName = JOptionPane.showInputDialog("Enter passenger first name");
            String lastName = JOptionPane.showInputDialog("Enter passenger last name");
            String homeTown = JOptionPane.showInputDialog("Enter passenger hometown");
            Connection.addPassenger(firstName, lastName, homeTown);
            JOptionPane.showMessageDialog(frame, "Passenger Added Successfully");
        }
        if (e.getSource() == addFlightsButton) {
            String origin = JOptionPane.showInputDialog("Enter flight origin");
            String destination = JOptionPane.showInputDialog("Enter flight destination");
            String aircraft = JOptionPane.showInputDialog("Enter aircraft id");
            String id = JOptionPane.showInputDialog("Enter flight id");
            Connection.addFlight(origin, destination, aircraft);
            JOptionPane.showMessageDialog(frame, "Flight Added Successfully");
        }


    }
}
