package sprites;

/**
 * Represents a 2D vector with x and y components.
 *
 * @author SingularWind
 */
public final class Vector2D {
    int x;   // The x component of the vector.
    int y;   // The y component of the vector.

    /**
     * Constructs a new Vector2D object with the specified x and y components.
     *
     * @param x The x component of the vector.
     * @param y The y component of the vector.
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Multiplies the vector by the specified factor.
     *
     * @param factor The factor to multiply the vector by.
     */
    public void multi(int factor) {
        x *= factor;
        y *= factor;
    }

    /**
     * Adds the specified vector to this vector.
     *
     * @param vector The vector to add.
     */
    public void add(Vector2D vector) {
        x += vector.x;
        y += vector.y;
    }

    /**
     * Subtracts the specified vector from this vector.
     *
     * @param vector The vector to subtract.
     */
    public void sub(Vector2D vector) {
        vector.reverse();
        add(vector);
    }

    /**
     * Reverses the direction of the vector.
     */
    public void reverse() {
        reverseX();
        reverseY();
    }

    /**
     * Reverses the x component of the vector.
     */
    public void reverseX() {
        x *= -1;
    }

    /**
     * Reverses the y component of the vector.
     */
    public void reverseY() {
        y *= -1;
    }
}
