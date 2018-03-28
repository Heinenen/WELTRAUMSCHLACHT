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
    /**
     * Leinwand, auf der die Animationsobjekte gezeichnet werden.
     */
    private AnimationPanel animationPanel;

    /**
     * Konstruktor zur Erzeugung des Fensters.
     */
    public AnimationFrame() {
        super("AnimationDemo");

        setPreferredSize(new Dimension(1280, 720));
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
