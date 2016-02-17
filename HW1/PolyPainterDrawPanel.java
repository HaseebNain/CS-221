import java.awt.*;
import javax.swing.*;

/**
 * JPanel that paints polymorphic PaintableThings.
 * DO NOT EDIT. THIS CLASS IS COMPLETE.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class PolyPainterDrawPanel extends JPanel
{
	private PaintableThing[] things;
	
	/**
	 * Constructor - initialize panel
	 */
	public PolyPainterDrawPanel() {
		setBackground(Color.white);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{		
		super.paintComponent(g);
		
		if (things != null)
		{
			for (PaintableThing thing : things) {
				thing.draw(g); //paint this thing on Graphics g
			}
		}		
	}

	/**
	 * Update shapes and call repaint()
	 * @param things - collection of things to paint
	 */
	public void paintThings(PaintableThing[] things)
	{
		this.things = things;
		repaint();
	}
	
	/**
	 * Set shapes to null and repaint()
	 */
	public void clear()
	{
		this.things = null;
		repaint();
	}
}
