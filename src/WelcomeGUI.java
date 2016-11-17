import javax.swing.*;
import java.awt.*;

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
    //JButton startGame = new JButton("Start Game");

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


        //to make sure the SpaceInvadersGUI can be focused on
        setFocusable(true);
        //gets the focus
        requestFocus();
    }

//    private class ButtonHandler implements ActionListener {
//        public void actionPerformed(ActionEvent e){
//            System.out.println("Button handler is working");
//
//            setVisible(false);
//
//        }
//    }



}
