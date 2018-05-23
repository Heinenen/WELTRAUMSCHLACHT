package game;

/**
 *
 * @author Thomas
 */
public abstract class Enemy extends Shape {
    
    private final int vmax;
    
    public Enemy(int x, int y, int vmax){
        super(x, y);
        this.vmax = vmax;
    }
    
    
}
