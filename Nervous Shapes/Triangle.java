import java.awt.*;

/**
 * @author Jeremy Lewis ITEC 3150
 * @version 1.0 Purpose of program: This class represents a tringle that can be
 *          displayed in a graphics context
 **/

public class Triangle extends Shape
{
    // Instance variables, side of triangle
    private int side;

    // Triangle Initilization set to zero
    public Triangle()
    {
        super(0, 0, Color.BLUE);
        this.side = 0;
    }

    // sides and color set for triangle
    public Triangle(int x, int y, Color color, int side)
    {
        super(x, y, color);
        this.side = side;
    }

    // Instance methods and draws triangle
    public void draw(Graphics g)
    {
        g.setColor(getColor());

        // height of the triangle is obtained from its side length using
        // Pythagorean Theorem
        int h = (int) Math.pow(
                (Math.pow(side, 2.0) - Math.pow((side / 2), 2.0)), 0.5);

        int X[] =
        { getX(), getX() + (side / 2), getX() + side };
        int Y[] =
        { getY(), getY() - h, getY() };

        g.fillPolygon(X, Y, 3);
    }

    // Shape getHeight and return height
    public int getHeight()
    {
        double h;
        // height of the triangle is obtained from its side length using
        // Pythagorean Theorem
        h = Math.pow((Math.pow(side, 2.0) - Math.pow((side / 2), 2.0)), 0.5);
        return ((int) h);
    }

    // Shape get width and set hight, then return side.
    public int getWidth()
    {
        return side;
    }
}
