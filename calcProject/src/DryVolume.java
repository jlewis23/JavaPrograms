/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3850 Spring 2013 Written: March 3, 2014
 * 
 *          Program: DrayVolume program, part of Measurement
 * 
 *          Converts dry volume measurements into pints
 * 
 */

public class DryVolume extends Measurement
{
    public enum ConvertType
    {
        GALLONS, QUARTS, PINTS;
    }

    public DryVolume()
    {
        super(0);
    }

    public DryVolume(double numPints)
    {
        super(numPints);
    }

    public DryVolume(double numGallons, double numQuarts, double numPints)
    {
        super(0);
        double tempPints = 0;
        tempPints += numGallons * 8;
        tempPints += numQuarts * 2;
        tempPints += numPints;
        setBaseAmount(tempPints);
    }

    // if statement for converting the type of CookingMeasurement
    // (gallons, Quarts, pints, cups, fluidounces, tablespoons, teaspoons, and
    // returns the amount in teaspons.
    public double represent(ConvertType type)
    {
        double temp = 0;

        if (type == ConvertType.GALLONS)
        {
            temp = representAsGallons();
        }
        else if (type == ConvertType.QUARTS)
        {
            temp = representAsQuarts();
        }
        else if (type == ConvertType.PINTS)
        {
            temp = representAsPints();
        }
        return temp;
    }

    // Gallons represented as Pints
    public double representAsGallons()
    {
        return getBaseAmount() / 8;
    }

    // Quarts represented as Pints
    public double representAsQuarts()
    {
        return getBaseAmount() / 2;
    }

    // Pints represented as Pints
    public double representAsPints()
    {
        return getBaseAmount();
    }    
}