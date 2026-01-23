package graphics.draw;

import graphics.shapes.BouncingBox;
import graphics.shapes.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for drawing graphics.
 * Manages and draws a collection of shapes (e.g., bouncing boxes).
 *
 * @author SingularWind
 */
public class DrawGraphics {
    private List<Shape> shapes;

    /**
     * Initializes this utility class for drawing graphics.
     */
    public DrawGraphics() {
        shapes = new ArrayList<>();
        addBoxes();
    }

    /**
     * Adds some bouncing boxes to the shapes list.
     */
    private void addBoxes() {
        // Makes three new testing boxes
        BouncingBox box1 = new BouncingBox(20, 40, Color.RED);
        box1.setVelocity(1, 2);
        BouncingBox box2 = new BouncingBox(20, 40, Color.GREEN);
        box2.setVelocity(10, 5);
        BouncingBox box3 = new BouncingBox(20, 40, Color.BLUE);
        box3.setVelocity(0, 20);

        // Adds boxes to the shapes list
        shapes.add(box1);
        shapes.add(box2);
        shapes.add(box3);
    }

    /**
     * Draws the content of the window on the surface.
     *
     * @param surface The surface where the content will be drawn.
     */
    public void draw(Graphics surface) {
        // Draws a testing line
        surface.drawLine(50, 50, 250, 250);

        // Casts to Graphics2D for better rendering options
        Graphics2D g2d = (Graphics2D) surface;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws each shape
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }
}
