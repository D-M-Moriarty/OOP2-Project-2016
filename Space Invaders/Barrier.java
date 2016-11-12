import java.awt.*;

/**
 * This is an instantiable class called Barrier for creating a barrier entity.
 * It is a sub-class of GameComponent therefore it inherits all of its
 * attributes and abstract methods
 *
 * @author Darren Moriarty
 * created on 11/11/2016.
 *
 * @version 2.0
 */
public class Barrier extends GameComponent {

    //Class Attributes

    // Two dimensional array of BarrierBlock objects
    private BarrierBlock[][] barrierBlocks;

    /**
     * 5 argument constructor
     * @param topLeftXPos
     * @param topLeftYPos
     * @param width
     * @param height
     * @param color
     */
    public Barrier(int topLeftXPos, int topLeftYPos, int width, int height, Color color) {
        super(topLeftXPos, topLeftYPos, width, height, color);

        // Instantiating the array of barrierBlocks
        barrierBlocks = new BarrierBlock[5][6];

        // Setting the dimensions of each barrier block in the array with a nested for loops to
        // create a grid of block (5 x 6)
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                // Setting the dimensions of each block
                barrierBlocks[i][j] = new BarrierBlock(200, 400, 100, 50, Color.GREEN, true);
            }
        }

    }

    @Override
    public void setTopLeftXPos(int topLeftXPos) {

    }

    public String toString(){
        return "Barrier class is working";
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


    public void update(){

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRect(topLeftXPos, topLeftYPos, width, height);
        g.fillRect(topLeftXPos, topLeftYPos, width, height);
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
