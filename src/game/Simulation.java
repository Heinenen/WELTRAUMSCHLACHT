package game;

import javax.swing.ImageIcon;

/**
 * Klasse zur Initialisierung und Steuerung der Simulation.
 *
 * @author Thomas
 */
public class Simulation {

    /**
     * Gewünschte Abmessungen des Fenster (in px)
     */
    public static int frameWidth = 1280;
    public static int frameHeight = 720;
    
    /**
     * Erzeugt die Animationsobjekte und startet die Animation.
     */
    public static void startAnimation() {
        // Fenster erzeugen
        AnimationFrame frame = new AnimationFrame(frameWidth, frameHeight);
        ImageIcon img = new ImageIcon("img/spaceshipa.png");
        frame.setIconImage(img.getImage());

        // Animations-Leinwand
        AnimationPanel panel = frame.getAnimationPanel();
        
        // Schiff erzeugen und anmelden
        // change 3rd parameter (with a number > 1 ) to change the speed of the ship
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

