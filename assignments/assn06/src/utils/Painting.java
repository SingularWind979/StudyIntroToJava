package utils;

import static utils.Setting.*;

import javax.swing.JFrame;

/**
 * Painting is a JFrame that contains a Painter.
 *
 * @author SingularWind
 */
public final class Painting extends JFrame {
    /**
     * Constructor for Painting.
     * @param painter The painter to be attached.
     */
    public Painting(Painter painter) {
        setTitle("Graphics Painting");
        setBackground(BG_COLOR);
        setPreferredSize(BG_SIZE);
        setContentPane(painter);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        pack();
    }
}
