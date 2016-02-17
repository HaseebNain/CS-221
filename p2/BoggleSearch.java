import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * BoggleSearch configures a game of Boggle and finds all words from a dictionary
 * found in the board. The program can either run as an interactive GUI or output
 * the found word list to the console. A board can be randomly generated or loaded
 * from an input file.
 * 
 * @author hnain
 */
@SuppressWarnings("serial")
public class BoggleSearch {
	private final int BOARD_DIMENSION; //can be initialized (once) in constructor

	private BoggleBoard board;
	private static Storage<BoggleSearchState> stateStore;
	private static ArrayList<BoggleSearchState> foundWordPaths=new ArrayList<BoggleSearchState>();
	private static HashSet<String> foundWords = new HashSet<String>();

	private static String myLetters="";
	private static BoggleGUI myBoggleGUI;

	private boolean isGUIFormat=false;
	private int dimensions;
	private int firstArg;
	private String secondArg, thirdArg,fourthArg;
	private static Boolean isDEBUG=false;

	private File myFile;
	private String nameOfFile;

	//TODO: other instance variables or constants, as necessary

	/**
	 * Configures the program according to command line options and launches
	 * the word search.
	 * 
	 * @param args
	 * 		boardDimension (positive integer required)<br>
	 * 		one of "-s" for stack or "-q" for queue (required)<br>
	 * 		one of "-c" for console output or "-g" for GUI display (required)<br>
	 * 		filename containing a starting Boggle board configuration (optional)
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		boolean isStack;
		boolean isGUI;
		int firstArg;
		String fourthArg;

		//Uncomment to enter DEBUG Mode
		//isDEBUG=true;


		try{

			firstArg= Integer.parseInt(args[0]);
			String secondArg = args[1].toString().toLowerCase();
			if(secondArg.equals("-s")||secondArg.equals("-q")){
				if(secondArg.equals("-s")){
					isStack=true;
				}else{
					isStack=false;
				}
			}else{
				throw new IllegalArgumentException("Error with 2nd Arguement!");
			}

			String thirdArg = args[2].toString().toLowerCase();
			if(thirdArg.equals("-c")||thirdArg.equals("-g")){
				if(thirdArg.equals("-g")){
					isGUI=true;
				}else{
					isGUI=false;
				}
			}

			else{
				throw new IllegalArgumentException("Error with 3rd Arguement!");
			}
			fourthArg = args[3].toString().toLowerCase();

		}catch(Exception e){
			throw new IllegalArgumentException("Check your arguements, they are invalid!");
		}


		if(isGUI){
			BoggleSearch mySearch = new	BoggleSearch(firstArg,isStack,isGUI,fourthArg);
			mySearch.searchBoggle();
			myBoggleGUI = new BoggleGUI(firstArg,myLetters,foundWords,mySearch);
		}else{
			BoggleSearch mySearch = new	BoggleSearch(firstArg,isStack,isGUI,fourthArg);
			mySearch.searchBoggle();
			System.out.println(mySearch.boggleToString());

		}

	}




	/**
	 * 
	 * This is the constructor, it will be responsible for equating all values to be used in searching for words.
	 * @param dimensions this will set the size of the grid to be searched by the BoggleSearch
	 * @param isStack this will determine whether the searching will be done via stacks or queues
	 * @param isGUI this will determine whether to print the words to the console or create a GUI to showcase the BoggleBoard
	 * @param fileName this will be the file to be searched by the program
	 * @throws FileNotFoundException in the case that the file is not found, an exception will be thrown
	 */
	private BoggleSearch(int dimensions, boolean isStack,boolean isGUI, String fileName) throws FileNotFoundException{
		String fileOutput="Grid is as follows:\n\n";
		myFile = new File(fileName);
		Scanner myScanner = new Scanner(myFile);
		while(myScanner.hasNext()){
			fileOutput=fileOutput+myScanner.nextLine()+"\n";
		}




		File letterFile = new File(fileName);
		Scanner fileScanner = new Scanner(letterFile);
		while(fileScanner.hasNext()){
			myLetters=myLetters+fileScanner.nextLine();
		}
		if(myLetters.length()!=(dimensions*dimensions)){
			throw new InvalidParameterException("Dimensions doesn't equal the size of the grid!");
		}
		if(isDEBUG){
			System.out.println("The Letters in This Grid are: "+myLetters);
			System.out.println(fileOutput);
		}
		BOARD_DIMENSION=dimensions;

		try{
			board = new BoggleBoard(BOARD_DIMENSION,fileName);

		}catch(Exception e){

		}
		if(isStack==true){
			stateStore = new Storage<BoggleSearchState>(Storage.DataStructure.stack);
		}else{
			stateStore = new Storage<BoggleSearchState>(Storage.DataStructure.queue);
		}
		if(isGUI==true){
			isGUIFormat=true;
		}

		nameOfFile=fileName;
		myFile = new File(fileName);
	}

