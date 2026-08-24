import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventDisplay extends JFrame implements ActionListener, ItemListener,
        ListSelectionListener, MouseListener, MouseMotionListener, KeyListener {

    private JTextArea log = new JTextArea(15, 40);
    private JButton button = new JButton("Click Me");
    private JCheckBox checkBox = new JCheckBox("Check Me");
    private JList<String> list = new JList<>(new String[]{"One","Two","Three"});
    private JTextField textField = new JTextField(15);
    private JPanel mousePad = new JPanel();

    public EventDisplay() {
        super("Displaying Events");
        setLayout(new BorderLayout());

        JPanel controls = new JPanel(new FlowLayout());
        controls.add(button);
        controls.add(checkBox);
        controls.add(new JScrollPane(list));
        controls.add(textField);
        mousePad.setPreferredSize(new Dimension(300, 80));
        mousePad.setBackground(Color.LIGHT_GRAY);
        controls.add(mousePad);

        add(controls, BorderLayout.NORTH);
        add(new JScrollPane(log), BorderLayout.CENTER);

        button.addActionListener(this);
        checkBox.addItemListener(this);
        list.addListSelectionListener(this);
        textField.addKeyListener(this);
        mousePad.addMouseListener(this);
        mousePad.addMouseMotionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    private void logEvent(java.util.EventObject e) {
        log.append(e.toString() + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    @Override public void actionPerformed(ActionEvent e) { logEvent(e); }
    @Override public void itemStateChanged(ItemEvent e) { logEvent(e); }
    @Override public void valueChanged(ListSelectionEvent e) { logEvent(e); }
    @Override public void mouseClicked(MouseEvent e) { logEvent(e); }
    @Override public void mousePressed(MouseEvent e) { logEvent(e); }
    @Override public void mouseReleased(MouseEvent e) { logEvent(e); }
    @Override public void mouseEntered(MouseEvent e) { logEvent(e); }
    @Override public void mouseExited(MouseEvent e) { logEvent(e); }
    @Override public void mouseDragged(MouseEvent e) { logEvent(e); }
    @Override public void mouseMoved(MouseEvent e) { logEvent(e); }
    @Override public void keyTyped(KeyEvent e) { logEvent(e); }
    @Override public void keyPressed(KeyEvent e) { logEvent(e); }
    @Override public void keyReleased(KeyEvent e) { logEvent(e); }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventDisplay::new);
    }
}
