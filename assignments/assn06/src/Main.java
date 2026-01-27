import sprites.Circle;
import sprites.Rectangle;
import sprites.Sprite;
import sprites.Triangle;
import utils.Painter;
import utils.Painting;

/**
 * Main is the entry point of the program.
 *
 * @author SingularWind
 */
public class Main {
    // testing code for the sprites.
    public static void main(String[] args) {
        // Create a painter and a painting.
        Painter painter = new Painter();
        Painting painting = new Painting(painter);

        // Add some sprites to the painter.
        Sprite rectangle = new Rectangle(100, 100, 50, 50, java.awt.Color.RED);
        rectangle.setVelocity(10, 1);
        painter.addSprite(rectangle);
        Sprite triangle = new Triangle(200, 200, 50, 50, java.awt.Color.BLUE);
        triangle.setVelocity(1, -1);
        painter.addSprite(triangle);
        Sprite circle = new Circle(100, 100, 50, java.awt.Color.CYAN);
        circle.setVelocity(1, -1);
        painter.addSprite(circle);

        // Start the animation.
        new Thread(painter).start();
    }
}
