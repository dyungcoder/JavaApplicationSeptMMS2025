import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class ScreenSaver2D extends JFrame {
    public ScreenSaver2D() {
        super("Screen Saver (Java 2D + Gradients)");
        setLayout(new BorderLayout());

        SaverPanel saverPanel = new SaverPanel();
        JTextField limitField = new JTextField("100");
        limitField.addActionListener(e -> {
            try {
                saverPanel.setShapeLimit(Integer.parseInt(limitField.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(saverPanel, "Enter a valid integer.");
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Shapes before clearing:"));
        topPanel.add(limitField);

        add(topPanel, BorderLayout.NORTH);
        add(saverPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    private class SaverPanel extends JPanel implements ActionListener {
        private Random random = new Random();
        private int shapeCount = 0;
        private int shapeLimit = 100;
        private Timer timer;

        public SaverPanel() {
            setBackground(Color.BLACK);
            timer = new Timer(1000, this);
            timer.start();
        }

        public void setShapeLimit(int limit) {
            this.shapeLimit = limit;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            if (shapeCount == 0) {
                super.paintComponent(g2);
            }

            if (shapeCount >= shapeLimit) {
                shapeCount = 0;
                return;
            }

            int type = random.nextInt(2); // 0=rectangle, 1=ellipse
            double x = random.nextInt(getWidth());
            double y = random.nextInt(getHeight());
            double w = random.nextInt(100) + 10;
            double h = random.nextInt(100) + 10;

            Color c1 = randomColor();
            Color c2 = randomColor();
            GradientPaint gradient = new GradientPaint(
                (float) x, (float) y, c1, (float) (x + w), (float) (y + h), c2);
            g2.setPaint(gradient);

            if (type == 0) {
                g2.fill(new Rectangle2D.Double(x, y, w, h));
            } else {
                g2.fill(new Ellipse2D.Double(x, y, w, h));
            }

            shapeCount++;
        }

        private Color randomColor() {
            return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScreenSaver2D::new);
    }
}
