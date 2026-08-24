import javax.swing.*;
import java.awt.*;

public class TemperatureConverter extends JFrame {
    private JTextField fahrenheitField = new JTextField(10);
    private JLabel resultLabel = new JLabel("Celsius: ");

    public TemperatureConverter() {
        super("Temperature Conversion");
        setLayout(new FlowLayout());

        add(new JLabel("Fahrenheit:"));
        add(fahrenheitField);
        add(resultLabel);

        fahrenheitField.addActionListener(e -> convert());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 100);
        setVisible(true);
    }

    private void convert() {
        try {
            double f = Double.parseDouble(fahrenheitField.getText());
            double c = 5.0 / 9 * (f - 32);
            resultLabel.setText(String.format("Celsius: %.2f", c));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Celsius: (invalid input)");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperatureConverter::new);
    }
}
