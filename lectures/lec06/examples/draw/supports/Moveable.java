package draw.supports;

import java.awt.*;

/**
 * Interface that defines the contract for movable shapes.
 *
 * @author SingularWind
 */
public interface Moveable {
    /**
     * Moves the shape on the given {@code surface}.
     *
     * @param surface the {@link Graphics} object representing the surface where the shape moves on
     */
    void move(Graphics surface);

    /**
     * Sets the position of the shape.
     *
     * @param x the x-coordinate of the new position
     * @param y the y-coordinate of the new position
     */
    void setPosition(int x, int y);

    /**
     * Sets the velocity of the shape.
     *
     * @param velX the x-coordinate of the new velocity
     * @param velY the y-coordinate of the new velocity
     */
    void setVelocity(int velX, int velY);
}
