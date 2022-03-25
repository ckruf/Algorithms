import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStackOfGenerics<Item> implements Iterable<Item> {
	private Node first;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	
	public void push(Item item) {
		Node newfirst = new Node();
		newfirst.item = item;
		newfirst.next = first;
		first = newfirst;
	}
	
	public Item pop() throws Exception {
		if (IsEmpty()) throw new Exception("Stack is empty");
		Node oldfirst = first;
		first = oldfirst.next;
		return oldfirst.item;
	}
	
	public boolean IsEmpty() {
		return first == null;
	}
}
