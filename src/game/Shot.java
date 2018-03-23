package game;

import java.awt.Graphics2D;

/**
 * Diese Klasse ist ein Modell eines 2D-Balls, der auf einer Animationsleinwand
 * bewegt und gezeichnet wird.
 * Objekte der Klasse Shot besitzen die (x/y)-Koordinaten des Mittelpunkts,
 einen Radius und "Geschwindigkeiten" in x- bzw. y-Richtung.
 * 
 * @author mars
 */

// AKA Ball
public class Shot extends Shape {


    /**
     * Radius des Balles
     */
    
    protected int radius;



    /**
     * Konstruktor der Klasse Ball.
     * @param x
     * @param y
     * @param vx
     * @param vy
     * @param radius
     */
    public Shot(int x, int y, int vx, int vy, int radius, String fileName) {
        super(x, y, vx, vy, fileName);
        this.radius = radius;        
    }
    


    /**
     * Der Shot zeichnet sich selbst auf der Leinwand.
     *
     * @param g2d aktueller Grafikkontext
     */
    @Override
    public void paint(Graphics2D g2d) {
        int diameter = 2 * radius;
        g2d.fillOval(x - radius, y - radius, diameter, diameter);
    }
}
