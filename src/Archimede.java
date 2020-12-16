public class Archimede extends Path implements DrawablePath {
    public Archimede(Point center, double size) {
        super(center, size);
    }

    @Override
    public Point getNextPoint(double teta) {
        double length, angle;
        int x,y;
        length = this.getSize() - (this.getSize()*teta);
        angle = Math.toRadians(teta*360)/200;
        x = (int)(this.getCenter().getX() - 0.001 * Math.round(length*Math.cos(angle)));
        y = (int)(this.getCenter().getX() - 0.001 * Math.round(length*Math.sin(angle)));
        return new Point(x,y);
    }
}
