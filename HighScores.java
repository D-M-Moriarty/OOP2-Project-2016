import javax.swing.*;
import java.awt.*;

/**
 * Created by Darren Moriarty on 24/11/2016.
 */
public class HighScores extends JPanel{

    private GameMain gameMain;
    private String highScoreText;
    private JTextArea textArea;

    // JPanel Constructor
    public HighScores(GameMain gameMain){
        // Calls the default constructor
        super();
        this.gameMain = gameMain;
        // Sets the size of the panel to the Width and Height constants
        setPreferredSize(new Dimension(SpaceInvadersGUI.WIDTH, SpaceInvadersGUI.HEIGHT));
        setBackground(Color.BLACK);

        gameMain.getHighScorers();


        Font textAreaFont = new Font("monospaced", Font.PLAIN,25);

        textArea = new JTextArea(15, 30);

        textArea.setText(String.format("%9s%12s\n","Name","Score"));

        textArea.setFont(textAreaFont);

        for (int i = gameMain.getHighScorersSize()-1; i >= 0; i--) {
            textArea.append(String.format("%-5d%-10s%5d\n",(gameMain.getHighScorersSize() - i) ,
                    gameMain.highScorers.get(i).getName().toString(),
                    gameMain.highScorers.get(i).getPlayerScore()));
        }

        add(textArea);


        setFocusable(true);
        //gets the focus
        requestFocus();
    }





}
