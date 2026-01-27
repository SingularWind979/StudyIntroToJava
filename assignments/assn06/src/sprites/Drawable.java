package sprites;

import java.awt.Graphics;

/**
 * Represents a drawable sprite.
 *
 * @author SingularWind
 */
public interface Drawable {
    /**
     * Draws the sprite on the specified graphics surface.
     *
     * @param surface The graphics surface to draw on.
     */
    void draw(Graphics surface);
}
