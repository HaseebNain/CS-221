import java.util.Comparator;
import java.util.ListIterator;


/**
 * This class is the testing class for the MergeSort.java class. It tests the MergeSort through various scenarios.
 * @author Haseeb Nain
 *
 */
public class MergeSortTester {
	private int passes = 0;
	private int failures = 0;

	private int total = 0;

	/** @param args not used */
	public static void main(String[] args) {
		//to avoid every method being static
		MergeSortTester tester = new MergeSortTester();
		tester.runTests();
	}

	/**
	 * Returns an DoubleLinkedList so the implementation can be changed
	 * in this one location rather than in every test.
	 *
	 * @return a new DoubleLinkedList
	 */
	private WrappedDLL<Integer> newList() {
		//TODO: enable only one of the two following
		// lines or add a new implementation to test
		return new WrappedDLL<Integer>();
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
		
		printTest("testFindSmallestOnNewList", testFindSmallestOnNewList());
		printTest("testFindSmallestOnListWith1Element", testFindSmallestOnListWith1Element());
		printTest("testFindSmallestOnListWith2Elements", testFindSmallestOnListWith2Elements());
		printTest("testFindSmallestOnListWith2SameElements", testFindSmallestOnListWith2SameElements());
		printTest("testFindSmallestOnListWith3Elements", testFindSmallestOnListWith3Elements());
		printTest("testFindSmallestOnListWith10Elements", testFindSmallestOnListWith10Elements());
		printTest("testFindSmallestWithComparatorOnNewList", testFindSmallestWithComparatorOnNewList());
		printTest("testFindSmallestWithComparatorOnListWith1Element", testFindSmallestWithComparatorOnListWith1Element());
		printTest("testFindSmallestWithComparatorOnListWith2Elements", testFindSmallestWithComparatorOnListWith2Elements());
		printTest("testFindSmallestWithComparatorOnListWith2SameElements", testFindSmallestWithComparatorOnListWith2SameElements());
		printTest("testFindSmallestWithComparatorOnListWith3Elements", testFindSmallestWithComparatorOnListWith3Elements());
		printTest("testFindSmallestWithComparatorOnListWith10Elements", testFindSmallestWithComparatorOnListWith10Elements());
		printTest("testFindLargestOnNewList", testFindLargestOnNewList());
		printTest("testFindLargestOnListWith1Element", testFindLargestOnListWith1Element());
		printTest("testFindLargestOnListWith2Elements", testFindLargestOnListWith2Elements());
		printTest("testFindLargestOnListWith3Elements", testFindLargestOnListWith3Elements());
		printTest("testFindLargestOnListWith10Elements", testFindLargestOnListWith10Elements());
		printTest("testFindLargestWithComparatorOnNewList", testFindLargestWithComparatorOnNewList());
		printTest("testFindLargestWithComparatorOnListWith1Element",testFindLargestWithComparatorOnListWith1Element());
		printTest("testFindLargestWithComparatorOnListWith2Elements",testFindLargestWithComparatorOnListWith2Elements());
		printTest("testFindLargestWithComparatorOnListWith3Elements",testFindLargestWithComparatorOnListWith3Elements());
		printTest("testFindLargestWithComparatorOnListWith10Elements",testFindLargestWithComparatorOnListWith10Elements());
		printTest("testSortOnNewList", testSortOnNewList());
		printTest("testSortOnNewListComparator", testSortOnNewListComparator());
		printTest("testSortOnListWith1Element", testSortOnListWith1Element());
		printTest("testSortOnListWith1ElementComparator", testSortOnListWith1ElementComparator());
		printTest("testSortOnListWith2ElementsSorted", testSortOnListWith2ElementsSorted());
		printTest("testSortOnListWith2ElementsSortedComparator", testSortOnListWith2ElementsSortedComparator());
		printTest("testSortOnListWith2ElementsUnsorted", testSortOnListWith2ElementsUnsorted());
		printTest("testSortOnListWith2ElementsUnsortedComparator", testSortOnListWith2ElementsUnsortedComparator());
		printTest("testSortOnListWith3ElementsSorted", testSortOnListWith3ElementsSorted());
		printTest("testSortOnListWith3ElementsSortedComparator", testSortOnListWith3ElementsSortedComparator());
		printTest("testSortOnListWith3ElementsUnsorted", testSortOnListWith3ElementsUnsorted());
		printTest("testSortOnListWith3ElementsUnsortedComparator", testSortOnListWith3ElementsUnsortedComparator());
		printTest("testSortOnLargeListSorted", testSortOnLargeListSorted());
		printTest("testSortOnLargeListSortedComparator", testSortOnLargeListSortedComparator());
		printTest("testSortOnLargeListSorted", testSortOnLargeListUnsorted());
		printTest("testSortOnLargeListSortedComparator", testSortOnLargeListUnsortedComparator());
		printTest("stringTest", stringTest());
		
		printFinalSummary();
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestOnNewList(){
		WrappedDLL<Integer> list = newList();


		try{
			MergeSort.findSmallest(list);
			return false;
		}catch(EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestOnListWith1Element(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);

		try{
			if(sort.findSmallest(list).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestOnListWith2Elements(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);
		list.add(2);

		try{
			if(sort.findSmallest(list).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestOnListWith3Elements(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);
		list.add(2);
		list.add(3);

		try{
			if(sort.findSmallest(list).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestOnListWith10Elements(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		try{
			if(sort.findSmallest(list).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindLargestOnNewList(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();

		try{
			sort.findLargest(list);
			return false;
		}catch(EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindLargestOnListWith1Element(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);

		try{
			if(sort.findLargest(list).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindLargestOnListWith2Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);
		list.add(2);

		try{
			if(sort.findLargest(list).equals(2))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindLargestOnListWith3Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);
		list.add(2);
		list.add(3);

		try{
			if(sort.findLargest(list).equals(3))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindLargestOnListWith10Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);

		try{
			if(sort.findLargest(list).equals(10))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestWithComparatorOnNewList(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		try{
			sort.findSmallest(list,rC);
			return false;
		}catch(EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestWithComparatorOnListWith1Element(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);

		try{
			if(sort.findSmallest(list,rC).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestWithComparatorOnListWith2Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);
		list.add(2);

		try{
			if(sort.findSmallest(list,rC).equals(2))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestOnListWith2SameElements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(2);
		list.add(2);

		try{
			if(sort.findSmallest(list).equals(2))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestWithComparatorOnListWith2SameElements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);
		list.add(1);

		try{
			if(sort.findSmallest(list,rC).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestWithComparatorOnListWith3Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);
		list.add(2);
		list.add(3);

		try{
			if(sort.findSmallest(list,rC).equals(3))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindSmallestWithComparatorOnListWith10Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);

		try{
			if(sort.findSmallest(list,rC).equals(10))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindLargestWithComparatorOnNewList(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		try{
			sort.findLargest(list,rC);
			return false;
		}catch(EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure.
	 */
	private boolean testFindLargestWithComparatorOnListWith1Element(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);

		try{
			if(sort.findLargest(list,rC).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testFindLargestWithComparatorOnListWith2Elements(){

		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);
		list.add(2);

		try{
			if(sort.findLargest(list,rC).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testFindLargestWithComparatorOnListWith3Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);
		list.add(2);
		list.add(3);

		try{
			if(sort.findLargest(list,rC).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testFindLargestWithComparatorOnListWith10Elements(){
		WrappedDLL list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);

		try{
			if(sort.findLargest(list,rC).equals(1))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnNewList(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		try{
			sort.sort(list);
			return true;
		}catch(EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnNewListComparator(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		try{
			sort.sort(list,rC);
			return true;
		}catch(EmptyCollectionException e){
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith1Element(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(1);
		try{
			sort.sort(list);
			if(list.first().equals(1))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith1ElementComparator(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(1);
		try{
			sort.sort(list,rC);
			if(list.first().equals(1))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}


	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith2ElementsSorted(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(1);
		list.add(2);
		try{
			sort.sort(list);
			if(list.first().equals(1)&&list.last().equals(2))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith2ElementsSortedComparator(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(1);
		list.add(2);
		try{
			sort.sort(list,rC);
			if(list.first().equals(2)&&list.last().equals(1))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith2ElementsUnsorted(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(2);
		list.add(1);
		try{
			sort.sort(list);
			if(list.first().equals(1)&&list.last().equals(2))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith2ElementsUnsortedComparator(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(2);
		list.add(1);
		try{
			sort.sort(list,rC);
			if(list.first().equals(2)&&list.last().equals(1))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith3ElementsSorted(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(1);
		list.add(2);
		list.add(3);
		try{
			sort.sort(list);
			if(list.first().equals(1)&&list.last().equals(3)&&list.get(1).equals(2))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure.  
	 */
	private boolean testSortOnListWith3ElementsSortedComparator(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(1);
		list.add(2);
		list.add(3);
		try{
			sort.sort(list,rC);
			if(list.first().equals(3)&&list.last().equals(1)&&list.get(1).equals(2))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith3ElementsUnsorted(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(3);
		list.add(2);
		list.add(1);
		try{
			sort.sort(list);
			if(list.first().equals(1)&&list.last().equals(3)&&list.get(1).equals(2))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnListWith3ElementsUnsortedComparator(){
		WrappedDLL<Integer> list = newList();
		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		list.add(3);
		list.add(2);
		list.add(1);
		try{
			sort.sort(list,rC);
			if(list.first().equals(3)&&list.last().equals(1)&&list.get(1).equals(2))
				return true;
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnLargeListSorted(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> list2 = newList();

		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();


		int max=100;
		int count=0;
		while(count<=max){
			list.add(count);
			count++;
		}
		list2=list;
		sort.sort(list);
		ListIterator<Integer> checker = list.listIterator();
		int countCheck=0;
		int checkVal=0;
		while(countCheck<=list.size()){

			if(list.first().equals(list2.first())){

			}else{
				return false;
			}
			list.removeFirst();
			list2.removeFirst();
			countCheck++;
		}

		return true;

	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnLargeListSortedComparator(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> list2 = newList();

		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();

		//This creates two lists, of a size which can be adjusted by changing the value of max. These lists will already be sorted.
		int max=100;
		int count=0;
		while(count<=max){
			list.add(count);
			count++;
		}

		max=100;
		count=0;
		while(count<=max){
			list2.add(count);
			count++;
		}

		
		sort.sort(list,rC);
		ListIterator<Integer> checker = list.listIterator();
		int countCheck=0;
		int checkVal=0;
		while(countCheck<=list.size()){
			//Because the first list is sorted with a reverse comparator, it will be organized in the reverse order of the second list.
			//This will allow for comparison of the two lists.
			if(list.first().equals(list2.last())){

			}else{
				//if there is distinction between the two lists the test will end and a failure will be reported.
				return false;
			}
			list.removeFirst();
			list2.removeLast();
			countCheck++;
		}

		return true;

	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnLargeListUnsorted(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> list2 = newList();

		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();


		int max=100;
		int count=0;
		while(count<=max){
			list.addToFront(count);
			count++;
		}

		max=100;
		count=0;
		while(count<=max){
			list2.add(count);
			count++;
		}

		sort.sort(list);
		ListIterator<Integer> checker = list.listIterator();
		int countCheck=0;
		int checkVal=0;
		while(countCheck<=list.size()){

			if(list.first().equals(list2.first())){

			}else{
				return false;
			}
			list.removeFirst();
			list2.removeFirst();
			countCheck++;
		}

		return true;

	}

	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean testSortOnLargeListUnsortedComparator(){
		WrappedDLL<Integer> list = newList();
		WrappedDLL<Integer> list2 = newList();

		MergeSort sort = new MergeSort();
		reverseComparator rC = new reverseComparator<>();


		int max=100;
		int count=0;
		while(count<=max){
			list.addToFront(count);
			count++;
		}

		max=100;
		count=0;
		while(count<=max){
			list2.add(count);
			count++;
		}

		sort.sort(list,rC);
		ListIterator<Integer> checker = list.listIterator();
		int countCheck=0;
		int checkVal=0;
		while(countCheck<=list.size()){

			if(list.first().equals(list2.last())){

			}else{
				return false;
			}
			list.removeFirst();
			list2.removeLast();
			countCheck++;
		}

		return true;

	}



	/**
	 * @return the result of the test, pass as success, fail as a failure. 
	 */
	private boolean stringTest(){
		//WrappedDLL<Integer> list = newList();
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		MergeSort sort = new MergeSort();

		list.add(2);
		list.add(3);
		list.add(24);
		list.add(25);
		list.add(32);
		list.add(62);
		list.add(7);
		list.add(8);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(-3);
		list.add(12);
		list.add(34);
		list.add(435);
		list.add(53);
		list.add(-531);
		list.add(352);
		list.add(0);
		
		
		System.out.println("size: "+list.size());
		
		
		
		System.out.println(list.toString());
		reverseComparator rC = new reverseComparator<>();
		sort.sort(list);
		
		
		System.out.println(list.toString());
				System.out.println("Smallest: "+MergeSort.findSmallest(list));
		System.out.println("size: "+list.size());
		System.out.println("Smallest Comp: "+MergeSort.findSmallest(list,rC));
		System.out.println("size: "+list.size());
		System.out.println("Largest: "+MergeSort.findLargest(list));

		
		System.out.println("Largest Comp: "+MergeSort.findLargest(list,rC));


		//		System.out.println("size: "+list.size());
		//System.out.println(list.toString());
		//MergeSort.sort(list,rC);
		//System.out.println(list.toString());



		return true;
	}
}
