
public class MergeBU {
    private static Comparable[] aux;
    
    public void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz+sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
    
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Check that left and right half is sorted
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        
        // Copy into auxiliary array
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        
        // Set i and j 'pointers' to beginning of left and right sub array
        int i = lo;
        int j = mid + 1;
        
        // k is 'pointer' to current position in final array
        for (int k = lo; k <= hi; k++) {
            // left sub array has been exhausted, take from right
            if (i > mid) a[k] = aux[j++];
            // right sub array has been exhausted, take from left
            else if (j > hi) a[k] = aux[i++];
            // current item in right sub array is less than current item in left
            // sub array, take current item from right sub array
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            // take item from left sub array
            else a[k] = aux[i++];
        }
        
        // Check that array is actually sorted after the procedure
        assert isSorted(a, lo, hi);
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }
}
