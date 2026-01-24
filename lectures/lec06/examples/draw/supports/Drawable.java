package draw.supports;

import java.awt.*;

/**
 * Interface that defines the contract for drawable shapes.
 *
 * @author SingularWind
 */
public interface Drawable {
    /**
     * Draws the shape on the given {@code surface}.
     *
     * @param surface the {@link Graphics} object representing the surface where the shape is drawn
     */
    void draw(Graphics surface);

    /**
     * Sets the color of the shape.
     *
     * @param clr the {@link Color} to set the shape's color
     */
    void setColor(Color clr);

    /**
     * Sets the size of the shape.
     *
     * @param w the width of the shape
     * @param h the height of the shape
     */
    void setSize(int w, int h);
}
