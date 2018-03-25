package game;

import java.awt.Graphics2D;

/**
 *
 * @author Thomas
 */
public class ShotA_minigun extends Shot {
    
    public ShotA_minigun(int x, int y, int vx, int vy, int radius) {
        super(x, y, vx, vy, radius);
    }
    
    
    
    
    @Override
    public void paint(Graphics2D g2d) {
        int diameter = 2 * radius;
        g2d.fillOval(x - radius, y - radius, radius, diameter);
    }
    
}
