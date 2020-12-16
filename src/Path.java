public abstract class Path {
    private Point center;
    private double size;

    public Path(Point center, double size){
        this.center = center;
        this.size = size;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
