import java.awt.*;

public abstract class MyShape {
    protected Point p1, p2;
    protected Color color;
    protected boolean filled;

    public MyShape(Point p1, Point p2, Color color, boolean filled) {
        this.p1 = p1; this.p2 = p2; this.color = color; this.filled = filled;
    }
    public void setPoint2(Point p2) { this.p2 = p2; }
    public abstract void draw(Graphics g);
}

class MyLine extends MyShape {
    public MyLine(Point p1, Point p2, Color c, boolean f) { super(p1, p2, c, f); }
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}

class MyOval extends MyShape {
    public MyOval(Point p1, Point p2, Color c, boolean f) { super(p1, p2, c, f); }
    public void draw(Graphics g) {
        g.setColor(color);
        int x = Math.min(p1.x, p2.x), y = Math.min(p1.y, p2.y);
        int w = Math.abs(p1.x - p2.x), h = Math.abs(p1.y - p2.y);
        if (filled) g.fillOval(x, y, w, h); else g.drawOval(x, y, w, h);
    }
}

class MyRectangle extends MyShape {
    public MyRectangle(Point p1, Point p2, Color c, boolean f) { super(p1, p2, c, f); }
    public void draw(Graphics g) {
        g.setColor(color);
        int x = Math.min(p1.x, p2.x), y = Math.min(p1.y, p2.y);
        int w = Math.abs(p1.x - p2.x), h = Math.abs(p1.y - p2.y);
        if (filled) g.fillRect(x, y, w, h); else g.drawRect(x, y, w, h);
    }
}
