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
     * @param x
     * @param y
     * @param vx
     * @param vy
     * @param fileName
     */
    public Ship(int x, int y, int vx, int vy, String fileName) {
        super(x, y, vx, vy);

        try {
            image = (BufferedImage) ImageIO.read(new File(fileName));
        } catch (Exception ex) {
            System.out.println(ex);
}

    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.drawImage(image, x, y, null);
    }
    
    // Fuer korrekte Diagonal-Bewegung mit Vorraussetzung vx = vy
    // vx_neu = sqr[(vx_alt^2) / 2] 
    
    public void moveUp() {
        vy = -5;
    }
    
    public void moveLeft() {
        vx = -5;  
    }
    
    public void moveDown(){
        vy = 5;
    }
    
    public void moveRight(){
        vx = 5;
    }
    
    public void stopUp(){
        if(vy != 5){
            vy = 0;
        }
    }
    
    public void stopLeft(){
        if(vx != 5){
            vx = 0;
        }
    }
    
    public void stopDown(){
        if(vy != -5){
            vy = 0;
        }
    }
    
    public void stopRight(){
        if(vx != -5){
            vx = 0;
        }
    }
}
