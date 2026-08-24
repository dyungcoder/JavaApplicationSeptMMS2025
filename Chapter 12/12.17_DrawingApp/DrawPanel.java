import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    public static final int LINE = 0, OVAL = 1, RECTANGLE = 2;

    private MyShape[] shapes = new MyShape[100];
    private int shapeCount = 0;
    private int shapeType = LINE;
    private MyShape currentShape = null;
    private Color currentColor = Color.BLACK;
    private boolean filledShape = false;
    private JLabel statusLabel;

    public DrawPanel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
        setBackground(Color.WHITE);

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void setShapeType(int type) { shapeType = type; }
    public void setCurrentColor(Color color) { currentColor = color; }
    public void setFilledShape(boolean filled) { filledShape = filled; }

    public void clearLastShape() {
        if (shapeCount > 0) shapeCount--;
        repaint();
    }

    public void clearDrawing() {
        shapeCount = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < shapeCount; i++) shapes[i].draw(g);
        if (currentShape != null) currentShape.draw(g);
    }

    private MyShape createShape(Point p1, Point p2) {
        switch (shapeType) {
            case OVAL: return new MyOval(p1, p2, currentColor, filledShape);
            case RECTANGLE: return new MyRectangle(p1, p2, currentColor, filledShape);
            default: return new MyLine(p1, p2, currentColor, filledShape);
        }
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        @Override
        public void mousePressed(MouseEvent e) {
            currentShape = createShape(e.getPoint(), e.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            currentShape.setPoint2(e.getPoint());
            if (shapeCount < shapes.length) {
                shapes[shapeCount++] = currentShape;
            }
            currentShape = null;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            statusLabel.setText("x: " + e.getX() + "  y: " + e.getY());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentShape != null) {
                currentShape.setPoint2(e.getPoint());
                repaint();
            }
            statusLabel.setText("x: " + e.getX() + "  y: " + e.getY());
        }
    }
}
