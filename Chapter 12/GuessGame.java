import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GuessGame extends JFrame {
    private int number;
    private Random random = new Random();
    private JLabel promptLabel = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
    private JLabel feedbackLabel = new JLabel(" ");
    private JTextField guessField = new JTextField(10);
    private JButton playAgainButton = new JButton("Play Again");
    private JPanel mainPanel = new JPanel();

    public GuessGame() {
        super("Guess the Number");
        number = 1 + random.nextInt(1000);

        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.add(promptLabel);
        mainPanel.add(guessField);
        mainPanel.add(feedbackLabel);
        mainPanel.add(playAgainButton);
        add(mainPanel);

        guessField.addActionListener(e -> checkGuess());
        playAgainButton.addActionListener(e -> resetGame());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            int diff = Math.abs(guess - number);

            if (diff == 0) {
                feedbackLabel.setText("Correct!");
                guessField.setEditable(false);
            } else {
                mainPanel.setBackground(diff < 50 ? Color.RED : Color.BLUE);
                feedbackLabel.setText(guess < number ? "Too Low" : "Too High");
            }
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Enter a valid number");
        }
    }

    private void resetGame() {
        number = 1 + random.nextInt(1000);
        guessField.setText("");
        guessField.setEditable(true);
        feedbackLabel.setText(" ");
        mainPanel.setBackground(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessGame::new);
    }
}
