import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Tetrahedron extends JFrame {
    public Tetrahedron() {
        super("Tetrahedron");
        add(new TetraPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class TetraPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            // Base triangle vertices
            Point a = new Point(100, 300);
            Point b = new Point(300, 300);
            Point c = new Point(200, 220); // back base vertex (drawn slightly up for depth)
            // Apex
            Point apex = new Point(200, 80);

            drawFace(g2, a, b, apex);
            drawFace(g2, b, c, apex);
            drawFace(g2, c, a, apex);
            drawFace(g2, a, b, c); // base
        }

        private void drawFace(Graphics2D g2, Point p1, Point p2, Point p3) {
            GeneralPath path = new GeneralPath();
            path.moveTo(p1.x, p1.y);
            path.lineTo(p2.x, p2.y);
            path.lineTo(p3.x, p3.y);
            path.closePath();
            g2.draw(path);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tetrahedron::new);
    }
}
