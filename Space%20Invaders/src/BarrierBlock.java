import java.awt.*;

/**
 * This is an instantiable class called BarrierBlock for creating individual barrier blocks entities.
 * It is a sub-class of GameComponent therefore it inherits all of its
 * attributes and abstract methods
 *
 * @author Darren Moriarty
 * created on 11/11/2016.
 *
 * @version 2.0
 */
public class BarrierBlock extends GameComponent {

    // class attributes are made private so that they can not be directly accessed outside this class

    // Boolean attribute to signify whether this entity is destroyed or not
    private boolean destroyed;

    /**
     * 6 argument contructor method
     *
     * @param topLeftXPos
     * @param topLeftYPos
     * @param width
     * @param height
     * @param color
     * @param destroyed The initial value of destroyed
     */
    public BarrierBlock(int topLeftXPos, int topLeftYPos, int width, int height, Color color, boolean destroyed) {
        super(topLeftXPos, topLeftYPos, width, height, color);
        setDestroyed(destroyed);
    }

    /**
     * This sets the value of destroyed
     * @param destroyed
     */
    private void setDestroyed(boolean destroyed){
        this.destroyed = destroyed;
    }

    /**
     * This returns the value of destroyed
     * @return
     */
    private boolean isDestroyed() {
        return destroyed;
    }

    public String toString(){
        return "BarrierBlock class is working";
    }

    @Override
    public void setTopLeftYPos(int topLeftYPos) {

    }

    @Override
    public void setTopLeftXPos(int topLeftXPos) {

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

        g.setColor(getColor());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRect(topLeftXPos, topLeftYPos, width, height);
        g.fillRect(topLeftXPos, topLeftYPos, width, height);

    }

    @Override
    public void update() {

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
