package gyc.java.main.algorithms.sort;

import java.util.Arrays;

/**
 * @author guoyc on 16-1-13.
 */
public class QuickSort extends BaseSort{

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int position = position(a, low, high);
        sort(a, low, position);
        sort(a, position + 1, high);
    }

    public static int position(Comparable[] a, int low, int high) {
        int flagValueIndex = low + (high - low) / 2;
        while (low < high) {
            while (less(a[low], a[flagValueIndex])) {
                low ++;
            }
            while (less(a[flagValueIndex], a[high])) {
                high --;
            }
            exchange(a, low, high);
        }
        return low;
    }

    public static void main(String[] args) {
        Integer[] a = {1,3,32,12,4411,51232,52,3124,134,151};
        sort(a);
        System.out.print(Arrays.toString(a));
    }
}
