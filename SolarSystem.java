import java.awt.*;
import javax.swing.*;

public class SolarSystem extends JFrame {
	
	
	public SolarSystem(){
		super("Solar System");
		setSize(800,500);
		setLocation(200,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.BLACK);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		new SolarSystem();
		
	}
	
	private class DrawStuff extends JComponent{
		public void paint(Graphics g) {
			
	 		Graphics2D graph2 = (Graphics2D)g;
	 		
	 		graph2 =  setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIASING_ON);
	 	}
	}
	
	 
}