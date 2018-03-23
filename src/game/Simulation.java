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
        
        Ship g = new Ship(100, 30, 0, 0, "img/magician.jpeg");
        panel.registerPlayer(g);       
        
        // Fenster berechnen und sichtbar setzen
        frame.pack();
        frame.setVisible(true);

        // Animation starten
        frame.startAnimation();
    }
}

