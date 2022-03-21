
public class ResizingArrayQueueOfStrings {
	private String[] q;
	private int head;
	private int tail;
	
	public ResizingArrayQueueOfStrings() {
		q = new String[1];
		head = 0;
		tail = 1;
	}
	
	public boolean IsEmpty() {
		return (((head - tail) == 1) && (q[head] == null));
	}
	
	public String dequeue() throws Exception {
		if (q[head] == null) throw new Exception("Queue is empty"); 
		String item = q[head];
		// index into array, then increment head
		q[head++] = null;
		if ((tail - head) == (q.length / 4))
			resize((tail - head) / 2);
		
		return item;
	}
	
	public void enqueue(String item) {
		if (tail + 1 == q.length)
			resize(q.length * 2);
		
		q[tail] =  item;
	}
	
	public void resize(int capacity) {
		String[] copy = new String[capacity];
		int itemCount = (tail - head);
		for (int i = 0; i < itemCount; i++)
			copy[i] = q[head + i];
		q = copy;
		head = 0;
		tail = itemCount;
	}
}
