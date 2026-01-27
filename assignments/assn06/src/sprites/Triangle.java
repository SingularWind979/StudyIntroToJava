package sprites;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a triangle sprite.
 *
 * @author SingularWind
 */
public class Triangle extends Sprite {
    private int[] xPoints;  // The x-coordinates of the triangle vertices.
    private int[] yPoints;  // The y-coordinates of the triangle vertices.

    /**
     * Constructs a new Triangle object with the specified position, velocity, size, and color.
     *
     * @param x       The x-coordinate of the triangle.
     * @param y       The y-coordinate of the triangle.
     * @param sizeX   The width of the triangle.
     * @param sizeY   The height of the triangle.
     * @param clr     The color of the triangle.
     */
    public Triangle(int x, int y, int sizeX, int sizeY, Color clr) {
        super(x, y, sizeX, sizeY, clr);
        xPoints = new int[3];
        yPoints = new int[3];
    }

    /**
     * Fills the shape of the sprite with the specified color.
     *
     * @param surface The graphics surface to draw on.
     */
    @Override
    protected void fillSprite(Graphics surface) {
        calcPoints();
        surface.fillPolygon(xPoints, yPoints, 3);
    }

    /**
     * Draws the outline of the sprite shape with a black border.
     *
     * @param surface The graphics surface to draw on.
     */
    @Override
    protected void drawSprite(Graphics surface) {
        calcPoints();
        surface.drawPolygon(xPoints, yPoints, 3);
    }

    /**
     * Calculates the coordinates of the vertices of the triangle.
     */
    private void calcPoints() {
        // Bottom left vertex
        xPoints[0] = pos.x - siz.x / 2;
        yPoints[0] = pos.y + siz.y / 2;
        // Bottom right vertex
        xPoints[1] = pos.x + siz.x / 2;
        yPoints[1] = pos.y + siz.y / 2;
        // Top vertex
        xPoints[2] = pos.x;
        yPoints[2] = pos.y - siz.y / 2;
    }
}
