import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

/**
 * Created by t00168162 on 09/11/2016.
 */
public class Tank extends JComponent {

    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    private static final int BARRELHEIGHT = 10;
    private static final int BARRELWIDTH = 10;
    private static final int BODYXPOS = 300;
    private static final int BODYYPOS = 800;
    private static final int BARRELXPOS = 335;
    private static final int BARRELYPOS = 790;
    private int bodyX = BODYXPOS;
    private int barrelX = BARRELXPOS;
    private Rectangle2D drawBody;
    private Rectangle2D drawBarrel;
    private Rectangle2D drawLine;

    public void paint(Graphics g) {

        Graphics2D graph2 = (Graphics2D)g;
        graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawBody = new Rectangle2D.Float(BODYXPOS, BODYYPOS, WIDTH, HEIGHT);

        drawBarrel = new Rectangle2D.Float(BARRELXPOS, BARRELYPOS, BARRELWIDTH, BARRELHEIGHT);

        drawLine = new Rectangle2D.Float(25, 900, 925, 10);

        graph2.setColor(Color.GREEN);
        graph2.fill(drawBody);

        graph2.fill(drawBarrel);
        graph2.setPaint(Color.GREEN);

        graph2.fill(drawLine);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            bodyX--;
            barrelX--;
        }

        if (key == KeyEvent.VK_RIGHT) {
            bodyX++;
            barrelX++;
        }

        if (key == KeyEvent.VK_SPACE) {

        }
    }

}
