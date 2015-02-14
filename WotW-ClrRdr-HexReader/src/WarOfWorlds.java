import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2013 Written: February 19, 2014
 *          Homework 4 Program 3
 * 
 *          Read the pg36.txt file and earch for words that are 16 characters or longer, and SOP them to the console.
 * 
 */

public class WarOfWorlds
{
    // throw exceptions
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // use try statement
        try
        {
            // Scan in hexColor file, and name it hexFile
            Scanner textFile = new Scanner(new File("pg36.txt"));
            
            // create warofworlds.txt using printwriter
            PrintWriter writer = new PrintWriter("warofworlds.txt");
            
            while (textFile.hasNext())
            {
                //initialze hexColor string
                String textLength = textFile.next();
                
                //begins the if/else statement to try matching words to more than 16 words
                if (textLength.matches("\\w[A-Za-z]{15,15}"))
                {
                    System.out.println("16+ Character Words: " + textLength);
                    writer.println("16+ Character Words: " + textLength);
                }
                else if(textLength.matches("\\w[A-Za-z]{16,}"))
                {
                    System.out.println("17+ Character Words: " + textLength);
                    writer.println("17+ Character Words: " + textLength);
                }
                else
                {
                    
                }
            }
            // close the textFile & writer so errors do not occur
            textFile.close();
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("FileCopy: " + e);
        }
    }
}