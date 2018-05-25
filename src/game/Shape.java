package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/** 
 * @author Thomas
 */
public abstract class Shape {
    
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
    
    /**
     * x-Koordinate der Maus
     */
    protected int mouseX;
    
    /**
     * y-Koordinate der Maus
     */
    protected int mouseY;
    
    /**
     * Winkel vom Schiff zur Maus
     */
    protected double alpha;
    
    /**
     * true if the object is, where it shouldn't be
     */
    protected boolean outOfPosition = false;
    
    /**
     * Constructor for objects of class Shape
     * @param x
     * @param y
     */
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        vx = 0;
        vy = 0;
    }
    
    /**
     * Diese Methode bewirkt das Verschieben des Balles in x- und y-Richtung.
     */
    public void move() {
        if(AnimationFrame.frameWidth * 2 < Math.abs(x) || AnimationFrame.frameHeight * 2 < Math.abs(y)){
            outOfPosition = true;
        }
        x = x + vx;
        y = y + vy;
    }
    
    public boolean isColliding(Shape other) {
        int dis= (int) Math.sqrt((other.getX() - x)*(other.getX() - x) + (other.getY() - y)*(other.getY()- y));
        return dis <= 27;
    }

    public abstract void paint(Graphics2D g2d);

    
    public void calcAlpha(){
        alpha = Math.atan2(-(mouseX - x), mouseY - y) + Math.PI;
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
    
    public abstract String getName();
    
    public double[] calcShotV(double v){
        double disSM;
        double[] vec = new double[2];
        // Vektor SM
        vec[0] = mouseX - x;
        vec[1] = mouseY - y;
        // Entfernung Schiff-Maus (Betrag Vektor)
        disSM = Math.sqrt(Math.pow(vec[0], 2) + Math.pow(vec[1], 2));
        vec[0] = (vec[0] / disSM) * v;
        vec[1] = (vec[1] / disSM) * v;
        
        return vec;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean getOutOfPosition(){
        return outOfPosition;
    }
    
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
}
