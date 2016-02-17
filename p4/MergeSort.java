import java.util.*;

/**
 * Class for sorting DoubleLinkedLists using either natural order or a
 * Comparator.
 * 
 * @author spanter, mvail, hnain
 */
public class MergeSort {
	
	/**
	 * Sort a list that implements the DoubleLinkedListADT using the natural  
	 * ordering of list elements DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The data type in the list must extend Comparable
	 * @param list
	 *            The list that will be sorted
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> void sort(
		DoubleLinkedListADT<T> list) {

		
		//This is the base case, if the list has a size of one, it is by definition already sorted
		if (list.size() <= 1) {
			return;
		}
		
		if (list.isEmpty())
			return;
		
		WrappedDLL<T> firstHalf = new WrappedDLL<T>(), secondHalf = new WrappedDLL<T>();

		//Divides the list into two halves
		for (int x = 0; x < (list.size() / 2); x++) {
			firstHalf.addToRear(list.get(x));
		}
		for (int x = (list.size() / 2); x < list.size(); x++) {
			secondHalf.addToRear(list.get(x));
		}

		//Recursively sort
		sort(firstHalf);

		sort(secondHalf);

		//Merge the two halves together until the final list is sorted.
		merge(firstHalf, secondHalf, list);

	}

	/**
	 * This will merge the two halves of the original list, in the natural order as deemed by the compareTo method.
	 * 
	 * @param first the first half of the list 
	 * @param second the second half of the list
	 * @param list the original list, that will be sorted
	 */
	private static <T extends Comparable<T>> void merge(
			DoubleLinkedListADT<T> first, DoubleLinkedListADT<T> second,
			DoubleLinkedListADT<T> list) {
		
		//Because Java is reference by value I have to erase the original list first
		while( list.size() !=0){
			list.removeFirst();
		}
		//I will compare the first value of the two lists, and then add the smaller value to the original list.
		//These comparisons are done though the compareTo method.
		while (first.size() > 0 && second.size() > 0) {
			if (first.get(0).compareTo(second.get(0)) < 0)
				list.add(first.remove(0));
			else
				list.add(second.remove(0));
		}

		//This will add the remaining elements of the first list to the original list
		while (first.size() != 0) {
			list.add(first.removeFirst());
		}

		//This will add the remaining elements of the second list to the original list
		while (second.size() != 0) {
			list.add(second.removeFirst());
		}
	}

	/**
	 * Sort a DoubleLinkedListADT with the provided Comparator DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of list to sort
	 * @param list
	 *            The list to sort
	 * @param c
	 *            The Comparator to use
	 * @see DoubleLinkedListADT
	 */
	public static <T> void sort(DoubleLinkedListADT<T> list, Comparator<T> c) {
	

			DoubleLinkedListADT<T> temp = new WrappedDLL<T>();

			//This is the base case, if the list has a size of one, it is sorted by definition.
			if (list.size() <= 1) {
				return;
			}
			WrappedDLL<T> firstHalf = new WrappedDLL<T>(), secondHalf = new WrappedDLL<T>();

			//Divide the list into two halves
			for (int x = 0; x < (list.size() / 2); x++) {
				firstHalf.addToRear(list.get(x));
			}
			for (int x = (list.size() / 2); x < list.size(); x++) {
				secondHalf.addToRear(list.get(x));
			}

			//recursivly sort the list halves
			sort(firstHalf,c);

			sort(secondHalf,c);

			//merge the two halves together to get a sorted list.
			//This merge method is also where I will be using the Comparator
			merge(firstHalf, secondHalf, list,c);

	}

	/**
	 * This will merge the two halves of the original list, in the order as deemed by the Comparator's compare method.
	 * 
	 * @param first The first half of the list 
	 * @param second the second half of the list
	 * @param list the original list being sorted
	 * @param c a comparator which will be used for the comparisons
	 */
	private static <T> void merge(DoubleLinkedListADT<T> first, DoubleLinkedListADT<T> second,
			DoubleLinkedListADT<T> list,Comparator<T> c) {
		
		//The original list is emptied
		while( list.size() !=0){
			list.removeFirst();
		}
		//the contents of the two halves of the list are compared, the smaller value as deemed by the comparator will be added to the original list.
		while (first.size() > 0 && second.size() > 0) {
			int compVal = c.compare(first.get(0),second.get(0)); 
			if ( compVal < 0)
				list.add(first.remove(0));
			else
				list.add(second.remove(0));
		}

		//this will add the remaining elements from the first list to the original list
		while (first.size() != 0) {
			list.add(first.removeFirst());
		}
		
		//this will add the remaining elements from the second list to the original list
		while (second.size() != 0) {
			list.add(second.removeFirst());
		}
	}

