import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by t00168162 on 09/11/2016.
 */
public class SpaceInvaders extends JFrame implements KeyListener{



    Tank tank = new Tank();

    public SpaceInvaders(){

        super("Space Invaders");
        setSize(1000,1000);
        setLocation(200,0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container cPane = getContentPane();

        //cPane.setBackground(Color.BLACK);


        add(tank);
        //setFocusable(true);
        addKeyListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SpaceInvaders();
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            tank.moveLeft();
            System.out.println("working");
        }

        if (key == KeyEvent.VK_RIGHT) {
            tank.moveRight();
            System.out.println("working on right");
        }

        if (key == KeyEvent.VK_SPACE) {
            tank.shootBullet();
        }

        tank.repaint();

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

//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_SPACE) {
//            tank.shootBullet();
//        }
//
//        tank.repaint();
    }


}
