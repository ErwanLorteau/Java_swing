import java.awt.*;
import java.util.ArrayList;

public class Model {
    private DrawablePath path;
    private DrawableShape shape;

    private Point pts; // le nouveau point
    private float size= 50; //la taille de la prochaine shape;
    //
    private double teta = 0;
    private double angle;
    private double addAngle = 0.1;
    private double interval=2;
    private Color color;

    private ArrayList<DrawableShape> shapes;
    private int tailleTrace = 50;

    public void addShape(DrawableShape shape){
        this.shapes.add(shape);
    }
    public void suppLastShape(){
        this.shapes.remove(0);
    }
    public DrawablePath getPath() {
        return path;
    }
    public void setPath(DrawablePath path) {
        this.path = path;
    }
    public DrawableShape getShape() {
        return shape;
    }
    public void setShape(DrawableShape shape) {
        this.shape = shape;
    }
    public Point getPts() {
        return pts;
    }
    public void setPts(Point pts) {
        this.pts = pts;
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    }
    public double getTeta() {
        return teta;
    }
    public void setTeta(double teta) {
        this.teta = teta;
    }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public double getAddAngle() {
        return addAngle;
    }
    public void setAddAngle(double addAngle) {
        this.addAngle = addAngle;
    }
    public double getInterval() {
        return interval;
    }
    public void setInterval(double interval) {
        this.interval = interval;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public ArrayList<DrawableShape> getShapes() {
        return shapes;
    }
    public void setShapes(ArrayList<DrawableShape> shapes) {
        this.shapes = shapes;
    }
    public int getTailleTrace() {
        return tailleTrace;
    }
    public void setTailleTrace(int tailleTrace) {
        this.tailleTrace = tailleTrace;
    }
}
