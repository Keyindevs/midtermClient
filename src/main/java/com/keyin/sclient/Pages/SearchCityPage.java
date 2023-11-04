package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;

import javax.swing.*;
import java.awt.*;

public class SearchCityPage {
    JFrame frame = new JFrame("Client");
    JButton backButton = new JButton("Back");
    public SearchCityPage(String name){
        String city = Connection.getCity(name);
        JTextArea textArea = new JTextArea(city);
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
}
