import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ChangeListener {
    private DrawingPanel shapePanel;
    private Controller controller;
    private JPanel mainPanel, parametres;

    //attribut du JPanel parametres :
    private JSlider vitesse, taille,couleurR, couleurG, couleurB, rotation;
    private JButton onOff;
    private boolean on = false;


    public View(String title, int width, int height){
        super(title);
        this.build(width, height);
    }
    private void build(int w, int h){
        this.setSize(w, h);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(false);
        this.setLayout(new BorderLayout());
        this.buildContentPanel();
    }
    private void buildContentPanel(){
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);
        buildShapePanel();
        buildParametrePanel();

    }
    private void buildShapePanel(){
        shapePanel = new DrawingPanel();
        shapePanel.setLayout(new BorderLayout());
        controller = new Controller(shapePanel.getModel(), shapePanel);
        mainPanel.add(shapePanel, BorderLayout.CENTER);
    }

    private void buildParametrePanel(){ //Fonction qui permet de créer le JPanel contenant tout les boutons et JSlider
        parametres = new JPanel(new GridLayout(0,1));
        mainPanel.add(parametres, BorderLayout.WEST);
        /*******FONT******/
        Font font = new Font("Courier", Font.BOLD, 25);

        /*******BOUTON******/
        JRadioButton circle = new JRadioButton("Circle");
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setShape(new Circle(new Point((float)getWidth()/2, (float)getHeight()/2),0,50, Color.BLACK));
            }
        });

        JRadioButton square = new JRadioButton("Square");
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setShape(new Square(new Point((float)getHeight()/2, (float)getWidth()/2), 50, 50, Color.BLACK));
            }
        });

        JRadioButton archimede = new JRadioButton("Archimede");
        archimede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = new Point((float)getWidth()/3, (float)getHeight()/2);
                controller.setPath(new Archimede(p, (double)getWidth()/4));
            }
        });

        JRadioButton lemniscape = new JRadioButton("Lemniscape");
        lemniscape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = new Point((float)getWidth()/3, (float)getHeight()/2);
                controller.setPath(new Lemniscape(p, (double)getWidth()/4));
            }
        });
        onOff = new JButton("start");
        onOff.setBackground(Color.GREEN);
        onOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!on){
                    on = true;
                    onOff.setText("stop");
                    onOff.setBackground(Color.RED);
                    controller.startChrono();
                } else {
                    on = false;
                    onOff.setText("start");
                    onOff.setBackground(Color.GREEN);
                    controller.stopChrono();
                }
            }
        });



        /****** Arangement des fields******/
        /*****main.Shape*****/
        JTextField nameShape = new JTextField("Shape :");
        nameShape.setEditable(false);
        nameShape.setHorizontalAlignment(SwingConstants.CENTER);
        nameShape.setFont(font);
        JPanel shape = new JPanel(new GridLayout(2,1));
        shape.add(circle);
        shape.add(square);
        ButtonGroup btnGroupShape = new ButtonGroup();
        btnGroupShape.add(circle);
        btnGroupShape.add(square);
        JPanel shapes = new JPanel(new GridLayout(1, 2));
        shapes.add(nameShape);
        shapes.add(shape);
        parametres.add(shapes);

        /*****Chemin*****/
        JTextField namePath = new JTextField("Chemin");
        namePath.setEditable(false);
        namePath.setHorizontalAlignment(SwingConstants.CENTER);
        namePath.setFont(font);
        JPanel path = new JPanel(new GridLayout(2, 1));
        path.add(lemniscape);
        path.add(archimede);
        ButtonGroup btnGroupPath = new ButtonGroup();
        btnGroupPath.add(archimede);
        btnGroupPath.add(lemniscape);
        JPanel paths = new JPanel(new GridLayout(1, 2));
        paths.add(namePath);
        paths.add(path);
        parametres.add(paths);

        /*****Vitesse*****/
        vitesse = new JSlider(-10, 10,2);
        JTextField nameVitesse = new JTextField("Vitesse :");
        nameVitesse.setEditable(false);
        nameVitesse.setHorizontalAlignment(SwingConstants.CENTER);
        nameVitesse.setFont(font);

        JPanel Vitesse = new JPanel(new GridLayout(1, 2));
        Vitesse.add(nameVitesse);
        Vitesse.add(vitesse);
        vitesse.addChangeListener(this);
        parametres.add(Vitesse);

        /*****Choix Taille*****/
        taille = new JSlider(20, 200, 50);

        JTextField nameTaille = new JTextField("Taille :");
        nameTaille.setEditable(false);
        nameTaille.setHorizontalAlignment(SwingConstants.CENTER);
        nameTaille.setFont(font);

        JPanel Taille = new JPanel(new GridLayout(1,2));
        Taille.add(nameTaille);
        Taille.add(taille);
        taille.addChangeListener(this);
        parametres.add(Taille);

        /*****Couleur*****/
        couleurR = new JSlider(0,255,0);
        couleurG = new JSlider(0,255,0);
        couleurB = new JSlider(0,255,0);

        JTextField nameCouleur = new JTextField("Couleur :");
        nameCouleur.setEditable(false);
        nameCouleur.setHorizontalAlignment(SwingConstants.CENTER);
        nameCouleur.setFont(font);

        JTextField nameCouleurRouge = new JTextField("Rouge :");
        nameCouleurRouge.setEditable(false);
        nameCouleurRouge.setHorizontalAlignment(SwingConstants.CENTER);

        nameCouleurRouge.setFont(font);

        JTextField nameCouleurVert = new JTextField("Vert :");
        nameCouleurVert.setEditable(false);
        nameCouleurVert.setHorizontalAlignment(SwingConstants.CENTER);
        nameCouleurVert.setFont(font);

        JTextField nameCouleurBleu = new JTextField("Bleu :");
        nameCouleurBleu.setEditable(false);
        nameCouleurBleu.setHorizontalAlignment(SwingConstants.CENTER);
        nameCouleurBleu.setFont(font);

        JPanel couleurs = new JPanel(new GridLayout(3,1));
        couleurs.add(couleurR);
        couleurs.add(couleurG);
        couleurs.add(couleurB);

        couleurR.addChangeListener(this);
        couleurG.addChangeListener(this);
        couleurB.addChangeListener(this);

        JPanel nameCouleurs = new JPanel(new GridLayout(3,1));
        nameCouleurs.add(nameCouleurRouge);
        nameCouleurs.add(nameCouleurVert);
        nameCouleurs.add(nameCouleurBleu);

        JPanel Couleur = new JPanel(new GridLayout(1, 3));
        Couleur.add(nameCouleur);
        Couleur.add(nameCouleurs);
        Couleur.add(couleurs);
        parametres.add(Couleur);

        /*****Rotation****/
        rotation = new JSlider(1, 50, 1);

        JTextField nameRotation = new JTextField("Vitesse de rotation : ");
        nameRotation.setEditable(false);
        nameRotation.setHorizontalAlignment(SwingConstants.CENTER);
        nameRotation.setFont(font);
        rotation.addChangeListener(this);
        JPanel Rotation = new JPanel(new GridLayout(1, 2));
        Rotation.add(nameRotation);
        Rotation.add(rotation);
        parametres.add(Rotation);
        /******Start and Stop ******/
        parametres.add(onOff);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        controller.setIntervalle(vitesse.getValue());
        controller.setSize(taille.getValue());
        controller.setColor(couleurR.getValue(), couleurG.getValue(), couleurB.getValue());
        controller.setAddAngle((double)rotation.getValue()/100);
    }
}
