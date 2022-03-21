
public class ResizingArrayQueueOfStrings {
	private String[] q;
	private int head;
	private int tail;
	private int n;
	
	public ResizingArrayQueueOfStrings() {
		q = new String[1];
		head = 0;
		tail = 0;
		n = 0;
	}
	
	public boolean IsEmpty() {
		return n == 0;
	}
	
	public String dequeue() throws Exception {
		if (n == 0) throw new Exception("Queue is empty"); 
		String item = q[head];
		// index into array, then increment head
		q[head++] = null;
		n--;
		if (head == q.length) 
			head = 0;
		if (n == (q.length / 4))
			resize(n / 2);
		
		return item;
	}
	
	public void enqueue(String item) {
		if (n == q.length)
			resize(q.length * 2);
		
		q[tail++] =  item;
		if (tail == q.length) 
			tail = 0;
		n++;
	}
	
	public void resize(int capacity) {
		assert capacity >= n;
		String[] copy = new String[capacity];
		/* Explanation of the modulo in the for loop:
		 * After several enqueues and dequeues, our queue may be wrapped
		 * around the end of the array (for example, head being at the last
		 * position in the array, and the second item in the queue then being
		 * at the first position in the array and so on). Because we are indexing
		 * into the original array at the 'head + i' position, if head is in the last 
		 * position in the array (let's say position 7 in an 8-long array), the following item
		 * will be taken from head + 1, but this would give us position 8 in an 8 long array,
		 * which would be out of bounds. Therefore we need to take the modulo of the length of the array,
		 * so that we start wrapping around to the beginning of the array.
		 */
		for (int i = 0; i < n; i++)
			copy[i] = q[(head + i) % q.length];
		q = copy;
		head = 0;
		tail = n;
	}
}
