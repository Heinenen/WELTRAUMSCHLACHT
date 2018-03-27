package game;

import java.awt.Graphics2D;

/**
 *
 * @author Thomas
 */
public class ShotA extends Shot {
    
    public ShotA(double x, double y, double vx, double vy, int radius) {
        super(x, y, vx, vy, radius);
    }
    
    
    
    
    @Override
    public void paint(Graphics2D g2d) {
        int diameter = 2 * radius;
        g2d.fillOval((int)x - radius, (int)y - radius, diameter, diameter);
    }
    
}
