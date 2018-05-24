/* *
 *<h4>Description:</h4> 
 *<br>
 *<p>
 * The List class here is a simple LinkedList structure that will be used as the
 * super class to a Stack and Queue class. The methods here will allow for
 * inserting and removing of nodes at certain indices in the list. 
 * 
 * This class contains an inner class called Node which is used to store the data from
 * the Object that is being manipulated in the list.
 *</p>
 *
 *@author Ian Bryan
 * */
public class List {

	/* *
	 * A little pseudocode to go with the class
	 * 
	 * List uses inner class Node to store object
	 * 
	 * Set head Node to null (the font of the LinkedList)
	 * 
	 * method insert an Object at specified index
	 * 	if list is empty, add to front of list
	 * 	else if next position is empty, add to end of list
	 * 	else if the list has 2+ Nodes, add to specified index
	 * 
	 * 
	 * method remove(int someIndex)
	 * 
	 * 	check if list is empty, if it is, throw exception
	 * 	if it's not, 
	 *		iterate over list and when
	 *		index matches i'th count of elements, 
	 *		remove the element at the i position.
	 *
	 * size() --> returns size of the list
	 * 
	 * toString --> go over list while the head isn't null and print the Node
	 * 
	 * isEmpty() --> check for if true when queried head is null. If false, the list isn't
	 * empty.
	 * 
	 * append() --> add Node to end of the list
	 * */

	private Node head;

	public List(){
		head = null;
	}

	/*
	 * Inner class, Node, is used to set the reference from the current
	 * link to the next one with the value of the Object passed in by the
	 * driver class and Node 2-argument constructor.
	 * */
	private class Node {

		private Object data;
		private Node next;

		/*No argument constructor*/
		public Node(){
			data = null; //set data to null because no value was passed in.
		}

		/* 
		 * <h4>Description:</h4><br>
		 * <p>Constructor that takes two arguments, one is an Object and the other
		 * is the position (next link).</p>
		 * 
		 * @param newData is an Object which may contain data that is to be
		 * manipulated.
		 * @param nextLink is a Node object that acts as a container for the next Node
		 * value to be added to the list.
		 * */
		public Node(Object newData, Node nextLink){
			data = newData;
			next = nextLink;
		}
	} 

	/*END NODE INNER CLASS*/

	public void insert(Object newLink, int linkIndex){



	}


}
