package game;

import java.awt.Graphics2D;

/**
 * Diese Klasse ist ein Modell eines 2D-Balls, der auf einer Animationsleinwand
 * bewegt und gezeichnet wird.
 * Objekte der Klasse Ball besitzen die (x/y)-Koordinaten des Mittelpunkts,
 * einen Radius und "Geschwindigkeiten" in x- bzw. y-Richtung.
 * 
 * @author mars
 */
public class Ball extends Shape {


    /**
     * Radius des Balles
     */
    protected int radius;



    /**
     * Konstruktor der Klasse Ball.
     *
     * @param aX x-Koordinate zu Beginn der Animation
     * @param aY y-Koordinate zu Beginn der Animation
     * @param aVx Verschiebung in x-Richtung pro Frame
     * @param aVy Verschiebung in y-Richtung pro Frame     
     * @param aRadius Radius des Balles
     */
    public Ball(int aX, int aY, int aVx, int aVy, int aRadius) {
        super(aX, aY, aVx, aVy);
        radius = aRadius;        
    }
    


    /**
     * Der Ball zeichnet sich selbst auf der Leinwand.
     *
     * @param g2d aktueller Grafikkontext
     */
    @Override
    public void paint(Graphics2D g2d) {
        int diameter = 2 * radius;
        g2d.fillOval(x - radius, y - radius, diameter, diameter);
    }
}
