package draw.shapes;

import draw.supports.Vector2D;

import java.awt.*;

/**
 * Class represents a flower shape that can be drawn on a surface.
 */
public class Flower extends Shape {
    public Flower() {
        super();
    }

    public Flower(Vector2D pos, Vector2D vel, Vector2D size, Color clr) {
        super(pos, vel, size, clr);
    }

    /**
     * Draw the shape on the surface.
     *
     * @param surface The surface where tbe shape is drawn on.
     */
    @Override
    public void draw(Graphics surface) {
        surface.setColor(Color.RED);
        move(surface);
    }
}
