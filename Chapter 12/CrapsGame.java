import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CrapsGame extends JFrame {
    private static final Random random = new Random();
    private int myPoint = 0;
    private boolean firstRoll = true;

    private JTextField die1Field = new JTextField(5);
    private JTextField die2Field = new JTextField(5);
    private JTextField sumField = new JTextField(5);
    private JTextField pointField = new JTextField(5);
    private JButton rollButton = new JButton("Roll Dice");
    private JLabel statusLabel = new JLabel("Click Roll Dice to play");

    public CrapsGame() {
        super("Craps Game");
        setLayout(new GridLayout(6, 1, 5, 5));

        add(labeled("Die 1:", die1Field));
        add(labeled("Die 2:", die2Field));
        add(labeled("Sum:", sumField));
        add(labeled("Point:", pointField));
        add(rollButton);
        add(statusLabel);

        die1Field.setEditable(false);
        die2Field.setEditable(false);
        sumField.setEditable(false);
        pointField.setEditable(false);

        rollButton.addActionListener(e -> playRound());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    private JPanel labeled(String text, JTextField field) {
        JPanel p = new JPanel(new FlowLayout());
        p.add(new JLabel(text));
        p.add(field);
        return p;
    }

    private int rollDice() {
        int d1 = 1 + random.nextInt(6);
        int d2 = 1 + random.nextInt(6);
        int sum = d1 + d2;
        die1Field.setText(String.valueOf(d1));
        die2Field.setText(String.valueOf(d2));
        sumField.setText(String.valueOf(sum));
        return sum;
    }

    private void playRound() {
        int sum = rollDice();

        if (firstRoll) {
            if (sum == 7 || sum == 11) {
                statusLabel.setText("You win!");
                firstRoll = true;
            } else if (sum == 2 || sum == 3 || sum == 12) {
                statusLabel.setText("You lose!");
                firstRoll = true;
            } else {
                myPoint = sum;
                pointField.setText(String.valueOf(myPoint));
                statusLabel.setText("Point is " + myPoint + ". Roll again.");
                firstRoll = false;
            }
        } else {
            if (sum == myPoint) {
                statusLabel.setText("You win! Point made.");
                firstRoll = true;
            } else if (sum == 7) {
                statusLabel.setText("You lose! Craps out.");
                firstRoll = true;
            } else {
                statusLabel.setText("No decision. Roll again. Point is " + myPoint);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CrapsGame::new);
    }
}
