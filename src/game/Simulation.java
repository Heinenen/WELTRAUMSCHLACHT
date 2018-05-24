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
    public final int frameWidth = 1200;
    public final int frameHeight = 800;
    
    /**
     * StartPosition des Schiffs
     */
    public static int shipStartX;
    public static int shipStartY;
    
        
    public int rd(int Min, int Max){
        return (int) (Min + (Math.random() * (Max - Min)));
    }
    
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
        // 3. Parameter (mit einer Zahl > 1 ) bestimmt die Geschwindigkeit des Schiffs
        // Standard = 15
        shipStartX = frameWidth / 2;
        shipStartY = frameHeight / 2;
        Ship g = new Ship(shipStartX, shipStartY, 15, "img/SPACESHIPA.png");
        panel.registerPlayer(g);
        Asteroid a = new Asteroid(100, 100, 1);
        panel.register(a);
        // Fenster berechnen und sichtbar setzen
        frame.pack();
        frame.setVisible(true);

        // Animation starten
        frame.startAnimation();
    }
    
}

