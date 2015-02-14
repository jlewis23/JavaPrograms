/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3850 Spring 2013 Written: March 3, 2014
 * 
 *          Program: CookingMeasure program, part of Measurement
 * 
 *          Converts the volume measurements into teaspoons
 * 
 */

public class CookingMeasure extends Measurement
{
    public enum ConvertType
    {
        GALLONS, QUARTS, PINTS, CUPS, FLUID_OUNCES, TABLESPOON, TEASPOON
    }

    public CookingMeasure()
    {
        super(0);
    }

    public CookingMeasure(double numTeaspoons)
    {
        super(numTeaspoons);
    }

    public CookingMeasure(double numGallons, double numQuarts, double numPints,
            double numCups, double numFluidOunces, double numTablespoons,
            double numTeaspoons)
    {
        super(0);
        double tempTeaspoons = 0;
        tempTeaspoons += numGallons * 768;
        tempTeaspoons += numQuarts * 192;
        tempTeaspoons += numPints * 96;
        tempTeaspoons += numCups * 48;
        tempTeaspoons += numFluidOunces * 6;
        tempTeaspoons += numTablespoons * 3;
        tempTeaspoons += numTeaspoons;
        setBaseAmount(tempTeaspoons);
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
        else if (type == ConvertType.CUPS)
        {
            temp = representAsCups();
        }
        else if (type == ConvertType.FLUID_OUNCES)
        {
            temp = representAsFluidOunces();
        }
        else if (type == ConvertType.TABLESPOON)
        {
            temp = representAsTablespoon();
        }
        else if (type == ConvertType.TEASPOON)
        {
            temp = representAsTeaspoons();
        }
        return temp;
    }

    // Gallons represented as Teaspoons
    public double representAsGallons()
    {
        return getBaseAmount() / 768;
    }

    // Quarts represented as Teaspoons
    public double representAsQuarts()
    {
        return getBaseAmount() / 192;
    }

    // Pints represented as Teaspoons
    public double representAsPints()
    {
        return getBaseAmount() / 96;
    }

    // Cups represented as Teaspoons
    public double representAsCups()
    {
        return getBaseAmount() / 48;
    }

    // FluidOunces represented as Teaspoons
    public double representAsFluidOunces()
    {
        return getBaseAmount() / 6;
    }

    // Tablespoon represented as Teaspoons
    public double representAsTablespoon()
    {
        return getBaseAmount() / 3;
    }

    // Teaspoons represented as Teaspoons
    public double representAsTeaspoons()
    {
        return getBaseAmount();
    }
}