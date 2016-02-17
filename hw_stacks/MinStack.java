
public class MinStack<T> implements StackADT{

	LinearNode<Object> top;
	int size=0;

	@Override
	public void push(Object element) {
		LinearNode<Object> tmp = new LinearNode<Object>(element);
		tmp.setNext(top);
		top = tmp;
		size++;
	}

	@Override
	public Object pop() {

		if(isEmpty())
			throw new EmptyCollectionException("MinStack");

		Object returnedObject = top.getElement();
		top=top.getNext();
		size--;

		return returnedObject;

	}

	@Override
	public Object peek() {
		Object returnedObject = top.getElement();
		return returnedObject;

	}

	@Override
	public boolean isEmpty() {
		if(size==0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return size;
	}

	public String toString(){
		String myOutPut="";
		if(isEmpty()||size()==0)
			myOutPut="[ ]";

		LinearNode<Object> current = new LinearNode<Object>();
		current = top;
		int counter=0;

		while(counter!=size()){
			myOutPut=myOutPut+"[ "+current.getElement()+" ]";
			current=current.getNext();	
			counter++;

		}

		return myOutPut;	
		
	}


//	public class StringMaker{
//		MinStack<Object> tmpStack;
//		MinStack<Object> myStack;
//		Object tmp;
//		
//		public String toString(){
//			int mySize=myStack.size();
//			String str="";
//			for(int i=0;i<mySize;i++){
//				
//				tmp=myStack.pop();
//				str=str+"-"+tmp;
//				tmpStack.push(tmp);
//			}
//			for(int i=0;i<mySize;i++){
//				myStack
//				
//			}
//		}
//		
//		
//		
//		
//		
//	}


}
