package game;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// AKA Graphic
public class Ship extends Shape {
    
    private boolean pressedW;
    private boolean pressedA;
    private boolean pressedS;
    private boolean pressedD;
    private double alpha;

    /**
     * Constructor for objects of class Graphic
     * @param x
     * @param y
     * @param vx
     * @param vy
     * @param fileName
     */
    public Ship(int x, int y, int vx, int vy, String fileName) {
        super(x, y, vx, vy, fileName);
        
        try {
            image = (BufferedImage) ImageIO.read(new File(fileName));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        rotatedImage = image;
    }
    
    AffineTransform at = new AffineTransform();
    
    public void rotate(double alpha, BufferedImage src){
        AffineTransform aT = AffineTransform.getRotateInstance(Math.toRadians(alpha), src.getWidth() / 2, src.getHeight() / 2);
        rotatedImage = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
    }
    
    
    // TODO finish method
    public void calcAlpha(int objX, int objY, int mouseX, int mouseY){
        
    }

    @Override
    public void paint(Graphics2D g2d) {
        rotate(alpha, image);
        g2d.drawImage(rotatedImage, x, y, null);
    }

    public void setPressedW(boolean pressedW) {
        this.pressedW = pressedW;
    }

    public void setPressedA(boolean pressedA) {
        this.pressedA = pressedA;
    }

    public void setPressedS(boolean pressedS) {
        this.pressedS = pressedS;
    }

    public void setPressedD(boolean pressedD) {
        this.pressedD = pressedD;
    }
    
    
    /** 
     * Fuer korrekte Diagonal-Bewegung mit Vorraussetzung vx = vy
     * vx_neu = sqr[(vx_alt^2) / 2] 
     * Diese Art der Steuerung hat den "Nachteil", dass eine Richtung pro Achse die andere dominiert.
     * D.h. wenn z.B. moveUp und moveDown angesprochen werden, bewegt das Schiff sich immer nach oben,
     * unabhaengig von der Reihenfolge in der die entsprechenden Tasten gedrueckt wurden
     */
    
    public void moveShip(){
        if(pressedW){
            if(pressedA){
                vx = -4;
                vy = -4;
            } else if(pressedD){
                vx = 4;
                vy = -4;
            } else {
                vx = 0;
                vy = -6;
            }
        } else if(pressedS){
            if(pressedA){
                vx = -4;
                vy = 4;
            } else if(pressedD){
                vx = 4;
                vy = 4;
            } else {
                vx = 0;
                vy = 6;
            } 
        } else if(pressedA){
            vx = -6;
            vy = 0;
        } else if(pressedD){
            vx = 6;
            vy = 0;
        } else {
            vx = 0;
            vy = 0;
        }
    }
}
