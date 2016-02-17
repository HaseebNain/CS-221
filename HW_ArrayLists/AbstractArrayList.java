import java.util.*;

/**
 * ArrayList represents an array implementation of a list. The front of
 * the list is kept at array index 0. This class will be extended
 * to create a specific kind of list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public abstract class AbstractArrayList<T> implements ListADT<T>
{
	private final static int DEFAULT_CAPACITY = 100;
	private final static int NOT_FOUND = -1;

	protected int rear;
	protected int head;
	protected T[] list; 
	protected int modCount;

	/**
	 * Creates an empty list using the default capacity.
	 */
	public AbstractArrayList()
	{
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty list using the specified capacity.
	 *
	 * @param initialCapacity the integer value of the size of the array list
	 */
	public AbstractArrayList(int initialCapacity)
	{
		rear = 0;
		head = 0;
		list = (T[])(new Object[initialCapacity]);
		modCount = 0;
	}

	
	/**
	 * Creates a new array to store the contents of this list with
	 * twice the capacity of the old one. Called by descendant classes
	 * that add elements to the list.
	 */
	protected void expandCapacity()
	{
		modCount++;
		rear=rear++;
	}

	public void add(int index, T element){
		rear++;
		list[index]=element;
		for (int scan=index; scan < rear; scan++)
			list[scan] = list[scan+1];

		modCount++;
	}
	
	public void set(int index, T element) {
		list[index]=element;
		modCount++;
	}
	
	
	public void add(T element) {
		rear++;
		list[rear]=element;
		modCount++;
	}
	
	public T get(int index) {
	
		return list[index];
	}

	public int indexOf(T element) {
		int index=0;
		index = this.find(element);
		return index;
	}
	
	public T remove(int index) {
		rear--;
		list[index]=null;
		for (int scan=index; scan < rear; scan++)
			list[scan] = list[scan+1];

		modCount++;

		return null;
	}
	/**
	 * Removes and returns the last element in this list.
	 *
	 * @return the last element in the list
	 * @throws EmptyCollectionException if the element is not in the list
	 */
	public T removeLast() throws EmptyCollectionException
	{
		modCount++;
		rear--;
		return list[rear+1];
		//TODO To be completed as a Programming Project
	}

	/**
	 * Removes and returns the first element in this list.
	 *
	 * @return the first element in the list
	 * @throws EmptyCollectionException if the element is not in the list
	 */
	public T removeFirst() throws EmptyCollectionException
	{
		modCount++;
		head++;
		return list[head-1];
		//TODO To be completed as a Programming Project
	}

	/**
	 * Removes and returns the specified element.
	 *
	 * @param  element the element to be removed and returned from the list
	 * @return the removed elememt
	 * @throws ElementNotFoundException if the element is not in the list
	 */
	public T remove(T element)
	{
		
		T result;
		int index = find(element);

		if (index == NOT_FOUND)
			throw new ElementNotFoundException("ArrayList");

		result = list[index];
		rear--;

		// shift the appropriate elements 
		for (int scan=index; scan < rear; scan++)
			list[scan] = list[scan+1];

		list[rear] = null;
		modCount++;

		return result;
	}
	
	
	public void removeViaIterator(T element){
		
		remove(element);
	}

	/**
	 * Returns a reference to the element at the front of this list.
	 * The element is not removed from the list.  Throws an
	 * EmptyCollectionException if the list is empty.  
	 *
	 * @return a reference to the first element in the list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T first() throws EmptyCollectionException
	{
		
		if(head==rear){
			throw new EmptyCollectionException("Boo");
		}
		
		return list[head];
		
	}

	/**
	 * Returns a reference to the element at the rear of this list.
	 * The element is not removed from the list. Throws an
	 * EmptyCollectionException if the list is empty.  
	 *
	 * @return a reference to the last element of this list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T last() throws EmptyCollectionException
	{
		if(head==rear){
			throw new EmptyCollectionException("Boo");
		}
		return list[rear];
		
	}

	/**
	 * Returns true if this list contains the specified element.
	 *
	 * @param target the target element
	 * @return true if the target is in the list, false otherwise 
	 */
	public boolean contains(T target)
	{
		return (find(target) != NOT_FOUND);
	}

	/**
	 * Returns the array index of the specified element, or the
	 * constant NOT_FOUND if it is not found.
	 *
	 * @param target the target element
	 * @return the index of the target element, or the 
	 *         NOT_FOUND constant
	 */
	private int find(T target)
	{
		int scan = 0; 
		int result = NOT_FOUND;

		if (!isEmpty())
			while (result == NOT_FOUND && scan < rear)
				if (target.equals(list[scan]))
					result = scan;
				else
					scan++;

		return result;
	}

	/**
	 * Returns true if this list is empty and false otherwise. 
	 *
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		boolean isEmpty=false;
		if(head==rear){
			isEmpty=true;
		}
		return isEmpty;

	}

	/**
	 * Returns the number of elements currently in this list.
	 *
	 * @return the number of elements in the list
	 */
	public int size()
	{
		return rear;
		//return modCount;
		//TODO To be completed as a Programming Project
	}

	/**
	 * Returns a string representation of this list. 
	 * 
	 * @return the string representation of the list
	 */
	public String toString()
	{
		String myArrayToString="";
		for (int i=0;i <rear;i++){
			myArrayToString=myArrayToString+list[i].toString();
		}
		return myArrayToString;
		//TODO To be completed as a Programming Project
	}

	/**
	 * Returns an iterator for the elements currently in this list.
	 * 
	 * @return an iterator for the elements in the list
	 */
	public Iterator<T> iterator()
	{
		return new ArrayListIterator();
	}

	/**
	 * ArrayListIterator iterator over the elements of an ArrayList.
	 */	
	private class ArrayListIterator implements Iterator<T>
	{
		int iteratorModCount;	//the "version" of the list at the time the Iterator was created
		int current;
		boolean canRemove;

		/**
		 * Sets up this iterator using the specified modCount.
		 * 
		 * @param modCount the current modification count for the ArrayList
		 */
		public ArrayListIterator()
		{
			iteratorModCount = modCount;
			current = 0;
			canRemove=false;
		}

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			
			
			
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();

			return (current < rear);
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return  the next element in the iteration
		 * @throws  NoSuchElementException if an element not found exception occurs
		 * @throws  ConcurrentModificationException if the collection has changed
		 */
		public T next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new NoSuchElementException();

			current++;
			canRemove=true;

			return list[current - 1];
		}

		/**
		 * The remove operation is not supported in this collection.
		 * 
		 * @throws UnsupportedOperationException if the remove method is called
		 */
		public void remove() throws UnsupportedOperationException
		{
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();

			
			if (!canRemove){
					throw new IllegalStateException();
			}
			
			//utility method up above after remove to avoid conflicing names.
			removeViaIterator(list[current-1]);
			iteratorModCount=modCount;
			canRemove=false;
			current--;
			//throw new UnsupportedOperationException();
		}

	}	
}
