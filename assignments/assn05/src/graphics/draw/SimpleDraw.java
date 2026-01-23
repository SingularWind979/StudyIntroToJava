package graphics.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class displays a window and delegates drawing to DrawGraphics.
 *
 * @author SingularWind
 */
public class SimpleDraw extends JPanel implements Runnable {
    // Basic frame settings
    public static final int FRAME_DELAY = 50;

    // Basic color settings
    public static final Color BG_COLOR = Color.WHITE;

    // Basic size settings
    public static final int WIDTH  = 300;
    public static final int HEIGHT = 300;
    public static final Dimension DRAW_SIZE = new Dimension(WIDTH, HEIGHT);

    // Animation state
    private boolean animate = true;

    // DrawGraphics object responsible for drawing content
    private DrawGraphics drawer;

    /**
     * Constructor to initialize the SimpleDraw with the given drawer (DrawGraphics).
     *
     * @param drawer The DrawGraphics object used to handle drawing operations
     */
    public SimpleDraw(DrawGraphics drawer) {
        this.drawer = drawer;
    }

    /**
     * Paints the component (panel) with the provided Graphics object.
     * This method is automatically called when the panel needs to be redrawn.
     *
     * @param g The Graphics object to used for rendering the content
     */
    @Override
    public void paintComponent(Graphics g) {
        // Calls JPanel's paintComponent to clear the area
        super.paintComponent(g);

        // Casting Graphics to Graphics2D for advanced drawing features
        Graphics2D g2d = (Graphics2D) g;

        // Delegate the actual drawing to the DrawGraphics object
        drawer.draw(g2d);
    }

    /**
     * Starts animation.
     * Sets the animate flag to true.
     */
    public void start() {
        animate = true;
    }

    /**
     * Stops animation.
     * Sets the animate flag to false.
     */
    public void stop() {
        animate = false;
    }

    /**
     * Checks if the animation is enabled.
     *
     * @return true if animation is enabled, false otherwise.
     */
    public boolean animateEnabled() {
        return animate;
    }

    /**
     * The animation loop that repeatedly repaints the panel while animation is enabled.
     * This method runs in a separate thread.
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (animateEnabled()) {
            long currentTime = System.currentTimeMillis();
            // Repaint the panel at a delay of FRMAE_DELAY if animation is enabled
            if (currentTime - lastTime >= FRAME_DELAY) {
                repaint();
                lastTime = currentTime;
            }
        }
    }

    /**
     * Creates the content.
     *
     * @return The content created.
     */
    private static SimpleDraw createContent() {
        SimpleDraw content = new SimpleDraw(new DrawGraphics());
        
        // Basic content settings
        content.setBackground(BG_COLOR);
        content.setPreferredSize(DRAW_SIZE);
        
        return content;
    }

    /**
     * Creates the window and attached content to the window.
     *
     * @param content The content to be attached to.
     * @return The window created.
     */
    private static JFrame createWindow(SimpleDraw content) {
        JFrame window = new JFrame("Graphics!");

        // Attaches content panel to the window frame
        window.setContentPane(content);
        
        // Basic window settings
        window.setBackground(BG_COLOR);
        window.setPreferredSize(DRAW_SIZE);
        window.setVisible(true);
        window.setResizable(false);
        window.pack();

        // Adds a WindowListener to the window to handle various window events
        window.addWindowListener(new WindowAdapter() {
            // This method is called when the window is about to close, exit the app
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            // This method is called when the window is restored from the minimized state, restart the app
            @Override
            public void windowDeiconified(WindowEvent e) {
                content.start();
            }
            // This method is called when the window is minimized, stop the app
            @Override
            public void windowIconified(WindowEvent e) {
                content.stop();
            }
        });
        
        return window;
    }

    public static void main(String[] args) {
        // Creates the window frame and content panel
        SimpleDraw content = createContent();
        JFrame window = createWindow(content);

        // Starts the animation loop of content in a separate thread
         new Thread(content).start();
    }
}
