import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * BadDLL is a partial (and poor) implementation of DoubleLinkedListADT.
 *
 * @author Java Foundations, mvail 
 * @version 4.0
 */
public class BadDLL<T> implements DoubleLinkedListADT<T>
{	
	private enum IterLastOp { next, prev, other } //%$@# compiler won't let me declare enum in LinearDoubleNode where it belongs

	private int count;
	private LinearDoubleNode<T> head, tail;
	private int modCount;

	/**
	 * Creates an empty list.
	 */
	public BadDLL()
	{
		count = 0;
		head = tail = null;
		modCount = 0;
	}

	/**
	 * Removes the first element in this list and returns a reference
	 * to it. Throws an EmptyCollectionException if the list is empty.
	 *
	 * @return a reference to the first element of this list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T removeFirst()
	{
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedList");
		}
		T retVal = head.getElement();
		if (count == 1) {
			head = tail = null;
		} else {
			if (head.getNext() != null) {
				head.getNext().setPrevious(null);
			}
			head = head.getNext();
		}
		
		modCount++;
		count--;
		return retVal;
	}

	/**
	 * Removes the last element in this list and returns a reference
	 * to it. Throws an EmptyCollectionException if the list is empty.
	 *
	 * @return the last element in this list
	 * @throws EmptyCollectionException if the list is empty    
	 */
	public T removeLast()
	{
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedList");
		}
		T retVal = tail.getElement();

