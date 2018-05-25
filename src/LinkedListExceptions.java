/*
 * Very basic class. Only catches the error thrown at
 * particular places and sends back a custom String to
 * the console.
 * */
public class LinkedListExceptions extends Exception{

	public LinkedListExceptions(String s){
		super(s);
	}
}
