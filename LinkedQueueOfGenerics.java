import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedQueueOfGenerics<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public Iterator<Item> iterator() {
		return new LinkedQueueIterator();
	}
	
	private class LinkedQueueIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if (current == null)
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public void enqueue (Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (IsEmpty()) first = last;
		else oldlast.next = last;
	}
	
	public Item dequeue() throws Exception {
		if (IsEmpty()) throw new Exception("Queue is empty");
		
		Item item = first.item;
		first = first.next;
		
		if (IsEmpty()) last = null;
		
		return item;
	}
	
	public boolean IsEmpty() {
		return first == null;
	}
}
