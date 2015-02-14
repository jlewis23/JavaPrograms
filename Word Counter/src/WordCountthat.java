import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// import of all used utilities

/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2013 Written: October 13, 2013
 *          Homework 4 WordCountThat
 * 
 *          A program that counts the words in one or more text files. Also
 *          implements a JFileChooser and prints the results to a JTextArea in a
 *          JFrame.
 * 
 */

public class WordCountthat
{
    /**
     * Initializing null values to showFrame, textArea, panel, fileChoose, and
     * openFile
     */
    JFrame showFrame;
    JTextArea textArea;
    JPanel panel;
    JFileChooser fileChoose;
    File[] openFile;

    // method to run WordCountThat
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            // running WordCountThat
            public void run()
            {
                new WordCountthat();
            }
        });
    }

    // Method to set JFrame, scan in user selections, and count words.
    public WordCountthat()
    {
        // setting attributes to showFrame and creating showFrame
        showFrame = new JFrame();
        showFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showFrame.setTitle("Word Count That");
        showFrame.setSize(500, 300);
        showFrame.setLocationRelativeTo(null);
        showFrame.setLayout(new BorderLayout());

        // creating fileChoose
        fileChoose = new JFileChooser();

        // Initialize the textArea
        textArea = new JTextArea("File Tracker:");

        // setting textArea visibility to true
        textArea.setVisible(true);

        // adding textArea and borderlayout to Showframe
        showFrame.add(textArea, BorderLayout.NORTH);

        // creating new panel
        panel = new JPanel();

        // setting layout to panel
        panel.setLayout(new GridLayout(1, 1));

        // adding the panel and border to the showFrame
        showFrame.add(panel, BorderLayout.SOUTH);

        // Initialize openButton & set the action to it
        JButton openButton = new JButton("Open File");
        openButton.setActionCommand("Open File");

        // adding actionListener to OpenButton
        openButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                // try & catch statement to satisfiy openDialog() requirements
                try
                {
                    fileChoose.setMultiSelectionEnabled(true);
                    openDialog();
                }
                catch (FileNotFoundException e)
                {
                    // catch block
                    e.printStackTrace();
                }
            }
        });

        // adds openButton to the panel
        panel.add(openButton);

        // sets visibility to the panel
        showFrame.setVisible(true);
    }

    // Show a open file dialog box
    private void openDialog() throws FileNotFoundException
    {
        // setting openChoice
        int openChoice = fileChoose.showOpenDialog(showFrame);

        // display choice using tracker
        logChoice(openChoice, "Open Dialog");

        // if statememnt to make openChoice ==
        if (openChoice == JFileChooser.APPROVE_OPTION)
        {
            // openFile is equal to what user selected.
            openFile = fileChoose.getSelectedFiles();

            // for statement to allow multiple selections of files
            for (int i = 0; i <= openFile.length - 1; i++)
            {
                // prints out file selected in textArea
                textArea.append("\nThe file selected is "
                        + openFile[i].getName());

                // import of scanner to read in the users selection of a file
                Scanner fileScan = new Scanner(new File(openFile[i].getPath()));

                // initializing words, lines, and chars
                int words = 0;
                int lines = 0;
                int chars = 0;
                while (fileScan.hasNextLine())
                {
                    // adding lines together
                    lines++;

                    // setting lines to string
                    String line = fileScan.nextLine();

                    // setting chars to += length of the lines
                    chars += line.length();

                    // adding words to Tokenizer to count all words by using
                    // whitespace to skip
                    words += new StringTokenizer(line, " ,").countTokens();
                }

                // printing amount of words to textArea
                textArea.append("\nNumber of Words " + Integer.toString(words));

                // closing scanner
                fileScan.close();
            }
        }
    }

    // append the button choice to the textArea
    private void logChoice(int choice, String dialog)
    {
        switch (choice)
        {
        // The user pressed cancel button
        case JFileChooser.CANCEL_OPTION:
            textArea.append("\nCancel Option received from " + dialog);
            break;
        }
    }
}