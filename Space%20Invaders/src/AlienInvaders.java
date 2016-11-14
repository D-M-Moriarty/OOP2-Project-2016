import javax.swing.*;
import java.awt.*;

/**
 * Created by Darren Moriarty on 12/11/2016.
 */
public class AlienInvaders extends GameComponent {

    private final int spaceBetween = 30;
    private int speed = 1;
    private ImageIcon[][] alienInvaders = new ImageIcon[5][11];
    private static ImageIcon temp = new ImageIcon("images/mS0hGaS.png");
    private static ImageIcon imageIcon =  new ImageIcon("images/mS0hGaS.png");
    private static ImageIcon imageIcon2 =  new ImageIcon("images/Space-large-invader.png");
    private static ImageIcon imageIcon3 =  new ImageIcon("images/Space-medium-invader.png");

    public AlienInvaders(int topLeftXPos, int topLeftYPos, int width, int height, Color color){
        super(topLeftXPos, topLeftYPos, width, height, color);
        //imageIcon = createImg("images/Space-large-invader.jpg");
        alienInvaders = populateAliens();
    }

    public ImageIcon[][] populateAliens(){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {

                //if(i == 0 || i == 3){
                    alienInvaders[i][j] = new ImageIcon("images/mS0hGaS.png");
//                }else if (i == 1 || i == 4){
//                    alienInvaders[i][j] = new ImageIcon("\"images/Space-large-invader.png\"");
//                }else {
//                    alienInvaders[i][j] = new ImageIcon("\"images/Space-medium-invader.png\"");
//                }

            }
        }
        return new ImageIcon[0][];
    }

    public ImageIcon createImg(String path){
        ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource(path));
        return imageIcon;
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, imageIcon);
    }


    @Override
    public void draw(Graphics2D g) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
//
//                g.setColor(Color.GREEN);
//                g.drawRect(this.topLeftXPos + (this.width * j), this.topLeftYPos * i, width, height);
//                g.fillRect(this.topLeftXPos + (this.width * j), this.topLeftYPos * i, width, height);


                if(i == 0 || i == 3){
                    g.drawImage(imageIcon.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                }else if (i == 1 || i == 4){
                    g.drawImage(imageIcon2.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                }else {
                    g.drawImage(imageIcon3.getImage(), (this.topLeftXPos + this.width * j), (this.topLeftYPos + (height * i)), null);
                }

                //g.drawImage(alienInvaders[i][j].getImage(), (topLeftXPos * j), (topLeftYPos * i), null);



            }
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
