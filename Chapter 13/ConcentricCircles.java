import javax.swing.*;
import java.awt.*;

public class ConcentricCircles extends JFrame {
    public ConcentricCircles() {
        super("Concentric Circles");
        add(new CirclePanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class CirclePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int diameter = 300;
            int x = 20, y = 20;
            for (int i = 0; i < 8; i++) {
                g.drawArc(x, y, diameter, diameter, 0, 360);
                x += 10;
                y += 10;
                diameter -= 20;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConcentricCircles::new);
    }
}
