import java.awt.*;

/**
 * Created by Darren Moriarty on 12/11/2016.
 */
public class Player {

    private int x;
    private int y;
    private int r;

    private int dx;
    private int dy;
    private int speed;

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private int lives;

    public Player(){

        x = 400;
        y = 400;
        r = 5;

        dx = 0;
        dy = 0;
        speed = 5;

        lives = 3;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
        g.setStroke(new BasicStroke(3));


    }

    public void setLeft(boolean direction){
        left = direction;
    }

    public void setRight(boolean direction){
        right = direction;
    }

    public void update(){
        if(left){
            x --;
        }
        if(right){
            x ++;
        }

        x += dx;

        dx = 0;
    }
}
