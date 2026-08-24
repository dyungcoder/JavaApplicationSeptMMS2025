import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ATMFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards = new JPanel(cardLayout);

    // very simplified account store: accountNumber -> [pin, balance]
    private Map<String, Object[]> accounts = new HashMap<>();
    private String currentAccount;

    public ATMFrame() {
        super("ATM");
        accounts.put("12345", new Object[]{"6789", 1000.0});

        cards.add(buildLoginPanel(), "login");
        cards.add(buildMenuPanel(), "menu");
        cards.add(buildWithdrawPanel(), "withdraw");
        cards.add(buildDepositPanel(), "deposit");

        add(cards);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    private JPanel buildLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        JTextField accountField = new JTextField();
        JPasswordField pinField = new JPasswordField();
        JLabel message = new JLabel(" ");
        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("Account Number:"));
        panel.add(accountField);
        panel.add(new JLabel("PIN:"));
        panel.add(pinField);
        panel.add(loginButton);
        panel.add(message);

        loginButton.addActionListener(e -> {
            String acc = accountField.getText();
            String pin = new String(pinField.getPassword());
            Object[] info = accounts.get(acc);
            if (info != null && info[0].equals(pin)) {
                currentAccount = acc;
                cardLayout.show(cards, "menu");
            } else {
                message.setText("Invalid account or PIN");
            }
        });
        return panel;
    }

    private JPanel buildMenuPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        JButton balanceButton = new JButton("Balance Inquiry");
        JButton withdrawButton = new JButton("Withdrawal");
        JButton depositButton = new JButton("Deposit");
        JButton removeCashButton = new JButton("Remove Cash");
        JButton logoutButton = new JButton("Logout");

        balanceButton.addActionListener(e -> {
            double bal = (double) accounts.get(currentAccount)[1];
            JOptionPane.showMessageDialog(this, String.format("Balance: $%.2f", bal));
        });
        withdrawButton.addActionListener(e -> cardLayout.show(cards, "withdraw"));
        depositButton.addActionListener(e -> cardLayout.show(cards, "deposit"));
        removeCashButton.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Please take your cash."));
        logoutButton.addActionListener(e -> cardLayout.show(cards, "login"));

        panel.add(balanceButton);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(removeCashButton);
        panel.add(logoutButton);
        return panel;
    }

    private JPanel buildWithdrawPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        JTextField amountField = new JTextField();
        JButton confirmButton = new JButton("Confirm Withdrawal");
        JButton backButton = new JButton("Back");

        confirmButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Object[] info = accounts.get(currentAccount);
                double bal = (double) info[1];
                if (amount <= bal) {
                    info[1] = bal - amount;
                    JOptionPane.showMessageDialog(this, "Please take your cash: $" + amount);
                    cardLayout.show(cards, "menu");
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient funds.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid amount.");
            }
        });
        backButton.addActionListener(e -> cardLayout.show(cards, "menu"));

        panel.add(new JLabel("Withdrawal amount:"));
        panel.add(amountField);
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(confirmButton);
        buttons.add(backButton);
        panel.add(buttons);
        return panel;
    }

    private JPanel buildDepositPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        JTextField amountField = new JTextField();
        JButton insertEnvelopeButton = new JButton("Insert Envelope");
        JButton backButton = new JButton("Back");

        insertEnvelopeButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Object[] info = accounts.get(currentAccount);
                info[1] = (double) info[1] + amount;
                JOptionPane.showMessageDialog(this, "Deposit accepted: $" + amount);
                cardLayout.show(cards, "menu");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid amount.");
            }
        });
        backButton.addActionListener(e -> cardLayout.show(cards, "menu"));

        panel.add(new JLabel("Deposit amount:"));
        panel.add(amountField);
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(insertEnvelopeButton);
        buttons.add(backButton);
        panel.add(buttons);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ATMFrame::new);
    }
}
