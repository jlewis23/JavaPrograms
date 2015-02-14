//package Assignment3;

/**
 * @author Jeremy Lewis ITEC 3150
 * @version 1.0
 * Purpose of program: This class represents a rectangle that can be displayed in a graphics
 * context
 **/

import java.awt.*;

public class Rectangle extends Shape
{
    // Instance variables
    private int width;
    private int height;

    /**
     * Rectangle Constructor
     * 
     * @param x
     * @param y
     * @param color
     * @param width
     * @param height
     */
    public Rectangle(int x, int y, Color color, int width, int height)
    {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    // Instance methods
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), width, height);
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }
}
