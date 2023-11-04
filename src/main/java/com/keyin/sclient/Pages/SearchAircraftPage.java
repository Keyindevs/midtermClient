package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchAircraftPage {
    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");
    public SearchAircraftPage(String code){

        List<String> planes = Connection.getAircraftOnPremise(code);
        JTextArea textArea = new JTextArea(String.valueOf(planes));
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

//    private List<String> getAirportData(String code) {
//        List<String> data = new ArrayList<>();
//        JSONArray airports = new JSONArray(Connection.getAirportByCode());
//
//        for (int i = 0; i < airports.length(); i++) {
//            JSONObject jsonObject = airports.getJSONObject(i);
//            JSONArray planes = jsonObject.getJSONArray("onPremisePlanes");
//            StringBuilder stringBuilder = new StringBuilder();
//
//            data.add(planes);
//
//        }
//        return data;
//    }
}
