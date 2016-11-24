/**
 * Created by t00168162 on 23/11/2016.
 */
public class Player {

    private int playerScore;
    private String name;

    public Player(int playerScore, String name){
        setName(name);
        setPlayerScore(playerScore);
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public String toString(){
        return "Players name is " + name + " their score is " + playerScore;
    }
}
