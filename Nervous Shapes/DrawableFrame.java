//package Assignment3;

/**
 * @author Jeremy Lewis ITEC 3150
 * @version 1.0
 * Purpose of program: Draws a window using AWT
 **/

//import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.JFrame;

public class DrawableFrame extends JFrame
{

    private Image imageBuffer;
    private Insets insets;

    /**
     * Constructor
     * 
     * @param title
     */
    public DrawableFrame(String title)
    {
        super(title);
    }

    // Called automatically to display the contents of the
    // frame
    public void paint(Graphics g)
    {
        if (imageBuffer != null)
            g.drawImage(imageBuffer, insets.left, insets.top, null);
    }

    // Called automatically by repaint. Used to reduce flicker.
    public void update(Graphics g)
    {
        paint(g);
    }

    // Sets the size of the frame. The width and height
    // parameters control the size of the drawable portion of
    // the frame. The frame itself is somewhat larger.
    public void setSize(int width, int height)
    {
        insets = getInsets();
        super.setSize(width + insets.left + insets.right, height + insets.top
                + insets.bottom);
        imageBuffer = createImage(width, height);
    }

    // Returns the graphics context associated with the image
    // buffer
    public Graphics getGraphicsContext()
    {
        return imageBuffer.getGraphics();
    }
}
