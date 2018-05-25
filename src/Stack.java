/*
 * Inherits from super class List for pushing new Nodes to the list of Nodes
 * and a pop method for removing Nodes
 * */
public class Stack extends List{
	
	/*Will call super class method insertFirst to add an object
	 * at the beginning of the list. All links will shift to the right
	 * when adding at the front of the list.
	 * */
	public void push(Object d){
		insertFirst(d);
	}
	
	/*Uses the overloaded remove() method from the super class
	 * List to remove a Node off the top of the stack
	 * of Nodes.
	 * */
	public Object pop(){
		return remove();
	}

	public static void main(String[] args) {
		List empty = new List();
		List one = new List();
		List multiple = new List();
		
		one.append(5);
		multiple.append(10);
		multiple.append (20);
		multiple.append (30);
	
		
		System.out.println("Empty:"+empty);
		System.out.println("One:"+one);
		System.out.println("Multiple:"+ multiple);	
		
		one.remove(0);
		multiple.remove(1);
		System.out.println("One (upon remove):"+one);
		System.out.println("Multiple (upon remove):"+ multiple);
		
//one.append(600, 1);
		multiple.append(400);
		System.out.println("One (on append):"+one);
		System.out.println("Multiple(on append):"+ multiple);

	}

}
