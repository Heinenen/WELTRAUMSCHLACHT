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
        
        // Shot bb = new Shot(500,500,0,0,550,"img/magician1.png");
        // panel.register(bb);
        
        Ship g = new Ship(100, 30, 0, 0, "img/magician2.png");
        panel.registerPlayer(g);    
        
        // Fenster berechnen und sichtbar setzen
        frame.pack();
        frame.setVisible(true);

        // Animation starten
        frame.startAnimation();
    }
}

