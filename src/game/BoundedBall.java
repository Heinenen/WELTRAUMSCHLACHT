package game;

/**
 * Diese Klasse ist ein Modell eines 2D-Balls, der auf einer Animationsleinwand
 * bewegt und gezeichnet wird.
 * Objekte der Klasse Shot besitzen die (x/y)-Koordinaten des Mittelpunkts,
 einen Radius und "Geschwindigkeiten" in x- bzw. y-Richtung.
 * 
 * @author mars
 */
public class BoundedBall extends Shot {
    /**
     * BoundingBox
     */
    private final BoundingBox box;
    
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
     * @param x
     * @param y
     * @param vx
     * @param vy
     * @param radius
     * @param box
     */
    public BoundedBall(int x, int y, int vx, int vy, int radius, BoundingBox box) {
        super(x, y, vx, vy, radius );
        this.box = box;       
    }   

    /**
     * Diese Methode bewirkt das Verschieben des Balles in x- und y-Richtung.
     *
     */
    @Override
    public void move() {
        super.move();

        // Pruefen, ob der untere Rand erreicht ist.
        if (y + radius >= box.getBottomY()) {
            y = box.getBottomY() - radius;
            vy = -vy;
        }

        // Pruefen, ob der rechte Rand erreicht ist.
        if (x + radius >= box.getRightX()) {
            x = box.getRightX() - radius;
            vx = -vx;
        }

        // Pruefen, ob der linke Rand erreicht ist.
        if (x - radius <= box.getLeftX()) {
            x = box.getLeftX() + radius;
            vx = -vx;
        }

        // Pruefen, ob der obere Rand erreicht ist.
        if (y - radius <= box.getTopY()) {
            y = box.getTopY() + radius;
            vy = -vy;
        }        
    }
}
