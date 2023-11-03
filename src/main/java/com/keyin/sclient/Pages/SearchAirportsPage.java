package com.keyin.sclient.Pages;

import javax.swing.*;
import java.awt.*;

public class SearchAirportsPage {
    JFrame frame = new JFrame("Client");


    public SearchAirportsPage(String airports){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JLabel(airports));
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
}
