import java.awt.Color;
import java.awt.Graphics;



/**
 * @author Haseeb Nain
 * This class will create a circle with a defined radius and position, designated by the user.
 */
public class CircleThing extends PaintableThing{

	private int red,blue,green;
	private int x, y, radius;
	private Color myColor;

	public  CircleThing(int xIn, int yIn, int radiusIn, Color col){
		x=xIn;
		y=yIn;
		radius=radiusIn;
		myColor = col;

	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int area = 0;
				area=(int) (Math.PI*(radius*radius));
		return area;
	}

	@Override
	public void draw(Graphics g) {
		

		
		red=(int) Math.random()*256;
		blue=(int) Math.random()*256;
		green=(int) Math.random()*256;
	

		//g.setColor(new Color(red,green,blue));

		g.setColor(myColor);
		g.fillOval(x, y, radius,radius);
		// TODO Auto-generated method stub
		
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
