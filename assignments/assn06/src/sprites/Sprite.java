package sprites;

import static utils.Setting.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Represents a basic moveable and drawable sprite.
 *
 * @author SingularWind
 */
public abstract class Sprite implements Drawable, Moveable {
    protected Vector2D siz; // The size of the sprite.
    protected Vector2D pos; // The center position of the sprite.
    protected Vector2D vel; // The velocity of the sprite.
    protected Color clr;    // The color of the sprite.

    /**
     * Constructs a new Sprite object with default settings.
     */
    public Sprite() {
        this(0, 0, 0, 0, Color.WHITE);
    }

    /**
     * Constructs a new Sprite object with the specified position, velocity, size, and color.
     *
     * @param x       The x-coordinate of the sprite.
     * @param y       The y-coordinate of the sprite.
     * @param sizeX   The width of the sprite.
     * @param sizeY   The height of the sprite.
     * @param clr     The color of the sprite.
     */
    public Sprite(int x, int y, int sizeX, int sizeY, Color clr) {
        this.pos = new Vector2D(x, y);
        this.vel = new Vector2D(0, 0);
        this.siz = new Vector2D(sizeX, sizeY);
        this.clr = clr;
    }

    /**
     * Draws the sprite on the specified graphics surface.
     *
     * @param surface The graphics surface to draw on.
     */
    @Override
    public void draw(Graphics surface) {
        // fill the shape with the specified color
        surface.setColor(clr);
        fillSprite(surface);

        // draw the outline with a black border
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        drawSprite(surface);
    }

    /**
     * Fills the sprite with the specified color.
     *
     * @param surface The graphics surface to draw on.
     */
    protected abstract void fillSprite(Graphics surface);

    /**
     * Draws the outline of the sprite with a black border.
     *
     * @param surface The graphics surface to draw on.
     */
    protected abstract void drawSprite(Graphics surface);

    /**
     * Moves the sprite by updating its position based on its velocity.
     */
    @Override
    public void move() {
        pos.add(vel);

        if (xHitBound()) {
            vel.reverseX();
        }
        if (yHitBound()) {
            vel.reverseY();
        }
    }

    /**
     * Helper method to check if the sprite has hit the horizontal bounds of the graphics surface.
     *
     * @return true if the sprite has hit the horizontal bounds, false otherwise.
     */
    protected boolean xHitBound() {
        return (pos.x - siz.x / 2 <= 0 && vel.x < 0)
                || (pos.x + siz.x / 2 >= BG_WIDTH && vel.x > 0);
    }

    /**
     * Helper method to check if the sprite has hit the vertical bounds of the graphics surface.
     *
     * @return true if the sprite has hit the vertical bounds, false otherwise.
     */
    protected boolean yHitBound() {
        return (pos.y - siz.y / 2 <= 0 && vel.y < 0)
                || (pos.y + siz.y / 2 >= BG_HEIGHT && vel.y > 0);
    }

    /**
     * Sets the velocity of the sprite.
     *
     * @param velX The x component of the velocity vector.
     * @param velY The y component of the velocity vector.
     */
    public void setVelocity(int velX, int velY) {
        vel = new Vector2D(velX, velY);
    }
}
