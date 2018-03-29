package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Leinwand zur Darstellung der Animationsobjekte und zur Steuerung der
 * Animation.
 *
 * @author Thomas
 */
public class AnimationPanel extends JPanel {

    /**
     * Bälle, die animiert werden
     */
    private final Shape[] shapes;
    private int nShapes;
    private final int MAX_N_SHAPES = 1000000;   
    
    boolean mousePressed = false;

    private Ship player;
    
    private int mx, my;
   
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
        this.addMouseMotionListener(new MyMouseMotionListener());
        this.addMouseListener(new MyMouseListener());
    }

    /**
     * Anmelden eines Shapes zur Animation.
     * @param shape
     */
    public void register(Shape shape) {
        shapes[findEmptyCell()] = shape;
        nShapes++;
        // uncomment to see usage of array memory
         System.out.println(findEmptyCell()); 
    }
    
    public void registerPlayer(Ship player) {
        this.player = player;
        register(player);
    }

    public int findEmptyCell(){
        int finder = 0;
        for(int i = 0; i < shapes.length; i++){
            if(shapes[i] == null){
                finder = i;
                break;
            }
        }
        return finder;
    }
    /**
     * Alle registierten Bälle werden bewegt.
     */
    private void moveAll() {
        for (int i = 0; i < nShapes; i++) {
            if (shapes[i] != null){
                if(shapes[i].getOutOfPosition()){
                    shapes[i] = null;
                } else {
                    shapes[i].move();
                }
            }
        }
    }

    /**
     * Zeichnet alle registrierten Bälle
     * @param g2d aktueller Grafikkontext
     */
    private void paintAll(Graphics2D g2d) {
        for (int i = 0; i < nShapes; i++) {
            if (shapes[i] == null){
                continue;
            }
            shapes[i].paint(g2d);
        }
                            
    }

    /**
     *
     * @param g2d
     */
    private void fillPanelBackground(Graphics2D g2d) {
        Color c = g2d.getColor();
        g2d.setColor(Color.BLACK);
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
            if(player.shoot()){
                register(player.getShotA());
            }
            
            // bewege die Bälle
            moveAll();
            // aktualisiere die Leinwand
            repaint();
        }
    }
    
    
    class MyKeyAdapter extends KeyAdapter {
                
        private boolean pressedW;
        private boolean pressedA;
        private boolean pressedS;
        private boolean pressedD;
        
        @Override
        public void keyPressed(KeyEvent e) {
            
            if (e.getKeyCode() == 87) {
//                System.out.println("Key pressed: " + e.getKeyCode() + "(W)");
                player.setPressedW(true);
            } else if (e.getKeyCode() == 65) {
//                System.out.println("Key pressed: " + e.getKeyCode() + "(A)");
                player.setPressedA(true);
            } else if (e.getKeyCode() == 83) {
//                System.out.println("Key pressed: " + e.getKeyCode() + "(S)");
                player.setPressedS(true);
            } else if (e.getKeyCode() == 68) {
//                System.out.println("Key pressed: " + e.getKeyCode() + "(D)");
                player.setPressedD(true);
            }
            
            player.moveShip();
            e.consume();
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            
            if (e.getKeyCode() == 87) {
//                System.out.println("Key released: " + e.getKeyCode() + "(W)");
                player.setPressedW(false);
            } else if (e.getKeyCode() == 65) {
//                System.out.println("Key released: " + e.getKeyCode() + "(A)");
                player.setPressedA(false);
            } else if (e.getKeyCode() == 83) {
//                System.out.println("Key relesaed: " + e.getKeyCode() + "(S)");
                player.setPressedS(false);
            } else if (e.getKeyCode() == 68) {
//                System.out.println("Key released: " + e.getKeyCode() + "(S)");
                player.setPressedD(false);
            }
            
            player.moveShip();
            e.consume();
        }
    }
    
    class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent me) {
            mx = me.getX();
            my = me.getY();
            
            player.setMouseX(mx);
            player.setMouseY(my);
            
            player.shoot();
            
            //System.out.println("MouseLocation (dragged): " + mx + ", " + my);
            
            me.consume();
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            mx = me.getX();
            my = me.getY();
            
            player.setMouseX(mx);
            player.setMouseY(my);
            
            // System.out.println("MouseLocation: " + mx + ", " + my);
            
            me.consume();
        }
    }
    
    class MyMouseListener implements MouseListener{

        @Override
        public void mousePressed(MouseEvent me) {
            player.setMousePressed(true);
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            player.setMousePressed(false);
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            // do nothing
        }

        @Override
        public void mouseExited(MouseEvent me) {
            // do nothing
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            // do nothing
        }
        
    }
}