	/**
	 * @return foundWordPaths, which is the path determined by the private BoggleSearchState class.
	 * 
	 */
	public ArrayList<BoggleSearchState> get(){
		return foundWordPaths;
	}


	/**
	 * @param word
	 * @return A point as found by BoggleSearchStates getPath() method. Which when looped will give the coordinates of each 
	 * 			letter in the word
	 */
	public Point[][] getFoundPathPoints(String word){
		int index = 0;
		BoggleSearchState tmp = foundWordPaths.get(index);
		while(!tmp.word.equalsIgnoreCase(word) && index < foundWordPaths.size()&&!word.equals("-----")){
			tmp=foundWordPaths.get(index);
			index++;
		}
		return tmp.getPath();


	}
	/**
	 * @return Returns a string equal to all the words found by the BoggleSearch
	 */
	public String boggleToString(){
		String outPut="";

		for(String words:foundWords){
			outPut=outPut+"\n"+words.toString();
		}	
		return outPut;
	}





	/**
	 * @throws Exception 
	 * Will search the boggle board for all possible word combinations, and store those words which are found in the BoggleDictionary
	 */
	public void searchBoggle() throws Exception{

		int lengthState=0;
		int maxLength=0;
		BoggleDictionary validWords = new BoggleDictionary();
		for(int row =0;row<BOARD_DIMENSION;row++){
			for (int col=0;col<BOARD_DIMENSION;col++){
				BoggleSearchState search =  new BoggleSearchState(row,col);	
				stateStore.store(search);
			}
		}
		int count=0;

		while(!stateStore.isEmpty()){
			count++;
			BoggleSearchState temp = stateStore.retrieve();
			if(temp.toString().length()>=3&&temp.toString().length()<=17){
				if(validWords.contains(temp.toString())){
					foundWordPaths.add(temp);
					foundWords.add(temp.getWord());
				}
			}
			lengthState=stateStore.size();
			if(lengthState>maxLength){
				maxLength=lengthState;
			}
			//System.out.println(lengthState=stateStore.size());
			if(temp.validNeighbor(temp.getRow()-1, temp.getCol()-1)){
				BoggleSearchState topLeft= new BoggleSearchState(temp.getRow()-1, temp.getCol()-1,temp);
				stateStore.store(topLeft);
			}
			if(temp.validNeighbor(temp.getRow()-1, temp.getCol())){
				BoggleSearchState top= new BoggleSearchState(temp.getRow()-1, temp.getCol(),temp);
				stateStore.store(top);
			}
			if(temp.validNeighbor(temp.getRow()-1, temp.getCol()+1)){
				BoggleSearchState topRight= new BoggleSearchState(temp.getRow()-1, temp.getCol()+1,temp);
				stateStore.store(topRight);
			}
			if(temp.validNeighbor(temp.getRow(), temp.getCol()-1)){
				BoggleSearchState left= new BoggleSearchState(temp.getRow(), temp.getCol()-1,temp);
				stateStore.store(left);
			}
			if(temp.validNeighbor(temp.getRow(), temp.getCol()+1)){
				BoggleSearchState right= new BoggleSearchState(temp.getRow(), temp.getCol()+1,temp);
				stateStore.store(right);
			}
			if(temp.validNeighbor(temp.getRow()+1, temp.getCol()-1)){
				BoggleSearchState botLeft= new BoggleSearchState(temp.getRow()+1, temp.getCol()-1,temp);
				stateStore.store(botLeft);
			}
			if(temp.validNeighbor(temp.getRow()+1, temp.getCol())){
				BoggleSearchState bot= new BoggleSearchState(temp.getRow()+1, temp.getCol(),temp);
				stateStore.store(bot);
			}
			if(temp.validNeighbor(temp.getRow()+1, temp.getCol()+1)){
				BoggleSearchState botRight= new BoggleSearchState(temp.getRow()+1, temp.getCol()+1,temp);
				stateStore.store(botRight);
			}
		}
		if(isDEBUG){
			System.out.println("The amount of times the search repeated: "+count+" for a grid of size: "+(BOARD_DIMENSION*BOARD_DIMENSION)+"\n Largest StateStore size: "+maxLength);
		}

	}

