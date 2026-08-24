import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KnightsTour extends JFrame {
    private static final int BOARD_SIZE = 8;
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE]; // 0 = unvisited, else move number
    private int currentRow, currentCol, moveNumber;
    private Timer timer;
    private BoardPanel boardPanel = new BoardPanel();

    private static final int[] ROW_MOVES = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] COL_MOVES = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightsTour() {
        super("Knight's Tour");
        add(boardPanel);

        currentRow = 0;
        currentCol = 0;
        moveNumber = 1;
        board[currentRow][currentCol] = moveNumber;

        timer = new Timer(400, new TimerHandler());
        timer.start();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    // Uses the "accessibility heuristic" (always move to the square with fewest onward moves)
    // to greatly increase the chance of completing a full tour, per Exercise 6.26.
    private int[] chooseNextMove() {
        int bestAccessibility = Integer.MAX_VALUE;
        int bestRow = -1, bestCol = -1;

        for (int i = 0; i < 8; i++) {
            int newRow = currentRow + ROW_MOVES[i];
            int newCol = currentCol + COL_MOVES[i];
            if (isValidMove(newRow, newCol)) {
                int accessibility = countAccessibleMoves(newRow, newCol);
                if (accessibility < bestAccessibility) {
                    bestAccessibility = accessibility;
                    bestRow = newRow;
                    bestCol = newCol;
                }
            }
        }
        return bestRow == -1 ? null : new int[]{bestRow, bestCol};
    }

    private int countAccessibleMoves(int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (isValidMove(row + ROW_MOVES[i], col + COL_MOVES[i])) count++;
        }
        return count;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0;
    }

    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] next = chooseNextMove();
            if (next == null) {
                timer.stop();
                boolean fullTour = moveNumber == BOARD_SIZE * BOARD_SIZE;
                String message = fullTour
                    ? "Full tour completed in " + moveNumber + " moves!"
                    : "Tour stopped after " + moveNumber + " moves (no more legal moves).";
                JOptionPane.showMessageDialog(KnightsTour.this, message);
                return;
            }
            currentRow = next[0];
            currentCol = next[1];
            moveNumber++;
            board[currentRow][currentCol] = moveNumber;
            boardPanel.repaint();
        }
    }

    private class BoardPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellSize = Math.min(getWidth(), getHeight()) / BOARD_SIZE;

            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    int x = col * cellSize;
                    int y = row * cellSize;
                    g.setColor((row + col) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                    g.fillRect(x, y, cellSize, cellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, cellSize, cellSize);

                    if (board[row][col] != 0) {
                        String text = String.valueOf(board[row][col]);
                        g.drawString(text, x + cellSize / 3, y + cellSize / 2);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KnightsTour::new);
    }
}
