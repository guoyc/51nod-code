package gyc.java.main.algorithms.sort;

/**
 * @author guoyc on 16-1-12.
 */
public abstract class BaseSort {

    public static boolean less (Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2) < 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable comparable = arr[i];
        arr[i] = arr[j];
        arr[j] = comparable;
    }
}
