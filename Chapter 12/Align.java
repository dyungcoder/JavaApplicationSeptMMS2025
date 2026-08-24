import javax.swing.*;
import java.awt.*;

public class Align extends JFrame {
    public Align() {
        super("Align");
        setLayout(new BorderLayout());

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        fieldsPanel.add(new JLabel("X:"));
        fieldsPanel.add(new JTextField("8"));
        fieldsPanel.add(new JLabel("Y:"));
        fieldsPanel.add(new JTextField("8"));

        JPanel checkPanel = new JPanel(new GridLayout(2, 1));
        checkPanel.add(new JCheckBox("Snap to Grid"));
        checkPanel.add(new JCheckBox("Show Grid"));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(checkPanel, BorderLayout.WEST);
        centerPanel.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        buttonPanel.add(new JButton("Ok"));
        buttonPanel.add(new JButton("Cancel"));
        buttonPanel.add(new JButton("Help"));
        buttonPanel.add(new JLabel()); // spacer

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 160);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Align::new);
    }
}
