package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static com.keyin.sclient.Connection.*;

public class CitiesPage implements ActionListener {
    JFrame frame = new JFrame("Client");

    JButton backButton = new JButton("Back");

    public CitiesPage() {
        String cities = Connection.getCities();
        List<String> cityNamesAndStates = getCityNamesAndStates(cities);

        StringBuilder text = new StringBuilder();
        for (String city : cityNamesAndStates) {
            text.append(city).append("\n");
        }

        JTextArea textArea = new JTextArea(text.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 20, 400, 400);

        JPanel panel = new JPanel();
        panel.add(backButton);
        backButton.setBounds(10, 450, 80, 25);
        backButton.addActionListener(e -> {
            new MainMenu();
            frame.dispose();
        });
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

    }

}
