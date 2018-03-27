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


    private final int width;
    private final int height;

    public BoundingBox(double x, double y, double vx, double vy, int width, int height) {
        super(x, y, vx, vy);
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics2D g2d) {
        Color c = g2d.getColor();
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(new Rectangle2D.Double(x, y, width, height));
        g2d.setColor(c);
    }

    public double getLeftX() {
        return x;
    }

    public double getRightX() {
        return x + width;
    }

    public double getTopY() {
        return y;
    }

    public double getBottomY() {
        return y + height;
    }
}