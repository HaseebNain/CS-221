/**
 * Put an array of ints in ascending order.
 * @author mvail
 */
public class OrderTest {
	/**
	 * Get an array of specified size and pass it to Order.order().
	 * Report the results.
	 * @param args either size of a new array, or a file containing ints
	 */
	public static void main(String[] args) {
		if (args.length != 1) {//1
			System.out.println("Usage:  java OrderTest sizeOfArray\n"
					+ "\tor\n\tjava OrderTest arrayFile");
			System.exit(1);
		}
		
		// create or read the int[]
		int size = 0;
		int[] array = new int[0];//5
		try {
			size = Integer.parseInt(args[0]);
			array = ArrayOfInts.randomizedArray(size);
		} catch (NumberFormatException nfe) {//8 
			try {
				array = ArrayOfInts.arrayFromFile(args[0]);
				size = array.length;
			} catch (Exception e) {
				System.err.println("unable to read array from " + args[0]);
				System.exit(1);//14
			}
		}
		
		System.out.println("before:");//15
		for (int i = 0; i < array.length; i++) {//2 n
			System.out.printf(((i+1) % 10 > 0) ? " %d" : " %d\n", array[i]);//1
		}
		
		int myNum = Order.order(array); //this is the call we want to measure
		
		System.out.println("\nafter:");//18
		for (int i = 0; i < array.length; i++) {//2 n
			System.out.printf(((i+1) % 10 > 0) ? " %d" : " %d\n", array[i]);
		}
		
		System.out.println(myNum);
		
	}
}
