import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Runs a bunch of operations on an implementation of the DoubleLinkedListADT
 * in an attempt to reveal bugs in the code.
 * 
 * @author mvail
 */
public class DLLUser {

	/**
	 * Uses DoubleLinkedListADT methods in a variety of ways and bails out if anything
	 * goes wrong along the way. A method like this is a poor substitute for a good
	 * unit test suite that isolates each list scenario and method and can more clearly
	 * identify under what conditions a method does what it should.
	 * 
	 * Use the Eclipse debugger to step through this method (and into the bad DLL code)
	 * to track down what's wrong with the code. Document which lines in main caused it
	 * to exit and how you used the debugger to identify and correct the problems.
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		DoubleLinkedListADT<Integer> list = new BadDLL<Integer>();

		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		Integer i3 = new Integer(3);
		Integer i4 = new Integer(4);

		Iterator<Integer> it;
		ListIterator<Integer> lit;

		//the list is empty

		System.out.println(list);

		if (list.size() != 0) System.exit(1);

		try {
			list.get(1);
			System.exit(1);
		} catch (IndexOutOfBoundsException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		try {
			list.removeFirst();
			System.exit(1);
		} catch (EmptyCollectionException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		if (list.contains(i1)) System.exit(1);

		try {
			list.last();
			System.exit(1);
		} catch (EmptyCollectionException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		if (!list.isEmpty()) System.exit(1);

		it = list.iterator();

		if (it.hasNext()) System.exit(1);

		lit = list.listIterator();

		if (lit.hasNext()) System.exit(1);

		if (lit.hasPrevious()) System.exit(1);

		// let's add something

		list.add(i1);

		try {
			@SuppressWarnings("unused")
			Integer i = it.next();
			System.exit(1);
		} catch (ConcurrentModificationException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		try {
			@SuppressWarnings("unused")
			Integer i = lit.next();
			System.exit(1);
		} catch (ConcurrentModificationException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		lit = list.listIterator();

		if (!lit.hasNext()) System.exit(1);

		if (lit.hasPrevious()) System.exit(1);

		if (!lit.next().equals(i1)) System.exit(1);

		if (!lit.hasPrevious()) System.exit(1);

		if (!lit.previous().equals(i1)) System.exit(1);

		if (list.size() != 1) System.exit(1);

		if (!list.contains(i1)) System.exit(1);

		if (!list.first().equals(i1)) System.exit(1);

		if (!list.last().equals(i1)) System.exit(1);

		// remove with lit

		lit.remove();

		if (!list.isEmpty()) System.exit(1);

		if (lit.hasNext()) System.exit(1);

		if (lit.hasPrevious()) System.exit(1);

		try {
			lit.remove();
			System.exit(1);
		} catch (IllegalStateException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		// add to front

		list.addToFront(i1);

		if (list.isEmpty()) System.exit(1);

		if (list.size() != 1) System.exit(1);

		if (!list.first().equals(i1)) System.exit(1);

		if (!list.get(0).equals(i1)) System.exit(1);

		try {
			lit.hasNext();
			System.exit(1);
		} catch (ConcurrentModificationException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		lit = list.listIterator(1);

		if (!lit.previous().equals(i1)) System.exit(1);

		System.out.println(list);

		// remove last element

		if (!list.remove(i1).equals(i1)) System.exit(1);

		try {
			lit.hasPrevious();
			System.exit(1);
		} catch (ConcurrentModificationException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		if (list.size() != 0) System.exit(1);

		// add several elements
		list.add(i1);

		list.add(i2);

		list.add(i3);

		list.add(i4);

		lit = list.listIterator(1);

		if (!lit.next().equals(i2)) System.exit(1);

		lit.remove();

		System.out.println(list);

		if (!lit.hasNext()) System.exit(1);

		if (!lit.next().equals(i3)) System.exit(1);

		if (!lit.previous().equals(i3)) System.exit(1);

		if (!lit.previous().equals(i1)) System.exit(1);

		if (!list.first().equals(i1)) System.exit(1);

		if (!list.last().equals(i4)) System.exit(1);

		// remove from front

		if (!list.removeFirst().equals(i1)) System.exit(1);

		try {
			lit.hasNext();
			System.exit(1);
		} catch (ConcurrentModificationException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		// remove by identity

		if (!list.remove(i4).equals(i4));

		System.out.println(list);

		if (!list.last().equals(i3)) System.exit(1);

		// remove from front with lit

		lit = list.listIterator(0);

		if (!lit.next().equals(i3)) System.exit(1);

		lit.remove();

		if (lit.hasPrevious()) System.exit(1);

		try {
			if (list.first().equals(i3)) System.exit(1);
			System.exit(1);
		} catch (EmptyCollectionException e) {
			// ok
		} catch (Exception e) {
			System.exit(1);
		}

		if (list.size() != 0) System.exit(1);

		// Success!
		System.out.println("Congratulations - Your DoubleLinkedList might be working correctly!");
	}
}
