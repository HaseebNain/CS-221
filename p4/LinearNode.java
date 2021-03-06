/**
 * LinearNode represents a node in a single-linked list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinearNode<E>
{
    private LinearNode<E> next;
    private LinearNode<E> previous;
    private E element;
    
    /**
     * Creates an empty node.
     */
    public LinearNode()
    {
        next = null;
        element = null;
        previous = null;
    }
    
    /**
     * Creates a node storing the specified element.
     *
     * @param elem the element to be stored within the new node
     */
    public LinearNode(E elem)
    {
        next = null;
        element = elem;
        previous = null;
    }
    
    /**
     * Returns the node that follows this one.
     *
     * @return the node that follows the current one
     */
    public LinearNode<E> getNext()
    {
        return next;
    }
    
    /**
     * Returns the node that is previous to this one.
     * 
     * @return the node that is previous to the current one
     */
    public LinearNode<E> getPrevious(){
    	return previous;
    	
    }
    
    /**
     * Sets the node that follows this one.
     *
     * @param node the node to be set to follow the current one
     */
    public void setNext(LinearNode<E> node)
    {
        next = node;
    }
    
    /**
     * Sets the node previous to this one.
     * 
     * @param node the node to be set as the previous node to the current node
     */
    public void setPrevious(LinearNode<E> node){
    	previous = node;
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

