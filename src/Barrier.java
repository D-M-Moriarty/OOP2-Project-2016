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
    private Rectangle[][] rectangles;

    private BarrierBlock[][] barrierBlocks2;
    private Rectangle[][] rectangles2;

    private BarrierBlock[][] barrierBlocks3;
    private Rectangle[][] rectangles3;

    Rectangle r1;

    Rectangle r3;

    Rectangle r4;

    Rectangle r2;

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
        rectangles = new Rectangle[7][12];

        barrierBlocks2 = new BarrierBlock[7][12];
        rectangles2 = new Rectangle[7][12];

        barrierBlocks3 = new BarrierBlock[7][12];
        rectangles3 = new Rectangle[7][12];

        // Setting the dimensions of each barrier block in the array with a nested for loops to
        // create a grid of block (5 x 6)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {

                // Setting the dimensions of each block
                // The position of each block is the width of the block wider relative to the block beside it
                barrierBlocks[i][j] = new BarrierBlock(this.topLeftXPos + (this.width * j), this.topLeftYPos
                        + (this.height * i), this.width, this.height, this.color, true);

                rectangles[i][j] = new Rectangle(this.topLeftXPos + (this.width * j), this.topLeftYPos
                        + (this.height * i), this.width, this.height);

                // Seconds Barrier
                barrierBlocks2[i][j] = new BarrierBlock(this.topLeftXPos + 350 + (this.width * j), this.topLeftYPos
                        + (this.height * i), this.width, this.height, this.color, true);

                rectangles2[i][j] = new Rectangle(this.topLeftXPos + 350 + (this.width * j), this.topLeftYPos
                        + (this.height * i), this.width, this.height);

                // Third Barrier
                barrierBlocks3[i][j] = new BarrierBlock(this.topLeftXPos + 700 + (this.width * j), this.topLeftYPos
                        + (this.height * i), this.width, this.height, this.color, true);

                rectangles3[i][j] = new Rectangle(this.topLeftXPos + 700 + (this.width * j), this.topLeftYPos
                        + (this.height * i), this.width, this.height);
            }
        }


    }

    // This method decides what to do every time the screen refreshes
    @Override
    public void update() {

        // Setting the dimensions of each barrier block in the array with a nested for loops to
        // create a grid of block (5 x 6)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {

                //Creating two rectangles to check for collisions with the intersects method
                if (SpaceInvadersGUI.bullets.size() > 0){

                    r1 = new Rectangle(rectangles[i][j]);

                    r3 = new Rectangle(rectangles2[i][j]);

                    r4 = new Rectangle(rectangles3[i][j]);



                    for (int k = 0; k < SpaceInvadersGUI.bullets.size(); k++) {
                        r2 = new Rectangle(SpaceInvadersGUI.bullets.get(k).getTopLeftXPos(),
                                SpaceInvadersGUI.bullets.get(k).getTopLeftYPos(),
                                SpaceInvadersGUI.bullets.get(k).getWidth(),
                                SpaceInvadersGUI.bullets.get(k).getHeight());

                        // Calculating the random value for hitting ger
                        if(r2.intersects(AlienInvaders.getGerX(), 10, 50 ,50)){
                            System.out.println("It hit ger");
                            SpaceInvadersGUI.bullets.remove(k);
                            AlienInvaders.setGerX(-2000);
                            SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() +
                                    ((int)(Math.random() * 150) + 51));
                            System.out.println(SpaceInvadersGUI.getPlayerScore());
                        }


                        if (r2.intersects(r1)) {

                            // Checking the height of the Block above
                            if(barrierBlocks[i-5][j].getHeight() == -1){
                                barrierBlocks[i-6][j].setHeight(-1);
                            }

                            if(barrierBlocks[i-4][j].getHeight() == -1){
                                barrierBlocks[i-5][j].setHeight(-1);
                            }

                            if(barrierBlocks[i-3][j].getHeight() == -1){
                                barrierBlocks[i-4][j].setHeight(-1);
                            }

                            if(barrierBlocks[i-2][j].getHeight() == -1){
                                barrierBlocks[i-3][j].setHeight(-1);
                            }

                            if(barrierBlocks[i-1][j].getHeight() == -1){
                                barrierBlocks[i-2][j].setHeight(-1);
                            }

                            if(barrierBlocks[i][j].getHeight() == -1){
                                barrierBlocks[i-1][j].setHeight(-1);
                            }

                            System.out.println("There was a collision at " + rectangles[i][j]);
                            SpaceInvadersGUI.bullets.remove(k);
                            barrierBlocks[i][j].setHeight(-1);


                        }else if (r2.intersects(r3)) {
                            System.out.println("Rectangles 2 " + rectangles2[i][j] +
                            "\nBullet Position Y" + SpaceInvadersGUI.bullets.get(k).getTopLeftYPos() +
                            "\n Position X " + SpaceInvadersGUI.bullets.get(k).getTopLeftXPos());

                            // Checking the height of the Block above
                            if(barrierBlocks2[i-5][j].getHeight() == -1){
                                barrierBlocks2[i-6][j].setHeight(-1);
                            }

                            if(barrierBlocks2[i-4][j].getHeight() == -1){
                                barrierBlocks2[i-5][j].setHeight(-1);
                            }

                            if(barrierBlocks2[i-3][j].getHeight() == -1){
                                barrierBlocks2[i-4][j].setHeight(-1);
                            }

                            if(barrierBlocks2[i-2][j].getHeight() == -1){
                                barrierBlocks2[i-3][j].setHeight(-1);
                            }

                            if(barrierBlocks2[i-1][j].getHeight() == -1){
                                barrierBlocks2[i-2][j].setHeight(-1);
                            }

                            if(barrierBlocks2[i][j].getHeight() == -1){
                                barrierBlocks2[i-1][j].setHeight(-1);
                            }

                            SpaceInvadersGUI.bullets.remove(k);
                            barrierBlocks2[i][j].setHeight(-1);

                        }else if (r2.intersects(r4)) {
                            System.out.println("Rectangles 3 " + rectangles2[i][j]);

                            // Checking the height of the Block above
                            if(barrierBlocks3[i-5][j].getHeight() == -1){
                                barrierBlocks3[i-6][j].setHeight(-1);
                            }

                            if(barrierBlocks3[i-4][j].getHeight() == -1){
                                barrierBlocks3[i-5][j].setHeight(-1);
                            }

                            if(barrierBlocks3[i-3][j].getHeight() == -1){
                                barrierBlocks3[i-4][j].setHeight(-1);
                            }

                            if(barrierBlocks3[i-2][j].getHeight() == -1){
                                barrierBlocks3[i-3][j].setHeight(-1);
                            }

                            if(barrierBlocks3[i-1][j].getHeight() == -1){
                                barrierBlocks3[i-2][j].setHeight(-1);
                            }

                            if(barrierBlocks3[i][j].getHeight() == -1){
                                barrierBlocks3[i-1][j].setHeight(-1);
                            }


                            SpaceInvadersGUI.bullets.remove(k);
                            barrierBlocks3[i][j].setHeight(-1);

                        }

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

//                if( i < 40 && j < 50){
//                    g.setColor(Color.BLACK);
//                }else{
//                    g.setColor(Color.GREEN);
//                }

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

    /**
     *
     * @return a barrierBlock
     */
//    public BarrierBlock getBarrierBlocks(){
//
//        for (int i = 0; i < 7; i++){
//            for (int j = 0; j < 12; j++){
//                return barrierBlocks[i][j];
//            }
//        }
//
//
//        return null;
//    }

    public String toString(){
        return "Barrier class is working";
    }

    @Override
    public void setTopLeftXPos(int topLeftXPos) {
        this.topLeftXPos = topLeftXPos;
    }

    @Override
    public void setTopLeftYPos(int topLeftYPos) {
        this.topLeftYPos = topLeftYPos;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
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
        return this.color;
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
