package game;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Diese Klasse ist ein Modell eines 2D-Balls, der auf einer Animationsleinwand
 * bewegt und gezeichnet wird.
 * Objekte der Klasse Ball besitzen die (x/y)-Koordinaten des Mittelpunkts,
 * einen Radius und "Geschwindigkeiten" in x- bzw. y-Richtung.
 * 
 * @author mars
 */
public class BoundedBall extends Ball {
    /**
     * BoundingBox
     */
    private BoundingBox box;
    
    /**
     * Konstruktor der Klasse BoundedBall.
     *
     * @param aX x-Koordinate zu Beginn der Animation
     * @param aY y-Koordinate zu Beginn der Animation
     * @param aRadius Radius des Balles
     * @param aVx Verschiebung in x-Richtung pro Frame
     * @param aVy Verschiebung in y-Richtung pro Frame     
     */

    /**
     * Konstruktor der Klasse BoundedBall.
     *
     * @param aX x-Koordinate zu Beginn der Animation
     * @param aY y-Koordinate zu Beginn der Animation
     * @param aVx Verschiebung in x-Richtung pro Frame
     * @param aVy Verschiebung in y-Richtung pro Frame     
     * @param aRadius Radius des Balles
     * @param aBox BoundingBox
     */
    public BoundedBall(int aX, int aY, int aVx, int aVy, int aRadius, BoundingBox aBox) {
        super(aX, aY, aVx, aVy, aRadius);
        box = aBox;        
    }   

    /**
     * Diese Methode bewirkt das Verschieben des Balles in x- und y-Richtung.
     *
     */
    public void move() {
        super.move();

        // Prüfen, ob der untere Rand erreicht ist.
        if (y + radius >= box.getBottomY()) {
            y = box.getBottomY() - radius;
            vy = -vy;
        }

        // Pr�fen, ob der rechte Rand erreicht ist.
        if (x + radius >= box.getRightX()) {
            x = box.getRightX() - radius;
            vx = -vx;
        }

        // Pr�fen, ob der linke Rand erreicht ist.
        if (x - radius <= box.getLeftX()) {
            x = box.getLeftX() + radius;
            vx = -vx;
        }

        // Pr�fen, ob der obere Rand erreicht ist.
        if (y - radius <= box.getTopY()) {
            y = box.getTopY() + radius;
            vy = -vy;
        }        
    }
}
