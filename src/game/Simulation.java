package game;

import java.util.ArrayList;
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
        
        // Schiff erzeugen und anmelden
        // change 5th parameter ( >1 ) to change the speed of the ship
        // standard = 6
        Ship g = new Ship(100, 30, 0, 0, 6, "img/magician2.png");
        panel.registerPlayer(g);
        
        // Fenster berechnen und sichtbar setzen
        frame.pack();
        frame.setVisible(true);

        // Animation starten
        frame.startAnimation();
        
        g.shoot();
        registerShots(panel, g);
    }
    
    public static void registerShots(AnimationPanel p, Ship g){
        ArrayList<ShotA> al = new ArrayList<>();
        al = g.getArrayList();
        for(int i = 0; i < al.size(); i++){
            p.register(al.get(i));
        }
    }
}

