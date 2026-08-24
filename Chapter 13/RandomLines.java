import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

public class RandomLines extends JFrame {
    public RandomLines() {
        super("Concentric Circles + Random Lines");
        add(new CirclePanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class CirclePanel extends JPanel {
        private Random random = new Random();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int diameter = 300;
            int x = 20, y = 20;
            g2.setStroke(new BasicStroke(1));
            g2.setPaint(Color.BLACK);
            for (int i = 0; i < 8; i++) {
                g2.draw(new Ellipse2D.Double(x, y, diameter, diameter));
                x += 10;
                y += 10;
                diameter -= 20;
            }

            for (int i = 0; i < 10; i++) {
                int x1 = random.nextInt(getWidth());
                int y1 = random.nextInt(getHeight());
                int x2 = random.nextInt(getWidth());
                int y2 = random.nextInt(getHeight());
                Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                float thickness = 1 + random.nextInt(8);

                g2.setPaint(color);
                g2.setStroke(new BasicStroke(thickness));
                g2.draw(new Line2D.Double(x1, y1, x2, y2));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomLines::new);
    }
}
