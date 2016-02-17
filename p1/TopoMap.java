import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




/**
 * @author Haseeb Nain
 * This class is the base class for Topomap, and will take in a file of a grid of numbers, outputting various information about the Topomap.
 */
public class TopoMap implements TopoMapBaseInterface{

	
	private Scanner myScanner;
	private int baseSize; 
	
	private double[][] baseMap;
	private double[][] evalMap;
	private int rowSize;
	private int colSize;

	/**
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws InvalidFileFormatException
	 * 
	 * This is the constructor for the TopoMap class, it takes in the name for a file. 
	 */
	public TopoMap(String fileName) throws FileNotFoundException, InvalidFileFormatException{
		File myFile = new File(fileName);
		myScanner = new Scanner(myFile);
		
		rowSize = (int) Double.parseDouble(myScanner.next());
		colSize = (int) Double.parseDouble(myScanner.next());


		 baseMap = new double[rowSize][colSize];
		 baseSize = baseMap.length;
		 evalMap=new double[rowSize][colSize];

		
		 
		 for(int row = 0; row<rowSize;row++){
			 for(int col=0;col<colSize;col++){
				 if(!myScanner.hasNextDouble()){
					 throw new InvalidFileFormatException("Invalid format detected!");
				 }
				 baseMap[row][col]=myScanner.nextDouble();			  	 
			 }
		 }
		
		
	}
	
	

	/**
	 * @return the base map's minimum value
	 */
	public double getBaseMin() {
		
		double min = baseMap[0][0];
		for(int row = 0; row < baseSize; row++){
			for(int col = 0; col < baseSize; col++){
				if(baseMap[row][col] < min){
					min = baseMap[row][col];
				}
			}
		}
		
		return min;
	}

	/**
	 * @return the base map's maximum value
	 */
	public double getBaseMax() {

		double max = baseMap[0][0];
		for(int row = 0; row < baseSize; row++){
			for(int col = 0; col < baseSize; col++){
				if(baseMap[row][col] > max){
					max = baseMap[row][col];
				}
			}
		}
		return max;
	}


	/**
	 * @return the base map's average value
	 */
	public double getBaseAvg() {
		

		double sum =0;//= baseMap[0][0];
		double avg = 0;
		for(int row = 0; row < rowSize; row++){
			for(int col = 0; col < colSize; col++){
				sum=sum+ baseMap[row][col];
			}
			
			avg = sum/(baseSize*baseSize);
			
		}
		return avg;
	}


	/**
	 * @return the base map
	 */
	public double[][] getBaseMap() {
		return baseMap;
	}


	/**
	 * @param row - This is the row value of the coordinate
	 * @param col - This is the column of the coordinate
	 * @return
	 * 
	 * This method takes in the coordinates of a location on the grid and returns the value to the North. If the coordinate is placed at the north edge
	 * it will return the current number of the inputed location.
	 */
	public double getNorth(int row, int col){
		if((row-1) < 0){
			return baseMap[row][col]; 
		}
		else{
			return baseMap[row-1][col];
		}
	}

	/**
	 * @param row - This is the row value of the coordinate
	 * @param col - This is the column of the coordinate
	 * @return
	 * 
	 * This method takes in the coordinates of a location on the grid and returns the value to the South. If the coordinate is placed at the south edge
	 * it will return the current number of the inputed location.
	 */
	public double getSouth(int row, int col){
		if((row+1) >= rowSize){
			return baseMap[row][col]; 
		}
		else{
			return baseMap[row+1][col];
		}
	}


	/**
	 * 
	 * @param row - This is the row value of the coordinate
	 * @param col - This is the coloum of the coordinate
	 * @return a value west of the entry coordinate
	 * 
	 * This method takes in the coordinates of a location on the grid and returns the value to the West. If the coordinate is placed at the west edge
	 * it will return the current number of the inputed location.
	 */
	public double getWest(int row, int col){
		if((col-1) < 0){
			return baseMap[row][col];
		}
		else{
			return baseMap[row][col-1];
		}
	}

	/**
	 * @param row
	 * @param col
	 * @return
	 * 
	 * This method takes in the coordinates of a location on the grid and returns the value to the East. If the coordinate is placed at the east edge
	 * it will return the current number of the inputed location.
	 */
	public double getEast(int row, int col){
		
		if((col+1) >= colSize){
			return baseMap[row][col];

		}
		else{
			return baseMap[row][col+1];
		}
	}
	
	
	/**
	 * @param row
	 * @param col
	 * @return
	 * 
	 * This method will return the new value of the inputed coordinate by using the getNorth, getEast, getSouth and getWest methods. The new value is then returned
	 */
	public double newValue(int row,int col){
		double myNum;
		
		myNum=(getNorth(row, col)+getEast(row, col)+getSouth(row, col)+getWest(row, col));
		
		return myNum;
	}


	/**
	 * Returns a map with the same dimensions as the base map, but each element
	 * is the sum of the 4 surrounding positions in the base map (with edges
	 * "mirrored"). This method is public, for testing purposes, but will be
	 * made a private utility method in the final TopoMap class.
	 * 
	 * @return map containing sums of surrounding elevations
	 */

	public double[][] getSurroundingElevationsMap() {

		
		
		for(int row = 0; row < rowSize; row++){
			for(int col = 0; col < colSize; col++){
				evalMap[row][col]=newValue(row, col);
			}
		}
		
		return evalMap;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 */
	public String toString(){

		
		getSurroundingElevationsMap();
		String outPut=("\nTopoMap\n_______________________________________________________\n");
		outPut=outPut+("-----------------------------------------\n Original map\n-----------------------------------------\n");
		
		for(int row = 0; row < rowSize; row++){
			for(int col = 0; col < colSize; col++){
				outPut=outPut+" "+baseMap[row][col];
			}
			outPut=outPut+"\n";
		}
		outPut=outPut+ "\nThe Average for this map is: " + getBaseAvg()+ "\nThe Max for this map is:" + getBaseMax()+ "\nThe Min for this map is: " + getBaseMin()+"\n";
		
		outPut=outPut+("-----------------------------------------\n Elevataed map\n-----------------------------------------\n");
		
		for(int row = 0; row < rowSize; row++){
			for(int col = 0; col < colSize; col++){
				outPut=outPut+" "+evalMap[row][col];
			}
			outPut=outPut+"\n";
		}
		outPut=outPut+"_______________________________________________________\n";
		return outPut;
	}

}
