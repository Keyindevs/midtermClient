package com.keyin.sclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class ConnectPage implements ActionListener {
    JFrame frame = new JFrame("Client");
    JTextField IP = new JTextField();
    JTextField port = new JTextField();
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
        frame.setSize(420,420);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connectButton) {
            String ip = IP.getText();
            String portNum = port.getText();
            new MainMenu(ip, portNum);
            System.out.println(ip + " " + portNum);
            frame.dispose();
        }


    }



}
