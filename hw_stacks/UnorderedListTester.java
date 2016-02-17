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
 * @author mvail
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
	private UnorderedListADT<Integer> newList() {
		//TODO: enable only one of the two following
		// lines or add a new implementation to test
		return new GoodUnorderedList<Integer>();
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
	private void runTests() {
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

		/////////////////
		//final verdict
		/////////////////
		printFinalSummary();
	}
	
	/** @return test success */
	private boolean testAddToFrontOnNewList() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToFront(i);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddToRearOnNewList() {
		UnorderedListADT<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.addToRear(i);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
	private boolean testRemoveFirstOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			list.removeFirst(); //exception expected
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveLastOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
	private boolean testRemoveElementOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
	private boolean testFirstOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
	private boolean testLastOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
	private boolean testContainsOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			return false;
		}
	}

	/** @return test success */
	private boolean testIsEmptyOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			return false;
		}
	}
	
	/** @return test success */
	private boolean testSizeOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			return (list.size() == 0);
		} catch (Exception e) {
			return false;
		}
	}
	
	/** @return test success */
	private boolean testIteratorOnNewList() {
		UnorderedListADT<Integer> list = newList();
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
	
	/** toString() is difficult to test - would like to confirm that
	 * the default address output has been overridden
	 * @return test success */
	private boolean testToStringOnNewList() {
		UnorderedListADT<Integer> list = newList();
		try {
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length()-1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0)) 
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

}//end class UnorderedListTester
