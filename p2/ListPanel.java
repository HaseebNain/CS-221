//********************************************************************
//  ListPanel.java       Authors: Lewis/Loftus
//
//  Represents the list of words for the PickImage program.
//********************************************************************

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.*;

public class ListPanel extends JPanel
{
	private JLabel label;
	public JList list;
	private String[] words;
	private JButton[][] buttons;
	private String chosenWord;
	private int gridSize;
	private BoggleSearch mySearch;

	private BoggleGUI gui;

	BoggleSearch myBoggleSearch;
	//-----------------------------------------------------------------
	//  Loads the list of word names into the list.
	//-----------------------------------------------------------------
	/**
	 * @param myWords An array of words to be placed into a list
	 * @param myLabel	Sets the label in the GUI to display the word selected by the list
	 * @param gui Takes in a reference to the gui, so that the word selected by the list picks buttons in the gui and highlights them accordingly
	 */
	public ListPanel (String[] myWords,JLabel myLabel, BoggleGUI gui)
	{
		
		
		label=myLabel;
		words=myWords;
		list = new JList (words);
		list.addListSelectionListener (new ListListener());
		list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.orange);
		this.gui = gui;

		add (list);
		setBackground (Color.white);
	}

	//*****************************************************************
	//  Represents the listener for the list of words.
	//*****************************************************************
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged (ListSelectionEvent ev)
		{
			if (list.isSelectionEmpty())
				System.out.println("Nothing Selected");//label.setIcon (null);
			else
			{
				String word = (String)list.getSelectedValue();
				chosenWord=word;
				label.setText(chosenWord);
				gui.actionPerformed(new ActionEvent(this, 0, "List item selected"));
			}
		}
	}
}

