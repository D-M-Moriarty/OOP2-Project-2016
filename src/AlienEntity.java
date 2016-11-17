import javax.swing.*;
import java.awt.*;

/**
 * Created by Darren Moriarty on 17/11/2016.
 */
public class AlienEntity extends GameComponent{

    private boolean destroyed;
    private ImageIcon alienImage = new ImageIcon("images/Space-large-invader.png");


    public AlienEntity(int topLeftXPos, int topLeftYPos, int width, int height, Color color, boolean destroyed){
        super(topLeftXPos, topLeftYPos, width, height, color);
        setDestroyed(destroyed);
    }


    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update() {

    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isDestroyed(){
        return destroyed;
    }
}
