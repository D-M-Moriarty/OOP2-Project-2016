import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

/**
 * Created by t00168162 on 09/11/2016.
 */
public class Tank extends JComponent implements KeyListener{

    //THIS CONSTANT IS FOR MY HOME SCREEN HEIGHT
    private static final int HOME_HEIGHT_REDUCTION = 225;//0 alternate between 300 and zero

    private static final int BODY_WIDTH = 80;
    private static final int BODY_HEIGHT = 40;
    private static final int BARREL_HEIGHT = 10;
    private static final int BARREL_WIDTH = 10;
    private static final int BODY_X_POS = 300;
    private static final int BODY_Y_POS = 825 - HOME_HEIGHT_REDUCTION;
    private static final int BARREL_X_POS = 335;
    private static final int BARREL_Y_POS = 815 - HOME_HEIGHT_REDUCTION;
    private int bodyX = BODY_X_POS;
    private int barrelX = BARREL_X_POS;
    private Rectangle2D drawBody;
    private Rectangle2D drawBarrel;
    private Rectangle2D drawLine;
    private int[] x = {20,80,100,100,75,75,70,30,25,25,0,0,20};
    private int[] y = {0,0,20,50,50,42,35,35,42,50,50,20,0};

    //Barrier barrier =  new Barrier();

    Rectangle rect;

//    public void init(){
//        rect = new Rectangle(0,0,50,50);
//    }

    public void paint(Graphics g) {

//        Graphics2D g2 = (Graphics2D)g;
//        g2.fill(rect);

        //creating graphics object
        Graphics2D tank = (Graphics2D)g;

        //smooting the edges
        tank.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //drawing the body of the tank
        drawBody = new Rectangle2D.Float(bodyX, BODY_Y_POS, BODY_WIDTH, BODY_HEIGHT);

        //drawing the barrel of the tank
        drawBarrel = new Rectangle2D.Float(barrelX, BARREL_Y_POS, BARREL_WIDTH, BARREL_HEIGHT);

        //drawing the line at the bottom of the screen
        drawLine = new Rectangle2D.Float(25, 650, 925, 10);

        //setting the colour to green
        tank.setColor(Color.GREEN);

        //drawing the shapes
        tank.fill(drawBody);
        tank.fill(drawBarrel);
        tank.fill(drawLine);


        //Adding the keyListener
//        setFocusable(true);
        addKeyListener(this);


        //add(new Barrier());

        //CREATING a graphic object to draw the barrier
        Graphics2D barrierG = (Graphics2D)g;

        barrierG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < x.length; i++)
            x[i] += 100;

        for (int i = 0; i < y.length; i++)
            y[i] += 500;

        Polygon barrier = new Polygon(x, y , 13);

        barrierG.setColor(Color.GREEN);
        barrierG.fill(barrier);
        // graph.drawPolygon(x, y , 13);

        //CREATING a graphic object to draw the barrier 2
        Graphics2D barrierG2 = (Graphics2D)g;

        barrierG2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < x.length; i++){
            x[i] += 300;
        }

        barrierG2.setColor(Color.GREEN);
        Polygon barrier2 = new Polygon(x, y , 13);
        barrierG2.fill(barrier2);

        //CREATING a graphic object to draw the barrier 3
        Graphics2D barrierG3 = (Graphics2D)g;

        barrierG3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < x.length; i++){
            x[i] += 650;
        }

        barrierG3.setColor(Color.GREEN);
        Polygon barrier3 = new Polygon(x, y , 13);
        barrierG3.fill(barrier3);


    }


        /**
         * Invoked when a key has been pressed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key pressed event.
         */
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                bodyX -= 1;
                barrelX -= 1;
                System.out.println("working");
            }

            if (key == KeyEvent.VK_RIGHT) {
                bodyX++;
                barrelX++;
                rect.setLocation(rect.x+2,rect.y);
                System.out.println("working on right");
            }

            if (key == KeyEvent.VK_SPACE) {

            }

            repaint();

        }

        /**
         * Invoked when a key has been typed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key typed event.
         */
        @Override
        public void keyTyped(KeyEvent e){

        }


        /**
         * Invoked when a key has been released.
         * See the class description for {@link KeyEvent} for a definition of
         * a key released event.
         */
        @Override
        public void keyReleased(KeyEvent e){

        }



}
