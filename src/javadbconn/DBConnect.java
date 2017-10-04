/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadbconn;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ravi
 */
public class DBConnect {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("MySQL Database connection");
        JLabel label = new JLabel("This program fetches information from database and presents them here");
        JButton closeButton = new JButton("Click to close");
        JButton showButton = new JButton("Click to view phones");
        //JList phoneJList;
       

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MySQLAccess databaseAccessObject = new MySQLAccess();
                try {
                    databaseAccessObject.readDataBase();
                    //phoneJList = new JList(phoneList.toArray());                   
                } catch (Exception ex) {
                    Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        // Get content pane
        Container pane = frame.getContentPane();

        // Set layout manager
        pane.setLayout(new FlowLayout());

        // Add to pane
        pane.add(label);
        pane.add(closeButton);
        pane.add(showButton);
        //pane.add(phoneJList);
        frame.pack();

        // Center the frame
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the current screen size
        Dimension scrnsize = toolkit.getScreenSize();

        // Get the frame size
        Dimension framesize = frame.getSize();

        // Set X,Y location
        frame.setLocation((int) (scrnsize.getWidth()
                - frame.getWidth()) / 2,
                (int) (scrnsize.getHeight()
                - frame.getHeight()) / 2);

        frame.setVisible(true);

    }

}
