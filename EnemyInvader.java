
import java.awt.*;

public class EnemyInvader extends GameComponent{
	
private boolean destroyed;
	
	public EnemyInvader(int topLeftXPosition,int topLeftYPosition,int width, int height, Color colour, boolean destroyed)
		{
			super(topLeftXPosition,topLeftYPosition,width,height,colour);
			setDestroyed(false);
		}
	
	public boolean getDestroyed()
		{
			return destroyed;
		}
		
		
	public void setDestroyed(boolean destroyed)
		{
			this.destroyed = destroyed;
		}
		
	public void update() {
        /*int speed = 1;
        if(getTopLeftXPos() < 1000)
            setTopLeftXPos(getTopLeftXPos()+speed);

        if(getTopLeftXPos() > 1000 - width * 11 && getTopLeftXPos() < 1000){
            setTopLeftYPos(getTopLeftYPos()+20);
            speed = -speed;
            setTopLeftXPos(getTopLeftXPos() + speed);
        }

        if(getTopLeftXPos()< 0){
             setTopLeftYPos(getTopLeftYPos()+20);
             speed = 1;
             setTopLeftXPos(getTopLeftXPos() + speed);
        }*/
        
        //check whether any space invader has reached the right or left border and, if so, alter the delta (direction) value accordingly
	    /*boolean rightBorderReached=false,leftBorderReached=false;
	    int delta=1;
					
						if(getTopLeftXPos()+getWidth()>=1000 && !getDestroyed())
						{
							rightBorderReached=true;
							delta=-1;	
						}
						if(getTopLeftXPos()<=0 && !getDestroyed())
						{
							leftBorderReached=true;
							delta=1;	
						}  
							
						setTopLeftXPos(getTopLeftXPos()+10*delta);
						
						if(leftBorderReached || rightBorderReached)
						{
							setTopLeftYPos(getTopLeftYPos()+Math.abs(2*delta));					
						}     */              
					}
			


    
    
    public void draw(Graphics2D g) {
    	        g.setColor(getColor());
	   	  	
                g.fillRect(getTopLeftXPos(),getTopLeftYPos(),getWidth(),getHeight()); 
		
			}
    
}