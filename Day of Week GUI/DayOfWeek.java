// Importing all necessary java tools
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class: Advanced Programming
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2014 Written: February 25, 2014
 * 
 * 
 *          This class – Lets a user pick the month and Date, and year and it
 *          will calculate the week day (sunday-Saturday)
 */

public class DayOfWeek
{
    // JFrame created
    private JFrame frame;
    // JPanel created
    private JPanel panel;

    // Month JLabel and JComboBox
    private JLabel monthMessage;
    private JComboBox monthChoice;

    // Day message and choice added
    private JLabel dayMessage;
    private JComboBox dayChoice;

    // yearMessage label and yearEntry textfield created
    private JLabel yearMessage;
    private JTextField yearEntry;

    // DayofWeek jlabel created
    private JLabel dowMessage;
    private JLabel newDayofWeek;

    // Strings to hold actionlistener information choices
    String monthChoices;
    String dayChoices;

    // Method creates the main frame for the GUI
    private void makeComponents()
    {
        // Creates the JFrame that holds the interactions
        frame = new JFrame();
        // Sets the frame size
        frame.setSize(300, 150);
        // sets title for GUI
        frame.setTitle("Day of Week");
        // JFrame will close upon clicking exit button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sets layout to
        frame.setLayout(new GridLayout(2, 2));
        // location set to middle of screen
        frame.setLocationRelativeTo(null);

        // Creates the Lables that tell a user what is happening.
        monthMessage = new JLabel("Month: ");
        dayMessage = new JLabel("Day: ");
        yearMessage = new JLabel("Year: ");
        dowMessage = new JLabel("The day of the week is: ");

        monthChoice = new JComboBox();

        // creates the entry field for the user
        yearEntry = new JTextField();
        // creates the action listener for when a user hits enter

    }

    // adds JCombobox's to JPanel
    private JPanel addComponent()
    {
        // monthChoice JComboBox created, 12 months added
        monthChoice = new JComboBox();
        monthChoice.addItem("January");
        monthChoice.addItem("February");
        monthChoice.addItem("March");
        monthChoice.addItem("April");
        monthChoice.addItem("May");
        monthChoice.addItem("June");
        monthChoice.addItem("July");
        monthChoice.addItem("August");
        monthChoice.addItem("September");
        monthChoice.addItem("October");
        monthChoice.addItem("November");
        monthChoice.addItem("December");
        // action listener for monthChoice combobox
        monthChoice.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String monthChoices = (String) monthChoice.getSelectedItem();
                System.out.println("Month Chosen: " + monthChoices);
            }
        });

        // dayChoice JComboBox is created, and 31 days added to it
        dayChoice = new JComboBox();
        dayChoice.addItem("1");
        dayChoice.addItem("2");
        dayChoice.addItem("3");
        dayChoice.addItem("4");
        dayChoice.addItem("5");
        dayChoice.addItem("6");
        dayChoice.addItem("7");
        dayChoice.addItem("8");
        dayChoice.addItem("9");
        dayChoice.addItem("10");
        dayChoice.addItem("11");
        dayChoice.addItem("12");
        dayChoice.addItem("13");
        dayChoice.addItem("14");
        dayChoice.addItem("15");
        dayChoice.addItem("16");
        dayChoice.addItem("17");
        dayChoice.addItem("18");
        dayChoice.addItem("19");
        dayChoice.addItem("20");
        dayChoice.addItem("21");
        dayChoice.addItem("22");
        dayChoice.addItem("23");
        dayChoice.addItem("24");
        dayChoice.addItem("25");
        dayChoice.addItem("26");
        dayChoice.addItem("27");
        dayChoice.addItem("28");
        dayChoice.addItem("29");
        dayChoice.addItem("30");
        dayChoice.addItem("31");
        // Action Listener added to dayChoice Jcombobox
        dayChoice.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String dayChoices = (String) dayChoice.getSelectedItem();
                System.out.println("Day Chosen: " + dayChoices);
            }
        });

        // new JPanel created
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));

        // monthMessage and monthChoice added to JPanel
        panel.add(monthMessage);
        panel.add(monthChoice);

        // Daymessage and dayChoice added to JPanel
        panel.add(dayMessage);
        panel.add(dayChoice);

        // yearMessage and yearEntryField added to panel
        panel.add(yearMessage);
        panel.add(yearEntry);

        // JPanel returned
        return panel;
    }

    private JPanel addComponents()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        // dow message added to JPanel
        panel.add(dowMessage);

        return panel;
    }

    // creates the Layout for the GUI, adds the component and components to the
    // Frame, and packs them
    private void makeLayout()
    {
        frame.add(addComponent());
        frame.add(addComponents());

        frame.pack();
    }

    // visibility for the frame is set to true
    private void setVisible()
    {
        frame.setVisible(true);
    }

    // main method for DayofWeek class
    public static void main(String[] args)
    {
        DayOfWeek dow = new DayOfWeek();
        dow.makeComponents();
        dow.makeLayout();
        dow.setVisible();
    }
}
