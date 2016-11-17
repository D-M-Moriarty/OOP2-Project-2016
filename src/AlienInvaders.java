import javax.swing.*;
import java.awt.*;

/**
 * Created by Darren Moriarty on 12/11/2016.
 */
public class AlienInvaders extends GameComponent {

    private final int spaceBetween = 30;
    private int speed = 1;
    private static ImageIcon[][] alienInvaders = new ImageIcon[5][11];

    private static int gerX = -2000;

    public static ImageIcon gerImage = new ImageIcon("images/ger.png");

    private static ImageIcon temp = new ImageIcon("images/mS0hGaS.png");

    private static ImageIcon imageIcon =  new ImageIcon("images/mS0hGaS.png");
    private static ImageIcon imageIcon2 =  new ImageIcon("images/Space-large-invader.png");
    private static ImageIcon imageIcon3 =  new ImageIcon("images/Space-medium-invader.png");

    public AlienInvaders(int topLeftXPos, int topLeftYPos, int width, int height, Color color){
        super(topLeftXPos, topLeftYPos, width, height, color);
        imageIcon = createImg("images/Space-large-invader.jpg");
        alienInvaders = populateAliens();
    }

    public ImageIcon[][] populateAliens(){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {

//                if(i == 0 || i == 3){
//                    alienInvaders[i][j] = new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("images/mS0hGaS.png"));
//                }else if (i == 1 || i == 4){
//                    alienInvaders[i][j] = new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("images/mS0hGaS.png"));
//                }else {
//                    alienInvaders[i][j] = new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("images/mS0hGaS.png"));
//                }

            }
        }
        return new ImageIcon[0][];
    }

    public ImageIcon createImg(String path){
        //ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource(path));
        return imageIcon;
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, imageIcon);
    }


    @Override
    public void draw(Graphics2D g) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {

                //g.drawImage(alienInvaders[i][j].getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);

//                g.setColor(Color.GREEN);
//                g.drawRect(this.topLeftXPos + (this.width * j), this.topLeftYPos * i, width, height);
//                g.fillRect(this.topLeftXPos + (this.width * j), this.topLeftYPos * i, width, height);


                if(i == 0 || i == 3){

                    if(topLeftXPos > 0 && topLeftXPos < 100){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 100 && topLeftXPos < 200){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 200 && topLeftXPos < 300){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 300 && topLeftXPos < 400){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 400 && topLeftXPos < 500){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 500 && topLeftXPos < 600){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 600 && topLeftXPos < 700){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 700 && topLeftXPos < 800){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 800 && topLeftXPos < 900){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 900  && topLeftXPos < 1000){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }

                }else if (i == 1 || i == 4){

                    if(topLeftXPos > 0 && topLeftXPos < 100){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 100 && topLeftXPos < 200){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 200 && topLeftXPos < 300){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 300 && topLeftXPos < 400){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 400 && topLeftXPos < 500){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 500 && topLeftXPos < 600){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 600 && topLeftXPos < 700){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 700 && topLeftXPos < 800){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 800 && topLeftXPos < 900){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 900  && topLeftXPos < 1000){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }

                }else {

                    if(topLeftXPos > 0 && topLeftXPos < 100){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 100 && topLeftXPos < 200){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 200 && topLeftXPos < 300){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 300 && topLeftXPos < 400){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 400 && topLeftXPos < 500){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 500 && topLeftXPos < 600){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 600 && topLeftXPos < 700){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 700 && topLeftXPos < 800){
                        g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 800 && topLeftXPos < 900){
                        g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }else if(topLeftXPos > 900  && topLeftXPos < 1000){
                        g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                    }

                }


            }
        }

        if (gerX > 0)
            g.drawImage(gerImage.getImage(), gerX, 10, null);

        g.setColor(Color.RED);
        if(gerX > -20 && gerX < 100){
            g.drawString("OH no, Its Ger!!!!!", 400, 20);
        }


    }

    @Override
    public void update() {

        if(topLeftXPos < 1000)
            topLeftXPos += speed;

        if(topLeftXPos > 1000 - width * 11 && topLeftXPos < 1000){
            topLeftYPos += 20;
            this.speed = -speed;
            topLeftXPos += speed;
        }

        if(topLeftXPos < 0){
            topLeftYPos += 20;
            this.speed = 1;
            topLeftXPos += speed;
        }

        gerX+=2;

        if(gerX > 1000){
            gerX = -2000;
        }


    }

    public static void setGerX(int x){
        gerX = x;
    }

    public static int getGerX(){
        return gerX;
    }

}
