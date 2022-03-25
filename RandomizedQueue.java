import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] q;
	private int n;
	
	public RandomizedQueue() {
		q = (Item[]) new Object[1];
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public void enqueue(Item item) {
		if (item == null) throw new IllegalArgumentException();
		if (n == q.length) resize(q.length * 2);
		q[n++] = item;
	}
	
	public Item dequeue() {
		if (n == 0) throw new NoSuchElementException();
		int randomInt = StdRandom.uniform(n);
		Item randomItem = q[randomInt];
		q[randomInt] = q[n - 1];
		q[--n] = null;
		if (q.length / 4 == n && n > 0) resize(q.length / 2);
		return randomItem;
	}
	
	public Item sample() {
		if (n == 0) throw new NoSuchElementException();
		int randomInt = StdRandom.uniform(n);
		return q[randomInt];
	}
	
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
			copy[i] = q[i];
		q = copy;
	}
	
	public Iterator<Item> iterator() {
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item> {
		private Item[] qcopy;
		private int k;
		
		public RandomQueueIterator() {
			k = n;
			qcopy = (Item[]) new Object[k];
			for (int i = 0; i < k; i++) {
				qcopy[i] = q[i];
			}
		}
		
		public boolean hasNext() {
			return k != 0;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			int randomInt = StdRandom.uniform(k);
			Item randomItem = qcopy[randomInt];
			qcopy[randomInt] = qcopy[k - 1];
			qcopy[--k] = null;
			return randomItem;
		}
	}
	/*
	public void print() {
		for (int i = 0; i < q.length; i++) {
			if (q[i] == null) {
				System.out.print("null");
			}
			else {
				System.out.print(q[i]);
			}
			System.out.print("|");
		}
		System.out.println();
	} */
	
	public static void main(String[] args) {
		RandomizedQueue<String> randomq = new RandomizedQueue<String>();
		randomq.enqueue("A");
		randomq.enqueue("B");
		randomq.enqueue("C");
		randomq.enqueue("D");
		randomq.enqueue("E");
//		randomq.print();
		System.out.println("The size of the queue is now: " + randomq.size());
		System.out.println("Is the queue empty now? " + randomq.isEmpty());
		System.out.println("Iterating through the queue in random order:");
		for (String s : randomq) {
			System.out.println(s);
		}
		System.out.println("Iterating through the queue in random order again:");
		for (String s : randomq) {
			System.out.println(s);
		}
		System.out.println("The queue after removing random letter " + randomq.dequeue());
//		randomq.print();
		System.out.println("The queue after removing another random letter " + randomq.dequeue());
//		randomq.print();
		randomq.dequeue();
		System.out.println("The queue after removing three letters: ");
//		randomq.print();
		randomq.dequeue();
		System.out.println("The queue after removing four letters: ");
//		randomq.print();
		randomq.dequeue();
		System.out.println("The queue after removing five letters: ");
//		randomq.print();
		System.out.println("The size of the queue is now: " + randomq.size());
		System.out.println("Is the queue empty now? " + randomq.isEmpty());
	}

}
