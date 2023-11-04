package com.keyin.sclient.Pages;

import javax.swing.*;
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
public class SearchPassengersPage implements ActionListener {
    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");

    public SearchPassengersPage() {
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

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

    }

    public searchLastName(String lastName){
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

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
















    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new MainMenu();
            frame.dispose();
        }
    }
}
