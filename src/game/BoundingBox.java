package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Eine BoundingBox 
 * @author mars
 */
public class BoundingBox extends Shape
{


    private int width;
    private int height;

    public BoundingBox(int aX, int aY, int aVx, int aVy, int aWidth, int aHeight) {
        super(aX, aY, aVx, aVy);
        width = aWidth;
        height = aHeight;
    }

    public void paint(Graphics2D g2d) {
        Color c = g2d.getColor();
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(new Rectangle2D.Double(x, y, width, height));
        g2d.setColor(c);
    }

    public int getLeftX() {
        return x;
    }

    public int getRightX() {
        return x + width;
    }

    public int getTopY() {
        return y;
    }

    public int getBottomY() {
        return y + height;
    }
}