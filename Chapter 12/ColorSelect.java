import javax.swing.*;
import java.awt.*;

public class ColorSelect extends JFrame {
    public ColorSelect() {
        super("ColorSelect");
        setLayout(new BorderLayout());

        String[] colors = {"RED","BLUE","GREEN","YELLOW","BLACK","WHITE","ORANGE"};
        JComboBox<String> colorBox = new JComboBox<>(colors);
        add(colorBox, BorderLayout.NORTH);

        JPanel checkPanel = new JPanel(new FlowLayout());
        checkPanel.add(new JCheckBox("Background"));
        checkPanel.add(new JCheckBox("Foreground"));
        add(checkPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("Ok"));
        buttonPanel.add(new JButton("Cancel"));
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(280, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorSelect::new);
    }
}
