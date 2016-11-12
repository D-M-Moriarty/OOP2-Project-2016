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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {

                // Setting the dimensions of each block
                // The position of each block is the width of the block wider relative to the block beside it
                barrierBlocks[i][j] = new BarrierBlock(this.topLeftXPos + (this.width * j), this.topLeftYPos
                        + (this.height * i), this.width, this.height, this.color, true);
            }
        }


    }

    // This method decides what to do every time the screen refreshes
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {

        // Setting the dimensions of each barrier block in the array with a nested for loops to
        // create a grid of block (5 x 6)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {

                //  Drawing the array of blocks to the screen

                g.setColor(getColor());
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g.drawRect(barrierBlocks[i][j].topLeftXPos,
                           barrierBlocks[i][j].topLeftYPos,
                           barrierBlocks[i][j].width,
                           barrierBlocks[i][j].height);

                g.fillRect(barrierBlocks[i][j].topLeftXPos,
                           barrierBlocks[i][j].topLeftYPos,
                           barrierBlocks[i][j].width,
                           barrierBlocks[i][j].height);

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
        return this.topLeftXPos;
    }

    @Override
    public int getTopLeftYPos() {
        return this.topLeftYPos;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
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
