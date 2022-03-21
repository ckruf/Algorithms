
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
		if (N > 0 && N == s.length / 4)
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
