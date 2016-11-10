

/**
 * Created by t00168162 on 10/11/2016.
 */
public class Bullet {
    private int y = 610;
    private int x= 337;
    private double speed = 1;

    public Bullet(){

    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    public void shootBullet() {
//        y--;
//    }

    public int getBulletY(){
        return y;
    }

    public int getBulletX(){
        return x;
    }

}
