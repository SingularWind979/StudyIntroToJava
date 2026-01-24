package draw.shapes;

import draw.supports.Vector2D;

import java.awt.*;

/**
 * Class represents a flower shape that can be drawn on a surface.
 *
 * @author SingularWind
 */
public class Flower extends Shape {
    /**
     * Constructs a {@code Flower} with default position, velocity, size, and color.
     * Calls the superclass constructor with default values for position, velocity, size, and color.
     */
    public Flower() {
        super();
    }

    /**
     * Constructs a {@code Flower} with specified position, velocity, size, and color.
     * Calls the superclass constructor with the provided parameters.
     *
     * @param pos  the position of the flower
     * @param vel  the velocity of the flower
     * @param size the size of the flower
     * @param clr  the color of the flower
     */
    public Flower(Vector2D pos, Vector2D vel, Vector2D size, Color clr) {
        super(pos, vel, size, clr);
    }

    /**
     * Draw the shape on the surface.
     *
     * @param surface the surface where tbe shape is drawn on
     */
    @Override
    public void draw(Graphics surface) {
        surface.setColor(Color.RED);
        move(surface);
    }
}
