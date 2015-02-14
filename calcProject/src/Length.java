/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3850 Spring 2013 Written: March 3, 2014
 * 
 *          Program: Length program, part of Measurement
 * 
 *          Converts the length measurements into inches
 * 
 */

public class Length extends Measurement
{
    // enumeration for the length measurements
    public enum ConvertType
    {
        MILES, YARDS, FEET, INCHES;
    }

    // Length constructor
    public Length()
    {
        super(0);
    }

    // Length constructor
    public Length(double inches)
    {
        super(inches);
    }

    // Length constructor; using tempInches as a temporary int holder for the
    // length measurements
    // does converting for the setBaseAmount
    public Length(double miles, double yards, double feet, double inches)
    {
        super(0);
        double tempInches = 0;
        tempInches += miles * 63360;
        tempInches += yards * 36;
        tempInches += feet * 12;
        tempInches += inches;
        setBaseAmount(tempInches);
    }

    // if statement for converting the type of length, (miles, yards, feet,
    // inches) and returns a measurement in inches
    public double represent(ConvertType type)
    {
        double temp = 0;

        if (type == ConvertType.MILES)
        {
            temp = representAsMiles();
        }
        else if (type == ConvertType.YARDS)
        {
            temp = representAsYards();
        }
        else if (type == ConvertType.FEET)
        {
            temp = representAsFeet();
        }
        else if (type == ConvertType.INCHES)
        {
            temp = representAsInches();
        }
        return temp;
    }

    // miles represented in inches
    public double representAsMiles()
    {
        return getBaseAmount() / 63360;
    }

    // yards represented in inches
    public double representAsYards()
    {
        return getBaseAmount() / 36;
    }

    // feet represented in inches
    public double representAsFeet()
    {
        return getBaseAmount() / 12;
    }

    // inches represented in inches
    public double representAsInches()
    {
        return getBaseAmount();
    }
}