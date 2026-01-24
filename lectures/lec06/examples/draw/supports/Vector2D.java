package draw.supports;

import lombok.Data;

/**
 * Class that represents a 2D vector with basic operations.
 *
 * @author SingularWind
 */
@Data
public class Vector2D {
    private int x;
    private int y;

    /**
     * Constructs a {@code Vector2D} with specified x and y components.
     *
     * @param x the x-coordinate of the vector
     * @param y the y-coordinate of the vector
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Adds the specified {@code Vector2D} to the current vector.
     *
     * @param delta the vector to be added to this vector
     */
    public void add(Vector2D delta) {
        x += delta.x;
        y += delta.y;
    }

    /**
     * Reverses the direction of the vector along the X axis.
     */
    public void reverseX() {
        x *= -1;
    }

    /**
     * Reverses the direction of the vector along the Y axis.
     */
    public void reverseY() {
        y *= -1;
    }
}
