import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;

/**
 * Created by Darren Moriarty on 24/11/2016.
 */
public class HighScores extends JPanel{

    private GameMain gameMain;
    private String highScoreText;

    // JPanel Constructor
    public HighScores(GameMain gameMain){
        // Calls the default constructor
        super();
        this.gameMain = gameMain;
        // Sets the size of the panel to the Width and Height constants
        setPreferredSize(new Dimension(SpaceInvadersGUI.WIDTH, SpaceInvadersGUI.HEIGHT));
        setBackground(Color.BLACK);

        gameMain.getHighScorers();

        for (int i = 0; i < gameMain.highScorers.size(); i++) {
            System.out.println("Score: \n" + gameMain.highScorers.get(i));
        }

        // create a JEditorPane
        JEditorPane jEditorPane = new JEditorPane();

        // make it read-only
        jEditorPane.setEditable(false);

        // add a HTMLEditorKit to the editor pane
        HTMLEditorKit kit = new HTMLEditorKit();
        jEditorPane.setEditorKit(kit);

        // now add it to a scroll pane
        JScrollPane scrollPane = new JScrollPane(jEditorPane);

        // add some styles to the html
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
        styleSheet.addRule("h1 {color: blue;}");
        styleSheet.addRule("h2 {color: #ff0000;}");
        styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");

        // create a document, set it on the jeditorpane, then add the html
        Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);

        System.out.println("the link size is " + gameMain.getHighScorersSize());

        for (int i = 0; i < gameMain.highScorers.size(); i++) {
            highScoreText += "Score:" + gameMain.highScorers.get(i);
        }
        jEditorPane.setText(highScoreText);


        add(jEditorPane);

        setFocusable(true);
        //gets the focus
        requestFocus();
    }





}
