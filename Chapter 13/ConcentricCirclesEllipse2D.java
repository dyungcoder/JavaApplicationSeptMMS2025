import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ConcentricCirclesEllipse2D extends JFrame {
    public ConcentricCirclesEllipse2D() {
        super("Concentric Circles (Ellipse2D)");
        add(new CirclePanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class CirclePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int diameter = 300;
            int x = 20, y = 20;
            for (int i = 0; i < 8; i++) {
                g2.draw(new Ellipse2D.Double(x, y, diameter, diameter));
                x += 10;
                y += 10;
                diameter -= 20;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConcentricCirclesEllipse2D::new);
    }
}
