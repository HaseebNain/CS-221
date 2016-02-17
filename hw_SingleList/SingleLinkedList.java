/**
 * SingleLinkedList represents a LinearNode-based implementation of both an unordered and indexed list.
 *
 * @author Java Foundations, 
 * @version 4.0
 */
public class SingleLinkedList<T> extends AbstractLinkedList<T> implements UnorderedListADT<T>, IndexedListADT<T>
{	
	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToFront(T element)
	{
		T myElement = first();
		LinearNode<T> elementNode = new LinearNode<T>(element);
		if (isEmpty()){
			head = elementNode;
			tail = head;//elementNode;
		} else{	
			elementNode.setNext(head);
			head = elementNode;
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
	public void addAfter(T element, T target)
	{
		
		LinearNode myNode = head;
		if(isEmpty()){
			throw new EmptyCollectionException("EMPTWERG");
		}
		LinearNode<T> targetNode = new LinearNode<T>(target);
		LinearNode<T> elementNode = new LinearNode<T>(element);
		while (myNode != null) { 
			if (myNode.getElement().equals(target)){
				myNode = myNode.getNext();
				break;
			}
		}
		myNode.setNext(elementNode);
		count++;
		modCount++;
	}

	/**  
	 * Inserts the specified element at the specified index. 
	 * 
	 * @param index   the index into the array to which the element is to be
	 *                inserted.
	 * @param element the element to be inserted into the array   
	 */
	public void add(int index, T element) {
		LinearNode myNode = head;
		while (myNode != null) { 
			if (index == 0) { 
				LinearNode newNode = new LinearNode(element);
				myNode.setNext(newNode);
				break;
			}
			myNode = myNode.getNext();
		}
		count++;
		modCount++;
	}

	/**  
	 * Adds the specified element to the rear of this list. 
	 *
	 * @param element  the element to be added to the rear of the list    
	 */
	public void add(T element) {
		addToRear(element);// TODO To be completed as a Programming Project
	}

	/**  
	 * Sets the element at the specified index. 
	 *
	 * @param index   the index into the array to which the element is to be set
	 * @param element the element to be set into the list
	 */
	public void set(int index, T element) {
		LinearNode myNode = head;
		int counter=0;
		while (myNode != null) { 
			if (index == 0) { 
				LinearNode newNode = new LinearNode(element);
				myNode.setNext(newNode);
				break;
			}else{
				counter++;
				myNode = myNode.getNext();
				if(counter==index){
					myNode.setNext(myNode);
					break;
				}
			}
			counter++;
		}
		count++;
		modCount++;
	}

	/**  
	 * Returns a reference to the element at the specified index. 
	 *
	 * @param index  the index to which the reference is to be retrieved from
	 * @return the element at the specified index    
	 */
	public T get(int index) {
		LinearNode myNode = head;
		int counter=0;
		while (myNode != null) { 
			if (index == 0) { 
				myNode.getElement();
				break;
			}else{
				counter++;
				if(counter==index){
					myNode.getElement();
					break;
				}
			}
			counter++;
		}
		return null ;
	}

	/**  
	 * Returns the index of the specified element. 
	 *
	 * @param element  the element for the index is to be retrieved
	 * @return the integer index for this element    
	 */
	public int indexOf(T element) {
		LinearNode myNode = head;
		int counter=0;
		while (myNode != null) { 
			if (myNode.getNext().equals(element)){
				break;
			}
			counter++;
		}
		return counter;
	}

	/**  
	 * Returns the element at the specified element. 
	 *
	 * @param index the index of the element to be retrieved
	 * @return the element at the given index    
	 */
	public T remove(int index) {
		LinearNode myNode = head;
		T returnNode = null;
		int counter=0;
		while (myNode != null) { 
			if (counter==index){
				returnNode = (T) myNode.getElement();
				myNode.setElement(null);
				break;
			}
			myNode.getNext();
			counter++;
		}
		count--;
		modCount++;
		return returnNode;
	}
}
