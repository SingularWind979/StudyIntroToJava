package sprites;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a rectangle sprite.
 *
 * @author SingularWind
 */
public class Rectangle extends Sprite {
    /**
     * Constructs a new Rectangle object with the specified position, velocity, size, and color.
     *
     * @param x       The x-coordinate of the rectangle.
     * @param y       The y-coordinate of the rectangle.
     * @param sizeX   The width of the rectangle.
     * @param sizeY   The height of the rectangle.
     * @param clr     The color of the rectangle.
     */
    public Rectangle(int x, int y, int sizeX, int sizeY, Color clr) {
        super(x, y, sizeX, sizeY, clr);
    }

    /**
     * Fills the rectangle shape with the specified color.
     *
     * @param surface The graphics surface to draw on.
     */
    @Override
    protected void fillSprite(Graphics surface) {
        surface.fillRect(pos.x - siz.x / 2, pos.y - siz.y / 2, siz.x, siz.y);
    }

    /**
     * Draws the outline of the rectangle shape with a black border.
     *
     * @param surface The graphics surface to draw on.
     */
    @Override
    protected void drawSprite(Graphics surface) {
        surface.drawRect(pos.x - siz.x / 2, pos.y - siz.y / 2, siz.x, siz.y);
    }
}
