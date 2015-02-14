/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3850 Spring 2013 Written: March 3, 2014
 * 
 *          Program: Measurement program, part of Measurement
 * 
 *          Sets base amounts for each of the other 3 classes, and based on a JUnitTest case.
 *          
 *          SOP's the tests
 */

public class Measurement
{
    private double baseAmount;
    
    public Measurement(double baseAmount)
    {
        this.baseAmount = baseAmount;
    }
    
    public double getBaseAmount()
    {
        return baseAmount;
    }
    
    public void setBaseAmount(double baseAmount)
    {
        this.baseAmount = baseAmount;
    }
    
    public Measurement plus(Measurement aMeasure)
    {
        Measurement newMeasure = new Measurement(baseAmount);
        newMeasure.setBaseAmount(baseAmount + aMeasure.getBaseAmount());
        return newMeasure;
    }
    
    public Measurement minus(Measurement aMeasure)
    {
        Measurement newMeasure = new Measurement(baseAmount);
        newMeasure.setBaseAmount(baseAmount - aMeasure.getBaseAmount());
        return newMeasure;
    }

    @Override
    public String toString()
    {
        return "Measurement [baseAmount=" + baseAmount + "]";
    }
}
