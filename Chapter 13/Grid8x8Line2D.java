import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Grid8x8Line2D extends JFrame {
    public Grid8x8Line2D() {
        super("8x8 Grid (Line2D)");
        add(new GridPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class GridPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            int cols = 8, rows = 8;
            double cellW = width / (double) cols;
            double cellH = height / (double) rows;

            for (int i = 0; i <= cols; i++) {
                double x = i * cellW;
                g2.draw(new Line2D.Double(x, 0, x, height));
            }
            for (int i = 0; i <= rows; i++) {
                double y = i * cellH;
                g2.draw(new Line2D.Double(0, y, width, y));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Grid8x8Line2D::new);
    }
}
