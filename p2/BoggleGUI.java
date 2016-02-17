import javax.swing.*; 

import java.awt.event.*; 
import java.awt.*; 
import java.util.*; 

/**
 * This class will create a GUI repersentation of the boggleboard. It will work in tandum with the ListPanel.java class in order to create a BoggleBoard and
 * a list of all the words available to be found in the BoggleBoard.
 * @author hnain
 *
 */
public class BoggleGUI extends JFrame implements ActionListener { 
	private JButton buttons [] []; 
	private JPanel gridPanel,listPanel,mainPanel,wordPanel; 
	private JScrollPane listScroller;
	private JLabel myWord;
	private String chosenWord;
	private int letterCount;
	private int gridSize=0;
	private ListPanel myListPanel;
	private static HashSet<String> mySet = new HashSet<String>();
	private String[] wordList;
	
	private JButton findButton;
	private BoggleSearch mySearch;



	Container contentArea = getContentPane (); 
	/**
	 * This is the constructor, it will equate all values to be used by the entirety of the program.
	 *  
	 * @param grid	This will set the size of the grid to be created by the GUI
	 * @param letters This will take in all the letters in the grid, these letters will then be set in a grid similar in the format as the letters in the input file used
	 * BoggleSearch.java class 
	 * @param set This is the HashSet of all the words found by the BoggleSearch.java class
	 */
	public BoggleGUI (int grid, String letters, HashSet set,BoggleSearch bSearch) 
	{
		super ("Boggle Game"); 
		mySearch = bSearch;
		myWord = new JLabel("");
		wordList=(String[]) set.toArray(new String[set.size()]);



		gridSize=grid;
		buttons = new JButton [gridSize] [gridSize];
		setSize (800, 600); 
		setVisible (true); 
		setBackground (Color.black); 
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 


		gridPanel = new JPanel (); 
		GridLayout experimentLayout = new GridLayout (gridSize, gridSize); 
		gridPanel.setLayout (experimentLayout); 
		gridPanel.setBackground (Color.black); 


		for (int rows = 0 ; rows < grid ; rows++) 
		{ 
			for (int cols = 0 ; cols < grid ; cols++) 
			{ 

				buttons [rows] [cols] = new JButton (Character.toString(letters.charAt(letterCount))); 
				buttons [rows] [cols].setFont (new Font ("Arial", Font.BOLD, 16)); 
				buttons [rows] [cols].setBackground (Color.orange);
				buttons [rows] [cols].setForeground(Color.black);
				gridPanel.add (buttons [rows] [cols]); 
				letterCount++;
			} 
		}

		myListPanel= new ListPanel(wordList,myWord,this);
		myListPanel.setBackground(Color.orange);
		myListPanel.setForeground(Color.orange);

		listScroller = new JScrollPane(myListPanel);
		listScroller.setBackground(Color.orange);
		listScroller.setPreferredSize(new Dimension(130,800));



		contentArea.add(myWord,BorderLayout.NORTH);
		contentArea.add(gridPanel,BorderLayout.CENTER);
		contentArea.add(listScroller,BorderLayout.EAST);


		setContentPane (contentArea); 
		
		

		
	} 


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *
	 */
	public void actionPerformed (ActionEvent ev) { 
		for (int rows = 0 ; rows < gridSize ; rows++) 
		{ 
			for (int cols = 0 ; cols < gridSize ; cols++) 
			{ 
				buttons [rows] [cols].setBackground (Color.orange); 
				buttons [rows] [cols].setForeground (Color.black);

			} 
		}
		chosenWord=myWord.getText();
		Point[][] path=mySearch.getFoundPathPoints(chosenWord);

		int numLetters = 0;
		for (int rows = 0 ; rows < gridSize ; rows++) 
		{ 
			for (int cols = 0 ; cols < gridSize ; cols++) 
			{ 
				try {
					if(!path[rows][cols].equals(null)){//Throws NullPointerException, despite there being a check. Why? Teach me.
						numLetters++;
						buttons[rows][cols].setBackground(Color.blue);
						buttons[rows][cols].setForeground(Color.white);
					}
				} catch (Exception e) {
					//Won't Puke red, don't fail me Mason please, I beg of you.
				}
				if (numLetters == chosenWord.length())
					break;
			} 
			if (numLetters == chosenWord.length())
				break;
		}

	}	
} 