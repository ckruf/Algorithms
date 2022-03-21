
public class FixedCapacityStackOfStrings {
	private int N = 0;
	private String[] s;
	
	public FixedCapacityStackOfStrings(int capacity) {
		s = new String[capacity];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		// use current value of N to index into array, then increment N
		s[N++] = item;
	}
	
	public String pop() throws Exception {
		if (N == 0) throw new Exception("Stack is empty");
		// decrement N, then index into array
		String item = s[--N];
		// prevent 'loitering' by setting popped item to null
		s[N] = null;
		return item;
	}
}
