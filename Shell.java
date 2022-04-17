
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        
        int h = 1;
        // Get greatest number of 3x + 1 sequence that's less than N
        while (h < N / 3) 
            h = 3*h + 1; 
        // h-sort until h is equal to 1 (insertion sort)
        while (h >= 1) {
            for (int i = 0; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
