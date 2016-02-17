
/**
 * This class will create a link based array to be used by the JosephusQueues class
 * @author Haseeb Nain
 *
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT{

	private LinearNode<T> head,tail;
	private int size;
	
	/**
	 * This is a constructor that will create a linked based queue, of no elements.
	 */
	public LinkedQueue(){
		size = 0;
		head=tail=null;
	}
	
	/**
	 * This method will take in an element, and add it the beginning of the queue.
	 * @param this method takes in an element to be added to the start of the queue.
	 */
	public void enqueue(Object element) {
		LinearNode<T> node = new LinearNode<T>((T)element);
		
		if(isEmpty()){
			head=node;
		}
		else
			tail.setNext(node);
		tail=node;
		size++;
		
	}

	/**
	 * This method will remove the last object in queue.
	 * @return this will return the object at the end of the queue.
	 */
	@Override
	public Object dequeue() {
		if(isEmpty()){
			throw new EmptyCollectionException("LinkedQueue");
		}
		
		T returnElement = head.getElement();
		head=head.getNext();
		size--;
		if(isEmpty()){
			tail=head;
		}
		return returnElement;
	}

	/**
	 * This method will return the first object in the array
	 * @return the first object in the method.
	 */
	@Override
	public Object first() {
		
		return head.getElement();
	}

	/**
	 * This method will return a boolean, true if the array is empty, false otherwise.
	 * @return a boolean repersentation of the state of the queue, and if it is empty or not
	 */
	@Override
	public boolean isEmpty() {
		if(size==0||(head==null&&tail==null))
			return true;
			else
		return false;
	}

	/**
	 * This method will return the size of the linked queue.
	 * @return an int value repersenting the size of the queue.
	 */
	@Override
	public int size() {

		return size;
	}
	
	/** 
	 * returns a string value stating all values in the the array queue
	 * @return a string value showing all the values in the queue.
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
			myOutPut=myOutPut+"[ "+current.getElement()+" ]";
			current=current.getNext();	
			counter++;

		}

		return myOutPut;	
	}


}
