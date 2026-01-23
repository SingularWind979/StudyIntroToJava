package graphics.shapes;

import java.awt.*;

/**
 * This class stores the shape.
 *
 * @author SingularWind
 */
public abstract class Shape {
    static class Tuple {
        int x;
        int y;
        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    Tuple pos;
    Tuple vel;
    Color color;

    /**
     * Initializes a new shape with default settings.
     */
    public Shape() {
        this(0, 0, Color.WHITE);
    }

    /**
     * Initializes a new shape with its center located at (startX, startY),
     * filled with startColor.
     *
     * @param startX The init x position of the shape.
     * @param startY The init y position of the shape.
     * @param startColor The init color of the shape.
     */
    public Shape(int startX, int startY, Color startColor) {
        pos = new Tuple(startX, startY);
        vel = new Tuple(0, 0);
        color = startColor;
    }

    /**
     * Draws the shape as its current position on to surface.
     *
     * @param surface The surface where the shape will be drawn.
     */
    public abstract void draw(Graphics surface);

    /**
     * Sets the velocity of the shape.
     *
     * @param startXVel The init x velocity.
     * @param startYVel The init y velocity.
     */
    public abstract void setVelocity(int startXVel, int startYVel);
}
