import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Darren Moriarty on 17/11/2016.
 */
public class AlienInvaders2 extends GameComponent {


    private AlienEntity[][] alienEntities;

    public static ImageIcon gerImage = new ImageIcon("images/ger.png");

    private int delta = 1, speed = 1;
    private static int gerX = -2000;
    private boolean rightBorderReached = false;
    private boolean leftBorderReached = false;
    private boolean firing;
    private int randomFiringTime;

    private ImageIcon alienImage = new ImageIcon("images/Space-large-invader.png");
    private static ImageIcon alienImage2 =  new ImageIcon("images/mS0hGaS.png");
    private static ImageIcon alienImage3 =  new ImageIcon("images/Space-medium-invader.png");


    public AlienInvaders2(int topLeftXPos, int topLeftYPos, int width, int height, Color color) {
        super(topLeftXPos, topLeftYPos, width, height, color);


        alienEntities = new AlienEntity[5][11];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {

                alienEntities[i][j] = new AlienEntity((getTopLeftXPos() + j * getWidth()),
                        (getTopLeftYPos() + i * getHeight()), getWidth(), getHeight(), getColor(),false);

            }

        }



    }

    @Override
    public void draw(Graphics2D g) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {

//                if(alienEntities[i][j].isDestroyed()){
//                    System.out.println("Aliens were destroyed");
//                }


                if (!alienEntities[i][j].isDestroyed()) {

                    g.setColor(Color.BLACK);


                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    g.drawRect(alienEntities[i][j].getTopLeftXPos(),
                            alienEntities[i][j].getTopLeftYPos(),
                            alienEntities[i][j].getWidth(),
                            alienEntities[i][j].getHeight());

                    g.fillRect(alienEntities[i][j].getTopLeftXPos(),
                            alienEntities[i][j].getTopLeftYPos(),
                            alienEntities[i][j].getWidth(),
                            alienEntities[i][j].getHeight());

                    if (i == 0 || i == 3){
                        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
                    }else if (i == 1 || i == 4){
                        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);

                    }else{
                        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
                    }

                }

            }

            if (gerX > 0)
                g.drawImage(gerImage.getImage(), gerX, 10, null);

            g.setColor(Color.RED);
            if (gerX > -20 && gerX < 100) {
                g.drawString("OH no, Its Ger!!!!!", 400, 20);
            }

        }
    }

    @Override
    public void update() {

        gerX+=2;

        if(gerX > 1000){
            gerX = -2000;
        }
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 11; j++) {
//
//                if(alienEntities[i][j].getTopLeftXPos() < 1000)
//                    alienEntities[i][j].topLeftXPos += speed;
//
//                if(alienEntities[i][j].topLeftXPos > 1000 - alienEntities[i][j].width  && alienEntities[i][j].topLeftXPos < 1000){
//                    alienEntities[i][j].topLeftYPos += 20;
//                    speed = -speed;
//                    alienEntities[i][j].topLeftXPos += speed;
//                }
//
//                if(alienEntities[i][j].topLeftXPos < 0){
//                    alienEntities[i][j].topLeftYPos += 20;
//                    speed = 1;
//                    alienEntities[i][j].topLeftXPos += speed;
//                }
//            }
//
//        }
//




        //Firing the enemy Bullets
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {

                Random rand = new Random();
                int  randomFire = rand.nextInt(11);
                int  randomFireRow = rand.nextInt(5);
                //System.out.println(randomFire);

                if(firing && !alienEntities[4][randomFire].isDestroyed()){
                    SpaceInvadersGUI.alienBullets.add(new AlienBullet(alienEntities[4][randomFire].getTopLeftXPos() + 20,
                            alienEntities[4][randomFire].getTopLeftYPos() + 40, 5, 10, Color.WHITE));

                    firing = false;

                }

            }

        }



        // Checking for collisions between tank bullets and aliens
        for (int k = 0; k < SpaceInvadersGUI.bullets.size(); k++) {
            Bullet bullet = SpaceInvadersGUI.bullets.get(k);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 11; j++) {


                    Rectangle bulletRect = new Rectangle(bullet.getTopLeftXPos(),
                            bullet.getTopLeftYPos(),bullet.getWidth(),bullet.getHeight());

                    Rectangle alienRect = new Rectangle(alienEntities[i][j].getTopLeftXPos(),
                            alienEntities[i][j].getTopLeftYPos(),alienEntities[i][j].getWidth(),alienEntities[i][j].getHeight());

                    if (bulletRect.intersects(alienRect)) {
                        //System.out.println("There was a collision");
                        if (i == 2 || i == 4){
                            SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() + 10);
                            System.out.println("1 and 3");
                        }else if (i == 3 || i == 5){
                            SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() + 25);
                            System.out.println("2 and 4");
                        }else{
                            SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() + 50);
                            System.out.println("ekse");
                        }
                        //SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() + 10);
                        SpaceInvadersGUI.bullets.remove(bullet);
                        alienEntities[i][j].setHeight(-1000);
                        alienEntities[i][j].setWidth(-1000);
                        alienEntities[i][j].setTopLeftXPos(-1000);
                        alienEntities[i][j].setTopLeftYPos(-1000);
                        alienEntities[i][j].setDestroyed(true);

                    }


                }
            }



        }

        for (int i = 0; i < SpaceInvadersGUI.bullets.size(); i++) {
            Rectangle r2 = new Rectangle(SpaceInvadersGUI.bullets.get(i).getTopLeftXPos(),
                    SpaceInvadersGUI.bullets.get(i).getTopLeftYPos(),
                    SpaceInvadersGUI.bullets.get(i).getWidth(),
                    SpaceInvadersGUI.bullets.get(i).getHeight());

            // Calculating the random value for hitting ger
            if(r2.intersects(getGerX(), 10, 50 ,50)){
                System.out.println("It hit ger");
                SpaceInvadersGUI.bullets.remove(i);
                setGerX(-2000);
                SpaceInvadersGUI.setPlayerScore(SpaceInvadersGUI.getPlayerScore() +
                        ((int)(Math.random() * 150) + 51));
                System.out.println(SpaceInvadersGUI.getPlayerScore());
            }
        }




        for(int k = 0; k < 5; k++){
            for(int j = 0; j < 11; j++){

                //System.out.println("Got here!");

                //could write methods called reachedRightBorder() and reachedLeftBorder() for the EnemyInvader class
                //and call them on all aliens[k][j] instead to determine if a border was encountered
                //if it was then the method would return true and that could be used to exit the loop early

                if(alienEntities[k][j].getTopLeftXPos() +
                        alienEntities[k][j].getWidth() >= SpaceInvadersGUI.WIDTH &&
                        !alienEntities[k][j].isDestroyed()){

                    //System.out.println("In the first for loop");
                    rightBorderReached = true;
                    delta = -1;
                    break;
                }
                if(alienEntities[k][j].getTopLeftXPos()<=0 && !alienEntities[k][j].isDestroyed()){

                    leftBorderReached = true;
                    delta = 1;
                    break;
                }
            }
        }


        //now update the horizontal position of each invader
        //if it turns out that the left or right border have been reached then move each invader down 2 pixels

        for(int k = 0; k < 5; k++){
            for(int j = 0;j < 11; j++){

                alienEntities[k][j].setTopLeftXPos(alienEntities[k][j].getTopLeftXPos() + delta);
                //System.out.println("In the second for loop");

                if(leftBorderReached || rightBorderReached){

                    alienEntities[k][j].setTopLeftYPos(alienEntities[k][j].getTopLeftYPos() + Math.abs(10 * delta));
                }
            }
        }

        leftBorderReached = false;
        rightBorderReached = false;

    }

    public void setAlienImage(ImageIcon alienImage) {
        this.alienImage = alienImage;
    }

    public void setGerX(int x){
        gerX = x;
    }

    public int getGerX(){
        return gerX;
    }


    public boolean isFiring() {
        return firing;
    }

    public void setFiring(boolean firing) {
        this.firing = firing;
    }
}

