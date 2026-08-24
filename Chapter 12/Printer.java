import javax.swing.*;
import java.awt.*;

public class Printer extends JFrame {
    public Printer() {
        super("Printer");
        setLayout(new BorderLayout());

        JLabel printerLabel = new JLabel("Printer: MyPrinter");

        JPanel checkPanel = new JPanel(new GridLayout(3, 1));
        checkPanel.add(new JCheckBox("Image"));
        checkPanel.add(new JCheckBox("Text"));
        checkPanel.add(new JCheckBox("Code"));

        JPanel radioPanel = new JPanel(new GridLayout(3, 1));
        ButtonGroup group = new ButtonGroup();
        JRadioButton selection = new JRadioButton("Selection");
        JRadioButton all = new JRadioButton("All", true);
        JRadioButton applet = new JRadioButton("Applet");
        group.add(selection); group.add(all); group.add(applet);
        radioPanel.add(selection); radioPanel.add(all); radioPanel.add(applet);

        JPanel optionsPanel = new JPanel(new GridLayout(1, 2));
        optionsPanel.add(checkPanel);
        optionsPanel.add(radioPanel);

        JPanel qualityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qualityPanel.add(new JLabel("Print Quality:"));
        qualityPanel.add(new JComboBox<>(new String[]{"High","Medium","Low"}));
        qualityPanel.add(new JCheckBox("Print to File"));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(printerLabel, BorderLayout.NORTH);
        centerPanel.add(optionsPanel, BorderLayout.CENTER);
        centerPanel.add(qualityPanel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 3, 3));
        buttonPanel.add(new JButton("OK"));
        buttonPanel.add(new JButton("Cancel"));
        buttonPanel.add(new JButton("Setup..."));
        buttonPanel.add(new JButton("Help"));

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Printer::new);
    }
}
