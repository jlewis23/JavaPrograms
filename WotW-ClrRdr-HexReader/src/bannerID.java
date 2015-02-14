import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2013 Written: February 19, 2014
 *          Homework 4 Program 2
 * 
 *          Read the hexColor file and decide if it is a valid, or invalid 9000
 *          banner id number
 * 
 */

public class bannerID
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scan in bannerID file
        Scanner bannerFile = new Scanner(new File("bannerID.txt"));

        while (bannerFile.hasNext())
        {
            // initilize bannerID
            String bannerID = bannerFile.next();

            // begin if/else statement to see if a number matches the desired
            // regEx
            if (bannerID.matches("^9[0]{3}[0-9]{5}"))
            {
                System.out.println("Valid Banner ID: " + bannerID);
            }
            else
            {
                System.out.println("Invalid Banner ID: " + bannerID);
            }
        }
        // closes scanner to eliminate possible errors
        bannerFile.close();
    }
}