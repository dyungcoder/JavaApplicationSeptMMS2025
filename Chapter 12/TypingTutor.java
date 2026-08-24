import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class TypingTutor extends JFrame implements KeyListener {
    private JTextArea typedArea = new JTextArea(5, 40);
    private Map<Character, JButton> keyButtons = new HashMap<>();
    private Map<JButton, Color> originalColors = new HashMap<>();
    private int correctCount = 0, incorrectCount = 0;
    private JLabel statsLabel = new JLabel("Correct: 0  Incorrect: 0");

    private static final String[] ROWS = {
        "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"
    };

    public TypingTutor() {
        super("Typing Tutor");
        setLayout(new BorderLayout());
        setFocusable(true);

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new BoxLayout(keyboardPanel, BoxLayout.Y_AXIS));
        for (String row : ROWS) {
            JPanel rowPanel = new JPanel(new FlowLayout());
            for (char c : row.toCharArray()) {
                JButton b = new JButton(String.valueOf(c));
                keyButtons.put(c, b);
                originalColors.put(b, b.getBackground());
                rowPanel.add(b);
            }
            keyboardPanel.add(rowPanel);
        }

        add(keyboardPanel, BorderLayout.NORTH);
        add(new JScrollPane(typedArea), BorderLayout.CENTER);
        add(statsLabel, BorderLayout.SOUTH);

        addKeyListener(this);
        typedArea.addKeyListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = Character.toUpperCase(e.getKeyChar());
        JButton b = keyButtons.get(c);
        if (b != null) {
            b.setBackground(Color.YELLOW);
            correctCount++;
        } else {
            incorrectCount++;
        }
        statsLabel.setText("Correct: " + correctCount + "  Incorrect: " + incorrectCount);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = Character.toUpperCase(e.getKeyChar());
        JButton b = keyButtons.get(c);
        if (b != null) {
            b.setBackground(originalColors.get(b));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TypingTutor::new);
    }
}
