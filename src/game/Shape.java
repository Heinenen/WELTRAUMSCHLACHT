package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
    
    
    protected BufferedImage image;
    protected BufferedImage rotatedImage;
    
    /**
     * x-Koordinate der Maus
     */
    protected int mouseX;
    
    /**
     * y-Koordinate der Maus
     */
    protected int mouseY;
    
    /**
     * Constructor for objects of class Shape
     * @param x
     * @param y
     * @param vx
     * @param vy
     */
    public Shape(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
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

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
    
    public Image rotateImage(Image src, double rad){
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        BufferedImage temp = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = temp.createGraphics();
        
        g2d.rotate(rad, height / 2, height / 2);
        g2d.drawImage(src, 0, 0, null , null);
        g2d.dispose();
        return temp;
    }
}
