import java.awt.*;

/**
 * This is an instantiable class called Bullet for creating a bullet entity.
 * It is a sub-class of GameComponent therefore it inherits all of its
 * attributes and abstract methods
 *
 * @author Darren Moriarty
 * created on 11/11/2016.
 *
 * @version 2.0
 */
public class Bullet extends GameComponent {

    // Class Attributes

    // The initial Y coordinate of the entity
    private int originalTopLeftYPos;

    /* The difference between the initial y position and the new y position
        This is the amount of pixels the entity will move per second/update */
    private final int DELTA_Y = 3;

    /**
     *
     * @param topLeftXPos
     * @param topLeftYPos
     * @param width
     * @param height
     * @param color
     * @param originalTopLeftYPos The initial Y coordinate of the entity
     */
    public Bullet(int topLeftXPos, int topLeftYPos, int width, int height, Color color, int originalTopLeftYPos) {
        super(topLeftXPos, topLeftYPos, width, height, color);
        setOriginalTopLeftYPos(originalTopLeftYPos);
    }

    /**
     * This sets the original Y position of the bullet entity from the top of the screen
     * @param originalTopLeftYPos
     */
    public void setOriginalTopLeftYPos(int originalTopLeftYPos) {
        this.originalTopLeftYPos = originalTopLeftYPos;
    }

    @Override
    public void setTopLeftXPos(int topLeftXPos) {

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
    public void draw(Graphics2D g) {

    }

//    @Override
//    public void draw(Graphics g) {
//
//    }

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
