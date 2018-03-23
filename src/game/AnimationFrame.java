package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Fenster zur Darstellung der Animation.
 * 
 * @author mars
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

        setPreferredSize(new Dimension(600, 400));
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
