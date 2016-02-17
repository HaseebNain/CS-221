import java.util.Iterator;




public class GoodLinkedList extends SingleLinkedList implements UnorderedListADT, IndexedListADT {





	@Override
	public Object removeFirst() {
		return super.removeFirst();
	}

	@Override
	public Object removeLast() {
		return super.removeLast();

	}

	@Override
	public Object remove(Object element) {

		return super.remove(element);
	}

	@Override
	public Object first() {

		return super.first();
	}

	@Override
	public Object last() {

		return super.last();
	}

	@Override
	public boolean contains(Object target) {

		return super.contains(target);
	}

	@Override
	public boolean isEmpty() {

		return super.isEmpty();
	}

	@Override
	public int size() {

		return super.size();
	}

	@Override
	public Iterator iterator() {

		return super.iterator();
	}

	@Override
	public void add(int index, Object element) {
		super.add(index, element);

	}

	@Override
	public void set(int index, Object element) {
		super.set(index, element);

	}

	@Override
	public void add(Object element) {
		super.add(element);

	}

	@Override
	public Object get(int index) {
		return super.get(index);

	}

	@Override
	public int indexOf(Object element) {

		return super.indexOf(element);
	}

	@Override
	public Object remove(int index) {

		return super.remove(index);
	}

	@Override
	public void addToFront(Object element) {
		super.addToFront(element);

	}

	@Override
	public void addToRear(Object element) {
		super.addToRear(element);

	}

	@Override
	public void addAfter(Object element, Object target) {
		super.addAfter(element, target);

	}

	public String toString(){
		String myOutPut="";
		int mySize = size();
		int count=0;
		if (isEmpty())
			throw new EmptyCollectionException("LinkedList");

		
		LinearNode<Integer> current = head;

		while (count!=mySize){
			
			myOutPut=myOutPut+" "+current.getElement().toString();
			current.getNext();
			count++;
		}
			return myOutPut;
	}




}
