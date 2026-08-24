import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ScreenSaverConfigurable extends JFrame {
    public ScreenSaverConfigurable() {
        super("Screen Saver (Configurable)");
        setLayout(new BorderLayout());

        SaverPanel saverPanel = new SaverPanel();
        JTextField limitField = new JTextField("100");

        limitField.addActionListener(new LimitFieldHandler(saverPanel, limitField));

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Lines before clearing:"));
        topPanel.add(limitField);

        add(topPanel, BorderLayout.NORTH);
        add(saverPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    // Inner class handling the JTextField's events, as required by the exercise.
    private class LimitFieldHandler implements ActionListener {
        private SaverPanel panel;
        private JTextField field;

        public LimitFieldHandler(SaverPanel panel, JTextField field) {
            this.panel = panel;
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int newLimit = Integer.parseInt(field.getText());
                panel.setLineLimit(newLimit);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Enter a valid integer.");
            }
        }
    }

    private class SaverPanel extends JPanel implements ActionListener {
        private Random random = new Random();
        private int lineCount = 0;
        private int lineLimit = 100;
        private Timer timer;

        public SaverPanel() {
            setBackground(Color.BLACK);
            timer = new Timer(1000, this);
            timer.start();
        }

        public void setLineLimit(int limit) {
            this.lineLimit = limit;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (lineCount == 0) {
                super.paintComponent(g);
            }

            if (lineCount >= lineLimit) {
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
        SwingUtilities.invokeLater(ScreenSaverConfigurable::new);
    }
}
