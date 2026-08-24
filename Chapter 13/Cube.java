import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Cube extends JFrame {
    public Cube() {
        super("Cube");
        add(new CubePanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class CubePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int size = 150;
            int offset = 60; // depth offset for the "3D" effect
            int x = 100, y = 150;

            // Front face corners
            Point flt = new Point(x, y);
            Point frt = new Point(x + size, y);
            Point frb = new Point(x + size, y + size);
            Point flb = new Point(x, y + size);

            // Back face corners (shifted by offset)
            Point blt = new Point(x + offset, y - offset);
            Point brt = new Point(x + size + offset, y - offset);
            Point brb = new Point(x + size + offset, y + size - offset);
            Point blb = new Point(x + offset, y + size - offset);

            drawQuad(g2, flt, frt, frb, flb); // front
            drawQuad(g2, blt, brt, brb, blb); // back
            drawLine(g2, flt, blt);
            drawLine(g2, frt, brt);
            drawLine(g2, frb, brb);
            drawLine(g2, flb, blb);
        }

        private void drawQuad(Graphics2D g2, Point p1, Point p2, Point p3, Point p4) {
            GeneralPath path = new GeneralPath();
            path.moveTo(p1.x, p1.y);
            path.lineTo(p2.x, p2.y);
            path.lineTo(p3.x, p3.y);
            path.lineTo(p4.x, p4.y);
            path.closePath();
            g2.draw(path);
        }

        private void drawLine(Graphics2D g2, Point p1, Point p2) {
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Cube::new);
    }
}
