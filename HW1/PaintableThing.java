import java.awt.Color;
import java.awt.Graphics;


/**
 * A thing that can be painted on a given Graphics object.
 * 
 * @author mvail
 */
public abstract class PaintableThing {
	//TODO: supply appropriate variables and methods common to all PaintableThings

	protected Color myColor;
	protected int size;
	protected int x,y;
	protected int red, green, blue;
	
	 
	/**
	 * @return the size of the painted object.
	 * 
	 */
	public abstract int getSize();
	
	
	/**
	 * @return the X Coordinate of the painted object
	 */
	public abstract int getX();
	
	/**
	 * @return the Y Coordinate of the painted object
	 */
	public abstract int getY();
	
	/**
	 * Draws this thing on the given Graphics object.
	 * @param g Graphics context on which to draw
	 */
	public abstract void draw(Graphics g);
}
