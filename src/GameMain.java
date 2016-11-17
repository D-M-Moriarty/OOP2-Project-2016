import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the main JFrame class with the main method to run the game
 *
 * @author Darren Moriarty
 * Created on 11/11/2016.
 *
 * This class inherits from JFrame
 */
public class GameMain extends JFrame{

    CardLayout cardLayout = new CardLayout();
    JPanel spaceGui =  new SpaceInvadersGUI();
    JPanel welcomeGUI = new WelcomeGUI();
    JPanel contPanel = new JPanel();
    JButton startGame = new JButton("Start Game");
    Container contentPane;


    // JFrame GUI constructor method
    public GameMain(){
        // Super calls the JFrame constructor and sets the title
        super("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,0);

        setContentPane(new SpaceInvadersGUI());

//        contentPane.add(startGame);
//
//        add(contentPane);
//
//        contentPane.setVisible(true);

        // This sets the size of the JFrame to whatever the size of the Component inside it is
        pack();
        setVisible(true);




        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                contentPane.add(spaceGui);
                System.out.println("new panel created");//for debugging purposes
                validate();
                setVisible(true);
            }
        });

        //        contPanel.setLayout(cardLayout);
//        welcomeGUI.add(startGame);
//
//        contPanel.add(spaceGui, "2");
//        contPanel.add(welcomeGUI, "1");
//
//        setContentPane(contPanel);
//
//        cardLayout.show(contPanel, "2");



        // Setting the content pane to the SpaceInvadersGUI
        //setContentPane(new SpaceInvadersGUI());



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
