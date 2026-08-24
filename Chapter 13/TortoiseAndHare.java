import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.Random;

public class TortoiseAndHare extends JFrame {
    private static final int RACE_LENGTH = 300;

    private int tortoisePosition = 0;
    private int harePosition = 0;
    private Random random = new Random();
    private Timer timer;
    private RacePanel racePanel = new RacePanel();
    private JLabel statusLabel = new JLabel("Ready, set, go!");

    public TortoiseAndHare() {
        super("Tortoise and Hare");
        setLayout(new BorderLayout());
        add(racePanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        timer = new Timer(200, new TimerHandler());
        timer.start();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveTortoise();
            moveHare();
            racePanel.repaint();

            if (tortoisePosition >= RACE_LENGTH && harePosition >= RACE_LENGTH) {
                finish("It's a tie!");
            } else if (tortoisePosition >= RACE_LENGTH) {
                finish("Tortoise wins!");
            } else if (harePosition >= RACE_LENGTH) {
                finish("Hare wins!");
            }
        }
    }

    private void finish(String message) {
        timer.stop();
        statusLabel.setText(message);
        JOptionPane.showMessageDialog(this, message);
    }

    private void moveTortoise() {
        int chance = random.nextInt(10);
        int move;
        if (chance < 5) move = 3;       // fast plod
        else if (chance < 7) move = -6; // slip
        else if (chance < 9) move = 1;  // slow plod
        else move = 0;                  // rest

        tortoisePosition = Math.max(0, tortoisePosition + move);
    }

    private void moveHare() {
        int chance = random.nextInt(10);
        int move;
        if (chance < 2) move = 0;        // sleep
        else if (chance < 4) move = 9;   // big hop
        else if (chance < 6) move = -12; // fast slip
        else if (chance < 8) move = 1;   // small hop
        else move = -2;                  // small slip

        harePosition = Math.max(0, harePosition + move);
    }

    private class RacePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int arcX = 20, arcY = 20;
            int arcWidth = getWidth() - 40, arcHeight = (getHeight() - 40) * 2;
            Arc2D.Double mountain = new Arc2D.Double(arcX, arcY, arcWidth, arcHeight, 180, 90, Arc2D.OPEN);
            g2.draw(mountain);

            drawRacer(g2, mountain, tortoisePosition, Color.GREEN, "T");
            drawRacer(g2, mountain, harePosition, Color.ORANGE, "H");
        }

        private void drawRacer(Graphics2D g2, Arc2D.Double mountain, int position, Color color, String label) {
            double fraction = Math.min(1.0, position / (double) RACE_LENGTH);
            double angle = Math.toRadians(180 - fraction * 90); // from 180 down to 90 degrees
            double cx = mountain.getCenterX();
            double cy = mountain.getCenterY();
            double rx = mountain.getWidth() / 2;
            double ry = mountain.getHeight() / 2;

            double px = cx + rx * Math.cos(angle);
            double py = cy + ry * Math.sin(angle);

            g2.setColor(color);
            g2.fillOval((int) px - 6, (int) py - 6, 12, 12);
            g2.drawString(label, (int) px - 4, (int) py - 10);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TortoiseAndHare::new);
    }
}
