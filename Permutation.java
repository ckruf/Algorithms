import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	public static void main(String[] args) {
		RandomizedQueue<String> randomq = new RandomizedQueue<String>();
//		System.out.println("args[0] is: " + args[0]);
		int k = Integer.parseInt(args[0]);
//		System.out.print("Type strings separated by spaces, then hit Enter and CTRL-D: ");
		while (!StdIn.isEmpty()) {
			String nextString = StdIn.readString();
			randomq.enqueue(nextString);
		}
//		randomq.print();
		for (int i = 0; i < k; i++) {
			System.out.println(randomq.dequeue());
		}
	}

}
