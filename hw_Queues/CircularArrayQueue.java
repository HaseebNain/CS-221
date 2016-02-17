
/**
 * This class will create a circular array that will be used by the JosephusQueues class
 * @author Haseeb Nain
 *
 * @param <T>
 */
public class CircularArrayQueue<T> implements QueueADT{

	
	private final static int DEFAULT_CAPACITY=100;
	private int head,tail,size;
	private T[] queue;
	
	/**
	 * This is a constructor that will create a circular array with a capacity specified by the user.
	 * @param initialCapacity
	 */
	public CircularArrayQueue(int initialCapacity){
		head=tail=size=0;
		queue = (T[]) (new Object[initialCapacity]);
	}
	
	/**
	 * This is a consturctor which will create a circular array with a default capacity of 100;
	 */
	public CircularArrayQueue(){
		head=tail=size=0;
		queue = (T[]) (new Object[DEFAULT_CAPACITY]);
	}
	
	/**
	 * This method will double the capacity of the circular array queue.
	 * 
	 */
	private void expandCapacity(){
		T[] larger = (T[]) (new Object[queue.length*2]);
		
		for(int i=0;i<size;i++){
			larger[i] = queue[head];
			head=(head+1)%queue.length;
		}
		head=0;
		tail=size;
		queue=larger;
	}
	
	
	/**
	 * This method will take in an element, and add it the beginning of the queue.
	 * @param this method takes in an element to be added to the start of the queue.
	 */
	@Override
	public void enqueue(Object element) {
		if(isEmpty())
		expandCapacity();
		queue[tail]=(T)element;
		tail=(tail+1)%queue.length;
		size++;
	}

	/**
	 * This method will remove the last object in queue.
	 * @return this will return the object at the end of the queue.
	 */
	@Override
	public Object dequeue() {
		if(isEmpty())
			throw new EmptyCollectionException("CircularArrayQueue");
		T returnElement = queue[head];
		queue[head]=null;
		head=(head+1)%queue.length;
		size--;
		return returnElement;
	}

	/**
	 * This method will return the first object in the array
	 * @return the first object in the method.
	 */
	@Override
	public Object first() {
		return queue[head];
	}

	/**
	 * This method will return a boolean, true if the array is empty, false otherwise.
	 * @return a boolean repersentation of the state of the queue, and if it is empty or not
	 */
	@Override
	public boolean isEmpty() {
		if(size==0)
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
		int counter=0;
		while(counter!=size()){
			myOutPut=myOutPut+"[ "+queue[counter]+" ]";	
			counter++;
		}
		return myOutPut;	
	}

}
