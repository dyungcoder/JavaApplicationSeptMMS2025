import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TurtleGraphics extends JFrame {
    private static final int SCALE = 10;

    private TurtlePanel turtlePanel = new TurtlePanel();
    private JTextField commandField = new JTextField(30);

    // Turtle state
    private int x = 200, y = 200;
    private int angle = 0; // 0 = facing up
    private boolean penDown = true;

    public TurtleGraphics() {
        super("Turtle Graphics");
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton runButton = new JButton("Run Command");
        JButton resetButton = new JButton("Reset");
        controlPanel.add(new JLabel("Command:"));
        controlPanel.add(commandField);
        controlPanel.add(runButton);
        controlPanel.add(resetButton);

        runButton.addActionListener(e -> runCommand(commandField.getText()));
        commandField.addActionListener(e -> runCommand(commandField.getText()));
        resetButton.addActionListener(e -> {
            x = 200; y = 200; angle = 0; penDown = true;
            turtlePanel.clear();
        });

        add(controlPanel, BorderLayout.NORTH);
        add(turtlePanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    // Supported commands (mirrors Exercise 6.21):
    //   1        -> pen up
    //   2        -> pen down
    //   3        -> turn right
    //   4 nn      -> turn left nn degrees is simplified to 90-degree turns: "4"
    //   5 nn      -> move forward nn positions
    //   6        -> print (ignored in GUI version)
    //   9        -> quit/reset
    private void runCommand(String commandLine) {
        StringTokenizer tok = new StringTokenizer(commandLine);
        while (tok.hasMoreTokens()) {
            int command = Integer.parseInt(tok.nextToken());
            switch (command) {
                case 1: penDown = false; break;
                case 2: penDown = true; break;
                case 3: angle = (angle + 90) % 360; break; // turn right
                case 4: angle = (angle - 90 + 360) % 360; break; // turn left
                case 5:
                    int count = Integer.parseInt(tok.nextToken());
                    move(count);
                    break;
                case 9:
                    x = 200; y = 200; angle = 0; penDown = true;
                    turtlePanel.clear();
                    break;
                default:
                    // ignore unrecognized command
            }
        }
        commandField.setText("");
    }

    private void move(int positions) {
        int pixels = positions * SCALE;
        double radians = Math.toRadians(angle);
        int newX = x + (int) (pixels * Math.sin(radians));
        int newY = y - (int) (pixels * Math.cos(radians));

        if (penDown) {
            turtlePanel.addLine(x, y, newX, newY);
        }
        x = newX;
        y = newY;
    }

    private class TurtlePanel extends JPanel {
        private List<Line2D.Double> segments = new ArrayList<>();

        public void addLine(int x1, int y1, int x2, int y2) {
            segments.add(new Line2D.Double(x1, y1, x2, y2));
            repaint();
        }

        public void clear() {
            segments.clear();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (Line2D.Double line : segments) {
                g2.draw(line);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TurtleGraphics::new);
    }
}
