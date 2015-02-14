
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;
/**
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2013 Written: October 14, 2013 Tetris
 *          Game
 * 
 * 
 * 
 */
public class Tetris extends Canvas implements Runnable, KeyListener
{    
    // Width is set to 400
    public static final int WIDTH = 400;

    // Height is set to 400
    public static final int HEIGHT = 425;
    
    public static void main(String[] args) throws FileNotFoundException,
            Exception, IOException
    {
        /**
         * Setting up JFrame attributes
         */
        // Initialize the JFrame and title
        final JFrame frame = new JFrame("Tetris Game");

        // Sets JFrame width and height
        frame.setSize(WIDTH, HEIGHT);

        // Sets closing operation for JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets Location of window to middle of screen
        frame.setLocationRelativeTo(null);

        // Does not allow user to resize frame
        frame.setResizable(false);

        // Sets Layout position to null
        frame.setLayout(null);

        /**
         * Adding JMenuBar to frame, and JMenu to bar, and JMenuItems, to JMenu
         */

        // sets up JMenuBar for JFrame
        JMenuBar barMenu = new JMenuBar();

        // Sets the menu dimensions
        barMenu.setBounds(0, 0, WIDTH, 25);

        // Creating File drop down for JMenuBar
        JMenu file = new JMenu("File");

        // Sets bounds of File drop down menu
        file.setBounds(0, 0, 45, 25);

        // Creates new Item on the JMenu
        JMenuItem newGame = new JMenuItem("New Game");
        // Adding action listener to JMenu item NewGame
        newGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Starting New Game");
            }
        });
       
        // Creates new Item on the JMenu
        JMenuItem highScore = new JMenuItem("Highscore");
        // Adding action listener to JMenu item NewGame
        highScore.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Sets Highscore to 0
                int highScores = 0;

                // Sets new frame to view Highscores
                // Set to final to allow disposal after usage
                final JFrame highScoreFrame = new JFrame("High Score");

                // Sets highScoreFrame size
                highScoreFrame.setSize(200, 150);

                // Sets highScoreFrame layout to null
                highScoreFrame.setLayout(null);

                // Sets highScoreFrame location to middle of screen
                highScoreFrame.setLocationRelativeTo(null);

                // Create lable to show highscore
                JLabel bestScore = new JLabel("High Score: " + highScores);

                // set lable bounds
                bestScore.setBounds(45, 0, 200, 50);

                // Jbutton created to exit HighScore window
                JButton highScoreButton = new JButton("Exit");

                // Setting size to button
                highScoreButton.setBounds(45, 75, 100, 30);

                // Add actionListener to button
                highScoreButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        // Disposes highScoreFrame after highScoreButton is
                        // clicked
                        highScoreFrame.dispose();
                    }
                });

                // Add highscore to highScoreFrame
                highScoreFrame.add(bestScore);

                // Add button to highScoreFrame
                highScoreFrame.add(highScoreButton);

                // Does not allow highScoreFrame to be resizeable
                highScoreFrame.setResizable(false);

                // Sets highScoreFrame to visible
                highScoreFrame.setVisible(true);
            }
        });

        // Creates Sound option on JMenu
        JMenuItem soundOption = new JMenuItem("Sound On");

        // Adding action listener to JMenu item Sound
        soundOption.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Sound On");

                // Try/Catch loop to collect errors caused by JMF

                try
                {
                    music();
                }
                catch (UnsupportedAudioFileException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                catch (Exception e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        
        // Creates new Item on the JMenu
        JMenuItem closeGame = new JMenuItem("Exit");
        // Adding action listener to JMenu item NewGame
        closeGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Exiting Game.");
                System.exit(0);
            }
        });

        /**
         * Creates Tetris main window and adds things to frames
         */

        // Creates tetris main window
        Tetris tetrisMain = new Tetris();

        // Sets the bounds to tetrisMain
        tetrisMain.setBounds(0, 25, WIDTH, HEIGHT - 25);

        // Adds tetris to frame
        frame.add(tetrisMain);

        /**
         * Adding in Menu options to JFrame
         */

        // Adds the JMenubar to the frame
        frame.add(barMenu);

        // Adds the file menu to barMenu to frame
        barMenu.add(file);

        // Adds "New Game" to JMenu
        file.add(newGame);

        // Adds "Highscore" to JMenu
        file.add(highScore);

        // Adds "Sound On/Off" to JMenu
        file.add(soundOption);

        // Adds "Exit" to JMenu
        file.add(closeGame);

        // Sets the visibility to true
        frame.setVisible(true);

        // starts tetrisMain
        tetrisMain.start();
    }

    // Method that starts threads
    public void start()
    {
        // New thread t
        Thread t = new Thread(this);

        // Priority of thread set to max
        t.setPriority(Thread.MAX_PRIORITY);

        // Starting thread t
        t.start();
    }

    public void run()
    {
        // boolean running is set to true
        boolean running = true;

        // If boolean is running
        while (running)
        {
            // Update is run
            update();

            // Prevents flashing frame / graphics
            BufferStrategy buf = getBufferStrategy();

            if (buf == null)
            {
                createBufferStrategy(3);
                continue;
            }

            // Graphics2D is set
            Graphics2D g = (Graphics2D) buf.getDrawGraphics();

            // Rendering graphics 2D
            render(g);

            // Buf is set to show
            buf.show();
        }
    }   

    public void render(Graphics2D g)
    {        
        // Sets background to black
        g.setColor(Color.BLACK);

        // Sets rectangle attributes
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Sets font color to white
        g.setColor(Color.WHITE);

        // Sets font to Arial and size to 20
        g.setFont(new Font("Arial", Font.PLAIN, 20));

        // Sets Tetris Text location
        g.drawString("Tetris", 180, 170);
    }

    // updates current processes in game
    public void update()
    {

    }

    public static void music() throws UnsupportedAudioFileException, Exception
    {
        // Program decides on which format to use based on the file chosen / coded in
        Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
        Format input2 = new AudioFormat(AudioFormat.MPEG);
        Format output = new AudioFormat(AudioFormat.LINEAR);
        PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder",
                new Format[]
                { input1, input2 }, new Format[]
                { output }, PlugInManager.CODEC);
        // Try loop to catch errors caused by JMF
        try
        {
            Player player = Manager.createPlayer(new MediaLocator(new File(
                    "Tetris-Theme-Original.wav").toURI().toURL()));
            player.start();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Key event method for when Keys are pressed
    public void keyPressed(KeyEvent e)
    {

    }

    // Key method for knowing which key is pressed
    public void keyTyped(KeyEvent e)
    {

    }

    // Key method for knowing when the buttons are released
    public void keyReleased(KeyEvent e)
    {

    }
}