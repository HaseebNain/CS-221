import java.util.Iterator;

/**
 * A unit test class for UnorderedListADT.
 * This is a set of black box tests that should work for
 *  any implementation of UnorderedListADT.
 * 
 * NOTE: One example test is given for each method using a new
 * list to get you started.
 * 
 * Method newList() returns one of two (or more) alternate
 * implementations to all tests, so you don't have to do a
 * search and replace on constructor calls in every test.
 *  
 * @author hnain
 */
public class UnorderedListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/** @param args not used */
	public static void main(String[] args) {
		//to avoid every method being static
		UnorderedListTester tester = new UnorderedListTester();
		tester.runTests();
	}

	/**
	 * Returns an UnorderedListADT so the implementation can be changed
	 * in this one location rather than in every test.
	 * @return a new UnorderedListADT
	 */
	private ArrayList<Integer> newList() {
		//TODO: enable only one of the two following
		// lines or add a new implementation to test
		return new ArrayList(100);
		//		return new BadUnorderedList<Integer>();
	}

	/** Print test results in a consistent format
	 * @param testDesc description of the test
	 * @param result indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		total++;
		if (result) {
			passes++;
		} else {
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** Print a final summary */
	private void printFinalSummary() {
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n", total, passes, failures);
	}

	/**
	 * Run tests to confirm required functionality from list constructors and methods
	 */
	protected void runTests() {
		// TESTS ON A NEW, EMPTY LIST

		printTest("testAddToFrontOnNewList", testAddToFrontOnNewList());
		printTest("testAddToRearOnNewList", testAddToRearOnNewList());
		printTest("testAddAfterOnNewList", testAddAfterOnNewList());
		printTest("testRemoveFirstOnNewList", testRemoveFirstOnNewList());
		printTest("testRemoveLastOnNewList", testRemoveLastOnNewList());
		printTest("testRemoveElementOnNewList", testRemoveElementOnNewList());
		printTest("testFirstOnNewList", testFirstOnNewList());
		printTest("testLastOnNewList", testLastOnNewList());
		printTest("testContainsOnNewList", testContainsOnNewList());
		printTest("testIsEmptyOnNewList", testIsEmptyOnNewList());
		printTest("testSizeOnNewList", testSizeOnNewList());
		printTest("testIteratorOnNewList", testIteratorOnNewList());
		printTest("testToStringOnNewList", testToStringOnNewList());

		//Tests AddToFront() through various scenarios
		printTest("testAddToFrontOnListWithElement",testAddToFrontOnListWithElement());
		printTest("testAddToFrontOnListWithElement_SizeTest",testAddToFrontOnListWithElement_SizeTest());
		printTest("testAddToFrontOnListWithElement_isEmptyTest",testAddToFrontOnListWithElement_isEmptyTest());
		printTest("testAddToFrontOnListWithElement_FirstTest",testAddToFrontOnListWithElement_FirstTest());
		printTest("testAddToFrontOnListWithElement_LastTest",testAddToFrontOnListWithElement_LastTest());
		printTest("testAddToFrontOnListWithTwoElements",testAddToFrontOnListWithTwoElements());
		printTest("testAddToFrontOnListWithTwoElements_SizeTest",testAddToFrontOnListWithTwoElements_SizeTest());
		printTest("testAddToFrontOnListWithTwoElements_isEmptyTest",testAddToFrontOnListWithTwoElements_isEmptyTest());
		printTest("testAddToFrontOnListWithTwoElements_FirstTest",testAddToFrontOnListWithTwoElements_FirstTest());
		printTest("testAddToFrontOnListWithTwoElements_LastTest",testAddToFrontOnListWithTwoElements_LastTest());

		//Tests AddToRear() through various scenarios
		printTest("testAddToRearOnListWithElement",testAddToRearOnListWithElement());
		printTest("testAddToRearOnListWithElement_SizeTest",testAddToRearOnListWithElement_SizeTest());
		printTest("testAddToRearOnListWithElement_isEmptyTest",testAddToRearOnListWithElement_isEmptyTest());
		printTest("testAddToRearOnListWithElement_FirstTest",testAddToRearOnListWithElement_FirstTest());
		printTest("testAddToRearOnListWithElement_LastTest",testAddToRearOnListWithElement_LastTest());
		printTest("testAddToRearOnListWithTwoElements",testAddToRearOnListWithTwoElements());
		printTest("testAddToRearOnListWithTwoElements_SizeTest",testAddToRearOnListWithTwoElements_SizeTest());
		printTest("testAddToRearOnListWithTwoElements_isEmptyTest",testAddToRearOnListWithTwoElements_isEmptyTest());
		printTest("testAddToRearOnListWithTwoElements_FirstTest",testAddToRearOnListWithTwoElements_FirstTest());
		printTest("testAddToRearOnListWithTwoElements_LastTest",testAddToRearOnListWithTwoElements_LastTest());

		//Tests AddAfter(element, target) through various scenarios
		printTest("testAddAfterOnListWithElement",testAddAfterOnListWithElement());
		printTest("testAddAfterOnListWithElement_SizeTest",testAddAfterOnListWithElement_SizeTest());
		printTest("testAddAftertOnListWithElement_isEmptyTest",testAddAftertOnListWithElement_isEmptyTest());
		printTest("testAddAfterOnListWithElement_FirstTest",testAddAfterOnListWithElement_FirstTest());
		printTest("testAddAfterOnListWithElement_LastTest",testAddAfterOnListWithElement_LastTest());
		printTest("testAddAfterOnListWithTwoElements",testAddAfterOnListWithTwoElements());
		printTest("testAddAfterOnListWithTwoElements_SizeTest",testAddAfterOnListWithTwoElements_SizeTest());
		printTest("testAddAftertOnListWithTwoElements_isEmptyTest",testAddAftertOnListWithTwoElements_isEmptyTest());
		printTest("testAddAfterOnListWithTwoElements_FirstTest",testAddAfterOnListWithTwoElements_FirstTest());
		printTest("testAddAfterOnListWithTwoElements_LastTest",testAddAfterOnListWithTwoElements_LastTest());


		//Tests RemoveFirst() through various scenarios
		printTest("testRemoveFirstOnListWithElement",testRemoveFirstOnWithElement());
		printTest("testRemoveFirstOnListWithElement_SizeTest",testRemoveFirstOnListWithElement_SizeTest());
		printTest("testRemoveFirstOnListWithElement_isEmptyTest",testRemoveFirstOnListWithElement_isEmptyTest());
		printTest("testRemoveFirstOnListWithElement_FirstTest",testRemoveFirstOnListWithElement_FirstTest());
		printTest("testRemoveFirstOnListWithElement_LastTest",testRemoveFirstOnListWithElement_LastTest());
		printTest("testRemoveFirstOnListWithTwoElements",testRemoveFirstOnWithTwoElements());
		printTest("testRemoveFirstOnListWithTwoElements_SizeTest",testRemoveFirstOnListWithTwoElements_SizeTest());
		printTest("testRemoveLastOnListWithTwoElements_isEmptyTest",testRemoveFirstOnListWithTwoElements_isEmptyTest());
		printTest("testRemoveFirstOnListWithTwoElements_FirstTest",testRemoveFirstOnListWithTwoElements_FirstTest());
		printTest("testRemoveFirstOnListWithTwoElements_LastTest",testRemoveFirstOnListWithTwoElements_LastTest());


		//Tests RemoveLast() through various scenarios
		printTest("testRemoveLastOnListWithElement",testRemoveLastOnWithElement());
		printTest("testRemoveLastOnListWithElement_SizeTest",testRemoveLastOnListWithElement_SizeTest());
		printTest("testRemoveLastOnListWithElement_isEmptyTest",testRemoveLastOnListWithElement_isEmptyTest());
		printTest("testRemoveLastOnListWithElement_FirstTest",testRemoveLastOnListWithElement_FirstTest());
		printTest("testRemoveLastOnListWithElement_LastTest",testRemoveLastOnListWithElement_LastTest());
		printTest("testRemoveLastOnListWithTwoElements",testRemoveLastOnWithTwoElements());
		printTest("testRemoveLastOnListWithTwoElements_SizeTest",testRemoveLastOnListWithTwoElements_SizeTest());
		printTest("testRemoveLastOnListWithTwoElements_isEmptyTest",testRemoveLastOnListWithTwoElements_isEmptyTest());
		printTest("testRemoveLastOnListWithTwoElements_FirstTest",testRemoveLastOnListWithTwoElements_FirstTest());
		printTest("testRemoveLastOnListWithTwoElements_LastTest",testRemoveLastOnListWithTwoElements_LastTest());

		//Tests Remove(T) through various scenarios
		printTest("testRemoveElementOnNewListWithElement",testRemoveElementOnNewListWithElement());
		printTest("testRemoveOnListWithElement_SizeTest",testRemoveOnListWithElement_SizeTest());
		printTest("testRemoveOnListWithElement_isEmptyTest",testRemoveOnListWithElement_isEmptyTest());
		printTest("testRemoveOnListWithElement_FirstTest",testRemoveOnListWithElement_FirstTest());
		printTest("testRemoveOnListWithElement_LastTest",testRemoveOnListWithElement_LastTest());
		printTest("testRemoveElementOnNewListWithTwoElements",testRemoveElementOnNewListWithTwoElements());
		printTest("testRemoveOnListWithTwoElements_SizeTest",testRemoveOnListWithTwoElements_SizeTest());
		printTest("testRemoveOnListWithTwoElements_isEmptyTest",testRemoveOnListWithTwoElements_isEmptyTest());
		printTest("testRemoveOnListWithTwoElements_FirstTest",testRemoveOnListWithTwoElements_FirstTest());
		printTest("testRemoveOnListWithTwoElements_LastTest",testRemoveOnListWithTwoElements_LastTest());


		//Tests First() through various scenarios
		printTest("testFirstOnNewListWithElement",testFirstOnNewListWithElement());
		printTest("testFirstOnNewListWithTwoElements",testFirstOnNewListWithTwoElements());

		//Tests Last() through various scenarios
		printTest("testLastOnNewListWithElement",testLastOnNewListWithElement());
		printTest("testLastOnNewListWithTwoElements",testLastOnNewListWithTwoElements());

		//Tests Contains() through various scenarios
		printTest("testContainsOnNewList_InvalidInputTest",testContainsOnNewList_InvalidInputTest());
		printTest("testContainsOnNewList_ValidInputTest()",testContainsOnNewList_ValidInputTest());

		//Tests Size() through various scenarios
		printTest("testSizeOnNewListWithElement",testSizeOnNewListWithElement());
		printTest("testSizeOnNewList_EmptyList()",testSizeOnNewList_EmptyList());

		//Tests isEmpty() through various scenarios
		printTest("testIsEmptyOnNewListWithElement_EmptyList",testIsEmptyOnNewListWithElement_EmptyList());
		printTest("testIsEmptyOnNewListWithElement_NotEmptyList",testIsEmptyOnNewListWithElement_NotEmptyList());

		//Tests Iterator, and the hasNext() and next() methods of the iterator
		printTest("testIteratorOnNewListWithElement",testIteratorOnNewListWithElement());
		printTest("testIteratorOnNewListWithElement_hasNext",testIteratorOnNewListWithElement_hasNext());
		printTest("testIteratorOnNewListWithElement_next",testIteratorOnNewListWithElement_next());

		//Tests toString() and whether it works
		printTest("testToStringOnNewListWithElement",testToStringOnNewListWithElement());
		printTest("testToStringOnNewListWithTwoElements",testToStringOnNewListWithTwoElements());		
		printTest("testToStringOnListWithElement_SizeTest",testToStringOnListWithElement_SizeTest());
		printTest("testToStringOnListWithElement_isEmptyTest",testToStringOnListWithElement_isEmptyTest());
		printTest("testToStringOnListWithElement_FirstTest",testToStringOnListWithElement_FirstTest());
		printTest("testToStringOnListWithElement_LastTest",testToStringOnListWithElement_LastTest());

		/////////////////
		//final verdict//
		printFinalSummary();
		/////////////////

	}

	/** @return test success */
	private boolean testAddToFrontOnNewList() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToFrontOnListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try	{
			list.addToFront(i);
			list.addToFront(i+1);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToFrontOnListWithElement_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i);
			if(list.size()==2)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToFrontOnListWithElement_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToFrontOnListWithElement_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			if(list.first()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToFrontOnListWithElement_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			if(list.last()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testAddToRearOnNewList() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToRear(i);
			list.addToRear(i+1);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToRearOnListWithElement_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);
		try{
			if(list.size()==2)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToRearOnListWithElement_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToRear(i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToRearOnListWithElement_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToRear(i);
			list.addToRear(i+1);
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToRearOnListWithElement_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToRear(i);
			list.addToRear(i+1);
			if(list.last()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testAddAfterOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			list.addAfter(new Integer(1), new Integer(2)); //ElementNotFoundException expected
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testAddAfterOnListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+1);
		try{
			list.addToFront(i);
			list.addAfter(j, i);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddAfterOnListWithElement_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+1);
		try{
			list.addToFront(i);
			list.addAfter(j, i);
			if(list.size()==2)
				return true;
			else
				return false;
		}
		catch(Exception e){
			System.out.println(list.size());
			return false;
		}
	}

	/** @return test success */
	private boolean testAddAftertOnListWithElement_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+1);
		try{
			list.addToFront(i);
			list.addAfter(j, i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddAfterOnListWithElement_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+1);
		try{
			list.addToFront(i);
			list.addAfter(j,i);
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddAfterOnListWithElement_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+1);

		try{
			list.addToFront(i);
			list.addAfter(j, i);
			if(list.last()==j){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			list.removeFirst(); //exception expected
		} catch (EmptyCollectionException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testRemoveFirstOnWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);


		list.addToFront(i);
		list.removeFirst();

		if(list.size()==0)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithElement_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.removeFirst();
			if(list.size()==0)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithElement_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.removeFirst();
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithElement_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeFirst();
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithElement_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeLast();
			if(list.last()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}



	/** @return test success */
	private boolean testRemoveLastOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			list.removeLast(); //exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);


		list.addToFront(i);
		list.removeLast();

		if(list.size()==0)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnListWithElement_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.removeLast();
			if(list.size()==0)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnListWithElement_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.removeLast();
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveLastOnListWithElement_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeLast();
			if(list.first()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveLastOnListWithElement_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeLast();
			if(list.last()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testRemoveElementOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			list.remove(new Integer(3)); //exception expected
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnNewListWithElement() {
		 ArrayList<Integer> list = newList();

		list.addToFront(3);
		list.remove(3); //exception expected

		if(list.size()==0)
			return true;
		else
			return false;

	}

	private boolean testRemoveOnListWithElement_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.remove(i);
			if(list.size()==0)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveOnListWithElement_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.remove(i);
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveOnListWithElement_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.remove(i+1);
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveOnListWithElement_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.remove(i+1);
			if(list.last()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testFirstOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			list.first(); //exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}


	/** @return test success */
	private boolean testFirstOnNewListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		int firstValue;
		int compareToFirst;

		try{
			firstValue=list.first();
			compareToFirst=list.removeFirst();
			if(firstValue==compareToFirst)
				return true; 
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}


	private boolean testFirstOnNewListWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.addToFront(i+1);

		int firstValue;
		int compareToFirst;

		try{
			firstValue=list.first();
			compareToFirst=list.removeFirst();
			if(firstValue==compareToFirst)
				return true; 
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testLastOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			list.last(); //exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testLastOnNewListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		try{
			int lastValue=list.last();
			int compareToLast=list.removeLast();
			if(lastValue==compareToLast)
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToFrontOnListWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try	{

			list.addToFront(i);
			list.addToFront(i+1);
			list.addToFront(i+2);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToFrontOnListWithTwoElements_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i);
			list.addToFront(i);
			if(list.size()==3)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToFrontOnListWithTwoElements_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToFrontOnListWithTwoElements_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.addToFront(i+2);
			if(list.first()==i+2){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToFrontOnListWithTwoElements_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.addToFront(i+2);
			if(list.last()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToRearOnListWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToRear(i);
			list.addToFront(i+1);
			list.addToRear(i+2);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToRearOnListWithTwoElements_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);

		list.addToFront(i);
		list.addToRear(i+1);
		list.addToRear(i+2);

		try{
			if(list.size()==3)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddToRearOnListWithTwoElements_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{

			list.addToFront(i);
			list.addToRear(i+1);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToRearOnListWithTwoElements_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{

			list.addToFront(i);
			list.addToRear(i+1);
			list.addToRear(i+2);
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddToRearOnListWithTwoElements_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{

			list.addToFront(i);		
			list.addToRear(i+1);
			list.addToRear(i+2);
			if(list.last()==i+2){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testAddAfterOnListWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+2);
		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.addAfter(j, i);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddAfterOnListWithTwoElements_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+2);
		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.addAfter(j, i);
			if(list.size()==3)
				return true;
			else
				return false;
		}
		catch(Exception e){
			System.out.println(list.size());
			return false;
		}
	}

	/** @return test success */
	private boolean testAddAftertOnListWithTwoElements_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+2);
		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.addAfter(j, i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddAfterOnListWithTwoElements_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+2);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.addAfter(j,i);
			if(list.first()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddAfterOnListWithTwoElements_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+2);

		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.addAfter(j, i);
			if(list.last()==j){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testRemoveFirstOnWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);

		list.addToFront(i);
		list.addToFront(i);
		list.removeFirst();

		if(list.size()==1)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithTwoElements_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i);
			list.removeFirst();
			if(list.size()==1)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithTwoElements_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i);
			list.removeFirst();
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithTwoElements_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeFirst();
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstOnListWithTwoElements_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeLast();
			if(list.last()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testRemoveLastOnWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);

		list.addToFront(i);
		list.addToFront(i);
		list.removeLast();

		if(list.size()==1)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnListWithTwoElements_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i);
			list.removeLast();
			if(list.size()==1)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveLastOnListWithTwoElements_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i);
			list.removeLast();
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveLastOnListWithTwoElements_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeLast();
			if(list.first()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveLastOnListWithTwoElements_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.removeLast();
			if(list.last()==i+1){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testRemoveElementOnNewListWithTwoElements() {
		 ArrayList<Integer> list = newList();

		list.addToFront(3);
		list.addToFront(3);

		list.remove(3); //exception expected

		if(list.size()==1)
			return true;
		else
			return false;

	}

	private boolean testRemoveOnListWithTwoElements_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(3);
			list.remove(i);
			if(list.size()==1)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testRemoveOnListWithTwoElements_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(3);

			list.remove(i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveOnListWithTwoElements_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.remove(i+1);
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveOnListWithTwoElements_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.remove(i+1);
			if(list.last()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testLastOnNewListWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);
		try{
			int lastValue=list.last();
			int compareToLast=list.removeLast();
			if(lastValue==compareToLast)
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testContainsOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			return false;
		}
	}


	/** @return test success */
	private boolean testContainsOnNewList_InvalidInputTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			return (!list.contains(i+1));
		} catch (Exception e) {
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnNewList_ValidInputTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {
			return (list.contains(i));
		} catch (Exception e) {
			return false;
		}
	}



	/** @return test success */
	private boolean testIsEmptyOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			return false;
		}
	}


	/** @return test success */
	private boolean testIsEmptyOnNewListWithElement_EmptyList() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.removeFirst();
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testIsEmptyOnNewListWithElement_NotEmptyList() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testSizeOnNewList() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try {

			return (list.size() == 1);
		} catch (Exception e) {
			return false;
		}
	}


	/** @return test success */
	private boolean testSizeOnNewListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i=new Integer(1);
		try{
			list.addToRear(i);
			if(list.size()==1)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSizeOnNewList_EmptyList() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
			list.removeFirst();
			return (list.size() == 0);
		} catch (Exception e) {
			return false;
		}
	}


	/** @return test success */
	private boolean testIteratorOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { //should be false
				return false;
			}
			try {
				it.next(); //exception expected
			} catch (Exception e) {
				//iterator() returned an Iterator<Integer>,
				//hasNext() returned false,
				//and next() threw an Exception
				return true;
			}
			//next() did not throw an exception
			return false;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			return false;
		}
	}

	/** @return test success */
	private boolean testIteratorOnNewListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);

		list.addToRear(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { 
				return true;
			}
			try {
				it.next(); //exception expected
			} catch (Exception e) {
				return false;
			}
			//next() did not throw an exception
			return true;
		} catch (Exception e) {
			//iterator() returned null or another invalid type
			return false;
		} 
	}

	/** @return test success */
	private boolean testIteratorOnNewListWithElement_hasNext() {
		 ArrayList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i);
		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) { 
				return true;
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testIteratorOnNewListWithElement_next() {
		 ArrayList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext() == true) {
				try {
					it.next(); //exception expected
					if(it.next()==i+1)
						return true;
				} catch (Exception e) {
					return false;
				}
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnNewList() {
		 ArrayList<Integer> list = newList();
		try {
			String str = list.toString();
			System.out.println("\ntoString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isAlphabetic(str.charAt(0)) 
					&& (Character.isDigit(lastChar)
							||
							(lastChar >= 'a' && lastChar <= 'f'))) {
				return false; //looks like default toString()
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnNewListWithElement() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		String str = list.toString();
		System.out.println("\ntoString() output:\n" + str);

		return	str.startsWith("[");

	}

	private boolean testToStringOnNewListWithTwoElements() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.addToFront(i+1);
		String str = list.toString();

		System.out.println("\ntoString() output:\n" + str);

		return	str.startsWith("[");

	}

	/** @return test success */
	private boolean testToStringOnListWithElement_SizeTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);

		try{
			list.addToFront(i);
			list.toString();
			System.out.println("\ntoString() output:\n" + list.toString());

			if(list.size()==1)
				return true;
			else
				return false;
		}
		catch(Exception e){
			System.out.println(list.size());
			return false;
		}
	}

	/** @return test success */
	private boolean testToStringOnListWithElement_isEmptyTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.toString();
			System.out.println("\ntoString() output:\n" + list.toString());		
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testToStringOnListWithElement_FirstTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);

		try{
			list.addToFront(i);
			list.toString();
			System.out.println("\ntoString() output:\n" + list.toString());
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testToStringOnListWithElement_LastTest() {
		 ArrayList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.toString();
			System.out.println("\ntoString() output:\n" + list.toString());
			if(list.last()==i){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}

}//end class UnorderedListTester
