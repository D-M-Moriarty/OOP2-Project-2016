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
        barrierBlocks = new BarrierBlock[7][12];
        // Setting the dimensions of each barrier block in the array with a nested for loops to
        // create a grid of block (5 x 6)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {

                // Setting the dimensions of each block
                // The position of each block is the width of the block wider relative to the block beside it
                barrierBlocks[i][j] = new BarrierBlock(getTopLeftXPos() + j * (getWidth() / 12), getTopLeftYPos()
                        + i * (getHeight() / 7), (getWidth() / 12), (getHeight() / 7), getColor(), false);
            }
        }


    }

    // This method decides what to do every time the screen refreshes
    @Override
    public void update() {

        for (int k = 0; k < SpaceInvadersGUI.bullets.size(); k++) {
            Bullet bullet = SpaceInvadersGUI.bullets.get(k);

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 12; j++) {

                    if (bullet.collidesWith(barrierBlocks[i][j])) {
                        System.out.println("There was a collision");
                        SpaceInvadersGUI.bullets.remove(bullet);
                        barrierBlocks[i][j].setHeight(-1);
                        barrierBlocks[i][j].setWidth(-1);
                        barrierBlocks[i][j].setTopLeftXPos(-1);
                        barrierBlocks[i][j].setTopLeftYPos(-1);
                        barrierBlocks[i][j].setDestroyed(true);

                    }


                }
            }

        }

        for (int k = 0; k < SpaceInvadersGUI.alienBullets.size(); k++) {
            AlienBullet bullet = SpaceInvadersGUI.alienBullets.get(k);


            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 12; j++) {

                    if (bullet.collidesWith(barrierBlocks[i][j])) {
                        //SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() + 10);
                        SpaceInvadersGUI.alienBullets.remove(bullet);
                        barrierBlocks[i][j].setHeight(-1);
                        barrierBlocks[i][j].setWidth(-1);
                        barrierBlocks[i][j].setTopLeftXPos(-1);
                        barrierBlocks[i][j].setTopLeftYPos(-1);
                        barrierBlocks[i][j].setDestroyed(true);

                    }
                }
            }




        }






    }


    @Override
    public void draw(Graphics2D g) {

        // Setting the dimensions of each barrier block in the array with a nested for loops to
        // create a grid of block (5 x 6)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {

                //  Drawing the array of blocks to the screen

                if(!barrierBlocks[i][j].isDestroyed()){
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    g.drawRect(barrierBlocks[i][j].getTopLeftXPos(),
                            barrierBlocks[i][j].getTopLeftYPos(),
                            barrierBlocks[i][j].getWidth(),
                            barrierBlocks[i][j].getHeight());

                    g.fillRect(barrierBlocks[i][j].getTopLeftXPos(),
                            barrierBlocks[i][j].getTopLeftYPos(),
                            barrierBlocks[i][j].getWidth(),
                            barrierBlocks[i][j].getHeight());
                }


            }
        }

    }

    /**
     *
     * @return a barrierBlock
     */
    public BarrierBlock[][] getBarrierBlocks(){
                return barrierBlocks;
    }

    public String toString(){
        return "Barrier class is working";
    }

}
