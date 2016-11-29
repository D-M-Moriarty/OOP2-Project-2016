import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
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

    //private CardLayout cardLayout = new CardLayout();
    private JPanel welcomeGUI = new WelcomeGUI();
    //private JPanel contPanel = new JPanel();

    private SpaceInvadersGUI spaceInvadersGUI;
    private HighScores highscores;

    //private Container contentPane;
    private ImageIcon imageIcon = new ImageIcon("images/1280x960-space-invaders-press-start-wallpaper.jpg");
    private JButton startGame = new JButton(imageIcon);

    private ImageIcon imageIcon2 = new ImageIcon("images/high-scores.png");
    private JButton startGame2 = new JButton(imageIcon2);

    private JMenuBar  jmenuBar;
    private JMenu jmenu;
    private JMenu jmenuBack;
    private JMenuItem itemBack;
    private JMenuItem jmenuItem;


    public LinkedList<Player> highScorers =  new LinkedList<Player>();


    // JFrame GUI constructor method
    public GameMain(){
        // Super calls the JFrame constructor and sets the title
        super("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,0);

        loadScores();

        jmenuBar = new JMenuBar();
        jmenu = new JMenu("Info");
        jmenuBack = new JMenu(("Back"));
        itemBack = new JMenuItem("Back");
        jmenuItem = new JMenuItem("History");

        jmenu.add(jmenuItem);
        jmenuBack.add(itemBack);
        jmenuBar.add(jmenu);
        jmenuBar.add(jmenuBack);
        setJMenuBar(jmenuBar);

        jmenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Space Invaders " +
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

        itemBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeContentPane2();
            }
        });




//        contPanel.setLayout(cardLayout);
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
                viewHighScores();
            }
        });

        getContentPane().setFocusable(true);
        getContentPane().requestFocusInWindow();
        // This sets the size of the JFrame to whatever the size of the Component inside it is
        pack();
        setVisible(true);

        //Changing the window closing
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit the game?");

                        if(option == JOptionPane.YES_OPTION){
                            try{
                                saveScores();
                                System.out.println("The save worked");
                            }
                            catch (IOException f){
                                f.printStackTrace();
                            }

                            setDefaultCloseOperation(EXIT_ON_CLOSE);
                        }else{
                            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                        }
                    }//end windowClosing

                    public void windowIconified(WindowEvent e){
                        JOptionPane.showMessageDialog(null,"Minimising the window");
                    }

                    public void windowDeiconified(WindowEvent e){
                        JOptionPane.showMessageDialog(null,"Restoring the window");
                    }
                });


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

        int smallest;
        for (int i = 0; i < highScorers.size(); i++) {
            smallest = i;
            for (int j = i + 1; j < highScorers.size(); j++) {
                if (highScorers.get(j).getPlayerScore() < highScorers.get(smallest).getPlayerScore()) {
                    smallest = j;

                }
            }
            if (smallest != i) {
                final int tempScore = highScorers.get(i).getPlayerScore();
                final String tempName = highScorers.get(i).getName();
                highScorers.get(i).setPlayerScore(highScorers.get(smallest).getPlayerScore());
                highScorers.get(i).setName(highScorers.get(smallest).getName());
                highScorers.get(smallest).setPlayerScore(tempScore);
                highScorers.get(smallest).setName(tempName);
            }

        }

        for (Player player: highScorers) {
            System.out.println(player.getName() + " has a score of " + player.getPlayerScore());
        }

    }

    public void removeFirstLink(){
        highScorers.remove(0);
    }

    public void startGame() {
        spaceInvadersGUI = new SpaceInvadersGUI(this);
        jmenuBar.setVisible(false);
        changeScreen(spaceInvadersGUI);
        pack();
    }

    public void viewHighScores() {
        highscores = new HighScores(this);
        changeScreen(highscores);
        pack();
    }

    public void changeContentPane2() {
        changeScreen(welcomeGUI);
        jmenuBar.setVisible(true);
    }

    private void changeScreen(JPanel screen) {
        setContentPane(screen);
        screen.requestFocusInWindow();
    }

    public void saveScores() throws IOException {
            ObjectOutputStream oob = new ObjectOutputStream(new FileOutputStream("HighScores.dat"));
            oob.writeObject(highScorers);
            oob.close();
    }

    public void loadScores() {
        try{
            ObjectInputStream oobIn = new ObjectInputStream(new FileInputStream("HighScores.dat"));
             highScorers = (LinkedList<Player>) oobIn.readObject();
            oobIn.close();
        }
        catch (FileNotFoundException e){ e.printStackTrace(); }
        catch (IOException e){ e.printStackTrace(); }
        catch (Exception e){ e.printStackTrace(); }

    }

    // main method creates a new JFrame called GameMain
    public static void main(String[] args) {
        new GameMain();
    }
}
