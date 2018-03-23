package game;

import java.awt.Graphics2D;

/**
 * Write a description of class Shape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Shape
{
     /**
     * x-Koordinate des Mittelpunkts
     */
    protected int x;

    /**
     * y-Koordinate des Mittelpunkts
     */
    protected int y;

    /**
     * "Geschwindigkeit" in x-Richtung
     */    
    protected int vx;

    /**
     * "Geschwindigkeit in y-Richtung
     */
    protected int vy;
    
    /**
     * Constructor for objects of class Shape
     */
    public Shape(int aX, int aY, int aVx, int aVy) {
        x = aX;
        y = aY;
        vx = aVx;
        vy = aVy; 
    }
    
        /**
     * Diese Methode bewirkt das Verschieben des Balles in x- und y-Richtung.
     *
     */
    public void move() {
        x = x + vx;
        y = y + vy;
    }

    public abstract void paint(Graphics2D g2d);
}
