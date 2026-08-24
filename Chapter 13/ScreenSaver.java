import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScreenSaver extends JFrame {
    public ScreenSaver() {
        super("Screen Saver");
        add(new SaverPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    // Note: as written, this draws as fast as possible, which can max out a CPU core --
    // that's the "problem" the exercise asks you to notice. Exercise 13.19 fixes it with a Timer.
    private class SaverPanel extends JPanel {
        private Random random = new Random();
        private int lineCount = 0;

        public SaverPanel() {
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (lineCount == 0) {
                super.paintComponent(g); // clears the panel only when we're starting a new batch
            }

            if (lineCount >= 100) {
                lineCount = 0;
                repaint();
                return;
            }

            int x1 = random.nextInt(getWidth());
            int y1 = random.nextInt(getHeight());
            int x2 = random.nextInt(getWidth());
            int y2 = random.nextInt(getHeight());
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.drawLine(x1, y1, x2, y2);

            lineCount++;
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScreenSaver::new);
    }
}
