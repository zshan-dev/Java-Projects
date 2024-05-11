/*
 * Date: Tuesday,October 31
 * Name: Zeeshan Bombaywala 
 * Description: 
 * This program is designed to create a personalized message for the user.
 * The user enters their name and age, and the program outputs a message
 * incorporating the user’s input. It includes buttons to clear the fields,
 * output the message, and exit the application.
 */

import javax.swing.*;
import java.awt.event.*;

public class buttons3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Personalized Message Generator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Creating and placing the Name Label and Text Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        // Creating and placing the Age Label and Text Field
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(10, 50, 80, 25);
        panel.add(ageLabel);

        JTextField ageText = new JTextField(20);
        ageText.setBounds(100, 50, 165, 25);
        panel.add(ageText);

        // Creating and placing the Message Label and Text Field
        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setBounds(10, 80, 80, 25);
        panel.add(messageLabel);

        JTextField messageText = new JTextField(20);
        messageText.setBounds(100, 80, 165, 25);
        panel.add(messageText);
        messageText.setEditable(false); // Makes the message field uneditable

        // Creating and defining action for Output Message Button
        JButton outputMessageButton = new JButton("Output Message");
        outputMessageButton.setBounds(10, 130, 130, 25);
        outputMessageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String age = ageText.getText();
                String message = "Hello " + name + "! You do not look a day older than " + age + ".";
                messageText.setText(message);
            }
        });
        panel.add(outputMessageButton);

        // Creating and defining action for Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(150, 130, 80, 25);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                ageText.setText("");
                messageText.setText("");
            }
        });
        panel.add(clearButton);

        // Creating and defining action for Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(240, 130, 80, 25);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);
    }
}
