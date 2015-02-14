import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Class: Advanced Programming
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2014 Written: February 25, 2014
 * 
 *          Person class that creates the variables to allow reading in the
 *          TVCharacter.txt And enters them into a JTable, also calculates the
 *          age of each individual
 */

public class TVCharacterTable extends JPanel
{
    // Array to hold all persons
    private ArrayList<TVCharacter> persons = new ArrayList<TVCharacter>();
    // Person from TVCharacter class
    private TVCharacter person;
    // Jtable
    private JTable table;
    // Scroll pane for JTable
    private JScrollPane scrollPane;
    // Data object for JTabel
    private Object[][] data;
    // Column for JTabel
    private String[] columnNames =
    { "First Name", "Last Name", "Date of Birth", "Age", "TV Show" };

    // Method to read in the TVCharacter.txt file and set them into an array
    // list, and then set the arrayList into the JTable
    public TVCharacterTable() throws FileNotFoundException, ParseException
    {
        // Scanner to scan in the .txt file
        Scanner tvChar = new Scanner(new File("TVCharacter.txt"));

        // delimiter to separate the strings in the .txt file
        tvChar.useDelimiter(" ");

        // while loops to assign each string to 1 person created for the array
        while (tvChar.hasNextLine())
        {
            // firstName from txt read
            String firstName = tvChar.next();
            // LastName from txt read
            String lastName = tvChar.next();
            // BirthDate from txt read
            String birthDate = tvChar.next();
            // simpleDateFormat to work with given txt file
            SimpleDateFormat myForm = new SimpleDateFormat("MM/dd/yyyy");
            // Inputs birthDate into SimpleDateFormat
            Date bDay = myForm.parse(birthDate);
            // Date of birth is calculated
            Calendar dob = Calendar.getInstance();
            // DOB is set to the simpleDateFormat birthDate
            dob.setTime(bDay);
            // Todays date is retrived from local calander
            Calendar today = Calendar.getInstance();
            // Age integer is used to calculate the age of said individual
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            // if statement to say if today is less than or equal to year,
            // subtrack age
            if (today.get(Calendar.DAY_OF_YEAR) <= dob
                    .get(Calendar.DAY_OF_YEAR))
                age--;
            // age is converted from an integer and set to a string
            String charAge = Integer.toString(age);
            // tvShow is entered for line
            String tvShow = tvChar.nextLine();

            // all retrieved strings are input into a person
            person = new TVCharacter(firstName, lastName, birthDate, charAge,
                    tvShow);
            // Each person is added to persons arraylist
            persons.add(person);
        }
        // Data object sets rows, and columns
        data = new Object[persons.size()][5];

        // integer set to 0 for for loop
        int i = 0;
        // forloop goes through character arraylist and then inserts data into
        // the JTable
        for (TVCharacter person : persons)
        {
            data[i] = person.getTableValues();
            i++;
        }

        // JTable is created
        table = new JTable(data, columnNames);
        // Frame for scrollable area is created
        table.setPreferredScrollableViewportSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);

        // Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);

        // Add the scroll pane to this panel.
        add(scrollPane);
        // scanner tvChar is closed.
        tvChar.close();

    }

    // GUI for frame is created, and thrown File/Parsing exceptions
    public static void createAndShowGUI() throws FileNotFoundException,
            ParseException
    {
        // Create and set up the window.
        JFrame frame = new JFrame("TV Character");
        // frame set to close on clicking exit button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        TVCharacterTable newContentPane = new TVCharacterTable();
        // content panes set to opaque
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        // frame visibility set to true
        frame.setVisible(true);
    }

    //main method to create and show the GUI
    public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException
    {
        createAndShowGUI();
    }
}