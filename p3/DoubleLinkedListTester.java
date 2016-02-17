import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class DoubleLinkedListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	/** @param args not used */
	public static void main(String[] args) {
		//to avoid every method being static
		DoubleLinkedListTester tester = new DoubleLinkedListTester();
		tester.runTests();
	}

	/**
	 * Returns an DoubleLinkedList so the implementation can be changed
	 * in this one location rather than in every test.
	 * @return a new DoubleLinkedList
	 */
	private DoubleLinkedList<Integer> newList() {
		//TODO: enable only one of the two following
		// lines or add a new implementation to test

		return new DoubleLinkedList<Integer>();
		//		return new BadDoubleLinkedList<Integer>();
	}

	private DoubleLinkedList<String> stringList(){
		return new DoubleLinkedList<String>();
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
		System.out.printf("%-55s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
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
		printTest("testListIteratorOnNewList", testListIteratorOnNewList());
		printTest("testToStringOnNewList", testToStringOnNewList());
		//	printTest("testToStringOnListWithOneElement", testToStringWithList());

		//Tests add(index,element) through various scenarios
		printTest("testAddIndexOnNewList()",testAddIndexElementOnNewList());
		printTest("testAddIndexOnListWithElement()",testAddIndexOnListWithElement());
		printTest("testAddIndexOnListWithElement()_SizeTest",testAddIndexOnListWithElement_SizeTest());
		printTest("testAddIndexOnListWithElement()_isEmptyTest",testAddIndexOnListWithElement_isEmptyTest());
		printTest("testAddIndexOnListWithElement()_FirstTest",testAddIndexOnListWithElement_FirstTest());
		printTest("testAddIndexOnListWithElement()_LastTest",testAddIndexOnListWithElement_LastTest());





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


		//Tests the Get method of the DoubleLinkedList through various scenarios
		printTest("testSetFirstOnNewList()",testSetFirstOnNewList());
		printTest("testSetFirstOnWithElement",testSetFirstOnWithElement());
		printTest("testSetFirstOnListWithElement_SizeTest",testSetFirstOnListWithElement_SizeTest());
		printTest("testSetFirstOnListWithElement_isEmptyTest",testSetFirstOnListWithElement_isEmptyTest());
		printTest("testSetFirstOnListWithElement_FirstTest",testSetFirstOnListWithElement_FirstTest());
		printTest("testSetFirstOnListWithElement_LastTest",testSetFirstOnListWithElement_LastTest());
		printTest("testSetFirstOnListWithTwoElements",testSetFirstOnListWithTwoElements());
		printTest("testSetFirstOnListWithTwoElements_SizeTest",testSetFirstOnListWithTwoElements_SizeTest());
		printTest("testSetFirstOnListWithTwoElements_isEmptyTest",testSetFirstOnListWithTwoElements_isEmptyTest());
		printTest("testSetFirstOnListWithTwoElements_FirstTest",testSetFirstOnListWithTwoElements_FirstTest());
		printTest("testSetFirstOnListWithTwoElements_LastTest",testSetFirstOnListWithTwoElements_LastTest());


		//Tests the Set method of the DoubleLinkedList through various scenarios
		printTest("testGetFirstOnNewList()",testGetFirstOnNewList());
		printTest("testGetFirstOnWithElement",testGetFirstOnWithElement());
		printTest("testGetFirstOnListWithElement_SizeTest",testGetFirstOnListWithElement_SizeTest());
		printTest("testGetFirstOnListWithElement_isEmptyTest",testGetFirstOnListWithElement_isEmptyTest());
		printTest("testGetFirstOnListWithElement_FirstTest",testGetFirstOnListWithElement_FirstTest());
		printTest("testGetFirstOnListWithElement_LastTest",testGetFirstOnListWithElement_LastTest());
		printTest("testGetFirstOnListWithTwoElements",testGetFirstOnListWithTwoElements());
		printTest("testGetFirstOnListWithTwoElements_SizeTest",testGetFirstOnListWithTwoElements_SizeTest());
		printTest("testGetFirstOnListWithTwoElements_isEmptyTest",testGetFirstOnListWithTwoElements_isEmptyTest());
		printTest("testGetFirstOnListWithTwoElements_FirstTest",testGetFirstOnListWithTwoElements_FirstTest());
		printTest("testGetFirstOnListWithTwoElements_LastTest",testGetFirstOnListWithTwoElements_LastTest());



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

		//Tests Remove(T element) through various scenarios
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

		//Tests Remove(int index) through various scenarios
		printTest("testRemoveIndexOnNewListWithElement",testRemoveIndexOnNewListWithElement());
		printTest("testRemoveIndexOnListWithElement_SizeTest",testRemoveIndexOnListWithElement_SizeTest());
		printTest("testRemoveIndexOnListWithElement_isEmptyTest",testRemoveIndexOnListWithElement_isEmptyTest());
		printTest("testRemoveIndexOnListWithElement_FirstTest",testRemoveIndexOnListWithElement_FirstTest());
		printTest("testRemoveIndexOnListWithElement_LastTest",testRemoveIndexOnListWithElement_LastTest());
		printTest("testRemoveIndexOnNewListWithTwoElements",testRemoveIndexElementOnNewListWithTwoElements());
		printTest("testRemoveIndexOnListWithTwoElements_SizeTest",testRemoveIndexOnListWithTwoElements_SizeTest());
		printTest("testRemoveIndexOnListWithTwoElements_isEmptyTest",testRemoveIndexOnListWithTwoElements_isEmptyTest());
		printTest("testRemoveIndexOnListWithTwoElements_FirstTest",testRemoveIndexOnListWithTwoElements_FirstTest());
		printTest("testRemoveIndexOnListWithTwoElements_LastTest",testRemoveIndexOnListWithTwoElements_LastTest());


		////*****STRING TESTS********\\
		//Tests add(index,element) through various scenarios
		printTest("testSTRINGAddIndexOnNewList()",testSTRINGAddIndexElementOnNewList());
		printTest("testSTRINGAddIndexOnListWithElement()",testSTRINGAddIndexOnListWithElement());
		printTest("testSTRINGAddIndexOnListWithElement()_SizeTest",testSTRINGAddIndexOnListWithElement_SizeTest());
		printTest("testSTRINGAddIndexOnListWithElement()_isEmptyTest",testSTRINGAddIndexOnListWithElement_isEmptyTest());
		printTest("testSTRINGAddIndexOnListWithElement()_FirstTest",testSTRINGAddIndexOnListWithElement_FirstTest());
		printTest("testSTRINGAddIndexOnListWithElement()_LastTest",testSTRINGAddIndexOnListWithElement_LastTest());





		//Tests AddToFront() through various scenarios
		printTest("testSTRINGAddToFrontOnListWithElement",testSTRINGAddToFrontOnListWithElement());
		printTest("testSTRINGAddToFrontOnListWithElement_SizeTest",testSTRINGAddToFrontOnListWithElement_SizeTest());
		printTest("testSTRINGAddToFrontOnListWithElement_isEmptyTest",testSTRINGAddToFrontOnListWithElement_isEmptyTest());
		printTest("testSTRINGAddToFrontOnListWithElement_FirstTest",testSTRINGAddToFrontOnListWithElement_FirstTest());
		printTest("testSTRINGAddToFrontOnListWithElement_LastTest",testSTRINGAddToFrontOnListWithElement_LastTest());
		printTest("testSTRINGAddToFrontOnListWithTwoElements",testSTRINGAddToFrontOnListWithTwoElements());
		printTest("testSTRINGAddToFrontOnListWithTwoElements_SizeTest",testSTRINGAddToFrontOnListWithTwoElements_SizeTest());
		printTest("testSTRINGAddToFrontOnListWithTwoElements_isEmptyTest",testSTRINGAddToFrontOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGAddToFrontOnListWithTwoElements_FirstTest",testSTRINGAddToFrontOnListWithTwoElements_FirstTest());
		printTest("testSTRINGAddToFrontOnListWithTwoElements_LastTest",testSTRINGAddToFrontOnListWithTwoElements_LastTest());

		//Tests AddToRear() through various scenarios
		printTest("testSTRINGAddToRearOnListWithElement",testSTRINGAddToRearOnListWithElement());
		printTest("testSTRINGAddToRearOnListWithElement_SizeTest",testSTRINGAddToRearOnListWithElement_SizeTest());
		printTest("testSTRINGAddToRearOnListWithElement_isEmptyTest",testSTRINGAddToRearOnListWithElement_isEmptyTest());
		printTest("testSTRINGAddToRearOnListWithElement_FirstTest",testSTRINGAddToRearOnListWithElement_FirstTest());
		printTest("testSTRINGAddToRearOnListWithElement_LastTest",testSTRINGAddToRearOnListWithElement_LastTest());
		printTest("testSTRINGAddToRearOnListWithTwoElements",testSTRINGAddToRearOnListWithTwoElements());
		printTest("testSTRINGAddToRearOnListWithTwoElements_SizeTest",testSTRINGAddToRearOnListWithTwoElements_SizeTest());
		printTest("testSTRINGAddToRearOnListWithTwoElements_isEmptyTest",testSTRINGAddToRearOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGAddToRearOnListWithTwoElements_FirstTest",testSTRINGAddToRearOnListWithTwoElements_FirstTest());
		printTest("testSTRINGAddToRearOnListWithTwoElements_LastTest",testSTRINGAddToRearOnListWithTwoElements_LastTest());

		//Tests AddAfter(element, target) through various scenarios
		printTest("testSTRINGAddAfterOnListWithElement",testSTRINGAddAfterOnListWithElement());
		printTest("testSTRINGAddAfterOnListWithElement_SizeTest",testSTRINGAddAfterOnListWithElement_SizeTest());
		printTest("testSTRINGAddAftertOnListWithElement_isEmptyTest",testSTRINGAddAftertOnListWithElement_isEmptyTest());
		printTest("testSTRINGAddAfterOnListWithElement_FirstTest",testSTRINGAddAfterOnListWithElement_FirstTest());
		printTest("testSTRINGAddAfterOnListWithElement_LastTest",testSTRINGAddAfterOnListWithElement_LastTest());
		printTest("testSTRINGAddAfterOnListWithTwoElements",testSTRINGAddAfterOnListWithTwoElements());
		printTest("testSTRINGAddAfterOnListWithTwoElements_SizeTest",testSTRINGAddAfterOnListWithTwoElements_SizeTest());
		printTest("testSTRINGAddAftertOnListWithTwoElements_isEmptyTest",testSTRINGAddAftertOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGAddAfterOnListWithTwoElements_FirstTest",testSTRINGAddAfterOnListWithTwoElements_FirstTest());
		printTest("testSTRINGAddAfterOnListWithTwoElements_LastTest",testSTRINGAddAfterOnListWithTwoElements_LastTest());


		//Tests the Get method of the DoubleLinkedList through various scenarios
		printTest("testSTRINGSetFirstOnWithElement",testSTRINGSetFirstOnWithElement());
		printTest("testSTRINGSetFirstOnListWithElement_SizeTest",testSTRINGSetFirstOnListWithElement_SizeTest());
		printTest("testSTRINGSetFirstOnListWithElement_isEmptyTest",testSTRINGSetFirstOnListWithElement_isEmptyTest());
		printTest("testSTRINGSetFirstOnListWithElement_FirstTest",testSTRINGSetFirstOnListWithElement_FirstTest());
		printTest("testSTRINGSetFirstOnListWithElement_LastTest",testSTRINGSetFirstOnListWithElement_LastTest());
		printTest("testSTRINGSetFirstOnListWithTwoElements",testSTRINGSetFirstOnListWithTwoElements());
		printTest("testSTRINGSetFirstOnListWithTwoElements_SizeTest",testSTRINGSetFirstOnListWithTwoElements_SizeTest());
		printTest("testSTRINGSetFirstOnListWithTwoElements_isEmptyTest",testSTRINGSetFirstOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGSetFirstOnListWithTwoElements_FirstTest",testSTRINGSetFirstOnListWithTwoElements_FirstTest());
		printTest("testSTRINGSetFirstOnListWithTwoElements_LastTest",testSetFirstOnListWithTwoElements_LastTest());


		//Tests the Set method of the DoubleLinkedList through various scenarios
		printTest("testSTRINGGetFirstOnWithElement",testSTRINGGetFirstOnWithElement());
		printTest("testSTRINGGetFirstOnListWithElement_SizeTest",testSTRINGGetFirstOnListWithElement_SizeTest());
		printTest("testSTRINGGetFirstOnListWithElement_isEmptyTest",testSTRINGGetFirstOnListWithElement_isEmptyTest());
		printTest("testSTRINGGetFirstOnListWithElement_FirstTest",testSTRINGGetFirstOnListWithElement_FirstTest());
		printTest("testSTRINGGetFirstOnListWithElement_LastTest",testSTRINGGetFirstOnListWithElement_LastTest());
		printTest("testSTRINGGetFirstOnListWithTwoElements",testSTRINGGetFirstOnListWithTwoElements());
		printTest("testSTRINGGetFirstOnListWithTwoElements_SizeTest",testSTRINGGetFirstOnListWithTwoElements_SizeTest());
		printTest("testSTRINGGetFirstOnListWithTwoElements_isEmptyTest",testSTRINGGetFirstOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGGetFirstOnListWithTwoElements_FirstTest",testSTRINGGetFirstOnListWithTwoElements_FirstTest());
		printTest("testSTRINGGetFirstOnListWithTwoElements_LastTest",testSTRINGGetFirstOnListWithTwoElements_LastTest());



		//Tests RemoveFirst() through various scenarios
		printTest("testSTRINGRemoveFirstOnListWithElement",testSTRINGRemoveFirstOnWithElement());
		printTest("testSTRINGRemoveFirstOnListWithElement_SizeTest",testSTRINGRemoveFirstOnListWithElement_SizeTest());
		printTest("testSTRINGRemoveFirstOnListWithElement_isEmptyTest",testSTRINGRemoveFirstOnListWithElement_isEmptyTest());
		printTest("testSTRINGRemoveFirstOnListWithElement_FirstTest",testSTRINGRemoveFirstOnListWithElement_FirstTest());
		printTest("testSTRINGRemoveFirstOnListWithElement_LastTest",testSTRINGRemoveFirstOnListWithElement_LastTest());
		printTest("testSTRINGRemoveFirstOnListWithTwoElements",testSTRINGRemoveFirstOnWithTwoElements());
		printTest("testSTRINGRemoveFirstOnListWithTwoElements_SizeTest",testSTRINGRemoveFirstOnListWithTwoElements_SizeTest());
		printTest("testSTRINGRemoveLastOnListWithTwoElements_isEmptyTest",testSTRINGRemoveFirstOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGRemoveFirstOnListWithTwoElements_FirstTest",testSTRINGRemoveFirstOnListWithTwoElements_FirstTest());
		printTest("testSTRINGRemoveFirstOnListWithTwoElements_LastTest",testSTRINGRemoveFirstOnListWithTwoElements_LastTest());


		//Tests RemoveLast() through various scenarios
		printTest("testSTRINGRemoveLastOnListWithElement",testSTRINGRemoveLastOnWithElement());
		printTest("testSTRINGRemoveLastOnListWithElement_SizeTest",testSTRINGRemoveLastOnListWithElement_SizeTest());
		printTest("testSTRINGRemoveLastOnListWithElement_isEmptyTest",testSTRINGRemoveLastOnListWithElement_isEmptyTest());
		printTest("testSTRINGRemoveLastOnListWithElement_FirstTest",testSTRINGRemoveLastOnListWithElement_FirstTest());
		printTest("testSTRINGRemoveLastOnListWithElement_LastTest",testSTRINGRemoveLastOnListWithElement_LastTest());
		printTest("testSTRINGRemoveLastOnListWithTwoElements",testSTRINGRemoveLastOnWithTwoElements());
		printTest("testSTRINGRemoveLastOnListWithTwoElements_SizeTest",testSTRINGRemoveLastOnListWithTwoElements_SizeTest());
		printTest("testSTRINGRemoveLastOnListWithTwoElements_isEmptyTest",testSTRINGRemoveLastOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGRemoveLastOnListWithTwoElements_FirstTest",testSTRINGRemoveLastOnListWithTwoElements_FirstTest());
		printTest("testSTRINGRemoveLastOnListWithTwoElements_LastTest",testSTRINGRemoveLastOnListWithTwoElements_LastTest());

		//Tests Remove(T element) through various scenarios
		printTest("testSTRINGRemoveElementOnNewListWithElement",testSTRINGRemoveElementOnNewListWithElement());
		printTest("testSTRINGRemoveOnListWithElement_SizeTest",testSTRINGRemoveOnListWithElement_SizeTest());
		printTest("testSTRINGRemoveOnListWithElement_isEmptyTest",testSTRINGRemoveOnListWithElement_isEmptyTest());
		printTest("testSTRINGRemoveOnListWithElement_FirstTest",testSTRINGRemoveOnListWithElement_FirstTest());
		printTest("testSTRINGRemoveOnListWithElement_LastTest",testSTRINGRemoveOnListWithElement_LastTest());
		printTest("testSTRINGRemoveElementOnNewListWithTwoElements",testSTRINGRemoveElementOnNewListWithTwoElements());
		printTest("testSTRINGRemoveOnListWithTwoElements_SizeTest",testSTRINGRemoveOnListWithTwoElements_SizeTest());
		printTest("testSTRINGRemoveOnListWithTwoElements_isEmptyTest",testSTRINGRemoveOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGRemoveOnListWithTwoElements_FirstTest",testSTRINGRemoveOnListWithTwoElements_FirstTest());
		printTest("testSTRINGRemoveOnListWithTwoElements_LastTest",testSTRINGRemoveOnListWithTwoElements_LastTest());

		//Tests Remove(int index) through various scenarios
		printTest("testSTRINGRemoveIndexOnNewListWithElement",testSTRINGRemoveIndexOnNewListWithElement());
		printTest("testSTRINGRemoveIndexOnListWithElement_SizeTest",testSTRINGRemoveIndexOnListWithElement_SizeTest());
		printTest("testSTRINGRemoveIndexOnListWithElement_isEmptyTest",testSTRINGRemoveIndexOnListWithElement_isEmptyTest());
		printTest("testSTRINGRemoveIndexOnListWithElement_FirstTest",testSTRINGRemoveIndexOnListWithElement_FirstTest());
		printTest("testSTRINGRemoveIndexOnListWithElement_LastTest",testSTRINGRemoveIndexOnListWithElement_LastTest());
		printTest("testSTRINGRemoveIndexOnNewListWithTwoElements",testSTRINGRemoveIndexElementOnNewListWithTwoElements());
		printTest("testSTRINGRemoveIndexOnListWithTwoElements_FirstTest",testSTRINGRemoveIndexOnListWithTwoElements_FirstTest());
		printTest("testSTRINGRemoveIndexOnListWithTwoElements_isEmptyTest",testSTRINGRemoveIndexOnListWithTwoElements_isEmptyTest());
		printTest("testSTRINGRemoveIndexOnListWithTwoElements_LastTements_SizeTest",testSTRINGRemoveIndexOnListWithTwoElements_SizeTest());
		printTest("testSTRINGRemoveIndexOnListWithTwoElements_isEmptyTest",testSTRINGRemoveIndexOnListWithTwoElements_LastTest());

		//Tests First() through various scenarios
		printTest("testSTRINGFirstOnNewListWithElement",testSTRINGFirstOnNewListWithElement());
		printTest("testSTRINGFirstOnNewListWithTwoElements",testSTRINGFirstOnNewListWithTwoElements());

		//Tests Last() through various scenarios
		printTest("testSTRINGLastOnNewListWithElement",testSTRINGLastOnNewListWithElement());
		printTest("testSTRINGLastOnNewListWithTwoElement",testSTRINGLastOnNewListWithTwoElement());


		//\\*****END STRING TESTS****//
		//Tests First() through various scenarios
		printTest("testFirstOnNewListWithElement",testFirstOnNewListWithElement());
		printTest("testFirstOnNewListWithTwoElements",testFirstOnNewListWithTwoElements());

		//Tests Last() through various scenarios
		printTest("testLastOnNewListWithElement",testLastOnNewListWithElement());
		printTest("testLastOnNewListWithTwoElements",testLastOnNewListWithTwoElements());

		//Tests Contains() through various scenarios
		printTest("testContainsOnNewList_InvalidInputTest",testContainsOnNewList_InvalidInputTest());
		printTest("testContainsOnNewList_ValidInputTest()",testContainsOnNewList_ValidInputTest());
		
		//Tests IndexOf() through Various Scenarios
		printTest("testIndexOfFirstOnNewList",testIndexOfFirstOnNewList());
		printTest("testIndexOfFirstOnListWithElement",testIndexOfFirstOnListWithElement());
		printTest("testIndexOfFirstOnList_OutOfBounds",testIndexOfOnListWithElement_InvalidElement());
		

		//Tests Size() through various scenarios
		printTest("testSizeOnNewListWithElement",testSizeOnNewListWithElement());
		printTest("testSizeOnNewList_EmptyList()",testSizeOnNewList_EmptyList());

		//Tests isEmpty() through various scenarios
		printTest("testIsEmptyOnNewListWithElement_EmptyList",testIsEmptyOnNewListWithElement_EmptyList());
		printTest("testIsEmptyOnNewListWithElement_NotEmptyList",testIsEmptyOnNewListWithElement_NotEmptyList());

		//Tests ListIterator, and the methods of the ListIterator
		printTest("testListIteratorOnNewListWithElement",testListIteratorOnNewListWithElement());
		printTest("testListIteratorOnNewListWithElement_hasNext",testListIteratorOnNewListWithElement_hasNext());
		printTest("testListIteratorOnEmptyList_hasNext",testListIteratorOnEmptyList_hasNext());
		printTest("testListIteratorOnNewListWithElement_next",testListIteratorOnNewListWithElement_next());
		printTest("testListIteratorOnEmptyList_next",testListIteratorOnEmptyList_next());
		printTest("testListIteratorOnNewListWithElement_hasPrevious",testListIteratorOnNewListWithElement_hasPrevious());
		printTest("testListIteratorOnEmptyList_hasPrevious",testListIteratorOnEmptyList_hasPrevious());
		printTest("testListIteratorOnNewListWithElement_previous",testListIteratorOnNewListWithElement_previous());
		printTest("testListIteratorOnEmptyList_previous",testListIteratorOnEmptyList_previous());
		printTest("testListIteratorOnNewListWithElement_remove",testListIteratorOnNewListWithElement_remove());
		printTest("testListIteratorOnEmptyList_remove",testListIteratorOnEmptyList_remove());
		printTest("testListIteratorOnNewListWithElement_set",testListIteratorOnNewListWithElement_set());
		printTest("testListIteratorOnEmptyList_set",testListIteratorOnEmptyList_set());
		printTest("testListIteratorOnNewListWithElement_add",testListIteratorOnNewListWithElement_add());



		//Tests Iterator, and the hasNext() and next() and the remove() methods of the iterator
		printTest("testListIteratorOnNewListWithElement_hasNext",testIteratorOnNewListWithElement_hasNext());
		printTest("testListIteratorOnNewListWithElement_next",testIteratorOnNewListWithElement_next());
		printTest("testListIteratorOnNewListWithElement_hasPrevious",testIteratorOnNewListWithElement_remove());


		//Tests the iterators  methods to see if they area able to handle the IllegalStateException
		printTest("testListIteratorIllegalStateException_add",testListIteratorIllegalStateException_add());
		printTest("testListIteratorIllegalStateException_remove",testListIteratorIllegalStateException_remove());
		printTest("testListIteratorIllegalStateException_set",testListIteratorIllegalStateException_set());




		//Test Iterator, checking if it detects if the list has been altered
		printTest("testIteratorHasNextConcurrentTest_NotALtered()",testIteratorHasNextConcurrentTest_NotALtered());
		printTest("testIteratorHasNextConcurrentTest_ALtered()",testIteratorHasNextConcurrentTest_ALtered());
		printTest("testIteratorNextConcurrentTest_NotALtered()",testIteratorNextConcurrentTest_NotALtered());
		printTest("testIteratorNextConcurrentTest_ALtered()",testIteratorNextConcurrentTest_ALtered());
		printTest("testIteratorRemoveConcurrentTest_NotALtered()",testIteratorRemoveConcurrentTest_NotALtered());
		printTest("testIteratorRemoveConcurrentTest_ALtered()",testIteratorRemoveConcurrentTest_ALtered());


		//Tests ListIterator and If it can detect a changed list
		printTest("testListIteratorHasNextConcurrentTest_NotALtered()",testListIteratorHasNextConcurrentTest_NotALtered());
		printTest("testListIteratorHasNextConcurrentTest_ALtered()",testListIteratorHasNextConcurrentTest_ALtered());
		printTest("testListIteratorNextConcurrentTest_NotALtered()",testListIteratorNextConcurrentTest_NotALtered());
		printTest("testListIteratorNextConcurrentTest_ALtered()",testListIteratorNextConcurrentTest_ALtered());
		printTest("testListIteratorHasPreviousConcurrentTest_NotALtered()",testListIteratorHasPreviousConcurrentTest_NotALtered());
		printTest("testListIteratorHasPreviousConcurrentTest_ALtered()",testListIteratorHasPreviousConcurrentTest_ALtered());
		printTest("testListIteratorPreviousConcurrentTest_NotALtered()",testListIteratorPreviousConcurrentTest_NotALtered());
		printTest("testListIteratorPreviousConcurrentTest_NotALtered()",testListIteratorPreviousConcurrentTest_ALtered());
		printTest("testListIteratorRemoveConcurrentTest_NotALtered()",testListIteratorRemoveConcurrentTest_NotALtered());
		printTest("testListIteratorRemoveConcurrentTest_ALtered()",testListIteratorRemoveConcurrentTest_ALtered());
		printTest("testListIteratorSetConcurrentTest_NotALtered()",testListIteratorSetConcurrentTest_NotALtered());
		printTest("testListIteratorSetConcurrentTest_ALtered()",testListIteratorSetConcurrentTest_ALtered());
		printTest("testListIteratorAddConcurrentTest_NotALtered()",testListIteratorAddConcurrentTest_NotALtered());
		printTest("testListIteratorAddConcurrentTest_ALtered()",testListIteratorAddConcurrentTest_ALtered());



		//Tests toString() and whether it works
		printTest("testToStringOnNewListWithElement",testToStringOnNewListWithElement());
		printTest("testToStringOnNewListWithTwoElements",testToStringOnNewListWithTwoElements());		
		printTest("testToStringOnListWithElement_SizeTest",testToStringOnListWithElement_SizeTest());
		printTest("testToStringOnListWithElement_isEmptyTest",testToStringOnListWithElement_isEmptyTest());
		printTest("testToStringOnListWithElement_FirstTest",testToStringOnListWithElement_FirstTest());
		printTest("testToStringOnListWithElement_LastTest",testToStringOnListWithElement_LastTest());



		printTest("compareTwoLists_Size",compareTwoLists_Size());
		printTest("compareTwoLists_isEmpty",compareTwoLists_isEmpty());
		printTest("compareTwoLists_Casting",compareTwoLists_Casting());
		printTest("compareTwoLists_CastingFail",compareTwoLists_CastingFail());
		printTest("compareTwoLists_Size",compareTwoLists_Size());
		

		printTest("testDummy", testDummy());

		/////////////////
		//final verdict
		/////////////////
		printFinalSummary();
	}

	private boolean testAddIndexElementOnNewList(){
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			list.add(i,i+1);

		} catch(IndexOutOfBoundsException e){
			return true;
		}catch (Exception e) {
			return false;
		}

		return true;
	}

	/** @return test success */
	private boolean testAddIndexOnListWithElement() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try	{
			list.addToFront(i);
			list.add(0,i+1);
			return true;
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddIndexOnListWithElement_SizeTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.add(0,i+1);
			if(list.size()==2)
				return true;
			else
				return false;
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddIndexOnListWithElement_isEmptyTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.add(0,i+1);
			return !list.isEmpty();
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddIndexOnListWithElement_FirstTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.add(0,i+1);
			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddIndexOnListWithElement_LastTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.add(0,i+1);
			if(list.last()==i+1){
				return true;
			}
			else{
				return false;
			}
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testAddToFrontOnNewList() {
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		}catch(ElementNotFoundException | EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testAddAfterOnNewList() {
		DoubleLinkedList<Integer> list = newList();
		try {
			list.addAfter(new Integer(1), new Integer(2)); //ElementNotFoundException expected
		} catch (ElementNotFoundException | EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** @return test success */
	private boolean testAddAfterOnListWithElement() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		//Integer j = new Integer(i+1);
		try{
			list.addToFront(i);
			list.addAfter(i+1, i);
			return true;
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testAddAfterOnListWithElement_SizeTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(i+1);
		try{
			list.addToFront(i);
			list.addAfter(j, i);
			if(list.size()==2)
				return true;
			else
				return false;
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			System.out.println(list.size());
			return false;
		}
	}

	/** @return test success */
	private boolean testAddAftertOnListWithElement_isEmptyTest() {
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		try{
			list.addToFront(i);
			list.addAfter(j,i);

			System.out.println("First: "+list.first());
			System.out.println("Last: "+list.last());

			if(list.first()==i){
				return true;
			}
			else{
				return false;
			}
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testAddAfterOnListWithElement_LastTest() {
		DoubleLinkedList<Integer> list = newList();
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
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testRemoveFirstOnNewList() {
		DoubleLinkedList<Integer> list = newList();
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
	private boolean testRemoveFirstOnWithElement() {
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		try{

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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
		try {
			list.remove(new Integer(3)); //exception expected
		} catch (ElementNotFoundException |EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/** @return test success */
	private boolean testRemoveElementOnNewListWithElement() {
		DoubleLinkedList<Integer> list = newList();

		list.addToFront(3);
		((ListADT<Integer>)list).remove(3);//exception expected

		if(list.size()==0)
			return true;
		else
			return false;

	}

	private boolean testRemoveOnListWithElement_SizeTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			((ListADT<Integer>)list).remove(i);
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
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			((ListADT<Integer>)list).remove(i);
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveOnListWithElement_FirstTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);

			((ListADT<Integer>)list).remove(i);
			if(list.first()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveOnListWithElement_LastTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{

			list.addToFront(i);
			((ListADT<Integer>)list).remove(i);
			if(list.last()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}


	/** @return test success */
	private boolean testFirstOnNewList() {
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.addToFront(i+1);

		try{
			if(list.first()==i+1)
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
	private boolean testRemoveIndexOnNewListWithElement() {
		DoubleLinkedList<Integer> list = newList();

		list.addToFront(3);
		((ListADT<Integer>)list).remove(3);//exception expected

		if(list.size()==0)
			return true;
		else
			return false;

	}

	private boolean testRemoveIndexOnListWithElement_SizeTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			((ListADT<Integer>)list).remove(i);
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
	private boolean testRemoveIndexOnListWithElement_isEmptyTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			((ListADT<Integer>)list).remove(i);
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveIndexOnListWithElement_FirstTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);

			((ListADT<Integer>)list).remove(i);
			if(list.first()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveIndexOnListWithElement_LastTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{

			list.addToFront(i);
			((ListADT<Integer>)list).remove(i);
			if(list.last()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}



	/** @return test success */
	private boolean testRemoveIndexElementOnNewListWithTwoElements() {
		DoubleLinkedList<Integer> list = newList();

		list.addToFront(3);
		list.addToFront(3);

		((ListADT<Integer>)list).remove(3);

		if(list.size()==1)
			return true;
		else
			return false;

	}

	private boolean testRemoveIndexOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(3);
			((ListADT<Integer>)list).remove(i);
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
	private boolean testRemoveIndexOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(3);

			((ListADT<Integer>)list).remove(i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveIndexOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			((ListADT<Integer>)list).remove(i+1);
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

	private boolean testRemoveIndexOnListWithTwoElements_LastTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			((ListADT<Integer>)list).remove(i+1);
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
	private boolean testRemoveElementOnNewListWithTwoElements() {
		DoubleLinkedList<Integer> list = newList();

		list.addToFront(3);
		list.addToFront(3);

		((ListADT<Integer>)list).remove(3);

		if(list.size()==1)
			return true;
		else
			return false;

	}

	private boolean testRemoveOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(3);
			((ListADT<Integer>)list).remove(i);
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
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(3);

			((ListADT<Integer>)list).remove(i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testRemoveOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			((ListADT<Integer>)list).remove(i+1);
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
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			((ListADT<Integer>)list).remove(i+1);
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
	
	

	//***************************
	//STRING TESTS
	//***************************
	private boolean testSTRINGAddIndexElementOnNewList(){
		DoubleLinkedList<String> list = stringList();

		try {
			list.add(0,"B");

		} catch(IndexOutOfBoundsException e){
			return true;
		}catch (Exception e) {
			return false;
		}

		return true;
	}

	/** @return test success */
	private boolean testSTRINGAddIndexOnListWithElement() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");
		try	{
			list.addToFront(i);
			list.add(0,"B");
			return true;
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddIndexOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.add(0,"B");
			if(list.size()==2)
				return true;
			else
				return false;
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddIndexOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.add(0,"B");
			return !list.isEmpty();
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddIndexOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.add(0,"B");
			if(list.first()==str){
				return true;
			}
			else{
				return false;
			}
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddIndexOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.add(0,"B");
			if(list.last()=="B"){
				return true;
			}
			else{
				return false;
			}
		} catch(IndexOutOfBoundsException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}



	/** @return test success */
	private boolean testSTRINGAddToFrontOnListWithElement() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try	{
			list.addToFront(str);
			list.addToFront("B");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddToFrontOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront(str);
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
	private boolean testSTRINGAddToFrontOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddToFrontOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			if(list.first()=="B"){
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
	private boolean testSTRINGAddToFrontOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			if(list.last()==str){
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
	private boolean testSTRINGAddToRearOnListWithElement() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToRear(str);
			list.addToRear("B");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddToRearOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		list.addToRear(str);
		list.addToRear("B");
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
	private boolean testSTRINGAddToRearOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToRear(str);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddToRearOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToRear(str);
			list.addToRear("B");
			if(list.first()==str){
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
	private boolean testSTRINGAddToRearOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToRear(str);
			list.addToRear("B");
			if(list.last()=="B"){
				return true;
			}
			else{
				return false;
			}
		}catch(ElementNotFoundException | EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}



	/** @return test success */
	private boolean testSTRINGAddAfterOnListWithElement() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		//Integer j = new Integer(i+1);
		try{
			list.addToFront(str);
			list.addAfter("B", str);
			return true;
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddAfterOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		try{
			list.addToFront(str);
			list.addAfter("B", str);
			if(list.size()==2)
				return true;
			else
				return false;
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			System.out.println(list.size());
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddAftertOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		try{
			list.addToFront(str);
			list.addAfter("B", str);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddAfterOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		try{
			list.addToFront(str);
			list.addAfter("B",str);

			System.out.println("First: "+list.first());
			System.out.println("Last: "+list.last());

			if(list.first()==str){
				return true;
			}
			else{
				return false;
			}
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddAfterOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");


		try{
			list.addToFront(str);
			list.addAfter("B", str);
			if(list.last().equals("B")){
				return true;
			}
			else{
				return false;
			}
		}catch(ElementNotFoundException| EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGRemoveFirstOnWithElement() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");


		list.addToFront(str);
		list.removeFirst();

		if(list.size()==0)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testSTRINGRemoveFirstOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
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
	private boolean testSTRINGRemoveFirstOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.removeFirst();
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGRemoveFirstOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeFirst();
			if(list.first()==str){
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
	private boolean testSTRINGRemoveFirstOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeLast();
			if(list.last()=="B"){
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
	private boolean testSTRINGRemoveLastOnWithElement() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");


		list.addToFront(str);
		list.removeLast();

		if(list.size()==0)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testSTRINGRemoveLastOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		list.addToFront(str);
		try{

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
	private boolean testSTRINGRemoveLastOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.removeLast();
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGRemoveLastOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeLast();
			if(list.first()=="B"){
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
	private boolean testSTRINGRemoveLastOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeLast();
			if(list.last()=="B"){
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
	private boolean testSTRINGRemoveElementOnNewListWithElement() {
		DoubleLinkedList<String> list = stringList();

		list.addToFront("A");
		((ListADT<String>)list).remove("A");//exception expected

		if(list.size()==0)
			return true;
		else
			return false;

	}

	private boolean testSTRINGRemoveOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			((ListADT<String>)list).remove(str);
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
	private boolean testSTRINGRemoveOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			((ListADT<String>)list).remove(str);
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testSTRINGRemoveOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);

			((ListADT<String>)list).remove(str);
			if(list.first()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testSTRINGRemoveOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{

			list.addToFront(str);
			((ListADT<String>)list).remove(str);
			if(list.last()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}




	/** @return test success */
	private boolean testSTRINGFirstOnNewListWithElement() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		list.addToFront(str);
		String firstValue;
		String compareToFirst;

		try{
			firstValue=list.first();
			compareToFirst=list.removeFirst();
			if(firstValue.equals(compareToFirst))
				return true; 
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}


	private boolean testSTRINGFirstOnNewListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		list.addToFront(str);
		list.addToFront("B");

		try{
			if(list.first()=="B")
				return true; 
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testSTRINGLastOnNewListWithElement() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		list.addToRear(str);
		try{
			String lastValue=list.last();
			String compareToLast=list.removeLast();
			if(lastValue.equals(compareToLast))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testSTRINGLastOnNewListWithTwoElement() {
		DoubleLinkedList<String> list = stringList();

		String str = new String("A");

		list.addToRear(str);
		list.addToRear("B");
		try{
			String lastValue=list.last();
			String compareToLast=list.removeLast();
			if(lastValue.equals(compareToLast))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddToFrontOnListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try	{

			list.addToFront(str);
			list.addToFront("B");
			list.addToFront("C");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddToFrontOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront(str);
			list.addToFront(str);
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
	private boolean testSTRINGAddToFrontOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront(str);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddToFrontOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.addToFront("C");
			if(list.first()=="C"){
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
	private boolean testSTRINGAddToFrontOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.addToFront("C");
			if(list.last()==str){
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
	private boolean testSTRINGAddToRearOnListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToRear(str);
			list.addToFront("B");
			list.addToRear("C");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddToRearOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		list.addToFront(str);
		list.addToRear("B");
		list.addToRear("C");

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
	private boolean testSTRINGAddToRearOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{

			list.addToFront(str);
			list.addToRear("B");
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddToRearOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{

			list.addToFront(str);
			list.addToRear("B");
			list.addToRear("C");
			if(list.first()==str){
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
	private boolean testSTRINGAddToRearOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{

			list.addToFront(str);		
			list.addToRear("B");
			list.addToRear("C");
			if(list.last().equals("C")){
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
	private boolean testSTRINGAddAfterOnListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		try{

			list.addToFront(str);
			list.addToFront("B");
			list.addAfter("B", str);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGAddAfterOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		try{

			list.addToFront(str);
			list.addToFront("B");
			list.addAfter("B", str);
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
	private boolean testSTRINGAddAftertOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		try{

			list.addToFront(str);
			list.addToFront("B");
			list.addAfter("B", str);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGAddAfterOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		try{
			list.addToFront(str);
			list.addToFront("B");
			list.addAfter("B",str);
			if(list.first()=="B"){
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
	private boolean testSTRINGAddAfterOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");


		try{
			list.addToFront(str);
			list.addToFront("B");
			list.addAfter("B", str);
			if(list.last().equals("B")){
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
	private boolean testSTRINGRemoveFirstOnWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		list.addToFront(str);
		list.addToFront(str);
		list.removeFirst();

		if(list.size()==1)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testSTRINGRemoveFirstOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront(str);
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
	private boolean testSTRINGRemoveFirstOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront(str);
			list.removeFirst();
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGRemoveFirstOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeFirst();
			if(list.first()==str){
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
	private boolean testSTRINGRemoveFirstOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeLast();
			if(list.last()=="B"){
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
	private boolean testSTRINGRemoveLastOnWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");

		list.addToFront(str);
		list.addToFront(str);
		list.removeLast();

		if(list.size()==1)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testSTRINGRemoveLastOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront(str);
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
	private boolean testSTRINGRemoveLastOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront(str);
			list.removeLast();
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGRemoveLastOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeLast();
			if(list.first()=="B"){
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
	private boolean testSTRINGRemoveLastOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			list.removeLast();
			if(list.last()=="B"){
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
	private boolean testSTRINGRemoveIndexOnNewListWithElement() {
		DoubleLinkedList<String> list = stringList();

		list.addToFront("X");
		((ListADT<String>)list).remove("X");//exception expected

		if(list.size()==0)
			return true;
		else
			return false;

	}

	private boolean testSTRINGRemoveIndexOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			((ListADT<String>)list).remove(str);
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
	private boolean testSTRINGRemoveIndexOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			((ListADT<String>)list).remove(str);
			return list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testSTRINGRemoveIndexOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);

			((ListADT<String>)list).remove(str);
			if(list.first()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testSTRINGRemoveIndexOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{

			list.addToFront(str);
			((ListADT<String>)list).remove(str);
			if(list.last()==null){
				return true;
			}
			else{
				return false;
			}
		}catch(EmptyCollectionException e){
			return true;
		}
		catch (Exception e){
			return false;
		}

	}



	/** @return test success */
	private boolean testSTRINGRemoveIndexElementOnNewListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();

		list.addToFront("A");
		list.addToFront("A");

		((ListADT<String>)list).remove("A");

		if(list.size()==1)
			return true;
		else
			return false;

	}

	private boolean testSTRINGRemoveIndexOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("X");
			((ListADT<String>)list).remove(str);
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
	private boolean testSTRINGRemoveIndexOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("X");

			((ListADT<String>)list).remove(str);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testSTRINGRemoveIndexOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			((ListADT<String>)list).remove("B");
			if(list.first()==str){
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

	private boolean testSTRINGRemoveIndexOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			((ListADT<String>)list).remove("B");
			if(list.last()==str){
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
	private boolean testSTRINGRemoveElementOnNewListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();

		list.addToFront("X");
		list.addToFront("X");

		((ListADT<String>)list).remove("X");

		if(list.size()==1)
			return true;
		else
			return false;

	}

	private boolean testSTRINGRemoveOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("X");
			((ListADT<String>)list).remove(str);
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
	private boolean testSTRINGRemoveOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("X");

			((ListADT<String>)list).remove(str);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	private boolean testSTRINGRemoveOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			((ListADT<String>)list).remove("B");
			if(list.first()==str){
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

	private boolean testSTRINGRemoveOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");
		try{
			list.addToFront(str);
			list.addToFront("B");
			((ListADT<String>)list).remove("B");
			if(list.last()==str){
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
	private boolean testSTRINGSetFirstOnWithElement() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");


		list.addToFront(i);
		list.set(0,i);

		if(list.size()==1)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testSTRINGSetFirstOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{
			list.addToFront(i);
			list.set(0,"B");
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
	private boolean testSTRINGSetFirstOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{
			list.addToFront(i);
			list.set(0,"B");
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGSetFirstOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");
		try{
			list.addToFront(i);
			list.set(0,"B");
			if(list.first().equals("B")){
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
	private boolean testSTRINGSetFirstOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");
		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.set(0,"B");
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
	private boolean testSTRINGSetFirstOnListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.set(0, i);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGSetFirstOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.set(0, i);
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
	private boolean testSTRINGSetFirstOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.set(0, i);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGSetFirstOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.set(0,i);
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
	private boolean testSTRINGSetFirstOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");


		try{
			list.addToFront(i);
			list.addToFront(i+1);
			list.set(0, i);
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
	private boolean testSTRINGGetFirstOnWithElement() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");


		list.addToFront(i);
		list.get(0);

		if(list.size()==1)
			return true;
		else
			return false;
	}

	/** @return test success */
	private boolean testSTRINGGetFirstOnListWithElement_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");
		try{
			list.addToFront(i);
			list.get(0);
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
	private boolean testSTRINGGetFirstOnListWithElement_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");
		try{
			list.addToFront(i);
			list.get(0);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGGetFirstOnListWithElement_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");
		try{
			list.addToFront(i);
			list.get(0);
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
	private boolean testSTRINGGetFirstOnListWithElement_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");
		try{

			list.addToFront("B");
			list.get(0);
			if(list.last().equals("B")){
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
	private boolean testSTRINGGetFirstOnListWithTwoElements() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.get(0);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/** @return test success */
	private boolean testSTRINGGetFirstOnListWithTwoElements_SizeTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.get(0);
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
	private boolean testSTRINGGetFirstOnListWithTwoElements_isEmptyTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{

			list.addToFront(i);
			list.addToFront(i+1);
			list.get(0);
			return !list.isEmpty();
		}
		catch (Exception e){
			return false;
		}

	}

	/** @return test success */
	private boolean testSTRINGGetFirstOnListWithTwoElements_FirstTest() {
		DoubleLinkedList<String> list = stringList();
		String i = new String("A");

		try{
			list.addToFront(i);
			list.addToFront("B");
			list.get(0);
			if(list.first().equals("B")){
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
	private boolean testSTRINGGetFirstOnListWithTwoElements_LastTest() {
		DoubleLinkedList<String> list = stringList();
		String str = new String("A");


		try{
			list.addToFront(str);
			list.addToFront("B");
			list.get(0);
			if(list.last()==str){
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

	//*****************************
	//END
	//STRING TESTS
	//*****************************


	/** @return test success */
	private boolean testLastOnNewListWithTwoElements() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		list.addToFront(i);
		list.addToFront(i+1);
		try{
			if(list.last()==i){
				return true;
			}
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testContainsOnNewList() {
		DoubleLinkedList<Integer> list = newList();
		try {
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			return false;
		}
	}


	/** @return test success */
	private boolean testContainsOnNewList_InvalidInputTest() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);
		try {
			return (!list.contains(i+1));
		} catch (Exception e) {
			return false;
		}
	}

	/** @return test success */
	private boolean testContainsOnNewList_ValidInputTest() {
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
		try {
			return (list.isEmpty() == true);
		} catch (Exception e) {
			return false;
		}
	}


	/** @return test success */
	private boolean testIsEmptyOnNewListWithElement_EmptyList() {
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
		DoubleLinkedList<Integer> list = newList();
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
	private boolean testListIteratorOnNewList() {
		DoubleLinkedList<Integer> list = newList();
		try {
			ListIterator<Integer> it = list.listIterator();
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
	private boolean testListIteratorOnNewListWithElement() {
		DoubleLinkedList<Integer> list = newList();
		Integer i = new Integer(1);

		list.addToRear(i);
		try {
			ListIterator<Integer> it = list.listIterator();
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
	private boolean testListIteratorOnNewListWithElement_hasNext() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i);
		try {
			ListIterator<Integer> it = list.listIterator();

			if (it.hasNext() == true) { 
				return true;
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}
	private boolean testListIteratorOnEmptyList_hasNext() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);


		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					//exception expected
					if(it.hasNext());
					return false;

				} catch (Exception e) {
					return false;
				}
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testListIteratorOnNewListWithElement_next() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
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
	private boolean testListIteratorOnEmptyList_next() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);

		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					it.next(); //exception expected


				} catch (Exception e) {
					return false;
				}
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}




	/** @return test success */
	private boolean testListIteratorOnNewListWithElement_hasPrevious() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					it.next(); //exception expected
					if(it.hasPrevious())
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
	private boolean testListIteratorOnEmptyList_hasPrevious() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);


		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					//exception expected
					it.hasPrevious();
					if(list.last()==5)
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


	/** @return test success */
	private boolean testListIteratorOnNewListWithElement_previous() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					it.next(); //exception expected
					if(it.previous()==i)
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

	private boolean testListIteratorOnEmptyList_previous() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasPrevious() == true) {
				try {
					it.previous(); //exception expected
				} catch (Exception e) {
					return false;
				}
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testListIteratorOnNewListWithElement_remove() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					it.next(); //exception expected
					it.remove();
					if(list.size()==1)
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
	private boolean testListIteratorOnEmptyList_remove() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);

		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {

					it.remove();

				} catch (Exception e) {
					return false;
				}
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}


	/** @return test success */
	private boolean testListIteratorOnNewListWithElement_set() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					it.next(); //exception expected
					it.set(5);
					if(list.last()==5)
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
	private boolean testListIteratorOnEmptyList_set() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);


		try {
			ListIterator<Integer> it = list.listIterator();
			it.set(i);

		} catch(IllegalStateException e){
			return true;
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean testIteratorNextConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			Iterator<Integer> it = list.iterator();
			it.next();
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean testIteratorNextConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			Iterator<Integer> it = list.iterator();
			list.add(i);
			it.next();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
		return false;
	}

	public boolean testIteratorHasNextConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			Iterator<Integer> it = list.iterator();
			it.hasNext();
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean testIteratorHasNextConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			Iterator<Integer> it = list.iterator();
			list.add(i);
			it.hasNext();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
		return false;
	}

	public boolean testIteratorRemoveConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			Iterator<Integer> it = list.iterator();
			it.next();
			it.remove();
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean testIteratorRemoveConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			Iterator<Integer> it = list.iterator();
			list.add(i);
			it.next();
			it.remove();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
		}
		return false;
	}


	public boolean testListIteratorNextConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.next();
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
		}
		return true;
	}



	public boolean testListIteratorNextConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			list.add(i);
			it.next();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
		}
		return false;
	}



	public boolean testListIteratorHasNextConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.hasNext();
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}



	public boolean testListIteratorHasNextConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			list.add(i);
			it.hasNext();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
		}
		return true;
	}


	public boolean testListIteratorRemoveConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.remove();
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}



	public boolean testListIteratorRemoveConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			list.add(i);
			it.next();
			it.remove();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}


	public boolean testListIteratorSetConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.set(i);
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}



	public boolean testListIteratorSetConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.set(i);

		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}


	public boolean testListIteratorHasPreviousConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.hasPrevious();

		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}



	public boolean testListIteratorHasPreviousConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			list.add(i);
			it.next();
			it.hasPrevious();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
		return false;
	}


	public boolean testListIteratorPreviousConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.previous();
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
		}
		return true;
	}



	public boolean testListIteratorPreviousConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			list.add(i);
			it.next();
			it.hasPrevious();
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}


	public boolean testListIteratorAddConcurrentTest_NotALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.add(i);
		}catch(ConcurrentModificationException e){
			return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}



	public boolean testListIteratorAddConcurrentTest_ALtered(){
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			list.add(i);
			it.next();
			it.add(i);
		}catch(ConcurrentModificationException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
		return false;
	}


	/** @return test success */
			private boolean testListIteratorOnNewListWithElement_add() {
		DoubleLinkedList<Integer> list = newList();

		Integer i = new Integer(1);
		list.addToRear(i);
		list.addToRear(i+1);

		try {
			ListIterator<Integer> it = list.listIterator();
			if (it.hasNext() == true) {
				try {
					it.next(); //exception expected
					it.add(5);
					if(list.size()==3)
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

			/** @return test success */
			private boolean testListIteratorIllegalStateException_add() {
				DoubleLinkedList<Integer> list = newList();

				Integer i = new Integer(1);
				list.addToRear(i);
				list.addToRear(i+1);

				try {
					ListIterator<Integer> it = list.listIterator();
					if (it.hasNext() == true) {
						try {
							it.next(); //exception expected
							it.set(i);
							it.add(i);
						} catch (IllegalStateException e) {
							return true;
						}
					}
					return true;
				}catch(Exception e){
					return false;
				}
			}

			/** @return test success */
			private boolean testListIteratorIllegalStateException_remove() {
				DoubleLinkedList<Integer> list = newList();

				Integer i = new Integer(1);
				list.addToRear(i);
				list.addToRear(i+1);

				try {
					ListIterator<Integer> it = list.listIterator();
					if (it.hasNext() == true) {
						try {
							it.next(); //exception expected
							it.set(i);
							it.remove();
						} catch (IllegalStateException e) {
							return true;
						}
					}
					return true;
				}catch(Exception e){
					return false;
				}
			}


			/** @return test success */
			private boolean testListIteratorIllegalStateException_set() {
				DoubleLinkedList<Integer> list = newList();

				Integer i = new Integer(1);
				list.addToRear(i);
				list.addToRear(i+1);

				try {
					ListIterator<Integer> it = list.listIterator();
					if (it.hasNext() == true) {
						try {
							it.next(); //exception expected
							it.add(i);
							it.set(i);
						} catch (IllegalStateException e) {
							return true;
						}
					}
					return true;
				}catch(Exception e){
					return false;
				}
			}



			/** @return test success */
			private boolean testIteratorOnNewListWithElement_hasNext() {
				DoubleLinkedList<Integer> list = newList();

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
				DoubleLinkedList<Integer> list = newList();

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

			/** @return test success */
			private boolean testIteratorOnNewListWithElement_remove() {
				DoubleLinkedList<Integer> list = newList();

				Integer i = new Integer(1);
				list.addToRear(i);
				list.addToRear(i+1);

				try {
					Iterator<Integer> it = list.iterator();
					if (it.hasNext() == true) {
						try {
							it.next(); //exception expected
							it.remove();
							if(list.size()==1)
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

			public boolean testListIteratorHasNext_sizeTest(){
				DoubleLinkedList<Integer> list = newList();

				Integer i = new Integer(1);
				list.addToRear(i);
				list.addToRear(i+1);

				try {
					ListIterator<Integer> it = list.listIterator();
					it.hasNext();
				}catch(ConcurrentModificationException e){
					return false;
				}
				catch(Exception e){
					return false;
				}
				return true;
			}




			/** toString() is difficult to test - would like to confirm that
			 * the default address output has been overridden
			 * @return test success */
			private boolean testToStringOnNewList() {
				DoubleLinkedList<Integer> list = newList();
				String str;
				try{
					str=list.toString();
					System.out.println(str);
					return(str.startsWith("["));
				}catch(Exception e){
					return false;
				}

			}

			/** toString() is difficult to test - would like to confirm that
			 * the default address output has been overridden
			 * @return test success */
			private boolean testToStringOnNewListWithElement() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				list.addToFront(i);
				String str = list.toString();
				System.out.println("\ntoString() output:\n" + str);

				return	str.startsWith("[");

			}

			private boolean testToStringOnNewListWithTwoElements() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				list.addToFront(i);
				list.addToFront(i+1);
				String str = list.toString();

				System.out.println("\ntoString() output:\n" + str);

				return	str.startsWith("[");

			}

			/** @return test success */
			private boolean testToStringOnListWithElement_SizeTest() {
				DoubleLinkedList<Integer> list = newList();
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
				DoubleLinkedList<Integer> list = newList();
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
				DoubleLinkedList<Integer> list = newList();
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
				DoubleLinkedList<Integer> list = newList();
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

			/** @return test success */
			private boolean testSetFirstOnNewList() {
				DoubleLinkedList<Integer> list = newList();
				try {
					list.set(0,0); //exception expected
				} catch (EmptyCollectionException e) {
					return true;
				} catch (Exception e) {
					return false;
				}
				return true;
			}

			/** @return test success */
			private boolean testSetFirstOnWithElement() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);


				list.addToFront(i);
				list.set(0,0);

				if(list.size()==1)
					return true;
				else
					return false;
			}

			/** @return test success */
			private boolean testSetFirstOnListWithElement_SizeTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{
					list.addToFront(i);
					list.set(0,1);
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
			private boolean testSetFirstOnListWithElement_isEmptyTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{
					list.addToFront(i);
					list.set(0,0);
					return !list.isEmpty();
				}
				catch (Exception e){
					return false;
				}

			}

			/** @return test success */
			private boolean testSetFirstOnListWithElement_FirstTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{
					list.addToFront(i);
					list.set(0,i+1);
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
			private boolean testSetFirstOnListWithElement_LastTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{
					list.addToFront(i);
					list.addToFront(i+1);
					list.set(0,0);
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
			private boolean testSetFirstOnListWithTwoElements() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{

					list.addToFront(i);
					list.addToFront(i+1);
					list.set(0, i);
					return true;
				}
				catch(Exception e){
					return false;
				}
			}

			/** @return test success */
			private boolean testSetFirstOnListWithTwoElements_SizeTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{

					list.addToFront(i);
					list.addToFront(i+1);
					list.set(0, i);
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
			private boolean testSetFirstOnListWithTwoElements_isEmptyTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{

					list.addToFront(i);
					list.addToFront(i+1);
					list.set(0, i);
					return !list.isEmpty();
				}
				catch (Exception e){
					return false;
				}

			}

			/** @return test success */
			private boolean testSetFirstOnListWithTwoElements_FirstTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{
					list.addToFront(i);
					list.addToFront(i+1);
					list.set(0,i);
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
			private boolean testSetFirstOnListWithTwoElements_LastTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);


				try{
					list.addToFront(i);
					list.addToFront(i+1);
					list.set(0, i);
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
			private boolean testGetFirstOnNewList() {
				DoubleLinkedList<Integer> list = newList();
				try {
					list.get(0); //exception expected
				} catch (EmptyCollectionException e) {
					return true;
				} catch (Exception e) {
					return false;
				}
				return true;
			}

			/** @return test success */
			private boolean testGetFirstOnWithElement() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);


				list.addToFront(i);
				list.get(0);

				if(list.size()==1)
					return true;
				else
					return false;
			}

			/** @return test success */
			private boolean testGetFirstOnListWithElement_SizeTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{
					list.addToFront(i);
					list.get(0);
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
			private boolean testGetFirstOnListWithElement_isEmptyTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{
					list.addToFront(i);
					list.get(0);
					return !list.isEmpty();
				}
				catch (Exception e){
					return false;
				}

			}

			/** @return test success */
			private boolean testGetFirstOnListWithElement_FirstTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{
					list.addToFront(i);
					list.get(0);
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
			private boolean testGetFirstOnListWithElement_LastTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);
				try{

					list.addToFront(i+1);
					list.get(0);
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
			private boolean testGetFirstOnListWithTwoElements() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{

					list.addToFront(i);
					list.addToFront(i+1);
					list.get(0);
					return true;
				}
				catch(Exception e){
					return false;
				}
			}

			/** @return test success */
			private boolean testGetFirstOnListWithTwoElements_SizeTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{

					list.addToFront(i);
					list.addToFront(i+1);
					list.get(0);
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
			private boolean testGetFirstOnListWithTwoElements_isEmptyTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{

					list.addToFront(i);
					list.addToFront(i+1);
					list.get(0);
					return !list.isEmpty();
				}
				catch (Exception e){
					return false;
				}

			}

			/** @return test success */
			private boolean testGetFirstOnListWithTwoElements_FirstTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);

				try{
					list.addToFront(i);
					list.addToFront(i+1);
					list.get(0);
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
			private boolean testGetFirstOnListWithTwoElements_LastTest() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);


				try{
					list.addToFront(i);
					list.addToFront(i+1);
					list.get(0);
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
			private boolean testIndexOfFirstOnNewList() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);


				try{
					
					
					if(list.indexOf(i+1)==0){
						return true;
					}
					else{
						return false;
					}
				}
				catch(IndexOutOfBoundsException|ElementNotFoundException e){
					return true;
				}
				catch (Exception e){
					return false;
				}
			}
			
			/** @return test success */
			private boolean testIndexOfFirstOnListWithElement() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);


				try{
					
					list.addToFront(i+1);
					
					if(list.indexOf(i+1)==0){
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
			private boolean testIndexOfOnListWithElement_InvalidElement() {
				DoubleLinkedList<Integer> list = newList();
				Integer i = new Integer(1);


				try{
					
					list.addToFront(i+1);
					
					if(list.indexOf(1+2)==0){
						return true;
					}
					else{
						return false;
					}
				}catch(ElementNotFoundException e){
					return true;
				}
				catch (Exception e){
					return false;
				}

			}
			
			
			
			
			
			
			private boolean compareTwoLists_Size(){
				DoubleLinkedList<String> listString = stringList();
				DoubleLinkedList<Integer> listIntegers =newList();
				listString.add("A");
				listIntegers.add(1);
				try{
				if(listIntegers.size()==listString.size())
					return true;
				else
					return false;
				}catch(Exception e){
					return false;
				}
			}
			private boolean compareTwoLists_isEmpty(){
				DoubleLinkedList<String> listString = stringList();
				DoubleLinkedList<Integer> listIntegers =newList();
				listString.add("A");
				listIntegers.add(1);
				try{
				if(listString.isEmpty()||listIntegers.isEmpty())
					return false;
				else
					return true;
				}catch(Exception e){
					return false;
				}
			}
			private boolean compareTwoLists_Casting(){
				DoubleLinkedList<String> listString = stringList();
				DoubleLinkedList<Integer> listIntegers =newList();
				listString.add("A");
				listIntegers.add(1);
				try{
					listString.add(listIntegers.first().toString());
					return true;
				
				}catch(Exception e){
					return false;
				}
			}
			private boolean compareTwoLists_CastingFail(){
				DoubleLinkedList<String> listString = stringList();
				DoubleLinkedList<Integer> listIntegers =newList();
				listString.add("A");
				listIntegers.add(1);
				try{
				listIntegers.add((Integer.parseInt(listString.first())));
					return false;
				}catch(ClassCastException |NumberFormatException e){
					return true;
				}
			}
			private boolean testDummy(){
				DoubleLinkedList<String> list = new DoubleLinkedList<String>();

				list.addToRear("A");
				list.addToRear("B");
				list.addToRear("C");
				list.addToRear("D");
				list.addToRear("E");
				list.addToRear("F");
				list.addToRear("G");
				list.addToRear("H");
				list.addToRear("I");
				list.addToRear("J");
				list.addToRear("K");
				list.addToRear("L");
				list.addToRear("M");
				list.addToRear("N");
				list.addToRear("O");
				list.addToRear("P");
				list.addToRear("Q");
				list.addToRear("R");
				list.addToRear("S");
				list.addToRear("T");
				list.addToRear("U");
				list.addToRear("V");
				list.addToRear("W");
				list.addToRear("X");
				list.addToRear("Y");
				list.addToRear("Z");

				//list.addToFront(2);
				//list.addToFront(1);
				//list.addAfter(4,2);
				System.out.println(list.toString());

				//list.remove("B");



				//System.out.println("First: "+list.first());
				//System.out.println("Last: "+list.last());

				System.out.println("Size: "+list.size());
				System.out.println("toString: "+list.toString());

				//System.out.println("First: "+list.first());
				//System.out.println("Last: "+list.last());
				return true;	}

}
