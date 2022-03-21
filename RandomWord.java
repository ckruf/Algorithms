import edu.princeton.cs.algs4.*;

public class RandomWord {

	public static void main(String[] args) {
		String champion = "";
		int i = 1;
		while(!StdIn.isEmpty()) {
//				StdOut.println("Loop started");
				String nextWord = StdIn.readString();
//				StdOut.println("next word is:" + nextWord);
				float probability = 1 / (float) i;
//				StdOut.println("probability is:" + probability);
				if (StdRandom.bernoulli(probability)) {
					champion = nextWord;
			}
				i++;
//				StdOut.println("champion is:" + champion);
		}
		StdOut.println("Final champ is:" + champion);
	}

}
