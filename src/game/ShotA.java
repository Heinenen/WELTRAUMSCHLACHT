package game;

import java.awt.Graphics2D;

/**
 * Diese Klasse ist ein Modell eines 2D-Balls, der auf einer Animationsleinwand
 * bewegt und gezeichnet wird.
 * Objekte der Klasse ShotA besitzen die (x/y)-Koordinaten des Mittelpunkts,
 einen Radius und "Geschwindigkeiten" in x- bzw. y-Richtung.
 * 
 * @author mars
 */

// AKA Ball
public class ShotA extends Shape {


    /**
     * Radius des Balles
     */
    
    protected int radius;



    /**
     * Konstruktor der Klasse Ball.
     * @param x
     * @param y
     */
    public ShotA(int x, int y) {
        super(x, y);
        this.radius = 20;
        
        double v = 20;
        double[] vec = new double[2];
        vec = calcShotV(v);
        this.vx = (int) vec[0];
        this.vy = (int) vec[1];
    }
    


    /**
     * Der ShotA zeichnet sich selbst auf der Leinwand.
     *
     * @param g2d aktueller Grafikkontext
     */
    @Override
    public void paint(Graphics2D g2d) {
        int diameter = 2 * radius;
        g2d.fillOval(x - radius, y - radius, diameter, diameter);
    }
}
