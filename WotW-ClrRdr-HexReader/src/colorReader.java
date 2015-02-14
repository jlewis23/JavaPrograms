import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2013 Written: February 19, 2014
 *          Homework 4 Program 2
 * 
 *          Read the hexColor file and decide if it is a valid, invalid, or
 *          shade of cray color.
 * 
 */

public class colorReader
{
    // throw exceptions
    public static void main(String[] args) throws FileNotFoundException
    {
        // use try statement
        try
        {
            // Scan in hexColor file, and name it hexFile
            Scanner hexFile = new Scanner(new File("hexColor.txt"));

            while (hexFile.hasNext())
            {
                //initialze hexColor string
                String hexColor = hexFile.next();

                if (hexColor.matches("^#([A-Fa-f0-9]{2})\\1\\1"))
                {
                    System.out.println("Shade of Gray: " + hexColor);
                }

                // if else statement for finding a valid hex color
                if (hexColor
                        .matches("^#[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]"))
                {
                    System.out.println("Valid HEX Color: " + hexColor);
                }
                else
                {
                    System.out.println("Invalid HEX Color: " + hexColor);
                }
            }
            // close the hexFile so errors do not occur
            hexFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("FileCopy: " + e);
        }
    }
}