
public class ResizingArrayStackOfStrings {
	private int N;
	private String[] s;
	
	public ResizingArrayStackOfStrings() {
		s = new String[1];
	}
	
	public void push(String item) {
		if (N == s.length)
			resize(2 * s.length);
		s[N++] = item;
	}
	
	public String pop() throws Exception {
		
		if (N == 0) throw new Exception("Stack is empty");
		
		// decrement N, then index into array
		String item = s[--N];
		s[N] = null;
		// If the array is one quarter full, we halve it
		// N > 0 seems unnecessary
		// Actually, the condition is necessary, otherwise if there is only one item
		// in the array, and then we pop it, we will resize to an array of size 0.
		// Then, if we try to push an item, we will get an ArrayIndexOutOfBoundsException,
		// since we would be trying to put an item at index 0, however an array of size 0
		// does not have such an index.
		if (N == s.length / 4 && N > 0)
			resize(s.length / 2);
		return item;
	}
	
	public void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = s[i];
		s = copy;
	}
}
