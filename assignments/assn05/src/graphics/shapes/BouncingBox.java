package graphics.shapes;

import graphics.draw.SimpleDraw;

import java.awt.*;

/**
 * This class stores and draws the box.
 *
 * @author SingularWind
 */
public class BouncingBox extends Shape {
    // Fixed size of the box.
    public static final int BOX_SIZE = 20;

    /**
     * Initializes a new box with default settings.
     */
    public BouncingBox() {
        super();
    }

    /**
     * Initializes a new box with its center located at (startX, startY),
     * filled with startColor.
     *
     * @param startX The init x position of the box center.
     * @param startY The init y position of the box center.
     * @param startColor The init color of the box.
     */
    public BouncingBox(int startX, int startY, Color startColor) {
        super(startX, startY, startColor);
        setVelocity(0, 0);
    }

    /**
     * Draws the box as its current position on to surface.
     *
     * @param surface The surface where the box will be drawn.
     */
    @Override
    public void draw(Graphics surface) {
        // Fills the rectangle in color
        surface.setColor(color);
        surface.fillRect(pos.x - BOX_SIZE / 2, pos.y - BOX_SIZE / 2, BOX_SIZE, BOX_SIZE);

        // Draws the black border
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawRect(pos.x - BOX_SIZE / 2, pos.y - BOX_SIZE / 2, BOX_SIZE, BOX_SIZE);

        // Move the center of the object each time we draw it
        pos.x += vel.x;
        pos.y += vel.y;

        // when the box hit the bound, reverse the direction
        if (xHitBound()) {
            vel.x *= -1;
        }
        if (yHitBound()) {
            vel.y *= -1;
        }
    }

    /**
     * Judges if the box hit the x direction bounder.
     *
     * @return true if hit the x direction bounder of the surface, false otherwise.
     */
    private boolean xHitBound() {
        return (pos.x - BOX_SIZE / 2 <= 0 && vel.x < 0)
                || (pos.x + BOX_SIZE / 2 >= SimpleDraw.DRAW_SIZE.width && vel.x > 0);
    }

    /**
     * Judge if the box hit the y direction bounder.
     *
     * @return true if hit the y direction bounder of the surface, false otherwise.
     */
    private boolean yHitBound() {
        return (pos.y - BOX_SIZE / 2 <= 0 && vel.y < 0)
                || (pos.y + BOX_SIZE / 2 >= SimpleDraw.DRAW_SIZE.height && vel.y > 0);
    }

    /**
     * Sets the velocity of the box.
     *
     * @param startXVel The init x velocity.
     * @param startYVel The init y velocity.
     */
    @Override
    public void setVelocity(int startXVel, int startYVel) {
        vel.x = startXVel;
        vel.y = startYVel;
    }
}
