package com.keyin.sclient.Pages;

import com.keyin.sclient.Connection;
import com.keyin.sclient.Pages.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectPage implements ActionListener {
    JFrame frame = new JFrame("Client");
    JTextField IP = new JTextField("localhost");
    JTextField port = new JTextField("8080");
    JButton connectButton = new JButton("Connect");

    public ConnectPage() {




        // Create Connection Panel

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JLabel("Welcome to the Client!"));
        panel.add(new JLabel("Please enter the IP address and port of the server you wish to connect to."));
        panel.add(new JLabel("IP Address:"));
        panel.add(IP);
        panel.add(new JLabel("Port:"));
        panel.add(port);
        panel.add(connectButton);
        connectButton.addActionListener(this);
        connectButton.setFocusable(false);


        //Configure Frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Connection Page");
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(600,600);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connectButton) {
            String ip = IP.getText();
            String portNum = port.getText();
            if (ip.matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$") && portNum.matches("^[0-9]*$")) {
                Connection connection = new Connection(ip, portNum, null, null);
                if (connection.pingServer()) {
                    new MainMenu(ip, portNum);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Server is offline.");
                }
            }
            else if(ip.equals("localhost") && portNum.matches("^[0-9]*$")) {
                Connection connection = new Connection(ip, portNum, null, null);
                if (connection.pingServer()) {
                    new MainMenu(ip, portNum);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Server is offline.");
                }
            }
            else if(ip.isEmpty() && portNum.isEmpty()) {
                ip = "localhost";
                portNum = "8080";
                Connection connection = new Connection(ip, portNum, null, null);
                if (connection.pingServer()) {
                    new MainMenu(ip, portNum);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Server is offline.");
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Please enter a valid IP address and port number.");
            }


    }



}}