		if (count == 1) {
			head = tail = null;
		} else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		modCount++;
		count--;
		return retVal;
	}

	/**
	 * Removes the first instance of the specified element from this
	 * list and returns a reference to it. Throws an EmptyCollectionException 
	 * if the list is empty. Throws a ElementNotFoundException if the 
	 * specified element is not found in the list.
	 *
	 * @param  targetElement the element to be removed from the list
	 * @return a reference to the removed element
	 * @throws ElementNotFoundException if the target element is not found
	 */
	public T remove(T targetElement) throws ElementNotFoundException 
	{
		if (isEmpty())
			throw new ElementNotFoundException("LinkedList");

		LinearDoubleNode<T> targetNode = head;

		while (targetNode != null && !targetElement.equals(targetNode.getElement())) {
			targetNode = targetNode.getNext();
		}

		if (targetNode == null)
			throw new ElementNotFoundException("LinkedList");

		if (size() == 1)
			head = tail = null;
		else if (targetNode.equals(head)) {
			targetNode.getNext().setPrevious(null);
			head = targetNode.getNext();
		} else if (targetNode.equals(tail)) {
			tail = tail.getPrevious();
			tail.setNext(null);
		} else {
			targetNode.getPrevious().setNext(targetNode.getNext());
			targetNode.getNext().setPrevious(targetNode.getPrevious());
		}

		count--;
		modCount++;

		return targetNode.getElement();
	}

	/**
	 * Returns the first element in this list without removing it. 
	 *
	 * @return the first element in this list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T first() throws EmptyCollectionException
	{
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedList");
		}
		return head.getElement();
	}

	/**
	 * Returns the last element in this list without removing it. 
	 *
	 * @return the last element in this list  
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T last() throws EmptyCollectionException
	{
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedList");
		}
		return tail.getElement();
	}

	/**
	 * Returns true if the specified element is found in this list and 
	 * false othebrwise. Throws an EmptyCollectionException if the list 
	 * is empty.
	 *
	 * @param  targetElement the element that is sought in the list
	 * @return true if the element is found in this list
	 */
	public boolean contains(T targetElement)
	{
		LinearDoubleNode<T> current = head;
		while (current != null) {
			if (targetElement.equals(current.getElement())) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	/**
	 * Returns true if this list is empty and false otherwise.
	 *
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in the list
	 */
	public int size()
	{
		return count;
	}

	/**
	 * Returns a string representation of this list.
	 *
	 * @return a string representation of the list    
	 */
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("[");

		LinearDoubleNode<T> current = head;
		while (current != null) {
			str.append(current.getElement());
			if (current.getNext() != null)
				str.append(", ");
			current = current.getNext();
		}
		str.append("]");
		return str.toString();
	}

	/**
	 * Returns an iterator for the elements in this list. 
	 *
	 * @return an iterator over the elements of the list
	 */
	public Iterator<T> iterator()
	{
		return listIterator();
	}

	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToFront(T element)
	{
		LinearDoubleNode<T> newNode = new LinearDoubleNode<T>(element);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		modCount++;
		count++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToRear(T element)
	{
		LinearDoubleNode<T> newNode = new LinearDoubleNode<T>(element);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		
		modCount++;
		count++;
	}	

	/* (non-Javadoc)
	 * @see UnorderedListADT#addAfter(java.lang.Object, java.lang.Object)
	 */
	public void addAfter(T element, T target) {
		//ignore - don't bother filling in this method
	}

	/* (non-Javadoc)
	 * @see IndexedListADT#add(int, java.lang.Object)
	 */
	public void add(int index, T element) {
		//ignore - don't bother filling in this method
	}

	/**  
	 * Adds the specified element to the rear of this list. 
	 *
	 * @param element  the element to be added to the rear of the list    
	 */
	public void add(T element) {
		addToRear(element);
	}

	/* (non-Javadoc)
	 * @see IndexedListADT#set(int, java.lang.Object)
	 */
	public void set(int index, T element) {
		// ignore - don't bother filling in this method
	}

	/**  
	 * Returns a reference to the element at the specified index. 
	 *
	 * @param index  the index to which the reference is to be retrieved from
	 * @return the element at the specified index    
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public T get(int index) {
		if(index>size()){
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		}
		LinearDoubleNode<T> iNode = head;		
		for (int i = 0; i < index; i++) {
			iNode = iNode.getNext();
		}
		return iNode.getElement();
	}

	/* (non-Javadoc)
	 * @see IndexedListADT#indexOf(java.lang.Object)
	 */
	public int indexOf(T element) {
		// ignore - don't bother filling in this method
		return -1;
	}

	/* (non-Javadoc)
	 * @see IndexedListADT#remove(int)
	 */
	public T remove(int index) {
		// ignore - don't bother filling in this method
		return null;
	}

	/* (non-Javadoc)
	 * @see DoubleLinkedListADT#listIterator()
	 */
	public ListIterator<T> listIterator() {
		return new LinkedListIterator(0);
	}

	/* (non-Javadoc)
	 * @see DoubleLinkedListADT#listIterator(int)
	 */
	public ListIterator<T> listIterator(int startingIndex) {
		return new LinkedListIterator(startingIndex);
	}

	///////////////////////////////////////////////////////////////////////////	

	/**
	 * LinkedIterator represents an iterator for a double-linked list of linear nodes.
	 */
	private class LinkedListIterator implements ListIterator<T>
	{
		private int iterModCount;
		private LinearDoubleNode<T> nextNode;
		private LinearDoubleNode<T> lastReturned;
		private int nextIdx;
		private IterLastOp lastOp;

		/**
		 * Initializes iterator before given starting index
		 * @param startingIndex index of element that would be returned by a call to next() 
		 */
		public LinkedListIterator(int startingIndex) {
			if (startingIndex < 0 || startingIndex > count) {
				throw new IndexOutOfBoundsException("LinkedListIterator");
			}
			nextNode = head;
			nextIdx = 0;
			lastReturned = null;
			iterModCount = modCount;
			lastOp = IterLastOp.other;
			for (int i = 0; i < startingIndex; i++) {
				next();
				//nextIdx++;
			}
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#hasNext()
		 */
		public boolean hasNext() {
			if (iterModCount != modCount) {
				throw new ConcurrentModificationException("LinkedListIterator");
			}
			return (nextNode != null);
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#next()
		 */
		public T next() {
			if (iterModCount != modCount) {
				throw new ConcurrentModificationException("LinkedListIterator");
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			T retVal = nextNode.getElement();
			lastReturned = nextNode;
			nextNode = nextNode.getNext();
			nextIdx++;
			lastOp = IterLastOp.next;
			return retVal;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#hasPrevious()
		 */
		public boolean hasPrevious() {
			if (iterModCount != modCount) {
				throw new ConcurrentModificationException("LinkedListIterator");
			}
			return (nextNode != head);
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#previous()
		 */
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException("LinkedListIterator");
			}
			if (nextNode != null) {
				nextNode = nextNode.getPrevious();
			} else {
				nextNode = tail;
			}
			lastReturned = nextNode;
			lastOp = IterLastOp.prev;
			nextIdx--;
			return nextNode.getElement();
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#remove()
		 */
		public void remove() {
			if (iterModCount != modCount) {
				throw new ConcurrentModificationException("LinkedListIterator");
			}
			if (lastOp == IterLastOp.other) {
				throw new IllegalStateException("LinkedListIterator");
			}
			if (lastOp == IterLastOp.prev) {
				nextNode = nextNode.getNext();
			}
			if (lastReturned == head) {
				removeFirst();
			} else if (lastReturned == tail) {
				removeLast();
			} else {
				lastReturned.getPrevious().setNext(lastReturned.getNext());
				lastReturned.getNext().setPrevious(lastReturned.getPrevious());
				count--;
				modCount++;
				
			}
			if (lastOp == IterLastOp.next) {
				nextIdx--;
			}
			iterModCount++; //to stay in sync
			lastReturned = null;
			lastOp = IterLastOp.other;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#nextIndex()
		 */
		public int nextIndex() {
			if (iterModCount != modCount) {
				throw new ConcurrentModificationException("LinkedListIterator");
			}
			return nextIdx;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#previousIndex()
		 */
		public int previousIndex() {
			if (iterModCount != modCount) {
				throw new ConcurrentModificationException("LinkedListIterator");
			}
			return nextIdx - 1;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#set(java.lang.Object)
		 */
		public void set(T e) {
			// ignore - don't bother filling in this method
			throw new UnsupportedOperationException("BadDLL");
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#add(java.lang.Object)
		 */
		public void add(T e) {
			// ignore - don't bother filling in this method
			throw new UnsupportedOperationException("BadDLL");
		}
	}

	///////////////////////////////////////////////////////////////////////////

	/**
	 * Node class needed to implement a double-linked list
	 * @param <E> data type to store
	 */
	private class LinearDoubleNode<E> {
		private LinearDoubleNode<E> next, prev;
		private E element;

		/**
		 * Creates a node storing the specified element.
		 *
		 * @param elem the element to be stored within the new node
		 */
		public LinearDoubleNode(E elem)
		{
			next = prev = null;
			element = elem;
		}

		/**
		 * Returns the node that follows this one.
		 *
		 * @return the node that follows the current one
		 */
		public LinearDoubleNode<E> getNext()
		{
			return next;
		}

		/**
		 * Returns the node that precedes this one.
		 *
		 * @return the node that precedes the current one
		 */
		public LinearDoubleNode<E> getPrevious()
		{
			return prev;
		}

		/**
		 * Sets the node that follows this one.
		 *
		 * @param node the node to be set to follow the current one
		 */
		public void setNext(LinearDoubleNode<E> node)
		{
			next = node;
		}

		/**
		 * Sets the node that precedes this one.
		 *
		 * @param node the node to be set to precede the current one
		 */
		public void setPrevious(LinearDoubleNode<E> node)
		{
			prev = node;
		}

		/**
		 * Returns the element stored in this node.
		 *
		 * @return the element stored in this node
		 */
		public E getElement()
		{
			return element;
		}

		/**
		 * Sets the element stored in this node.
		 *
		 * @param elem the element to be stored in this node
		 */
		public void setElement(E elem)
		{
			element = elem;
		}
	}
}
