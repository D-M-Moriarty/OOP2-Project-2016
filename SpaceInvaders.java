import javax.swing.*;
import java.awt.*;

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

        Barrier barrier = new Barrier();
        barrier.setLocation(500,500);

        //add(barrier);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SpaceInvaders();
        new Tank();
    }


}
