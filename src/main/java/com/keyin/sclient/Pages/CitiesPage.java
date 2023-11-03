package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CitiesPage {
    JFrame frame = new JFrame("Client");

    public CitiesPage () {
        String cities = Connection.getCities();
        JPanel panel = new JPanel();
        JLabel label = new JLabel(cities);
        label.setBounds(10, 20, 80, 25);
        panel.add(label);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);


    }
}
