import java.awt.Font;
import java.awt.Graphics;



/**
 * @author Haseeb Nain
 * This class takes in a string from the user and places at a users designated location with a random color
 */
public class WordWriter extends PaintableThing{

	private int x,y,font;
	private String myWord ="";
	
	WordWriter(int xIn, int yIn,String theWords){
		
		
		x=xIn;
		y=yIn;
		myWord = theWords;
	}
	
	@Override
	public int getSize() {
		return font;
		
	}

	@Override
	public void draw(Graphics g) {

		g.drawString(myWord, x, y);


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
