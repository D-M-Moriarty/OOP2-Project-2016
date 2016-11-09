import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Created by t00168162 on 09/11/2016.
 */
public class SpaceInvaders extends JFrame{

    public SpaceInvaders(){

        super("Space Invaders");
        setSize(1000,1000);
        setLocation(200,0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container cPane = getContentPane();

        cPane.setBackground(Color.BLACK);

        add(new Tank());

        setVisible(true);
    }

    public static void main(String[] args) {
        new SpaceInvaders();
    }

    private class DrawStuff extends JComponent{
        public void paint(Graphics g){

            Graphics2D graph2 = (Graphics2D)g;
            graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Shape drawBody = new Rectangle2D.Float(300, 300, 80, 40);
            Shape drawBarrel = new Rectangle2D.Float(335, 290, 10, 10);
            graph2.setColor(Color.GREEN);
            graph2.fill(drawBody);
            graph2.fill(drawBarrel);
            graph2.setPaint(Color.BLACK);
        }

    }


}
