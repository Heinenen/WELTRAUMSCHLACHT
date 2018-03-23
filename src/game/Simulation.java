package game;

/**
 * Klasse zur Initialisierung und Steuerung der Simulation.
 *
 * @author mars
 */
public class Simulation {

    /**
     * Erzeugt die Animationsobjekte und startet die Animation.
     */
    public static void startAnimation() {
        // Fenster erzeugen
        AnimationFrame frame = new AnimationFrame();

        // Animations-Leinwand
        AnimationPanel panel = frame.getAnimationPanel();
        
        // B�lle erzeugen 
        Ball b1 = new Ball(200, 30, 3, 1, 5);
        Ball b2 = new Ball(100, 30, 3, 2, 10);        

        // B�lle an der Leinwand anmelden
        panel.register(b1);
        panel.register(b2);

        // B�lle erzeugen
        BoundingBox box = new BoundingBox(40, 60, 1, 1, 100, 200);
        BoundedBall bb1 = new BoundedBall(200, 30, 3, 2, 5, box);
        BoundedBall bb2 = new BoundedBall(200, 30, 0, 0, 8, box);

        // B�lle und BoundingBox an der Leinwand anmelden
        panel.register(box);
        panel.register(bb1);
        panel.register(bb2);
        
        Ship g = new Ship(100, 30, 0, 0, "img/magician.jpeg");
        panel.registerPlayer(g);       
        
        // Fenster berechnen und sichtbar setzen
        frame.pack();
        frame.setVisible(true);

        // Animation starten
        frame.startAnimation();
    }
}

