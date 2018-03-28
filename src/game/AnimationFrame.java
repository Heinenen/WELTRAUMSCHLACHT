package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
     * @param frameWidth
     * @param frameHeight
     */
    public AnimationFrame(int frameWidth, int frameHeight) {
        super("WELTRAUMSCHLACHT");
        
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        initComponents();
    }
    /*
    private ImageIcon windowIcon(){
        ImageIcon tempImg = new ImageIcon("img/spaceshipa.png");
        super.setIconImage(tempImg);
        return tempImg;
    }
*/
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
