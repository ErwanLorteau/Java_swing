public class Lemniscape extends Path implements DrawablePath {
    public Lemniscape(Point center, double size) {
        super(center, size);
    }

    @Override
    public Point getNextPoint(double teta) {
        final double v = 1 + Math.sin(Math.toRadians(teta)) * Math.sin(Math.toRadians(teta));
        return new Point((float)(this.getCenter().getX() + this.getSize() * (Math.cos(Math.toRadians(teta))/v)),(float)(this.getCenter().getY() + this.getSize() * (Math.sin(Math.toRadians(teta))* Math.cos(Math.toRadians(teta)))/v));
    }
}
