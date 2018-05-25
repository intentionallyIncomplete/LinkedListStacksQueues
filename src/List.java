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
	 * Useful links that I used when trying to figure this stuff out.
	 * http://pages.cs.wisc.edu/~vernon/cs367/notes/4.LINKED-LIST.html
	 * https://courses.cs.washington.edu/courses/cse143/17wi/lectures/ListNode.java
	 * https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
	 * https://courses.cs.washington.edu/courses/cse143/09wi/lectures/2009-01-30/programs/LinkedIntList.java
	 * https://www.geeksforgeeks.org/how-to-write-functions-that-modify-the-head-pointer-of-a-linked-list/
	 * https://mydevgeek.com/linked-list-insert-a-node-at-a-specific-position/
	 * https://stackoverflow.com/questions/26783447/java-creating-an-insert-function-for-a-linkedlist-to-add-all-inserted-elements
	 * https://docs.oracle.com/javase/7/docs/api/java/util/List.html#add(int,%20E)
	 * https://www2.hawaii.edu/~esb/2011fall.ics211/LinkedList.java.html
	 * https://courses.cs.washington.edu/courses/cse143/11wi/lectures/01-28/programs/LinkedIntList.java
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
	 * Description:<br>
	 * <p>
	 * Using the single arg construcor to build a new
	 * Node object.
	 * </p>
	 * 
	 * @param d - an object with a value which will be stored
	 * at the next position in the list.
	 * */
	public void insertFirst(Object d){
		Node newHeader = new Node(d);
		newHeader.next = head;
		head = newHeader;
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
	 * while each iteration, set the current Node position
	 * to the reference of the next one - then return that final reference.
	 * Very useful for when needing to find the final element in the list and add something
	 * after it or when wanting to add something somewhere in between the first and last
	 * link.
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
	 * <h4>Description:</h4><br>
	 * <p>
	 * Remove the head node from the list. 
	 * </p>
	 * 
	 * @see insert()
	 * */
	public boolean remove(int index){
		try {
			if(head==null){
				throw new LinkedListExceptions("List is empty");
			}else if(index < 0  || index > size()){
				throw new LinkedListExceptions("Invalid position to remove. List is not that large/small");
			}else{
				Node currentPos = moveToNext(index-1);
				head = currentPos;
				return true;
			}
		}catch(LinkedListExceptions lle){
			System.out.println(lle.getMessage());
		}
		return true;
	}

	public boolean remove(){
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
	 * Description:<br>
	 * <p>
	 * Will use the private utility method searchFor() to look for a particular
	 * Object (Node) within the current list.
	 * </p>
	 * 
	 * @param aNode - a Node object that is the target to look for within
	 * the list. Value is sent as parameter to searchFor() method.
	 * @see searchFor
	 * */
	public boolean contains(Object aNode){
		return searchFor(aNode) != null;
	}

	/*
	 * Description:<br>
	 * <p>
	 * A private utility method that's very handy for checking to see if the list
	 * contains a particular item. While the reference pointer leads to another
	 * link, then continue to move to the next Node. If a match is found, then
	 * return that Node.
	 * </p>
	 * 
	 * @param targetNode - the Object to search the list for.
	 * */
	private Node searchFor(Object targetNode){
		Node currentNode = head;

		while(currentNode !=null){
			if(head == (targetNode)){
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
	 * Description:<br>
	 * <p>
	 * Will return true if the current head value points to a null location.
	 * False otherwise - meaning there is a link after the current one or we are
	 * not at the beginning or end of the list.
	 * </p>
	 * 
	 * @see Node inner class constructor#1
	 * */
	public boolean isEmpty(){

		return head==null;
	}

	/*
	 * <h4>Description:</h4>
	 * <p>
	 * Finding the index (position) of a particular Node within the list. First, set the
	 * position to look at the current Node value. Then, while the current position
	 * has a value (Node) then check the target Node against the current position. If
	 * it's a match, return the Node's position in the list.
	 * </p>
	 * @param target - a Node object
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

	/*
	 * Description:<br>
	 * <p>
	 * Adds to the end of the list by finding the next available
	 * position that references a null pointer.
	 * </p>
	 * 
	 * @param d - a Node object
	 * @param head - a reference object of Node
	 * */
	public void append(Object d){
		Node temp = head;

		if (head == null) {
			head = new Node(d, null);
		}

		while ((head.next != null)) {
			head = head.next;
		}

		head.next = new Node(d, null);
	}

	public static void main(String[] args){

		/*
		 * Mostly copied over from the lab so I didn't have to retype a lot of the tests.
		 * Added testing for other methods such as indexOf, contains, size, and isEmpty.
		 * */
		String target = "testingList!";

		List list = new List(); //new list

		Object object1 = (Character) target.charAt(4); //i
		Object object2 = (Character) target.charAt(1); //e
		Object object3 = (Character) target.charAt(2); //s
		Object object4 = (Character) target.charAt(9); //s
		Object object5 = (Character) target.charAt(3); //t - won't be added

		list.insert(object1, 0);
		list.insert(object2, 1);
		list.insert(object3, 2);
		list.insert(object4, 3);
		list.insert(object5, 5); //testing the custom exceptions class.

		System.out.println("My list has " + list.size( ) + " nodes.");
		list.toString();
		System.out.println("toString = " + list.toString());

		list.remove(0);
		//list.contains(object3);
		System.out.println(list.indexOf(object3));
		//list.deleteNode();
		//list.deleteNode();
		//list.deleteNode();

		System.out.println(list.isEmpty()); //check for empty list

		System.out.println("after deleting head, list has " + list.size() + " nodes");
		System.out.println("toString = " + list.toString());
	}
}