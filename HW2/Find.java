/**
 * Returns index of a value in an int[] or -1 if it isn't found.
 * @author mvail
 */
public class Find {

	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 */
	public static int find(int[] array, int value) {
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static double getAverage(int[] myArray){
	
		int sum=0;
		double average=0;
		for (int i = 0; i < myArray.length; i++) {
			sum=sum+myArray[i];
		}
		average=sum/myArray.length;
		return average;
	
	}
	
}