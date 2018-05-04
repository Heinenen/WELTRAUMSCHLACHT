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
    public final int frameWidth = 800;
    public final int frameHeight = 500;
    
    /**
     * StartPosition des Schiffs
     */
    public static int shipStartX;
    public static int shipStartY;
    
    /**
     * Erzeugt die Animationsobjekte und startet die Animation.
     */
    public void startAnimation() {
        // Fenster erzeugen
        AnimationFrame frame = new AnimationFrame(frameWidth, frameHeight);
        frame.setResizable(false);
        ImageIcon img = new ImageIcon("img/spaceshipa.png");
        frame.setIconImage(img.getImage());

        // Animations-Leinwand
        AnimationPanel panel = frame.getAnimationPanel();
        
        // Schiff erzeugen und anmelden
        // change 3rd parameter (with a number > 1 ) to change the speed of the ship
        // standard = 6
        shipStartX = frameWidth / 2;
        shipStartY = frameHeight / 2;
        Ship g = new Ship(shipStartX, shipStartY, 15, "img/SPACESHIPA.png");
        panel.registerPlayer(g);
        
        // Fenster berechnen und sichtbar setzen
        frame.pack();
        frame.setVisible(true);

        // Animation starten
        frame.startAnimation();
    }
    
}

