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
    private final int DELTA_Y = 5;
    private boolean firing = false;

    /**
     *
     * @param topLeftXPos
     * @param topLeftYPos
     * @param width
     * @param height
     * @param color
     */
    public Bullet(int topLeftXPos, int topLeftYPos, int width, int height, Color color) {
        super(topLeftXPos, topLeftYPos, width, height, color);
        setOriginalTopLeftYPos(topLeftYPos);
    }

    /**
     * This sets the original Y position of the bullet entity from the top of the screen
     * @param topLeftYPos
     */
    public void setOriginalTopLeftYPos(int topLeftYPos) {
        this.originalTopLeftYPos = topLeftYPos;
    }

    public void isFiring(boolean fire){ firing = fire; }

    // This method fires the bullet by reducing the the y position by Delta_y each update
    public void fireBullet(){
        topLeftYPos -= DELTA_Y;
    }

    // This method removes a bullet from the ArrayList of bullets once its hit an enemy or passed the top of the screen
    public void removeBullet(){
        if(getTopLeftYPos() + height < 0){
            SpaceInvadersGUI.bullets.remove(0);
        }
    }

    @Override
    public void update(){
            fireBullet();
            removeBullet();
    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(Color.WHITE);//getColor();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRect(topLeftXPos, topLeftYPos, width, height);
        g.fillRect(topLeftXPos, topLeftYPos, width, height);

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
        return topLeftYPos;
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
