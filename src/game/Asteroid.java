package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author schueler
 */
public class Asteroid extends Enemy {
    
    private int shipX, shipY;
    
    public static boolean gameOver = false;
    
    public Asteroid(int x, int y, int vx, int vy){
        super(x, y);
        this.vx = vx;
        this.vy = vy;
        
        try {
            image = (BufferedImage) ImageIO.read(new File("img/Asteroid.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void move(){
        super.move();
        // hit-check asteroid-ship
        if((x < Ship.shipX + 45 && x > Ship.shipX - 45) && (y < Ship.shipY + 45 && y > Ship.shipY - 45)){
            gameOver = true;
        }
    }
    
    
    @Override
    public String getName(){
        return "Asteroid";
    }
    
    

    @Override
    public void paint(Graphics2D g2d){
        g2d.drawImage(image, null, x - (int)(image.getWidth() / 2), y - (int)(image.getHeight() / 2));
    }
}