	/**
	 * Find the smallest element in a list according to the natural ordering of  
	 * list elements DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The smallest element
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findSmallest(
			DoubleLinkedListADT<T> list) {

		//Create my iterator, and use the first value as the original smallest value
		ListIterator<T> it1 = list.listIterator();
		T smallestVal = list.first();
		T compareVal = it1.next();

		//If empty, return null
		if(list.isEmpty()){
			return null;
		}
		//If the list has a size of one, then the smallest value is the value of the list.
		if (list.size() == 1) {
			return list.first();
		}
		
		//If the list has a size of two, I will compare the two values in the list and return the smallest
		if (list.size() == 2) {
			if (list.first().compareTo(list.last()) >= 0) {
				return list.last();
			} else {
				return list.first();
			}
		}

		//If the list has a size greater than one, I will iterate through the list, replacing the smallest value with any value smaller then it.
		while (it1.hasNext()) {
			compareVal = it1.next();
			if (smallestVal.compareTo(compareVal) >= 0) {
				smallestVal = compareVal;

			}
		}
		
		// Return the smallest value.
		return smallestVal;

	}

	/**
	 * Find the smallest element in a list with a Custom comparator DO NOT
	 * MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The smallest element
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findSmallest(DoubleLinkedListADT<T> list, Comparator<T> c) {
		
		//Create my iterator, and use the first value as the original smallest value
		ListIterator<T> it1 = list.listIterator();
		T smallestVal = list.first();
		
		
		//If empty, return null
		if(list.isEmpty()){
			return null;
		}
		//If the list has a size of one, then the smallest value is the value of the list.
		if (list.size() == 1) {
			return list.first();
		}
		
		//If the list has a size of two, I will use the comparator to compare the two values in the list and return the smallest
		if (list.size() == 2) {
			if (c.compare(list.first(),list.last()) >= 0) {
				return list.last();
			} else {
				return list.first();
			}
		}
		
		
		//If the list has a size greater than one, I will iterate through the list Comparing values and replacing the smallest value with any value smaller then it.
		for (int x = 0; x < list.size(); x++) {
			if (it1.hasNext()) {
				T it1Val = it1.next();
				int compVal = c.compare(smallestVal, it1Val);
				if (compVal >= 0) {
					smallestVal = it1Val;
				}
			}
		}
		// Return the smallest value.
		return smallestVal;

	}

	/**
	 * Find the largest element in a list according to the natural ordering of
	 * list elements DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The largest element
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findLargest(
			DoubleLinkedListADT<T> list) {

		//Create my iterator, and use the first value as the original largest value
		ListIterator<T> it1 = list.listIterator();
		T largestVal = list.first();
		T compareVal = it1.next();
		
		//If empty, return null
		if(list.isEmpty()){
			return null;
		}
		
		//If the list has a size of one, then the largest value is the value of the list.
		if (list.size() == 1) {
			return list.first();
		}
		
		//If the list has a size of two, I will compare the two values in the list and return the largest
		if (list.size() == 2) {
			if (list.first().compareTo(list.last()) >= 0) {
				return list.first();
			} else {
				return list.last();
			}
		}

		//If the list has a size greater than one, I will iterate through the list, replacing the largest value with any value larger than it.
		while (it1.hasNext()) {
			compareVal = it1.next();
			if (largestVal.compareTo(compareVal) <= 0) {
				largestVal = compareVal;

			}
		}
		// Return the largest value.
		return largestVal;

	}

	/**
	 * Find the largest element in a list with a Custom comparator DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The largest element
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findLargest(DoubleLinkedListADT<T> list, Comparator<T> c) {
	
		//Create my iterator, and use the first value as the original smallest value
		T largestVal = list.first();
		ListIterator<T> it1 = list.listIterator();
	
		//If empty, return null
		if(list.isEmpty()){
			return null;
		}
		
		//If the list has a size of one, then the smallest value is the value of the list.
		if(list.size()==1){
			return list.first();
		}
		
		//If the list has a size of two, I will use the comparator to compare the two values in the list and return the largest
		if (list.size() == 2) {
			if (c.compare(list.first(),list.last()) >= 0) {
				return list.first();
			} else {
				return list.last();
			}
		}
		
		//If the list has a size greater than one, I will iterate through the list comparing the list through the Comparator, replacing the largest value with any value larger then it.
		for (int x = 0; x < list.size(); x++) {
			if (it1.hasNext()) {
				T it1Val = it1.next();
				int compVal = c.compare(largestVal, it1Val);
				if (compVal <= 0) {
					largestVal = it1Val;
				}
			}
		}
		
		// Return the largest value.
		return largestVal;
	}
}
