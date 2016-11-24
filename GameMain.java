import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * This is the main JFrame class with the main method to run the game
 *
 * @author Darren Moriarty
 * Created on 11/11/2016.
 *
 * This class inherits from JFrame
 */
public class GameMain extends JFrame{

    private CardLayout cardLayout = new CardLayout();
    private JPanel welcomeGUI = new WelcomeGUI();
    private JPanel contPanel = new JPanel();

    private SpaceInvadersGUI spaceInvadersGUI;

    private Container contentPane;
    private ImageIcon imageIcon = new ImageIcon("images/1280x960-space-invaders-press-start-wallpaper.jpg");
    private JButton startGame = new JButton(imageIcon);

    private ImageIcon imageIcon2 = new ImageIcon("images/high-scores.png");
    private JButton startGame2 = new JButton(imageIcon2);

    JMenuBar  jmenuBar;
    JMenu jmenu;
    JMenuItem jmenuItem;


    private LinkedList<Player> highScorers =  new LinkedList<Player>();


    // JFrame GUI constructor method
    public GameMain(){
        // Super calls the JFrame constructor and sets the title
        super("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,0);

        jmenuBar = new JMenuBar();
        jmenu = new JMenu("Info");
        jmenuItem = new JMenuItem("History");

        jmenu.add(jmenuItem);
        jmenuBar.add(jmenu);
        setJMenuBar(jmenuBar);

        jmenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Space Invaders (Japanese: スペースインベーダー Hepburn: Supēsu Inbēdā?)\n" +
                        "is an arcade video game created by Tomohiro Nishikado and released in 1978.\n" +
                        "It was originally manufactured and sold by Taito in Japan, and was later licensed\n" +
                "for production in the United States by the Midway division of Bally. Space Invaders is one of\n" +
                        "the earliest shooting games and the aim is to defeat waves of aliens with a laser\n" +
                        "cannon to earn as many points as possible. In designing the game, Nishikado drew\n" +
                        "inspiration from popular media: Breakout, The War of the Worlds, and Star Wars.\n" +
                                "To complete it, he had to design custom hardware and development tools.\n" +
                        "\nIt was one of the forerunners of modern video gaming and helped expand the\n" +
                        "video game industry from a novelty to a global industry (see golden age of video arcade games).\n" +
                        "When first released, Space Invaders was very successful.\n");
            }
        });




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

    public void addToHighScorers(Player highScorers){
        this.highScorers.add(highScorers);
    }

    public int getHighScorersSize(){

        return highScorers.size();
    }

    public void getHighScorers(){

        for (Player player: highScorers) {
            System.out.println(player);
        }
    }

    public void sortHighScorers(){

        for (int i = 0; i < highScorers.size(); i++) {



        }

    }

    public void startGame() {
        spaceInvadersGUI = new SpaceInvadersGUI(this);
        jmenuBar.setVisible(false);
        pack();
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
