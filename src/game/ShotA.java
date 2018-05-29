package game;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Diese Klasse ist ein Modell eines 2D-Balls, der auf einer Animationsleinwand
 * bewegt und gezeichnet wird.
 * Objekte der Klasse ShotA besitzen die (x/y)-Koordinaten des Mittelpunkts,
 einen Radius und "Geschwindigkeiten" in x- bzw. y-Richtung.
 * 
 * @author Thomas
 */

// AKA Ball
public class ShotA extends Shape {


    /**
     * Radius des Balles
     */
    protected int radius;
    
    private final int v;



    /**
     * Konstruktor der Klasse Ball.
     * @param x
     * @param y
     */
    public ShotA(int x, int y) {
        super(x, y);
        this.radius = 5;
        this.v = 30;
    }
    
    public void velocity(){
        double[] vec;
        vec = calcShotV(v);
        if((int) vec[0] == 0  && (int) vec[1] == 0){
            vx = 0;
            vy = v;
        } else {
            vx = (int) vec[0];
            vy = (int) vec[1];
        }
    }
    
    @Override
    public String getName(){
        return "ShotA";
    }
    
    /**
     * Der ShotA zeichnet sich selbst auf der Leinwand.
     *
     * @param g2d aktueller Grafikkontext
     */
    @Override
    public void paint(Graphics2D g2d) {
        int diameter = 2 * radius;
        g2d.setColor(Color.green);
        g2d.fillOval(x - radius, y - radius, diameter, diameter);
    }
}
