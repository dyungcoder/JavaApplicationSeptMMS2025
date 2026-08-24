import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomCharacters extends JFrame {
    public RandomCharacters() {
        super("Random Characters");
        add(new CharPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private class CharPanel extends JPanel {
        private Random random = new Random();
        private String[] fontNames = {"Serif", "SansSerif", "Monospaced"};

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            for (int i = 0; i < 20; i++) {
                char c = (char) ('A' + random.nextInt(26));
                String fontName = fontNames[random.nextInt(fontNames.length)];
                int style = random.nextInt(4); // combinations of PLAIN/BOLD/ITALIC
                int size = 12 + random.nextInt(40);
                int x = random.nextInt(Math.max(1, getWidth() - 40));
                int y = 40 + random.nextInt(Math.max(1, getHeight() - 40));

                g2.setFont(new Font(fontName, style, size));
                g2.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                g2.drawString(String.valueOf(c), x, y);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomCharacters::new);
    }
}
