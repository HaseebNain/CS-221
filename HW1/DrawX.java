import java.awt.Color;
import java.awt.Graphics;


/**
 * @author Haseeb Nain
 * This class will create a line of length 70
 * 
 */
public class DrawX extends PaintableThing{

	private int x,y;
	private Color myColor;
	
	public DrawX(int xIn, int yIn, Color col){
		x=xIn;
		y=yIn;
		myColor = col;
		
	}
	@Override
	public int getSize() {
		
		// The length of the line will always be equal to approximatly 70, with the length and width sides of the "triangle" being 50.
		
		return 70;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(myColor);
		
		//Drawys several lines, in order to appear "Thicker"
		
		g.drawLine(x-50, y-50, x+50, y+50);
		g.drawLine(x+50, y-50, x-50, y+50);

		g.drawLine(x-49, y-49, x+49, y+49);
		g.drawLine(x+49, y-49, x-49, y+49);
		
		g.drawLine(x-48, y-48, x+48, y+48);
		g.drawLine(x+48, y-48, x-48, y+48);
		
		g.drawLine(x-51, y-51, x+51, y+51);
		g.drawLine(x+51, y-51, x-51, y+51);
		
		g.drawLine(x-52, y-52, x+52, y+52);
		g.drawLine(x+52, y-52, x-52, y+52);
		
		
		
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
