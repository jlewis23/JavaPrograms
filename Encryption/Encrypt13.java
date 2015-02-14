// Importing all necessary java tools
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**Class: Advanced Programming
* @author Jeremy Lewis
* @version 1.0
* Course : ITEC 3150 Spring 2014
* Written: February 23, 2014
*
*
* This class – Takes a users input and encrypts it
*
* Purpose: – Purpose is to encrypt a users input
*/

public class Encrypt13
{
    //Initilize variables for frame, JLabels, JTextField, Strings, Chars, and Ints
    private JFrame frame;
    private JPanel panel;
    
    private JLabel originalMessage;
    private JLabel encryptedMessage;

    private JTextField originalText;
    private JLabel encryptedText;
    private String encryptText;
    private String encodedText;

    private int textLength;
    char inputChar;

    //Method creates the main frame for the GUI
    private void makeComponents()
    {
        // Creates the JFrame that holds the interactions
        frame = new JFrame();
        //Sets the frame size
        frame.setSize(500, 150);
        //sets title for GUI
        frame.setTitle("Encrypt by Rotating 13");
        //JFrame will close upon clicking exit button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets layout to 2x2
        frame.setLayout(new GridLayout(2, 2));
        //location set to middle of screen
        frame.setLocationRelativeTo(null);

        //Creates the Lables that tell a user what is happening.
        originalMessage = new JLabel("Original Message: ");
        encryptedMessage = new JLabel("Encrypted Message: ");

        //creates the entry field for the user
        originalText = new JTextField();
        //creates the action listener for when a user hits enter
        originalText.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // retives the input from the user
                encryptText = originalText.getText();
                //empty string is created to be used as a place holder
                encodedText = "";
                //length of the user text input
                textLength = encryptText.length();

                for (int i = 0; i < textLength; i++)
                {
                    // gets the current character from the input
                    inputChar = encryptText.charAt(i);

                    // portion of if statement that sets the character to a new letter 13 down
                    if ((inputChar >= 65 && inputChar <= 77)
                            || (inputChar >= 97 && inputChar <= 109))
                    {
                        //rotates characters A-M 13 spaces
                        encodedText += (char) (inputChar + 13);
                    }
                    //portion of if statement that rotates characters N-Z 13 spaces
                    else if ((inputChar >= 78 && inputChar <= 90)
                            || (inputChar >= 110 && inputChar <= 122))
                    {
                        encodedText += (char) (inputChar - 13);
                    }
                    else
                    {
                        encodedText += inputChar;
                    }
                }
                // sets encryptedText to hold what encodedText once held
                encryptedText.setText(encodedText);
            }
        });
        //JLabel for Encrypted text created
        encryptedText = new JLabel(encodedText);
    }
    
    //adds the originalMessage and originalText to the JPanel
    private JPanel addComponent()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        panel.add(originalMessage);
        panel.add(originalText);

        return panel;
    }

    //adds the encryptMessage and encrypted Text to the JPanel
    private JPanel addComponents()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        panel.add(encryptedMessage);
        panel.add(encryptedText);

        return panel;
    }

    // creates the Layout for the GUI, adds the component and components to the Frame, and packs them
    private void makeLayout()
    {
        frame.add(addComponent());
        frame.add(addComponents());

        frame.pack();
    }

    //visibility for the frame is set to true
    private void setVisible()
    {
        frame.setVisible(true);
    }

    //main method to run all the other methods
    public static void main(String[] args)
    {
        Encrypt13 encrypt = new Encrypt13();
        encrypt.makeComponents();
        encrypt.makeLayout();
        encrypt.setVisible();
    }
}