package graphics.draw;

import graphics.shapes.BouncingBox;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the utility class for drawing graphics.
 *
 * @author SingularWind
 */
public class DrawGraphics {
    private List<BouncingBox> boxes;

    /**
     * Initializes this utility class for drawing graphics.
     */
    public DrawGraphics() {
        boxes = new ArrayList<>();
        BouncingBox box1 = new BouncingBox(20, 40, Color.RED);
        box1.setVelocity(1, 2);
        BouncingBox box2 = new BouncingBox(20, 40, Color.GREEN);
        box2.setVelocity(10, 5);
        BouncingBox box3 = new BouncingBox(20, 40, Color.BLUE);
        box3.setVelocity(0, 20);
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
    }

    /**
     * Draws the content of the window on surface.
     *
     * @param surface The surface where the content will be drawn.
     */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        for (BouncingBox box : boxes) {
            box.draw(surface);
        }
    }
}
