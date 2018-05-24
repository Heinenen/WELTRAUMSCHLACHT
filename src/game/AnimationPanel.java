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
    
    private boolean pause = true;
    private int asteroidPause = 0;
    
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
        player.moveShip();
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
        
        public int rdx(){
            int r = (int) (50 + (Math.random() * (450 - 50)));
            if (r < 250){
                r = AnimationFrame.frameWidth + r;
            } else {
                r = r - 500;
            }
            return r;
        }
    
        public int rdy(){
            int r = (int) (50 + (Math.random() * (450 - 50)));
            if (r < 250){
                r = AnimationFrame.frameHeight + r;
            } else {
                r = r - 500;
            }
            return r;
        }
        
        public int rdPos(int min, int max){
            return (int) (min + (Math.random() * (max - min)));
        }
        
        // asteroid velocity
        public double[] calcAV(double v, int rdx, int rdy){
            double dis;
            double[] vec = new double[2];
            // vector asteroid - pos in field 
            vec[0] = rdPos(0, AnimationFrame.frameWidth)- rdx;
            vec[1] = rdPos(0, AnimationFrame.frameHeight) - rdy;
            
            // distance asteroid - pos in field (Betrag Vektor)
            dis = Math.sqrt(Math.pow(vec[0], 2) + Math.pow(vec[1], 2));
            vec[0] = (vec[0] / dis) * v;
            vec[1] = (vec[1] / dis) * v;
            return vec;
        }
        
        @Override
        public void run() {
            
            // shoot every second tick
            if(pause){
                if(player.shoot()){
                    register(player.getShotA());
                }
                pause = false;
            } else {
                pause = true;
            }
            
            // spawn asteroid
            if(asteroidPause == 10){
                int rdx = rdx();
                int rdy = rdy();
                double[] aV = calcAV(5, rdx, rdy);
                Asteroid a = new Asteroid(rdx, rdy, (int)aV[0], (int)aV[1]);
                register(a);
                asteroidPause = 0;
            } else {
                asteroidPause++;
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
            
//            System.out.println("MouseLocation: " + mx + ", " + my);
            
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