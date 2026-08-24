import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ScreenSaverTimer extends JFrame {
    public ScreenSaverTimer() {
        super("Screen Saver (Timer)");
        add(new SaverPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    private class SaverPanel extends JPanel implements ActionListener {
        private Random random = new Random();
        private int lineCount = 0;
        private Timer timer;

        public SaverPanel() {
            setBackground(Color.BLACK);
            timer = new Timer(1000, this);
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (lineCount == 0) {
                super.paintComponent(g);
            }

            if (lineCount >= 100) {
                lineCount = 0;
                return;
            }

            int x1 = random.nextInt(getWidth());
            int y1 = random.nextInt(getHeight());
            int x2 = random.nextInt(getWidth());
            int y2 = random.nextInt(getHeight());
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.drawLine(x1, y1, x2, y2);

            lineCount++;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScreenSaverTimer::new);
    }
}