	////////////////////////////////////////////////////////
	// INNER CLASS: BOGGLESEARCHSTATE
	////////////////////////////////////////////////////////

	/** Represents a path through the current Boggle board. It may or may
	 * not represent a valid word or partial word.
	 * @author mvail
	 */

	public class BoggleSearchState {
		/** sentinal value for the start of a path */
		private final Point INITIAL_POINT = new Point(-1, -1);

		/** occupied positions are part of the path while 
		 * the Points in each position indicate that position's
		 * predecessor, for tracing the order of the path */
		private Point[][] searchPath;
		/** the last Point in the path - next states must extend from this Point */
		private Point lastPoint;
		/** the character sequence formed by the path */
		private String word;

		/** Initialize a search path
		 * @param initialRow starting row coordinate for a search path
		 * @param initialCol starting col coordinate for a search path
		 */
		public BoggleSearchState(int initialRow, int initialCol) {
			searchPath = new Point[BOARD_DIMENSION][BOARD_DIMENSION];
			lastPoint = new Point(initialRow, initialCol); //must precede call to validState()
			if (inBounds()) {
				//these coordinates have no predecessor, so store sentinel Point
				//as predecessor of this Point in the searchPath
				searchPath[initialRow][initialCol] = INITIAL_POINT;
				//start word with the letter at current lastPoint position
				if (board.charAt(initialRow, initialCol) == 'Q') {
					word = "QU";
				} else {
					word = Character.toString(board.charAt(initialRow, initialCol));
				}
			} else {
				throw new IllegalArgumentException();
			}
		}

		/** Extend a search path to a new position from previousState
		 * @param newRow row coordinate of this position
		 * @param newCol col coordinate of this position
		 * @param previousState path prior to this position
		 */
		public BoggleSearchState(int newRow, int newCol, BoggleSearchState previousState) {
			searchPath = new Point[BOARD_DIMENSION][BOARD_DIMENSION];
			//duplicate the previous state's path for independence between states
			for (int row = 0; row < searchPath.length; row++) {
				for (int col = 0; col < searchPath[row].length; col++) {
					searchPath[row][col] = previousState.searchPath[row][col];
				}
			}
			lastPoint = new Point(newRow, newCol);
			if (inBounds() && searchPath[newRow][newCol] == null) {
				//store previous state's lastPoint as the predecessor of this state's lastPoint
				searchPath[newRow][newCol] = previousState.lastPoint; //need a copy?
				//add current lastPoint's corresponding letter to word
				if (board.charAt(newRow, newCol) == 'Q') {
					word = previousState.getWord() + "QU";
				} else {
					word = previousState.getWord() + Character.toString(board.charAt(newRow, newCol));
				}
			} else {
				throw new IllegalArgumentException();
			}
		}

		/** @return true if coordinates are in-bounds */
		private boolean inBounds() {
			boolean valid = true;
			if (lastPoint.x < 0 || lastPoint.x >= searchPath.length
					|| lastPoint.y < 0 || lastPoint.y >= searchPath[lastPoint.x].length) {
				valid = false;
			}
			return valid;
		}




		/** Check if a potential next path step is valid
		 * @param row row of potential next step
		 * @param col col of potential next step
		 * @return true if next step is adjacent and available
		 */
		public boolean validNeighbor(int row, int col) {
			boolean isValid = true;
			if (Math.abs(row - lastPoint.x) > 1 || Math.abs(col - lastPoint.y) > 1) {
				isValid = false;
			}
			if (row < 0 || row >= searchPath.length || col < 0 || col >= searchPath[row].length
					|| searchPath[row][col] != null) { //depending on short-circuiting
				isValid = false;
			}
			return isValid;
		}

		/** @return word (or gibberish) formed by this search path */
		public String getWord() {
			return word;
		}

		/** @return copy of the search path */
		public Point[][] getPath() {
			Point[][] copy = new Point[searchPath.length][searchPath.length];
			for (int row = 0; row < searchPath.length; row++) {
				for (int col = 0; col < searchPath[row].length; col++) {
					copy[row][col] = searchPath[row][col];
				}
			}
			return copy;
		}

		/** @return row of last position */
		public int getRow() {
			return lastPoint.x;
		}

		/** @return col of last position */
		public int getCol() {
			return lastPoint.y;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return word;
		}
	} //BoggleSearchState class

}//BoggleSearch class
