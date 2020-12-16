import java.awt.*;

public class Square extends Shape implements DrawableShape{

    public Square(Point p, double angle, float size, Color c) {
        super(p, angle, size, c);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        Point pul = new Point((int)(this.getCenter().getX() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.cos(Math.toRadians(this.getAngle() + 45 ))), (int)(this.getCenter().getY() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.sin(Math.toRadians(this.getAngle() + 45 ))));
        Point pur = new Point((int)(this.getCenter().getX() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.cos(Math.toRadians(this.getAngle() + 135))), (int)(this.getCenter().getY() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.sin(Math.toRadians(this.getAngle() + 135))));
        Point plr = new Point((int)(this.getCenter().getX() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.cos(Math.toRadians(this.getAngle() + 225))), (int)(this.getCenter().getY() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.sin(Math.toRadians(this.getAngle() + 225))));
        Point pll = new Point((int)(this.getCenter().getX() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.cos(Math.toRadians(this.getAngle() + 315))), (int)(this.getCenter().getY() + Math.sqrt(this.getSize()*this.getSize()*2)/2 * Math.sin(Math.toRadians(this.getAngle() + 315))));
        g.drawLine((int)pul.getX(), (int)pul.getY(), (int)pur.getX(), (int)pur.getY());
        g.drawLine((int)pur.getX(), (int)pur.getY(), (int)plr.getX(), (int)plr.getY());
        g.drawLine((int)plr.getX(), (int)plr.getY(), (int)pll.getX(), (int)pll.getY());
        g.drawLine((int)pll.getX(), (int)pll.getY(), (int)pul.getX(), (int)pul.getY());

    }
}