//if (i == 0 || i == 3) {
//
//        if (topLeftXPos > 0 && topLeftXPos < 100) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 100 && topLeftXPos < 200) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 200 && topLeftXPos < 300) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 300 && topLeftXPos < 400) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 400 && topLeftXPos < 500) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 500 && topLeftXPos < 600) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 600 && topLeftXPos < 700) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 700 && topLeftXPos < 800) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 800 && topLeftXPos < 900) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 900 && topLeftXPos < 1000) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        }
//
//        } else if (i == 1 || i == 4) {
//
//        if (topLeftXPos > 0 && topLeftXPos < 100) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 100 && topLeftXPos < 200) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 200 && topLeftXPos < 300) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 300 && topLeftXPos < 400) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 400 && topLeftXPos < 500) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 500 && topLeftXPos < 600) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 600 && topLeftXPos < 700) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 700 && topLeftXPos < 800) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 800 && topLeftXPos < 900) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 900 && topLeftXPos < 1000) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        }
//
//        } else {
//
//        if (topLeftXPos > 0 && topLeftXPos < 100) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 100 && topLeftXPos < 200) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 200 && topLeftXPos < 300) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 300 && topLeftXPos < 400) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 400 && topLeftXPos < 500) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 500 && topLeftXPos < 600) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 600 && topLeftXPos < 700) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 700 && topLeftXPos < 800) {
//        g.drawImage(alienImage3.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 800 && topLeftXPos < 900) {
//        g.drawImage(alienImage2.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        } else if (topLeftXPos > 900 && topLeftXPos < 1000) {
//        g.drawImage(alienImage.getImage(), alienEntities[i][j].getTopLeftXPos(), alienEntities[i][j].getTopLeftYPos(), null);
//        }
//        }
