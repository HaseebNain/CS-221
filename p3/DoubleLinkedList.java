import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Creates a DoubleLinkedList of elements, implements the DoubleLinkedListADT class.
 * 
 * @author hnain
 */

public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToFront(T element)
	{

		LinearNode<T> elementNode = new LinearNode<T>(element);
		if (isEmpty()){
			head = elementNode;
			tail = elementNode;
		} else{	
			head.setPrevious(elementNode);
			elementNode.setNext(head);
			head=elementNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToRear(T element)
	{
		LinearNode<T> elementNode = new LinearNode<T>(element);
		if (isEmpty()){
			head = elementNode;
			tail = head;
		} else{
			tail.setNext(elementNode);
			elementNode.setPrevious(tail);
			tail=elementNode;
		}
		count++;
		modCount++;
	}	
	/**
	 * Adds the specified element to this list after the given target.
	 *
	 * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found
	 */
	public void addAfter(T element, T target) throws ElementNotFoundException
	{


		LinearNode<T> myNode = head;
		if(isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");


		LinearNode<T> elementNode = new LinearNode<T>(element);
		while (myNode != null) { 
			if (myNode.getElement().equals(target)){
				if(size()==1){
					addToRear(element);
					return;
				}
				if(myNode==head){
					add(0,element);
					return;

				}if(myNode==tail){
					add(element);
					return;
				}

				LinearNode<T> nxt = myNode.getNext();
				myNode.setNext(elementNode);
				elementNode.setPrevious(myNode);
				elementNode.setNext(nxt);
				nxt.setPrevious(elementNode);
				count++;
				modCount++;
				return;
			}
			myNode = myNode.getNext();
		}
		throw new ElementNotFoundException("You Done Failed at Finding a Valid Target!");
	}

	/**  
	 * Inserts the specified element at the specified index. 
	 * 
	 * @param index   the index into the array to which the element is to be
	 *                inserted.
	 * @param element the element to be inserted into the array   
	 */
	public void add(int index, T element) {
		LinearNode<T> elementNode = new LinearNode<T>(element);
		LinearNode<T> current = head;

		if (index >= size()||index<0)
			throw new IndexOutOfBoundsException("DoubleLinkedList");

		int counter=0;
		while ( current != null) {
			if(index==0){
				addToRear(element);
				return;
			}
			if(index==size()){
				addToRear(element);
				return;
			}

			if(counter==index){

				elementNode.setNext(current.getNext());
				current.getNext().setPrevious(elementNode);
				current.setNext(elementNode);
				elementNode.setPrevious(current);
				count++;
				modCount++;
				return;
			}
			current = current.getNext();
			counter++;
		}

	}

	/**  
	 * Adds the specified element to the rear of this list. 
	 *
	 * @param element  the element to be added to the rear of the list    
	 */
	public void add(T element) {
		addToRear(element);
	}

	/**  
	 * Sets the element at the specified index. 
	 *
	 * @param index   the index into the array to which the element is to be set
	 * @param element the element to be set into the list
	 */
	public void set(int index, T element) throws IndexOutOfBoundsException{
		LinearNode<T> current = head;

		int counter=0;
		
		if(index>size()||index<0)
			throw new IndexOutOfBoundsException();
		
		while ( current != null) { 

			if(counter==index){
				current.setElement(element);
				return;
			}
			current = current.getNext();
			counter++;
		}
	}

	/**  
	 * Returns a reference to the element at the specified index. 
	 *
	 * @param index  the index to which the reference is to be retrieved from
	 * @return the element at the specified index    
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		LinearNode<T> current = head;
		T returnElement=null;
		int counter=0;
		if(index>size()||index<0)
			throw new IndexOutOfBoundsException();
		while (current != null) { 

			if(counter==index){
				returnElement = current.getElement();
				return current.getElement();
			}
			current = current.getNext();
			counter++;
		}
		return returnElement;
	}

	/**  
	 * Returns the index of the specified element. 
	 *
	 * @param element  the element for the index is to be retrieved
	 * @return the integer index for this element    
	 */
	public int indexOf(T element) throws ElementNotFoundException{
		LinearNode<T> current= head;
		int counter=0;
		while (current != null) { 
			if (current.getElement().equals(element)){
				return counter;

			}
			current = current.getNext();
			counter++;
		}
		throw new ElementNotFoundException("DoubleLinkedList");
	}

	/**  
	 * Returns the element at the specified element. 
	 *
	 * @param index the index of the element to be retrieved
	 * @return the element at the given index    
	 */
	public T remove(int index)  throws IndexOutOfBoundsException{
		LinearNode<T> current= head;
		T returnNode = null;
		int counter=0;
		
		if(index>size()||index<0)
			throw new IndexOutOfBoundsException();

		while (current != null) { 
			if (size()==1){
				head=tail=null;
				break;
			}
			if (counter==index){

				returnNode = current.getElement();

				current.getNext().setPrevious(current.getPrevious());
				current.getPrevious().setNext(current.getNext());

				break;
			}
			current=current.getNext();
			counter++;
		}
		count--;
		modCount++;
		return returnNode;
	}
	protected int count;
	protected LinearNode<T> head, tail;
	protected int modCount;

	/**
	 * Creates an empty DoubleLinkedList.
	 */
	public DoubleLinkedList()
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
	public T removeFirst() throws EmptyCollectionException
	{
		LinearNode<T> current = head;
		T myElement;
		if (isEmpty())
			throw new EmptyCollectionException("LinkedList");


		if(size()==0){
			head=tail=null;
		}

		myElement = first();

		head=head.getNext();
		count--;
		modCount++;

		return myElement;
	}

	/**
	 * Removes the last element in this list and returns a reference
	 * to it. Throws an EmptyCollectionException if the list is empty.
	 *
	 * @return the last element in this list
	 * @throws EmptyCollectionException if the list is empty    
	 */
	public T removeLast() throws EmptyCollectionException
	{

		T myElement;
		if (isEmpty())
			throw new EmptyCollectionException("LinkedList");



		if(size()==0){
			head=tail=null;
		}

		myElement = last();

		tail=tail.getPrevious();

		count--;
		modCount++;
		return myElement;
	}

	/**
	 * Removes the first instance of the specified element from this
	 * list and returns a reference to it. Throws an EmptyCollectionException 
	 * if the list is empty. Throws a ElementNotFoundException if the 
	 * specified element is not found in the list.
	 *
	 * @param  targetElement the element to be removed from the list
	 * @return a reference to the removed element
	 * @throws EmptyCollectionException if the list is empty
	 * @throws ElementNotFoundException if the target element is not found
	 */
	public T remove(T targetElement) throws EmptyCollectionException, ElementNotFoundException 
	{
		if (isEmpty())
			throw new EmptyCollectionException("LinkedList");


		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		while (current != null && !found)
			if (targetElement.equals(current.getElement()))
				found = true;
			else
			{
				previous = current;
				current = current.getNext();
			}

		if (!found)
			throw new ElementNotFoundException("LinkedList");

		if (size() == 1)  // only one element in the list
			head = tail = null;
		else if (current.equals(head))  // target is at the head 
			head = current.getNext();
		else if (current.equals(tail))  // target is at the tail
		{
			tail = previous;
			tail.setNext(null);
		}
		else  // target is in the middle
			previous.setNext(current.getNext());

		count--;
		modCount++;

		return current.getElement();
	}

	/**
	 * Returns the first element in this list without removing it. 
	 *
	 * @return the first element in this list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T first() throws EmptyCollectionException
	{
		if(head==null){
			throw new EmptyCollectionException("DoubleLinkedList");
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
		if(isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");
		return tail.getElement();
	}

	/**
	 * Returns true if the specified element is found in this list and 
	 * false otherwise. Throws an EmptyCollectionException if the list 
	 * is empty.
	 *
	 * @param  targetElement the element that is sought in the list
	 * @return true if the element is found in this list
	 * 
	 */
	public boolean contains(T targetElement)  throws ElementNotFoundException
	{

		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		while (current != null && !found){
			if (targetElement.equals(current.getElement()))
				found = true;
			else
			{
				previous = current;
				current = current.getNext();
			}
		}
		
		return found;	
	}

	/**
	 * Returns true if this list is empty and false otherwise.
	 *
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		if(head==null||tail==null){
			return true;
		}else{
			return false;
		}
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
		String myOutPut="";
		if(isEmpty()||size()==0)
			myOutPut="[ ]";

		LinearNode<T> current = new LinearNode<T>();
		current = head;
		int counter=0;

		while(counter!=size()){
			//myOutPut="";
			myOutPut=myOutPut+"[ "+current.getElement()+" ]";
			current=current.getNext();	
			counter++;

		}

		return myOutPut;	
	}

	/**
	 * Returns an iterator for the elements in this list. 
	 *
	 * @return an iterator over the elements of the list
	 */
	public ListIterator<T> listIterator()
	{
		return new LinkedListIterator();
	}



	/**
	 * Returns an iterator for the elements in this list, starting at the
	 * specified index
	 * 
	 * @return a LinkedListIterator with its starting index chosen by the user
	 */
	public ListIterator<T> listIterator(int startingIndex) {

		return new LinkedListIterator(startingIndex);
	}

	/** 
	 * Returns a casted variation of the LinkedLinkedIterator so that it can only use methods
	 * designated by the Iterator class
	 * 
	 * @return an Iterator for the elements on in the list.
	 */
	@Override
	public Iterator<T> iterator() {


		return (Iterator<T>) listIterator();

	}

	/**
	 * LinkedIterator represents an iterator for a linked list of linear nodes.
	 */
	private class LinkedListIterator implements ListIterator<T>
	{
		private int iteratorModCount;  // the "version" of the list at the time the Iterator was created
		private LinearNode<T> current;  // the current position
		private boolean lastActionNext,lastActionPrevious;
		private int index;

		/**
		 * Sets up this iterator using the specified items.
		 *
		 * @param collection  the collection the iterator will move over
		 * @param size        the integer size of the collection
		 */
		public LinkedListIterator()
		{
			current = head;
			iteratorModCount = modCount;
			index=0;
			lastActionNext=false;
			lastActionPrevious=false;
		}

		/**
		 * Creates a LinkedListIterator with its starting index chosen by the user
		 * 
		 * @param startingIndex
		 */
		public LinkedListIterator(int startingIndex){

			current = head;
			iteratorModCount = modCount;
			index=startingIndex;
			lastActionNext=false;
			lastActionPrevious=false;

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

			return (current != null);
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
		public boolean hasPrevious() throws ConcurrentModificationException{
			if(iteratorModCount!=modCount)
				throw new ConcurrentModificationException();
			
			return (current!=null);
//			if(current.getPrevious().equals(null)){
//				return false;
//			}
//			else return true;
			
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T next() throws ConcurrentModificationException,NoSuchElementException
		{
			if (!hasNext())
				throw new NoSuchElementException();
			if(modCount!=iteratorModCount)
				throw new ConcurrentModificationException();
			T result = current.getElement();
			current = current.getNext();
			lastActionNext=true;
			lastActionPrevious=false;
			index++;
			return result;
		}

		/**
		 * Returns the previous element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T previous() throws ConcurrentModificationException, NoSuchElementException{
			if (!hasPrevious())
				throw new NoSuchElementException();
			if(modCount!=iteratorModCount)
				throw new ConcurrentModificationException();
			T result = current.getElement();
			current = current.getPrevious();
			lastActionNext=false;
			lastActionPrevious=true;
			index--;
			return result;
		}


		/**
		 * Removes the element which has been last passed by the iterator
		 */
		public void remove() throws IllegalStateException
		{

			if(lastActionNext==false &&lastActionPrevious==false)
				throw new IllegalStateException();
			LinearNode<T> tmp;

			if(lastActionNext){
				tmp = current.getPrevious();
				if (tmp!=head)
					tmp.getPrevious().setNext(current);
				lastActionNext=false;
			}	
			if(lastActionPrevious){
				tmp = current.getNext();
				if(tmp !=tail)
					tmp.getNext().setPrevious(current);
				lastActionPrevious=false;
			}
			else{

			}

		}

		@Override
		public void add(T e) {
			LinearNode<T> tmp;
			LinearNode<T> elmNode = new LinearNode<T>(e);


			if(lastActionNext){
				tmp = current.getPrevious();
				if (tmp!=head)
					tmp.getPrevious().setNext(elmNode);
				elmNode.setNext(current);
				lastActionNext=false;
			}	
			if(lastActionPrevious){
				tmp = current.getNext();
				if(tmp !=tail)
					tmp.getNext().setPrevious(elmNode);
				elmNode.setPrevious(current);
				lastActionPrevious=false;
			}
			else{

			}

		}

		@Override
		public int nextIndex() {

			int nextIndex=0;
			nextIndex = index+1;
			return nextIndex;
		}

		@Override
		public int previousIndex() {

			int nextIndex=0;
			nextIndex = index-1;
			return nextIndex;
		}

		@Override
		public void set(T e) {
			LinearNode<T> tmp;

			if(lastActionNext==false&&lastActionPrevious==false){
				throw new IllegalStateException();
			}
			
			
			if(lastActionNext){
				tmp = current.getPrevious();
				if (tmp!=head)
					tmp.getPrevious().setElement(e);
			}	
			if(lastActionPrevious){
				tmp = current.getNext();
				if(tmp !=tail)
					tmp.getNext().setElement(e);
			}
			
			

		}
	}
}





