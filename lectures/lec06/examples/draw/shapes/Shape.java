package draw.shapes;

import draw.supports.Canvas;
import draw.supports.Vector2D;
import draw.supports.Drawable;
import draw.supports.Moveable;
import lombok.Getter;

import java.awt.*;

/**
 * Abstract class that defines the basic properties of a shape.
 *
 * @author SingularWind
 */
@Getter
public abstract class Shape implements Drawable, Moveable {
    private Vector2D pos;
    private Vector2D vel;
    private Vector2D size;
    private Color clr;

    public Shape() {
        pos = new Vector2D(0, 0);
        vel = new Vector2D(0, 0);
        size = new Vector2D(0, 0);
        clr = new Color(0, 0, 0, 0);
    }

    public Shape(Vector2D pos, Vector2D vel, Vector2D size, Color clr) {
        this.pos = pos;
        this.vel = vel;
        this.size = size;
        this.clr = clr;
    }

    /**
     * Sets the color of the shape.
     *
     * @param clr the {@link Color} to set the shape's color
     */
    @Override
    public void setColor(Color clr) {
        this.clr = clr;
    }

    /**
     * Sets the size of the shape.
     *
     * @param w the width of the shape
     * @param h the height of the shape
     */
    @Override
    public void setSize(int w, int h) {
        this.size = new Vector2D(w, h);
    }

    /**
     * Sets the position of the shape.
     *
     * @param x the x-coordinate of the new position
     * @param y the y-coordinate of the new position
     */
    @Override
    public void setPosition(int x, int y) {
        this.pos = new Vector2D(x, y);
    }

    /**
     * Sets the velocity of the shape.
     *
     * @param velX the x-coordinate of the new velocity
     * @param velY the y-coordinate of the new velocity
     */
    @Override
    public void setVelocity(int velX, int velY) {
        this.vel = new Vector2D(velX, velY);
    }

    /**
     * Moves the shape on the given {@code surface}.
     *
     * @param surface the {@link Graphics} object representing the surface where the shape moves on
     */
    @Override
    public void move(Graphics surface) {
        pos.add(vel);

        if (xHitBound()) {
            vel.reverseX();
        }
        if (yHitBound()) {
            vel.reverseY();
        }
    }

    /**
     * Judges if the shape hit the x-axis bounder.
     *
     * @return true if the shape hit the x-axis bounder, otherwise false
     */
    private boolean xHitBound() {
        return (pos.getX() - size.getX() / 2 < 0 && vel.getX() < 0)
                || (pos.getX() + size.getX() / 2 > Canvas.WIDTH && vel.getX() > 0);
    }

    /**
     * Judges if the shape hit the y-axis bounder.
     *
     * @return true if the shape hit the y-axis bounder, otherwise false
     */
    private boolean yHitBound() {
        return (pos.getY() - size.getY() / 2 < 0 && vel.getY() < 0)
                || (pos.getY() - size.getY() / 2 > Canvas.HEIGHT && vel.getY() > 0);
    }
}
