
public class Merge {
    
    public static void sort(Comparable[] a) {
        // it's important to create auxiliary array in this method and not in any of the
        // helpers, because we only want to pay the price for array creation once. 
        // Otherwise - poor performance.
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
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
    
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // Base case. Because we are doing successive calls using mid as either lo
        // (when sorting right half) or hi (when sorting right half), they (hi and lo) are getting
        // closer and closer to each other, until they're equal and hit base case
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        // sort right half
        sort(a, aux, mid + 1, hi);
        // sort left half
        sort(a, aux, lo, mid);
        // merge sorted sub arrays
        merge(a, aux, lo, mid, hi);
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
