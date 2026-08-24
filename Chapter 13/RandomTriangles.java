import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class RandomTriangles extends JFrame {
    public RandomTriangles() {
        super("Random Triangles");
        add(new TrianglePanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class TrianglePanel extends JPanel {
        private Random random = new Random();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            for (int i = 0; i < 5; i++) {
                int x1 = random.nextInt(getWidth());
                int y1 = random.nextInt(getHeight());
                int x2 = random.nextInt(getWidth());
                int y2 = random.nextInt(getHeight());
                int x3 = random.nextInt(getWidth());
                int y3 = random.nextInt(getHeight());

                GeneralPath path = new GeneralPath();
                path.moveTo(x1, y1);
                path.lineTo(x2, y2);
                path.lineTo(x3, y3);
                path.closePath();

                g2.setPaint(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                g2.fill(path);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomTriangles::new);
    }
}
