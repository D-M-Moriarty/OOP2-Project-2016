import javax.swing.*;

/**
 * This is the main JFrame class with the main method to run the game
 *
 * @author Darren Moriarty
 * Created on 11/11/2016.
 *
 * This class inherits from JFrame
 */
public class GameMain extends JFrame{

    // JFrame GUI constructor method
    public GameMain(){
        // Super calls the JFrame constructor and sets the title
        super("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,0);

        // Setting the content pane to the SpaceInvadersGUI
        setContentPane(new SpaceInvadersGUI());

       // setContentPane(new WelcomeGUI());

        // This sets the size of the JFrame to whatever the size of the Component inside it is
        pack();
        setVisible(true);

        //Chaninging the window closing
//        addWindowListener(
//                new WindowAdapter(){
//                    public void windowClosing(WindowEvent e){
//                        int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit the game?");
//
//                        if(option == JOptionPane.YES_OPTION){
//                            setDefaultCloseOperation(EXIT_ON_CLOSE);
//                        }else{
//                            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//                        }
//                    }//end windowClosing
//
//                    public void windowIconified(WindowEvent e){
//                        JOptionPane.showMessageDialog(null,"Minimising the window");
//                    }
//
//                    public void windowDeiconified(WindowEvent e){
//                        JOptionPane.showMessageDialog(null,"Restoring the window");
//                    }
//                });


    }


    // main method creates a new JFrame called GameMain
    public static void main(String[] args) {
        new GameMain();
    }
}
