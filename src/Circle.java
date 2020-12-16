import java.awt.*;

public class Circle extends Shape implements DrawableShape{
    public Circle(Point p, double angle, float size, Color c) {
        super(p, angle, size, c);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        Point p = getUpperLeftCorner();
        g.drawArc((int)p.getX(), (int)p.getY(), (int)this.getSize(), (int)this.getSize(), 0, 360);
    }
    public Point getUpperLeftCorner(){
        return new Point(this.getCenter().getX()-this.getSize()/2, this.getCenter().getY()-this.getSize()/2);
    }
}
