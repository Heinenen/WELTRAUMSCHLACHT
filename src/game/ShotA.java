package game;

import java.awt.Graphics2D;

/**
 *
 * @author Thomas
 */
public class ShotA extends Shot {
    
    public ShotA(int x, int y, int vx, int vy, int radius) {
        super(x, y, vx, vy, radius);
    }
    
    
    
    
    @Override
    public void paint(Graphics2D g2d) {
        int diameter = 2 * radius;
        g2d.fillOval(x - radius, y - radius, diameter, diameter);
    }
    
}
