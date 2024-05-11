/*
 * Date: Tuesday, October 31
 * Name: Zeeshan Bombaywala
 * Description: 
 * This program calculates the area of a rectangle. The user enters the length and width, 
 * and the program outputs the area. The program includes error handling for negative numbers 
 * and non-numeric inputs. It also features clear, exit, and calculate buttons.
 */

import javax.swing.*;
import java.awt.event.*;

public class buttons2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Area of a Rectangle Calculator");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Creating and placing the Length Label and Text Field
        JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setBounds(10, 20, 80, 25);
        panel.add(lengthLabel);

        JTextField lengthText = new JTextField(20);
        lengthText.setBounds(100, 20, 165, 25);
        panel.add(lengthText);

        // Creating and placing the Width Label and Text Field
        JLabel widthLabel = new JLabel("Width:");
        widthLabel.setBounds(10, 50, 80, 25);
        panel.add(widthLabel);

        JTextField widthText = new JTextField(20);
        widthText.setBounds(100, 50, 165, 25);
        panel.add(widthText);

        // Creating and placing the Result Label and Text Field
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 80, 80, 25);
        panel.add(resultLabel);

        JTextField resultText = new JTextField(20);
        resultText.setBounds(100, 80, 165, 25);
        panel.add(resultText);
        resultText.setEditable(false); // Makes the result field uneditable

        // Creating and defining action for Calculate Button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 130, 100, 25);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double length = Double.parseDouble(lengthText.getText());
                    double width = Double.parseDouble(widthText.getText());

                    // Check if length and width are non-negative
                    if(length < 0 || width < 0) {
                        JOptionPane.showMessageDialog(panel, "Error: Length and width must be non-negative numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double area = length * width;
                        resultText.setText(String.valueOf(area));
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Error: Please input a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(calculateButton);


        // Creating and defining action for Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(120, 130, 80, 25);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lengthText.setText("");
                widthText.setText(""); // Clearing the width field as well
                resultText.setText("");
            }
        });
        panel.add(clearButton);

        // Creating and defining action for Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 130, 80, 25);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);
    }
}
