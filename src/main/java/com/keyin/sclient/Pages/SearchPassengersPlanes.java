package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;

import javax.swing.*;
import java.awt.*;


public class SearchPassengersPlanes {

    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");
    public SearchPassengersPlanes(String firstName, String lastName, String homeTown){
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 20, 400, 400);
        String[] flights = Connection.getPassengerFlights(String.format("%s%s%s", firstName, lastName, homeTown)).replace("[", "").replace("]", "").replace("\"","").split(",");

        for (String flight : flights) {
            // this is appending the aircraft used in the flight to the text area
            textArea.append(flight + "\n");
        }

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
    }
