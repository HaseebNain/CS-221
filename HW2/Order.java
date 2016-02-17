/**
 * Takes an array and reorders it so elements are in ascending order.
 * @author mvail
 */
public class Order {

	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * @param array ints that need to be ordered 
	 */
	public static int order(int[] array) {

		int myNum = 0;
		
		for (int next = 1; next < array.length; next++) {//2
        	//n
        	myNum++;
            int val = array[next];
            int index = next;
            while (index > 0 && val < array[index - 1]) {//3
                array[index] = array[index - 1];//n
                index--;
                
                myNum++;
            }
            array[index] = val;
        }
        return myNum;
	}
	
	
	}


