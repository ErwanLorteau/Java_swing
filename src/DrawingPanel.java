import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawingPanel extends JPanel implements ActionListener {

    private Model model;
    private Timer chrono = new Timer(16, this);

    public DrawingPanel(){
        super();
        this.model = new Model();
        model.setPts(new Point((int)(getHeight()/2), (int)(getWidth()/2)));
        model.setShapes(new ArrayList<DrawableShape>());
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(model.getPath() instanceof Archimede){
            model.setPts(model.getPath().getNextPoint(model.getTeta()));
            if(model.getPts().getX()> getWidth()|| model.getPts().getY() > getHeight()){
                model.setTeta(0);
            }
        }else if(model.getPath() instanceof Lemniscape){
            model.setPts(model.getPath().getNextPoint(model.getTeta()));
        }

        if(model.getShape() instanceof Circle){
            model.addShape(new Circle(model.getPts(),0, model.getSize(), model.getColor()));
        }
        if(model.getShape() instanceof Square){
            model.addShape(new Square(model.getPts(), model.getAngle(),model.getSize(), model.getColor()));
        }
        if(model.getPath() != null){ // si le path a été choisi
            for (DrawableShape s: model.getShapes()) { // pour chaque shape dans shapes
                if(s instanceof Circle){
                    s.draw(g);
                }
                if (s instanceof Square){
                    s.draw(g);
                    model.setAngle(model.getAngle()+model.getAddAngle());
                }
            }
        }
        if(model.getShapes().size()>= model.getTailleTrace()){ // si le nombre de shape dépasse le nombre maximum on les supprimes
            model.suppLastShape();//on supprime la première qui a été crée
        }
    }




    public void startChrono(){
        this.chrono.start();
    }
    public void stopChrono(){
        this.chrono.stop();
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public Timer getChrono() {
        return chrono;
    }
    public void setChrono(Timer chrono) {
        this.chrono = chrono;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.model.setTeta(this.model.getTeta()+ this.model.getInterval());
        repaint();
    }
}
