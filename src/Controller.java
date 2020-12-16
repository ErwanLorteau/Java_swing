import java.awt.*;

public class Controller {
    private Model model;
    private DrawingPanel drawingPanel;

    public Controller(Model model, DrawingPanel drawingPanel){
        super();
        this.model = model;
        this.drawingPanel = drawingPanel;
    }
    public void setIntervalle(double intervalle){
        this.model.setInterval(intervalle);
    }
    public void setSize(float size){
        this.model.setSize(size);
    }
    public void setColor(int r, int g, int b){
        this.model.setColor(new Color(r, g, b));
    }
    public void setAddAngle(double angle){
        model.setAddAngle(angle);
    }
    public void setShape(DrawableShape shape){
        model.setShape(shape);
    }
    public DrawablePath getPath(){
        return this.model.getPath();
    }
    public void setPath(DrawablePath path){
        this.model.setPath(path);
    }
    public void startChrono(){
        this.drawingPanel.startChrono();
    }
    public void stopChrono(){
        this.drawingPanel.stopChrono();
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public DrawingPanel getDrawingPanel() {
        return this.drawingPanel;
    }
    public void setView(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}
