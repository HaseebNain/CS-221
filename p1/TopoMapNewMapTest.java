import java.io.FileNotFoundException;


/**
 * @author Haseeb Nain
 *
 */
public class TopoMapNewMapTest {

	public static void main(String[] args) throws FileNotFoundException, InvalidFileFormatException {

	TopoMap myMap = new TopoMap("myMap.txt"); 
	
	System.out.println(myMap.toString());
	System.out.println("The avg for the Map is: \n"+ myMap.getBaseAvg());
	System.out.println("The max for the Map is: \n"+ myMap.getBaseMax());
	System.out.println("The min for the Map is: \n"+ myMap.getBaseMin());
	
	System.out.println(myMap.toString());
	System.out.println("Location test for point(1,1)");
	
	System.out.println("North: "+myMap.getNorth(1, 1));
	System.out.println("East: "+myMap.getEast(1, 1));
	System.out.println("South: "+myMap.getSouth(1, 1));
	System.out.println("West: "+myMap.getWest(1,1));
	
	System.out.println(myMap.getEast(1, 1)+myMap.getNorth(1, 1)+myMap.getSouth(1, 1)+myMap.getSouth(1, 1));
	
	myMap.getSurroundingElevationsMap();
	

	
	System.out.println(myMap.getEast(1, 1));
	System.out.println(myMap.getEast(1, 1)+myMap.getNorth(1, 1)+myMap.getSouth(1, 1)+myMap.getSouth(1, 1));


	}

}
