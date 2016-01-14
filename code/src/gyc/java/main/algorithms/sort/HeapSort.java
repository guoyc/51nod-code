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
        // for 循环中其实就是构造一个堆,根据定义来执行
        for (int i = length / 2; i > 0; i --) {
            if (less(copyArr[i * 2], copyArr[i])) {
                exchange(copyArr, i, i * 2);
            }
        }
        int i = 0;
        // i就是原始数组应该替换的位置
        while (i <= arr.length - 1) {
            // copyArr的第一个元素永远是最小的,赋值后需要加一
            arr[i++] = copyArr[1];
            // 第一个元素与最后一个元素交换,然后把长度减一,相当于弹出数列,比较好的方式是直接赋值为0,这样可以释放内存
            exchange(copyArr, 1, --length);
            // 对第一个元素进行sink操作,就是把他放入堆对应的位置
            sink(copyArr, length);
        }
    }

    // 该方法就是对第一个元素进行sink操作,根据第二个元素来判断数组的长度,来决定循环的结束方式
    public static void sink(Comparable[] arr, int length) {
        int i = 1;
        // 如果没有左节点直接循环结束
        while (2 * i < length) {
            // 找到左节点坐标
            int j = 2 * i;
            // 如果有右节点,并且小于左节点,那么如果待交换的索引应该是右节点
            if (j + 1 < length && less(arr[j + 1], arr[j])) {
                j += 1;
            }
            // 如果父节点小于带交换节点,说明父节点小,符合堆的定义,循环结束
            if (less(arr[i], arr[j])) {
                break;
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
