import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueueOfGenerics<Item> implements Iterable<Item> {
	private Item[] q;
	private int head;
	private int tail;
	private int n;
	
	public ResizingArrayQueueOfGenerics() {
		head = 0;
		tail = 0;
		n = 0;
		q = (Item[]) new Object[1];
	}
	
	public Iterator<Item> iterator() {
		return new ArrayQueueIterator();
	}
	
	private class ArrayQueueIterator implements Iterator<Item> {
		 int current = head;
		 public boolean hasNext() {
			 return current % q.length != tail;
		 }
		 
		 public void remove() {
			 throw new UnsupportedOperationException();
		 }
		 public Item next() {
			 if (!hasNext()) {
				 throw new NoSuchElementException();
			 }
			 Item item = q[current];
			 current = (current + 1) % q.length;
			 return item;
		 }
	}
	
	public void enqueue(Item item) {
		if (n == q.length)
			resize(2 * q.length);
		q[tail++] = item;
		if (tail == q.length)
			tail = 0;
		n++;
	}
	
	public Item dequeue() {
		if (n == 0) throw new NoSuchElementException();
		Item item = q[head];
		q[head++] = null;
		n--;
		if (head == q.length)
			head = 0;
		if (n > 0 && n == q.length / 4)
			resize(q.length / 2);
		return item;
	}
	
	public void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
			copy[i] = q[(head + i) % q.length];
		q = copy;
		head = 0;
		tail = n;
	}
}
