import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSystemConverter extends JFrame {
    private final JTextField inputField;
    private final JButton convertButton;
    private final JComboBox<String> conversionTypeDropdown; 
    private final JTextField resultOutput; 
    private final JLabel inputLabel;

    /**
     * The constructor sets up the GUI layout and initializes all components.
     */

    // Creating object
    public NumberSystemConverter() { 
        super("Base Conversion Tool");

        // Set the layout manager for the main frame
        setLayout(new BorderLayout(5, 5));

        // Make the window non-resizable
        setResizable(false);

        // Label for the input field to clearly indicate where users should enter their number
        inputLabel = new JLabel("Enter your number:");
        add(inputLabel, BorderLayout.WEST);

        // The input field where users will type the number they want to convert
        inputField = new JTextField(20);
        add(inputField, BorderLayout.CENTER);

        // Dropdown for selecting the type of conversion (Array)
        String[] conversionTypes = {
                "Decimal to Binary",
                "Binary to Decimal",
                "Decimal to Hexadecimal",
                "Hexadecimal to Decimal",
                "Binary to Hexadecimal",
                "Hexadecimal to Binary"
        };
        conversionTypeDropdown = new JComboBox<>(conversionTypes); // point this out, no need to specifiy string
        add(conversionTypeDropdown, BorderLayout.NORTH);

        // Button that triggers the conversion process
        convertButton = new JButton("Convert");
        add(convertButton, BorderLayout.EAST);

        // Use a non-editable JTextField for the result
        resultOutput = new JTextField(" Result: ", 20);
        resultOutput.setEditable(false); // Make the text field non-editable
        add(resultOutput, BorderLayout.SOUTH);

        // Event listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performConversion();
            }
        });

        // Set the default close operation and configure the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    /**
     * This method is called when the convert button is pressed.
     * It performs the conversion based on the selected type and handles any input errors.
     */
    private void performConversion() {
        String input = inputField.getText();
        String conversionType = (String) conversionTypeDropdown.getSelectedItem();
        String result;
        try {
            // Determine the type of conversion based on the user's selection and perform it
            switch (conversionType) {
                case "Decimal to Binary":
                    int decimal = Integer.parseInt(input); // string to int
                    result = Integer.toBinaryString(decimal);
                    break;
                case "Binary to Decimal":
                    if (!input.matches("[01]+")) {
                        throw new NumberFormatException("Invalid binary number.");
                    }
                    result = String.valueOf(Integer.parseInt(input, 2));
                    break;
                case "Decimal to Hexadecimal":
                    decimal = Integer.parseInt(input);
                    result = Integer.toHexString(decimal).toUpperCase();
                    break;
                case "Hexadecimal to Decimal":
                    if (!input.matches("[0-9A-Fa-f]+")) {
                        throw new NumberFormatException("Invalid hexadecimal number.");
                    }
                    result = String.valueOf(Integer.parseInt(input, 16));
                    break;
                case "Binary to Hexadecimal":
                    if (!input.matches("[01]+")) {
                        throw new NumberFormatException("Invalid binary number.");
                    }
                    int binaryToDecimal = Integer.parseInt(input, 2);
                    result = Integer.toHexString(binaryToDecimal).toUpperCase();
                    break;
                case "Hexadecimal to Binary":
                    if (!input.matches("[0-9A-Fa-f]+")) {
                        throw new NumberFormatException("Invalid hexadecimal number.");
                    }
                    int hexToDecimal = Integer.parseInt(input, 16);
                    result = Integer.toBinaryString(hexToDecimal);
                    break;
                default:
                    result = "Invalid conversion type.";
                    break;
            }
            // Display the result of the conversion in the resultOutput text field
            resultOutput.setText(" Result: " + result);
        } catch (NumberFormatException nfe) {
            // Display an error message dialog if an invalid number is entered
            JOptionPane.showMessageDialog(null, "Invalid Input Try Again"); 
        }
    }

    /**
     * The main method that creates and shows the GUI.
     */
    public static void main(String[] args) {
        new NumberSystemConverter();
    }}
    
