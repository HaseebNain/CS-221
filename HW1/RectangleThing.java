import java.awt.Color;
import java.awt.Graphics;


/**
 * @author Haseeb Nain
 * This class will create a rectangle with dimensions, location, and color designated by the user
 *
 */
public class RectangleThing extends PaintableThing{

	
	int red,blue,green;
	private int x, y, width,length;
	private Color myColor;
	

	public RectangleThing(int xIn, int yIn, int widthIn, int lengthIn, Color col){
		x=xIn;
		y=yIn;
		width=widthIn;
		length=lengthIn;
		myColor = col;

		
	}
	@Override
	public int getSize() {
		
		return length*width;

		
	}

	@Override
	public void draw(Graphics g) {


		red=(int) Math.random()*256;
		blue=(int) Math.random()*256;
		green=(int) Math.random()*256;
	

		g.setColor(myColor);
		//g.setColor(new Color(red,green,blue));
		
		
		g.fillRect(x, y, width, length);
		g.drawRoundRect(x, y, 50, 50, 100, 100);
		
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
