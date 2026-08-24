import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleCalculator extends JFrame {
    private double radius, centerX, centerY;
    private CirclePanel circlePanel = new CirclePanel();

    public CircleCalculator() {
        super("Circle Calculator");
        setLayout(new BorderLayout());

        radius = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the radius:"));
        centerX = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the center x-coordinate:"));
        centerY = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the center y-coordinate:"));

        double diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        JLabel infoLabel = new JLabel(String.format(
            "<html>Diameter: %.2f &nbsp; Circumference: %.2f &nbsp; Area: %.2f</html>",
            diameter, circumference, area));

        add(infoLabel, BorderLayout.SOUTH);
        add(circlePanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    private class CirclePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            double x = centerX - radius;
            double y = centerY - radius;
            g2.draw(new Ellipse2D.Double(x, y, radius * 2, radius * 2));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CircleCalculator::new);
    }
}
