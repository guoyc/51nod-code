package gyc.java.main.algorithms.sort;

/**
 * 归并排序
 * @author guoyc on 16-1-12.
 */
public class MergeSort extends BaseSort{

    //合并两个数组
    public static void merge(Comparable[] arr, int low, int mid, int high) {
        int i = low; // 第一个数组的开头
        int j = mid + 1; // 第二个数组的开头
        Comparable[] copyArr = new Comparable[arr.length];
        //复制所有的值到一个copy数组
        System.arraycopy(arr, 0, copyArr, 0, copyArr.length);
        for (int k = 0; k < arr.length; k ++) {
            if (low > mid) {
                arr[k] = copyArr[j++];
            } else if (j > high) {
                arr[k] = copyArr[i++];
            } else if (less(copyArr[i], copyArr[j])) {
                arr[k] = copyArr[i++];
            } else {
                arr[k] = copyArr[j++];
            }
        }
    }

    // 自顶向下的排序的顶端方法
    public static void topSort(Comparable[] arr) {
        topSort(arr, 0, arr.length);
    }
    //  自顶向下的排序的递归方法
    public static void topSort(Comparable[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high -  low) / 2;
        topSort(arr, low, mid);
        topSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void bottomSort(Comparable[] arr) {
        // sunSize 子数组长度, 从底至上的合并就是显示数组长度为1的子数组合并,以此类推
        for (int sunSize = 1; sunSize < arr.length; sunSize += sunSize) {
            for (int low = 0; low < arr.length; low = low + sunSize + sunSize) {
                int high = low + sunSize + sunSize - 1;
            }
        }
    }
}
