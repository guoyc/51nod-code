package gyc.java.main.algorithms.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 简单来说就是用父节点表示法用数组来标识一个树,然后使堆有序化的情况下可以不断的弹出顶端元素,然后就可以输出排序了
 * @author guoyc on 16-1-14.
 */
public class HeapSort extends BaseSort {

    public static void sort(Comparable[] arr) {
        Comparable[] copyArr = new Comparable[arr.length + 1];
        // 由于需要表示树,所以不能从0开始
        for (int i = 0; i < arr.length; i ++) {
            copyArr[i + 1] = arr[i];
        }
        sort(arr, copyArr);
    }

    public static void sort(Comparable[] arr, Comparable[] copyArr) {
        int length = copyArr.length;
        for (int i = length / 2; i > 0; i --) {
            if (less(copyArr[i * 2], copyArr[i])) {
                exchange(copyArr, i, i * 2);
            }
        }
        int i = 0;
        while (i < length - 1) {
            arr[i] = copyArr[1];
            exchange(copyArr, 1, length - 1);
            length = length - 1;
            sink(copyArr, length);
            i = i + 1;
        }
        arr[length - 1] = copyArr[1];
    }

    public static void sink(Comparable[] arr, int length) {
        int i = 1;
        while (2 * i <= length) {
            int j = 2 * i;
            if (j + 1 < length && less(arr[j + 1], arr[j])) {
                j += 1;
            }
            exchange(arr, i, j);
            i = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1,3,32,12,4411,51232,52,3124,134,151};
        sort(a);
        System.out.print(Arrays.toString(a));
    }
}
