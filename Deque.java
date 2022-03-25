import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int n;
	
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	
	public Deque() {
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public void addFirst(Item item) {
		if (item == null) throw new IllegalArgumentException();
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (n == 0) 
			last = first;
		else
			oldfirst.previous = first;
		n++;
	}
	
	public void addLast(Item item) {
		if (item == null) throw new IllegalArgumentException();
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.previous = oldlast;
		if (n == 0) 
			first = last;
		else
			oldlast.next = last;
		n++;
	}
	
	public Item removeFirst() {
		if (n == 0) throw new NoSuchElementException();
		Item item = first.item;
		Node newfirst = first.next;
		first = newfirst;
		n--;
		if (n == 0) 
			last = first;
		else
			first.previous = null;
		return item;
	}
	
	public Item removeLast() {
		if (n == 0) throw new NoSuchElementException();
		Item item = last.item;
		Node newlast = last.previous;
		last.previous = null;
		last = newlast;
		n--;
		if (n == 0) 
			first = last;
		else
			last.next = null;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		
		Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	/*
	public String toString() {
		if (n == 0) return "Deque is currently empty";
		else {
			String dequeStr = "";
			for (Item item : this) {
				dequeStr = dequeStr + item + "; ";
			}
			return dequeStr;
		}
	} */
	
	public static void main(String[] args) {
		Deque<String> deque = new Deque<String>();
		deque.addFirst("This");
		System.out.println(deque);
		deque.addFirst("Check");
		System.out.println(deque);
		deque.addLast("Out");
		System.out.println(deque);
		deque.removeFirst();
		System.out.println(deque);
		deque.removeLast();
		System.out.println(deque);
		deque.removeLast();
		System.out.println(deque);
		deque.addLast("This");
		System.out.println(deque);
		deque.addFirst("Check");
		System.out.println(deque);
		System.out.println("Size of deque is: " + deque.size());
		deque.removeLast();
		System.out.println(deque);
		deque.removeFirst();
		System.out.println(deque);
		System.out.println("Is the deque empty? " + deque.isEmpty());
		
	}
}
