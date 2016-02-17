import java.util.Comparator;


/**
 * 
 * This class implements Comparator and returns the value opposite the comparator's natural order, which will be compared using the extended comparable.
 * @author Haseeb Nain
 *
 * @param <T>
 */
public class reverseComparator<T extends Comparable<T>> implements Comparator<T>{


	
		@Override
		public int compare(T o1, T o2) {
			
			// I will store the value of the compareTo method, which has compared the two objects.
			int compVal = o1.compareTo(o2);
			
			//If the original compareTo value is less than zero I will return a positive number, in this case 1.
			if(compVal<0){
				return 1;
			}
			
			//If the original compareTo value is greater than zero I will return a negative number, in this case -1.
			if(compVal >0){
				return -1;
			}
			
			//If none of these are the case, I will simply return zero.
				return 0;
			
		}
		

}
	

