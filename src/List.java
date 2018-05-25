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

	/*
	 * Inner class, Node, is used to set the reference from the current
	 * link to the next one with the value of the Object passed in by the
	 * driver class and Node 2-argument constructor.
	 * */
	private class Node {

		private Object data;
		private Node next;

		/*
		 * <h4>Description:</h4><br>
		 * <p>
		 * Builds a new Node object with a reference to the next
		 * link in the list as well as content for the body
		 * of the Node represented by d which is an Object.
		 * </p>
		 * 
		 * @param d - used to store the body of the new Node
		 * being constructed.
		 * @param ref - used to point to the next (maybe null)
		 * location of the next link in the list. 
		 * */
		private Node(Object d, Node ref){
			data = d;
			next = ref;
		}

		/* 
		 * <h4>Description:</h4><br>
		 * <p>Constructor that takes an object to build a new Node
		 * with and set the pointer to null.
		 * </p>
		 * 
		 * @param d - an object that holds a value to be added as a link
		 * in the list of other links.
		 * */
		public Node(Object d){
			data = d;
			next = null;
		}
	} 

	/*END NODE INNER CLASS*/

	private Node head; //front (head) of the list
	//private Node tail;

	/*
	 * Description:
	 * <p>
	 * Constructs a new empty list by setting the head pointer to null. This defines an empty list
	 * </p>
	 * */
	public List(){
		head = null; //empty list
		//tail = null;
	}

	/*
	 * Description:
	 * <p>
	 * Implemented insert method takes an object and a reference to where
	 * in the list to add it. 
	 * </p>
	 * 
	 * @param d - an Object that holds the value used
	 * to set the body of the Node. This could be any data type.
	 * @throws exception thrown with message if index is
	 * not a valid place within the list or if the index
	 * is more than the size of the list (out of bounds).
	 * */
	public void insert(Object d, int index){
		try{
			//empty list condition check
			if(index == 0){
				head = new Node(d,head);
			}else if(index > size()){
				throw new LinkedListExceptions("Index: " + index + " was not within size of the list"
						+ " size of list was: " + size());
			}else{
				Node currPosition = moveToNext(index-1);
				Node tempNode = new Node(d,currPosition.next);
				currPosition.next = tempNode;}
		}catch(LinkedListExceptions lle){
			System.out.println(lle.getMessage());
		}
	}

	/*
	 * <h4>Description:</h4><br>
	 * <p>
	 * A private utility method for traversing the list of Nodes
	 * while each iteration, 
	 * </p>
	 * 
	 * @param index
	 * @see insert() method
	 * */
	private Node moveToNext(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	/*
	 * 
	 * 
	 * */
	public boolean deleteNode(){

		if(head!=null){
			head = head.next;
			return true;
		}else{
			return false;
		}
	}


	/*
	 * Simply moves from one link to the next
	 * as long as the position isn't null and
	 * increases the counter by one for each time
	 * that happens.  
	 * 
	 * @see pg. 854 of "Absolute Java" by Walter Savitch
	 * */
	public int size(){
		int count = 0;
		Node currentLink = head;
		while(currentLink != null){
			count++;
			currentLink = currentLink.next;
		}
		return count;
	}

	/*
	 * 
	 * 
	 * */
	public boolean contains(Object aNode){
		return searchFor(aNode) != null;
	}

	/*
	 * 
	 * 
	 * */
	private Node searchFor(Object targetNode){
		Node currentNode = head;

		while(currentNode !=null){
			if(head.equals(targetNode)){
				return currentNode;
			}
			head = head.next;
		}
		return null;
	}

	/*
	 * <h4>Description:</h4>
	 * <p>
	 * General toString method for returning the value of 
	 * each Node as a string to print to console. While the Node
	 * object is not null, meaning there's some data in the position,
	 * then print the value to the console.
	 * </p>
	 * 
	 * */
	public String toString() {
		String retValue = "";
		Node current = head;

		while(current != null) {
			retValue += current.data.toString() + " ";
			current = current.next;
		}
		return retValue;
	}

	/*
	 * 
	 * 
	 * */
	public boolean isEmpty(){

		return head==null;
	}

	/*
	 * <h4>Description:</h4>
	 * <p>
	 * 
	 * </p>
	 * @param target
	 * */
	public int indexOf(Object target){
		int index = 0;
		Node curr = head;

		while (curr != null) {
			if (curr.equals(target)) {
				return index;
			}
			index++;
			curr = curr.next;
		}

		return -1;
	}

	public static void main(String[] args) throws LinkedListExceptions{

		String target = "testingLinkedList!";

		List list = new List();
		Object object1 = (Character) target.charAt(4);
		Object object2 = (Character) target.charAt(1);
		Object object3 = (Character) target.charAt(2);
		Object object4 = (Character) target.charAt(9);
		Object object5 = (Character) target.charAt(3);

		list.insert(object1, 0);
		list.insert(object2, 1);
		list.insert(object3, 2);
		list.insert(object4, 3);
		list.insert(object5, 5);

		System.out.println("My list has " + list.size( ) + " nodes.");
		list.toString();
		System.out.println("toString = " + list.toString());

		list.deleteNode();

		System.out.println("after deleting head, list has " + list.size() + " nodes");
		System.out.println("toString = " + list.toString());
	}
}