import javax.swing.*;
import java.awt.*;

public class Grid10x10 extends JFrame {
    public Grid10x10() {
        super("10x10 Grid");
        add(new GridPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class GridPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cols = 10, rows = 10;
            int cellW = getWidth() / cols;
            int cellH = getHeight() / rows;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    g.drawRect(col * cellW, row * cellH, cellW, cellH);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Grid10x10::new);
    }
}
