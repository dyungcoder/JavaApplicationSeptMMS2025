import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ScreenSaverShapes extends JFrame {
    public ScreenSaverShapes() {
        super("Screen Saver (Shapes)");
        setLayout(new BorderLayout());

        SaverPanel saverPanel = new SaverPanel();
        JTextField limitField = new JTextField("100");
        limitField.addActionListener(e -> {
            try {
                saverPanel.setLineLimit(Integer.parseInt(limitField.getText()));
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

        public void setLineLimit(int limit) {
            this.shapeLimit = limit;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (shapeCount == 0) {
                super.paintComponent(g);
            }

            if (shapeCount >= shapeLimit) {
                shapeCount = 0;
                return;
            }

            int type = random.nextInt(3); // 0=line, 1=oval, 2=rect
            int x1 = random.nextInt(getWidth());
            int y1 = random.nextInt(getHeight());
            int w = random.nextInt(100) + 10;
            int h = random.nextInt(100) + 10;

            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            switch (type) {
                case 0:
                    int x2 = random.nextInt(getWidth());
                    int y2 = random.nextInt(getHeight());
                    g.drawLine(x1, y1, x2, y2);
                    break;
                case 1:
                    g.drawOval(x1, y1, w, h);
                    break;
                case 2:
                    g.drawRect(x1, y1, w, h);
                    break;
            }

            shapeCount++;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScreenSaverShapes::new);
    }
}
