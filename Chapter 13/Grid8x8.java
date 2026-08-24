import javax.swing.*;
import java.awt.*;

public class Grid8x8 extends JFrame {
    public Grid8x8() {
        super("8x8 Grid");
        add(new GridPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class GridPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            int cols = 8, rows = 8;
            double cellW = width / (double) cols;
            double cellH = height / (double) rows;

            for (int i = 0; i <= cols; i++) {
                int x = (int) (i * cellW);
                g.drawLine(x, 0, x, height);
            }
            for (int i = 0; i <= rows; i++) {
                int y = (int) (i * cellH);
                g.drawLine(0, y, width, y);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Grid8x8::new);
    }
}
