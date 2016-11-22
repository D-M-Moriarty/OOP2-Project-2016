import javax.swing.*;
import java.awt.*;

/**
 * This is an instantiable class called Tank for creating a Tank entity.
 * It is a sub-class of GameComponent therefore it inherits all of its
 * attributes and abstract methods
 *
 * @author Darren Moriarty
 * created on 11/11/2016.
 *
 * @version 2.0
 */
public class Tank extends GameComponent{


    // class attributes are made private so that they can not be directly accessed outside this class

    // Boolean to see which direction to move thev entity
    private boolean left;
    private boolean right;
    // This is the initial amount of lives of the Tank entity
    private int livesLeft;
    /* The difference between the initial x position and the new x position
        This is the amount of pixels the entity will move per second/update */
    private int deltaX;
    // The initial speed to travel horizontally
    private int horizontalSpeed;

//    public Tank(){
//        this(,,,,,);
//    }

    /**
     * 6 argument constructor method
     *
     * @param topLeftXPos The initial x coordinate of the instantiated Tank entity object
     * @param topLeftYPos The initial y coordinate of the instantiated Tank entity object
     * @param width The initial widht of the entity
     * @param height The initial height of the Tank entity
     * @param color The initial colour of the Tank entity
     * @param livesLeft The initial amount of lives the Tank entity has
     * @param horizontalSpeed The initial horizontal speed of the Tank entity
     */
    public Tank(int topLeftXPos, int topLeftYPos, int width, int height, Color color, int livesLeft, int horizontalSpeed) {
        super(topLeftXPos, topLeftYPos, width, height, color);
        setLivesLeft(livesLeft);
        setHorizontalSpeed(horizontalSpeed);
    }

    /**
     * This sets the amount of the lives for the entity
     * @param livesLeft is the amount of lives
     */
    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    /**
     * This returns the amount of lives the entity has remaining
     * @return the amount of lives left
     */
    public int getLivesLeft(){
        return livesLeft;
    }

    public void setLeft(boolean direction){
        left = direction;
    }

    public void setRight(boolean direction){
        right = direction;
    }


    public void setHorizontalSpeed(int horizontalSpeed) {
        this.horizontalSpeed = horizontalSpeed;
    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(getColor());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRect(getTopLeftXPos(), getTopLeftYPos(), getWidth(), getHeight());
        g.fillRect(getTopLeftXPos(), getTopLeftYPos(), getWidth(), getHeight());

    }

    // This method decides what to do every time the screen refreshes
    @Override
    public void update(){

        // If the left attribute has the value of true
        if(left){
            // The next position of deltaX is the value of the horizontal speed ie. 5 pixels to the left
            deltaX = horizontalSpeed;
            // The original value of topLeftXPos is now the original value minus the next positions value deltaX
            topLeftXPos -= deltaX;
        }
        // If the right attribute has the value of true
        if(right){
            // The next position of x is the value of the horizontal speed ie. 5 pixels to the right
            deltaX  = horizontalSpeed;
            // The original value of x is now the original value plus the next positions value
            topLeftXPos += deltaX;
        }

        // This insures that the entity doesn't travel outside the green line at the bottom of the screen
        if(topLeftXPos > 1000 - width - 25){
            topLeftXPos = 1000 - width - 25;
        }
        if(topLeftXPos < 25){
            topLeftXPos = 25;
        }

        // Resetting deltaX to 0
        deltaX = 0;

        for (int k = 0; k < SpaceInvadersGUI.alienBullets.size(); k++) {
            AlienBullet bullet = SpaceInvadersGUI.alienBullets.get(k);


            Rectangle bulletRect = new Rectangle(bullet.getTopLeftXPos(),
                    bullet.getTopLeftYPos(),bullet.getWidth(),bullet.getHeight());

            Rectangle alienRect = new Rectangle(this.getTopLeftXPos(),
                    this.getTopLeftYPos(), this.getWidth(), this.getHeight());

            if (bulletRect.intersects(alienRect)) {
                System.out.println(getLivesLeft());

                setLivesLeft(getLivesLeft() - 1);
                SpaceInvadersGUI.tankLife1.setColor(Color.BLACK);

                if(getLivesLeft() == 1){
                    SpaceInvadersGUI.tankLife2.setColor(Color.BLACK);
                }

                //SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() + 10);
                SpaceInvadersGUI.alienBullets.remove(bullet);

                if (getLivesLeft() < 1){
                    SpaceInvadersGUI.tankLife3.setColor(Color.BLACK);
                    this.setTopLeftXPos(-100);
                    this.setTopLeftYPos(-100);
                    this.setWidth(-100);
                    this.setHeight(-100);
                    JOptionPane.showMessageDialog(null, "Your tank has been destroyed");
                    try {
                        Thread.sleep(9999);
                    }catch (Exception e){e.printStackTrace();}

                    //System.exit(0);
                }



            }



        }

    }

    public String toString(){
        return "Tank class is working";
    }




}
