package gyc.java.main.algorithms.sort;

/**
 * 希尔排序
 * @author guoyc on 16-1-12.
 */
public class ShellSort extends BaseSort{

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n /3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(arr[h], arr[j-h]); j -=h) {
                    exchange(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
