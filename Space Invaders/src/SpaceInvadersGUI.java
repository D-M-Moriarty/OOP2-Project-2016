import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * This is the JPanel class which is just a flat container for holding components
 *
 * @author Darren Moriarty
 * Created on 11/11/2016.
 *
 * This class inherits from JPanel
 * It Interfaces with Runnable and KeyListener
 */
public class SpaceInvadersGUI extends JPanel implements Runnable, KeyListener{

    // Class Attributes

    // width of the panel
    public static final int WIDTH = 1000;
    // height of the panel
    public static final int HEIGHT = 700;
    // Buffered image
    private BufferedImage image;
    // creating a Graphics object
    private Graphics2D g;
    // Boolean to signify whether the game is running or not
    private boolean isRunning;
    // Creating an independent process
    private Thread thread;
    // initial Frames per Second
    private int FPS = 60;
    // Average FPS
    private double averageFPS;

    // Declaring entity objects
    private Tank tank;
    private Barrel barrel;
    private Barrier barrier, barrier2, barrier3;

    // JPanel Constructor
    public SpaceInvadersGUI(){
        // Calls the default constructor
        super();
        // Sets the size of the panel to the Widht and Height constants
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        //to make sure the SpaceInvadersGUI can be focused on
        setFocusable(true);
        //gets the focus
        requestFocus();
    }

    @Override
    public void addNotify(){
        //loads JPanel
        super.addNotify();

        if(thread == null){
            // Sets the new thread to the class
            thread = new Thread(this);
            // Starts the thread
            thread.start();
        }
        // Adds the KeyListener to this class
        addKeyListener(this);

    }

    @Override
    public void run() {
        //set is running to true
        isRunning = true;
        // Creates a new image
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // Sets the value of the graphics object
        g = (Graphics2D) image.getGraphics();

        // Initialises the GameComponents entities
        tank = new Tank(400, 580, 100, 50, Color.GREEN, 3, 10);
        barrel = new Barrel(445, 570, 10, 10, Color.GREEN, 10);
        barrier = new Barrier(100, 500, 20, 10, Color.GREEN);
        barrier2 = new Barrier(450, 500, 20, 10, Color.GREEN);
        barrier3 = new Barrier(800, 500, 20, 10, Color.GREEN);

        // Declaring variables to determine loop length time
        long startTime;
        //UpdateRenderDrawTime in milliseconds
        long URDTimeMilliS;
        // Time spent waiting for loop to start again
        long waitTime;
        // Total time of loop
        long totalTime = 0;

        // The number of frames counted per loop
        int frameCount = 0;
        // The maximum amount of frames allowed per loop
        int maxFrameCount = 30;

        // the length of time it takes for the loop to run
        long targetTime = 1000 / FPS;



        // The main game loop
        while (isRunning){

            // sets the Systems current time in nanoseconds
            startTime  = System.nanoTime();

            // Methods to re-draw the graphics to the screen each iteration of the loop
            gameUpdate();
            gameRender();
            gameDraw();

            //UpdateRenderDrawTime is set to current system time minus the startTime divided by a million since its in nanoseconds
            URDTimeMilliS = (System.nanoTime() - startTime) / 1000000;
            // time spent waiting before the loop runs again
            waitTime = targetTime - URDTimeMilliS;

            // Try and catch block
            try {
                // Try sleeping for the length of the waitTime
                Thread.sleep(waitTime);
            } catch (Exception e) {
                // If it cant it will catch the exception / error
                //e.printStackTrace();
            }

            // the total looptime
            totalTime += System.nanoTime() - startTime;
            // Increasing the frame count by one each iteration of the loop
            frameCount++;

            // If the amount of frames counted in the loop matched the maxFrameCount
            if(frameCount == maxFrameCount){
                // The average FPS is
                averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
                // Resetting the frameCount and the totalTIme
                frameCount = 0;
                totalTime = 0;
            }
        }
    }

    // Responsible for updating everything in the game eg.Positions, values
    private void gameUpdate() {
        tank.update();
        barrel.update();
        barrier.update();
    }

    // Draws to the offscreen image, ie. determines what to draw on the next frame
    private void gameRender() {

        // These are constants that will be in every frame
        g.setColor(Color.BLACK);
        g.fillRect(0, 0 , WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        //g.drawString("The FPS is: " + averageFPS, 100, 100);

        g.drawString("The value of tank is: " + tank, 100, 100);
        //System.out.println(tank);

        g.setColor(Color.GREEN);
        //drawing the line at the bottom of the screen
        Rectangle2D bottomLine = new Rectangle2D.Float(25, 650, 950, 10);
        g.fill(bottomLine);

        // draws the updated object values
        tank.draw(g);
        barrel.draw(g);
        barrier.draw(g);
        barrier2.draw(g);
        barrier3.draw(g);

    }

    // drawing on to the game screen
    private void gameDraw() {
        Graphics gRef = this.getGraphics();
        gRef.drawImage(image, 0 ,0, null);
        gRef.dispose();
    }

    // KeyListener interface methods
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        // If the left key is pressed
        if(key == KeyEvent.VK_LEFT){
            // sets the setLeft methods to true which will tell the update method which direction to travel
            tank.setLeft(true);
            barrel.setLeft(true);
            System.out.println("left was pressed");
        }

        if(key == KeyEvent.VK_RIGHT){
            tank.setRight(true);
            barrel.setRight(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        // If the left key is released it will set the value of setLeft to false to stop the entity moving
        if(key == KeyEvent.VK_LEFT){
            tank.setLeft(false);
            barrel.setLeft(false);
        }

        if(key == KeyEvent.VK_RIGHT){
            tank.setRight(false);
            barrel.setRight(false);
        }
    }
}
