package utils;

import sprites.Sprite;
import static utils.Setting.*;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

/**
 * Painter is a JPanel that paints sprites.
 *
 * @author SingularWind
 */
public final class Painter extends JPanel implements Runnable {
    private List<Sprite> sprites;   // The list of sprites to paint.
    private boolean animated;       // Whether the animation is enabled.

    /**
     * Constructor for Painter.
     */
    public Painter() {
        sprites = new ArrayList<>();
        animated = true;
        setBackground(BG_COLOR);
        setPreferredSize(BG_SIZE);
        setVisible(true);
    }

    /**
     * Adds a sprite to the painter.
     *
     * @param sprite The sprite to add.
     */
    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }

    /**
      * Removes a sprite from the painter.
      *
      * @param sprite The sprite to remove.
      */
    public void removeSprite(Sprite sprite) {
        sprites.remove(sprite);
    }

    /**
      * Paints the component.
      *
      * @param g The graphics context.
      */
    @Override
    protected void paintComponent(Graphics g) {
        // Clear the background
        super.paintComponent(g);

        // Enable antialiasing
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw sprites
        for (Sprite sprite : sprites) {
            sprite.draw(g);
            sprite.move();
        }
    }

    /**
     * Enables the animation.
     */
    public synchronized void startAnimation() {
        animated = true;
    }

    /**
     * Disables the animation.
     */
    public synchronized void stopAnimation() {
        animated = false;
    }

    /**
     * Returns whether the animation is enabled.
     *
     * @return Whether the animation is enabled.
     */
    public synchronized boolean animationEnabled() {
        return animated;
    }

    /**
     * Runs The animation loop, use a custom timer to control the animation speed.
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (animationEnabled()) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime >= DELAY) {
                startTime = currentTime;
                repaint();
            }
        }
    }
}
