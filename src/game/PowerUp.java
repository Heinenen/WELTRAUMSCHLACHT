/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO; 

/**
 *
 * @author Thomas
 */
public class PowerUp extends Enemy{

    public static boolean poweredUp = false;
    
    public PowerUp(int x, int y, int vx, int vy) {
        super(x, y);
        this.vx = vx;
        this.vy = vy;
        
        try {
            image = (BufferedImage) ImageIO.read(new File("img/PowerUp(Fire).png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
    @Override
    public String getName(){
        return "PowerUp";
    }
    
    @Override
    public void paint(Graphics2D g2d){
        g2d.drawImage(image, null, x - (int)(image.getWidth() / 2), y - (int)(image.getHeight() / 2));
    }
    
}
