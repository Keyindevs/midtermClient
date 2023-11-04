package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;

import javax.swing.*;

public class FlightsPage{
    JFrame frame = new JFrame("Client");

    JButton backButton = new JButton("Back");

    public FlightsPage () {
        String flights = Connection.getFlights();

    }

}
