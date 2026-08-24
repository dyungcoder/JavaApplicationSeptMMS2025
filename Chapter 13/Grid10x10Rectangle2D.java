import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Grid10x10Rectangle2D extends JFrame {
    public Grid10x10Rectangle2D() {
        super("10x10 Grid (Rectangle2D)");
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
            int cols = 10, rows = 10;
            double cellW = getWidth() / (double) cols;
            double cellH = getHeight() / (double) rows;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    g2.draw(new Rectangle2D.Double(col * cellW, row * cellH, cellW, cellH));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Grid10x10Rectangle2D::new);
    }
}
