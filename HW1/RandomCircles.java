import java.awt.Color;
import java.awt.Graphics;


/**
 * @author Haseeb Nain
 * This class will create 8 random colored circles in a straight line at the Y coordinate given by the user.
 */
public class RandomCircles extends PaintableThing{

	private int x,y,radius;
	private Color myColor, color2,color3,color4,color5,color6,color7,color8;
	
	public RandomCircles(int yIn){

		
		
		
		
		y=yIn;
		


		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		myColor = new Color(red,green,blue);
		
		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		color2 = new Color(red,green,blue);
		
		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		color3 = new Color(red,green,blue);
		
		
		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		color4 = new Color(red,green,blue);
		
		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		color5 = new Color(red,green,blue);
		
		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		color6 = new Color(red,green,blue);
		
		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		color7 = new Color(red,green,blue);
		
		red=(int) ((int) 0+Math.random()*256);
		blue=(int) ((int) 0+Math.random()*256);
		green=(int) ((int) 0+Math.random()*256);

		color8 = new Color(red,green,blue);
		
	}
	@Override
	public int getSize() {
		int area=0;
		area=(int)Math.PI*(radius*radius);
		
		return area;
	}

	@Override
	public void draw(Graphics g) {

		
		g.setColor(myColor);
		g.fillOval(10, y, 50,50);
		g.setColor(color2);
		g.fillOval(70, y, 50,50);
		g.setColor(color3);
		g.fillOval(130, y, 50,50);
		g.setColor(color4);
		g.fillOval(190, y, 50,50);
		g.setColor(color5);
		g.fillOval(250, y, 50,50);
		g.setColor(color6);
		g.fillOval(310, y, 50,50);
		g.setColor(color7);
		g.fillOval(370, y, 50,50);
		g.setColor(color8);
		g.fillOval(4300, y, 50,50);
		
		
	}
	@Override
	public int getX() {
		
		return x;
	}

	@Override
	public int getY() {
	
		return y;
	}

}
