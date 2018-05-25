/*
 * Also inherits from the super class List to use the enqueue
 * and dequeue methods for 
 * */
public class Queue extends List{

	/*
	 * Description:<br>
	 * <p>
	 * I am struggling to understand how this works. It will simply call the super class
	 * method insertFirst() which is overriding the condition to insert at a certain index
	 * which is how the other insert() method works.
	 * </p>
	 * */
	public void enqueue(Object d){
		insertFirst(d);
	}

	/*
	 * Description:<br>
	 * <p>
	 * Removes the current Node.
	 * </p>
	 * 
	 * @see Stack.java 
	 * @see List.java
	 * */
	public Object dequeue(){
		return remove();
	}


	public static void main(String[] args) {

	}

}
