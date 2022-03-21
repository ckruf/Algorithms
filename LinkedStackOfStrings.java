
public class LinkedStackOfStrings {
	
	private Node first = null;
	
	private class Node {
		String item;
		Node next;
	}
	
	public void push (String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public String pop() throws Exception {
		if (first == null) throw new Exception("Stack is empty");
		
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean IsEmpty() {
		return first == null;
	}
	
	
}
