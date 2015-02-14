package tetris3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Tetris extends JFrame
{

    JLabel statusbar;
    JMenu tetrisMenu = new JMenu("File");
    JMenuBar tetrisBarMenu = new JMenuBar();
    static JMenuItem tetrisCloseGame = new JMenuItem("Close Game");
    JMenuItem tetrisSoundOption = new JMenuItem("Sound On/Off");
    static ImageIcon backgroundImage = new ImageIcon("tetrisstart.png");
    static JLabel imageLabel = new JLabel(backgroundImage);

    public Tetris()
    {

        // adding a scoreboard at the bottom of the game
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        // Adding a menu to the game frame itself
        add(tetrisBarMenu, BorderLayout.NORTH);
        tetrisBarMenu.add(tetrisMenu);

        // adding an option to close game from in the game and adding action
        // listener
        tetrisMenu.add(tetrisCloseGame);
        tetrisCloseGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        // adding an option for sound while in game
        tetrisMenu.add(tetrisSoundOption);
        tetrisSoundOption.addActionListener(new ActionListener()
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
        Board board = new Board(this);
        add(board);
        board.start();

        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Method used to create the score keeper at bottom of the game
    public JLabel getStatusBar()
    {
        return statusbar;
    }

    public static void music() throws UnsupportedAudioFileException, Exception
    {
        // Program decides on which format to use based on the file chosen /
        // coded in
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

    public static void main(String[] args)
    {

        // Start Screen Initialized and Shown when program is run
        final JFrame startScreen = new JFrame();
        startScreen.setBounds(550, 200, 200, 375);
        startScreen.setResizable(false);
        // startScreen.setLayout(null);

        // Creating the Menu at the top of the frame
        JMenu file = new JMenu("File");
        JMenuBar barMenu = new JMenuBar();
        barMenu.setBounds(0, 0, 200, 25);

        // Creating option for a new game on menu and adding action listener
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Tetris game = new Tetris();
                game.setLocationRelativeTo(null);
                game.setVisible(true);
                startScreen.setVisible(false);
            }
        });

        // Creating and Adding Action Listener to Sound Option
        JMenuItem soundOption = new JMenuItem("Sound On/Off");
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

        // Action Listener to close game option
        tetrisCloseGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        // Adding everything to menu and frame
        startScreen.add(barMenu);
        startScreen.add(imageLabel);
        barMenu.add(file);
        file.add(newGame);
        file.add(soundOption);
        file.add(tetrisCloseGame);
        startScreen.setVisible(true);

    }
}