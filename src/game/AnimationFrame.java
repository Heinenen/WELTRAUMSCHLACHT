package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Fenster zur Darstellung der Animation.
 * 
 * @author Thomas
 */

public class AnimationFrame extends JFrame {
    
    public static int frameWidth;
    public static int frameHeight;
    /**
     * Leinwand, auf der die Animationsobjekte gezeichnet werden.
     */
    private AnimationPanel animationPanel;

    /**
     * Konstruktor zur Erzeugung des Fensters.
     * @param frameWidth
     * @param frameHeight
     */
    public AnimationFrame(int frameWidth, int frameHeight) {
        super("WELTRAUMSCHLACHT");
        AnimationFrame.frameWidth = frameWidth;
        AnimationFrame.frameHeight = frameHeight;
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        initComponents();
    }
    
    /**
     * Initialisiert die Bausteine des Fensters.
     */
    private void initComponents() {
        animationPanel = new AnimationPanel();
        getContentPane().add(animationPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    


    /**
     * Gibt die Animationsleinwand zurück.
     * @return Animationsleinwand
     */
    public AnimationPanel getAnimationPanel() {
        return animationPanel;
    }

    /**
     * Start der Animation.
     */
    public void startAnimation() {
        animationPanel.start();
    }    
}
