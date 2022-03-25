import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStackOfGenerics<Item> implements Iterable<Item> {
	private Item[] s;
	private int N = 0;
	
	public ResizingArrayStackOfGenerics() {
		// Because Java does not allow the declaration of a generic
		// array (s = new Item[1]), we need to declare an array of
		// Objects and then cast it to an array of Items
		s = (Item[]) new Object[1];
	}
	
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;
		
		public boolean hasNext() {
			return i > 0;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			return s[--i];
		}
	}
	
	
	public void push(Item item) {
		if (N == s.length)
			resize(2 * s.length);
		s[N++] = item;
	}
	
	public Item pop() throws Exception {
		if (IsEmpty()) throw new Exception("Stack is empty");
		
		Item item = s[--N];
		
		if (N > 0 && s.length == N / 4) resize(s.length / 2);
		
		return item;
	}
	
	public boolean IsEmpty() {
		return N == 0;
	}
	
	public void resize(int capacity) {
		if (capacity < N) return;
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < capacity; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}
	
}
