import java.awt.*;

public abstract class Shape {
    private  Point center;
    private double angle;
    private float size;
    private Color color;

    public Shape(Point p, double angle, float size, Color c){
        this.center = p;
        this.angle = angle;
        this.size = size;
        this.color = c;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
