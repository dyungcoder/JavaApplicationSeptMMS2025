import javax.swing.*;
import java.awt.*;

public class TemperatureConverterKelvin extends JFrame {
    private JTextField inputField = new JTextField(10);
    private JComboBox<String> fromBox = new JComboBox<>(new String[]{"Fahrenheit","Celsius","Kelvin"});
    private JComboBox<String> toBox = new JComboBox<>(new String[]{"Fahrenheit","Celsius","Kelvin"});
    private JLabel resultLabel = new JLabel("Result: ");

    public TemperatureConverterKelvin() {
        super("Temperature Conversion (F/C/K)");
        setLayout(new FlowLayout());

        add(new JLabel("Value:"));
        add(inputField);
        add(new JLabel("From:"));
        add(fromBox);
        add(new JLabel("To:"));
        add(toBox);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> convert());
        add(convertButton);
        add(resultLabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 100);
        setVisible(true);
    }

    private void convert() {
        try {
            double value = Double.parseDouble(inputField.getText());
            String from = (String) fromBox.getSelectedItem();
            String to = (String) toBox.getSelectedItem();

            // Normalize to Celsius first
            double celsius;
            switch (from) {
                case "Fahrenheit": celsius = 5.0 / 9 * (value - 32); break;
                case "Kelvin": celsius = value - 273.15; break;
                default: celsius = value;
            }

            // Convert from Celsius to target
            double result;
            switch (to) {
                case "Fahrenheit": result = celsius * 9.0 / 5 + 32; break;
                case "Kelvin": result = celsius + 273.15; break;
                default: result = celsius;
            }

            resultLabel.setText(String.format("Result: %.2f %s", result, to));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: (invalid input)");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperatureConverterKelvin::new);
    }
}
