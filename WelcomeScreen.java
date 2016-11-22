import javax.swing.*;

/**
 * Created by Darren Moriarty on 14/11/2016.
 */
public class WelcomeScreen extends JFrame{

    public WelcomeScreen(){
        super("This is the welcome screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,0);

        // Setting the content pane to the SpaceInvadersGUI
        //setContentPane(new SpaceInvadersGUI());

        // This sets the size of the JFrame to whatever the size of the Component inside it is
        pack();
        setVisible(true);
    }
}
