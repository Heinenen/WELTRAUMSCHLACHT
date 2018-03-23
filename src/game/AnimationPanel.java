package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Leinwand zur Darstellung der Animationsobjekte und zur Steuerung der
 * Animation.
 *
 * @author mars
 */
public class AnimationPanel extends JPanel {

    /**
     * Bälle, die animiert werden
     */
    private Shape[] shapes;
    private int nShapes;
    private int MAX_N_SHAPES = 100;   
    
    boolean mousePressed = false;

    private Ship robot;
   
    /**
     * Timer-Objekt zum Neuzeichnen des Frames
     */
    private Timer animationTimer;

    /**
     * Kosntruktor
     */
    public AnimationPanel() {
        super();       
        shapes = new Shape[MAX_N_SHAPES];        
        nShapes = 0;
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());                          
        this.addMouseListener(new MyMouseAdapter());
    }

    /**
     * Anmelden eines Shapes zur Animation.
     * @param shape
     */
    public void register(Shape shape) {
        shapes[nShapes] = shape;
        nShapes++;
    }
    
    public void registerPlayer(Ship robot) {
        this.robot = robot;
        register(robot);
    }

    /**
     * Alle registierten Bälle werden bewegt.
     */
    private void moveAll() {
        for (int i = 0; i < nShapes; i++) {
            shapes[i].move();
        }
    }

    /**
     * Zeichnet alle registrierten Bälle
     * @param g2d aktueller Grafikkontext
     */
    private void paintAll(Graphics2D g2d) {
        for (int i = 0; i < nShapes; i++) {        
            shapes[i].paint(g2d);
        }
                            
    }

    /**
     *
     * @param g2d
     */
    private void fillPanelBackground(Graphics2D g2d) {
        Color c = g2d.getColor();
        g2d.setColor(Color.WHITE);
        Dimension d = getSize();
        g2d.fillRect(0, 0, (int) d.getWidth(), (int) d.getHeight());
        g2d.setColor(c);
    }

    /**
     * Zeichnet die Leinwand. 
     * @param g
     */
    @Override   
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
        Graphics2D g2d = (Graphics2D) g;
        fillPanelBackground(g2d);
        
        paintAll(g2d);
    }

    /**
     * Startet den Timer und damit die Animation.
     */
    public void start() {
        if (animationTimer != null) {
            animationTimer.cancel();
        }
        animationTimer = new Timer();
        animationTimer.scheduleAtFixedRate(new AnimationTask(), 0, 25);
    }

    /**
     * Task zur Steuerung der Animation.
     */
    private class AnimationTask extends TimerTask {
        @Override
        public void run() {
            // bewege die Bälle
            moveAll();
            // aktualisiere die Leinwand
            repaint();
        }
    }
    
    
    class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("MyKeyAdapter::keyPressed: " + e.getKeyCode());
            
            if (e.getKeyCode() == 87) {
                System.out.println("press: W");
                robot.moveUp();
            } else if (e.getKeyCode() == 65) {
                System.out.println("press: A");
                robot.moveLeft();
            } else if (e.getKeyCode() == 83) {
                System.out.println("press: S");
                robot.moveDown();
            } else if (e.getKeyCode() == 68) {
                System.out.println("press: D");
                robot.moveRight();
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("MyKeyAdapter::keyReleaed: " + e.getKeyCode());
            
            if (e.getKeyCode() == 87) {
                System.out.println("release: W");
                robot.stopUp();
            } else if (e.getKeyCode() == 65) {
                System.out.println("release: A");
                robot.stopLeft();
            } else if (e.getKeyCode() == 83) {
                System.out.println("relesae: S");
                robot.stopDown();
            } else if (e.getKeyCode() == 68) {
                System.out.println("release: D");
                robot.stopRight();
            }
        }
    }
    
    class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("mousePressed: [x = " + e.getX() + ", y = " + e.getY() + "]");
            mousePressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("mouseReleased: [x = " + e.getX() + ", y = " + e.getY() + "]");
            mousePressed = false;
        }
        
        public int mouseGetX(MouseEvent e){
            return e.getX();
        }
        
        public int mouseGetY(MouseEvent e){
            return e.getY();
        }
    }
}
