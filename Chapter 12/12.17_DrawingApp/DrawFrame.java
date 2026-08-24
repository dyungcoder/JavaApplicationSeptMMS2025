import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {
    public DrawFrame() {
        super("Drawing Application");
        setLayout(new BorderLayout());

        JLabel statusLabel = new JLabel("x: 0  y: 0");
        DrawPanel drawPanel = new DrawPanel(statusLabel);

        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton undoButton = new JButton("Undo");
        JButton clearButton = new JButton("Clear");
        Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE,
                Color.MAGENTA, Color.CYAN, Color.YELLOW, Color.PINK, Color.GRAY,
                Color.DARK_GRAY, Color.LIGHT_GRAY, Color.WHITE};
        JComboBox<Color> colorBox = new JComboBox<>(colors);
        JComboBox<String> shapeBox = new JComboBox<>(new String[]{"Line","Oval","Rectangle"});
        JCheckBox filledCheck = new JCheckBox("Filled");

        controlPanel.add(undoButton);
        controlPanel.add(clearButton);
        controlPanel.add(colorBox);
        controlPanel.add(shapeBox);
        controlPanel.add(filledCheck);

        undoButton.addActionListener(e -> drawPanel.clearLastShape());
        clearButton.addActionListener(e -> drawPanel.clearDrawing());
        colorBox.addActionListener(e -> drawPanel.setCurrentColor((Color) colorBox.getSelectedItem()));
        shapeBox.addActionListener(e -> drawPanel.setShapeType(shapeBox.getSelectedIndex()));
        filledCheck.addActionListener(e -> drawPanel.setFilledShape(filledCheck.isSelected()));

        add(controlPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
    }
}
