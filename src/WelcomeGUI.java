import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * This is the JPanel class which is just a flat container for holding components
 *
 * @author Darren Moriarty
 * Created on 11/11/2016.
 *
 * This class inherits from JPanel
 * It Interfaces with Runnable and KeyListener
 */
public class WelcomeGUI extends JPanel {


    // Class Attributes

    // width of the panel
    public static final int WIDTH = 1000;
    // height of the panel
    public static final int HEIGHT = 700;

    // JPanel Constructor
    public WelcomeGUI(){
        // Calls the default constructor
        super();
        // Sets the size of the panel to the Widht and Height constants
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        //startGame.setLocation(400,400);

//        add(startGame);
//
//        startGame.addActionListener(new ButtonHandler());


        //to make sure the SpaceInvadersGUI can be focused on
        setFocusable(true);
        //gets the focus
        requestFocus();
    }

//    private class ButtonHandler implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//            System.out.println("Button handler is working");
//
//            WelcomeGUI.this.setVisible(false);
//        }
//    }



}
