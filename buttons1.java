/*
 * Date: Tuesday, October 31
 * Name: Zeeshan Bombaywala
 * Description: 
 * This program calculates the area of a circle based on the user's input radius.
 * It has a GUI interface that allows the user to enter the radius, calculate the area,
 * clear all inputs and results, and exit the application. It also includes error handling 
 * to manage non-numeric inputs, ensuring that the program operates smoothly without unexpected 
 * interruptions.
 */

import javax.swing.*;
import java.awt.event.*;

public class buttons1 {

    // Main method to execute the application
    public static void main(String[] args) {
        // Creating the frame and setting basic properties
        JFrame frame = new JFrame("Circle Area Calculator");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creating a panel to place components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        // Making the frame visible
        frame.setVisible(true);
    }

    // Method to place and organize components in the panel
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        
        // Creating and setting the radius label
        JLabel radiusLabel = new JLabel("Radius:");
        radiusLabel.setBounds(10, 20, 80, 25);
        panel.add(radiusLabel);                
        
        // Creating and setting the radius text field
        JTextField radiusText = new JTextField(20);
        radiusText.setBounds(100, 20, 165, 25);
        panel.add(radiusText);
        
        // Creating and setting the result label
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 50, 80, 25);
        panel.add(resultLabel);
        
        // Creating and setting the result text field
        JTextField resultText = new JTextField(20);
        resultText.setBounds(100, 50, 165, 25);
        panel.add(resultText);
        resultText.setEditable(false);
        
        // Creating, setting, and adding functionality to the calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 80, 100, 25);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(radiusText.getText());
                    double area = Math.PI * radius * radius;
                    resultText.setText(String.valueOf(area));
                }catch (NumberFormatException ex) {
                    // Handling invalid (non-numeric) input with an error message
                    JOptionPane.showMessageDialog(panel, "Error: please input a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(calculateButton);
        
        // Creating, setting, and adding functionality to the clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(120, 80, 80, 25);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clearing the text fields
                radiusText.setText("");
                resultText.setText("");
            }
        });
        panel.add(clearButton);
        
        // Creating, setting, and adding functionality to the exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 80, 80, 25);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exiting the application
                System.exit(0);
            }
        });
        panel.add(exitButton);
    }
}
