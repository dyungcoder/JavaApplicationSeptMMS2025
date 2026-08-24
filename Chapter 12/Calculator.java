import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    public Calculator() {
        super("Calculator");
        setLayout(new BorderLayout());

        JTextField display = new JTextField();
        add(display, BorderLayout.NORTH);

        String[] keys = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+"
        };
        JPanel keypad = new JPanel(new GridLayout(4, 4, 3, 3));
        for (String k : keys) keypad.add(new JButton(k));
        add(keypad, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(260, 260);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
