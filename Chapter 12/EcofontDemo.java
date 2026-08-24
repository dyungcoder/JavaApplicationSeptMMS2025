import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EcofontDemo extends JFrame {
    private JTextField inputField = new JTextField(20);
    private JLabel displayLabel = new JLabel("Type something above");
    private int fontSize = 9;
    private Font ecoFont;

    public EcofontDemo() {
        super("Ecofont Demo");
        setLayout(new BorderLayout());

        // Load the Ecofont .ttf if available; otherwise fall back to a system font.
        try {
            ecoFont = Font.createFont(Font.TRUETYPE_FONT, new File("Spranq_eco_sans_regular.ttf"));
        } catch (Exception ex) {
            ecoFont = new Font("SansSerif", Font.PLAIN, fontSize);
        }
        displayLabel.setFont(ecoFont.deriveFont((float) fontSize));

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Text:"));
        topPanel.add(inputField);
        JButton increaseButton = new JButton("Increase Font Size");
        JButton decreaseButton = new JButton("Decrease Font Size");
        topPanel.add(increaseButton);
        topPanel.add(decreaseButton);

        inputField.addActionListener(e -> displayLabel.setText(inputField.getText()));
        increaseButton.addActionListener(e -> {
            fontSize++;
            displayLabel.setFont(ecoFont.deriveFont((float) fontSize));
        });
        decreaseButton.addActionListener(e -> {
            if (fontSize > 1) fontSize--;
            displayLabel.setFont(ecoFont.deriveFont((float) fontSize));
        });

        add(topPanel, BorderLayout.NORTH);
        add(displayLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EcofontDemo::new);
    }
}
