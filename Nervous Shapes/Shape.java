//package Assignment3;

/**
 * @author Jeremy LewisITEC 3150
 * @version 1.0
 * Purpose of program: This class represents a graphic shape that can be displayed in a graphics
 * context
 **/
// Represents a geometric shape that can be displayed in a
// graphics context

import java.awt.*;

public abstract class Shape
{
    // Instance variables
    private int x;
    private int y;
    private Color color;

    // Constructor
    protected Shape(int x, int y, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Abstract methods
    public abstract void draw(Graphics g);

    public abstract int getHeight();

    public abstract int getWidth();

    // Other instance methods
    public Color getColor()
    {
        return color;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

}
