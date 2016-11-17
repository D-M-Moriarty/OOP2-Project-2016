import java.awt.*;

/**
 * This is an abstract class called GameComponent for creating different game entities
 *
 * @author Darren Moriarty
 * created on 11/11/2016.
 *
 * @version 2.0
 */

// This class is not instantiable
public abstract class GameComponent {

    //Class attributes are protected as they are only to be accessed subclasses of this class

    // The position of the x coordinate of this entity
    protected int topLeftXPos;
    // The position of the y coordinate of the is entity
    protected int topLeftYPos;
    // The width of this entity
    protected int width;
    // The height of this entity
    protected int height;
    // The colour of this entity
    protected Color color;

    /** 5 argument constructor method
     *
     * @param topLeftXPos value passed into the method
     * @param topLeftYPos value passed into the method
     * @param width value passed into the method
     * @param height value passed into the method
     * @param color value passed into the method
     *
     * this.width = width assigns the value of the argument to the class attribute
     */
    public GameComponent(int topLeftXPos, int topLeftYPos, int width, int height, Color color){
        setTopLeftXPos(topLeftXPos);
        setTopLeftYPos(topLeftYPos);
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    // List of abstract methods

    /** mutator method to set the top left X position
     * of the entity being created
     * THis is from the left of the screen towards th right
     @param topLeftXPos the top left corner*/
    public void setTopLeftXPos(int topLeftXPos) {
        this.topLeftXPos = topLeftXPos;
    }

    /**
     * mutator method to set the top left Y position
     * of the entity being created
     * This is from the top of the screen down
     *
     * @param topLeftYPos the top left corner
     */
    public void setTopLeftYPos(int topLeftYPos) {
        this.topLeftYPos = topLeftYPos;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public int getTopLeftXPos() {
        return this.topLeftXPos;
    }


    public int getTopLeftYPos() {
        return this.topLeftYPos;
    }


    public int getWidth() {
        return this.width;
    }


    public int getHeight() {
        return this.height;
    }


    public Color getColor() {
        return this.color;
    }

    /**
     * This method draws graphics to the screen
     * @param g
     */
    public abstract void draw(Graphics2D g);

    public abstract void update();


    /**
     *
     * @return a string to show that the class is working
     */
    public String toString(){
        return "Game Component is working";
    }

} // End of class
