package sprites;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Circle is a class that represents a circle shape.
 *
 * @author SingularWind
 */
public class Circle extends Sprite {
    private int radius;  // The radius of the circle.

    /**
     * Constructs a new Circle object with the specified position, velocity, size, and color.
     *
     * @param x The x-coordinate of the circle's center.
     * @param y The y-coordinate of the circle's center.
     * @param r The radius of the circle.
     * @param clr The color of the circle.
     */
    public Circle(int x, int y, int r, Color clr) {
        super(x, y, 2 * r, 2 * r, clr);
        radius = r;
    }

    /**
     * Fills the sprite with the specified color.
     *
     * @param surface The graphics surface to draw on.
     */
    @Override
    protected void fillSprite(Graphics surface) {
        surface.fillOval(pos.x - radius, pos.y - radius, 2 * radius, 2 * radius);
    }

    /**
     * Draws the outline of the sprite with a black border.
     *
     * @param surface The graphics surface to draw on.
     */
    @Override
    protected void drawSprite(Graphics surface) {
        surface.drawOval(pos.x - radius, pos.y - radius, 2 * radius, 2 * radius);
    }
}
