import javax.swing.*;
import javax.swing.border.LineBorder;
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
    JPanel welcomeGUI = new WelcomeGUI();
    JPanel contPanel = new JPanel();

    SpaceInvadersGUI spaceInvadersGUI;

    Container contentPane;
    ImageIcon imageIcon = new ImageIcon("images/1280x960-space-invaders-press-start-wallpaper.jpg");
    JButton startGame = new JButton(imageIcon);

    ImageIcon imageIcon2 = new ImageIcon("images/high-scores.png");
    JButton startGame2 = new JButton(imageIcon2);


    // JFrame GUI constructor method
    public GameMain(){
        // Super calls the JFrame constructor and sets the title
        super("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,0);

        contPanel.setLayout(cardLayout);
        welcomeGUI.add(startGame);
        welcomeGUI.add(startGame2);

        startGame.setBackground(Color.black);
        startGame.setBorder(new LineBorder(Color.BLACK));
        startGame2.setBackground(Color.BLACK);
        startGame2.setBorder(new LineBorder(Color.BLACK));

        setContentPane(welcomeGUI);

        // button to load the game
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();

                System.out.println("new panel created");//for debugging purposes
                validate();
                setVisible(true);
            }
        });

        // Button for loading the high scores
        startGame2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().setFocusable(true);
        getContentPane().requestFocusInWindow();
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

    public void startGame() {
        spaceInvadersGUI = new SpaceInvadersGUI(this);

        changeScreen(spaceInvadersGUI);
    }

    public void changeContentPane2() {
        changeScreen(welcomeGUI);
    }

    private void changeScreen(JPanel screen) {
        setContentPane(screen);
        screen.requestFocusInWindow();
    }

    public void gameOver() {
        System.out.println("game over");
        welcomeGUI.setVisible(true);
        spaceInvadersGUI.isRunning = false;
        this.dispose();
    }

    // main method creates a new JFrame called GameMain
    public static void main(String[] args) {
        new GameMain();
    }
}
