package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Shape
{
    private BufferedImage image;

    /**
     * Constructor for objects of class Graphic
     */
    public Ship(int aX, int aY, int aVx, int aVy, String fileName) {
        super(aX, aY, aVx, aVy);

        try {
            image = (BufferedImage) ImageIO.read(new File(fileName));
        } catch (Exception ex) {
            System.out.println(ex);
}

    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(image, x, y, null);
    }
    
    public void left() {
        vx = vx - 1;
    }
    
    public void right() {
        vx = vx + 1;  
    }
}
