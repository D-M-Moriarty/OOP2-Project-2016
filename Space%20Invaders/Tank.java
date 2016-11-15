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
        g.drawRect(topLeftXPos, topLeftYPos, width, height);
        g.fillRect(topLeftXPos, topLeftYPos, width, height);

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
    }

    public String toString(){
        return "Tank class is working";
    }



    @Override
    public void setTopLeftXPos(int topLeftXPos) {
        this.topLeftXPos = topLeftXPos;
    }

    @Override
    public void setTopLeftYPos(int topLeftYPos) {

    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public int getTopLeftXPos() {
        return 0;
    }

    @Override
    public int getTopLeftYPos() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }


    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void MoveDown() {

    }

}
