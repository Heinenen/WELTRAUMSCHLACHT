package game;

/**
 * Klasse zur Initialisierung und Steuerung der Simulation.
 *
 * @author Thomas
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
        
        // Schiff erzeugen und anmelden
        // change 3rd parameter ( >1 ) to change the speed of the ship
        // standard = 6
        Ship g = new Ship(100, 30, 6, "img/SPACESHIPA.png");
        panel.registerPlayer(g);
        
        // Fenster berechnen und sichtbar setzen
        frame.pack();
        frame.setVisible(true);

        // Animation starten
        frame.startAnimation();
    }
    
}

