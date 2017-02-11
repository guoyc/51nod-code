package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author guoyc on 2016/1/24.
 */
public class No1019 {

    public static int[] temp;
    public static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        int[] inputNumberArr = new int[n];
        for (int i = 0;  i < n; i++) {
            inputNumberArr[i] = Integer.parseInt(reader.readLine());
        }
        temp = new int[inputNumberArr.length];
        mergeSort(inputNumberArr, 0, inputNumberArr.length - 1);
        System.out.print(res);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int current = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[current++] = arr[i++];
            } else {
                res = res + mid + 1 - i;
                temp[current++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[current++] = arr[i++];
        }
        while (j <= high) {
            temp[current++] = arr[j++];
        }
        for (int k = 0; k < current; k++) {
            arr[low++] = temp[k];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
}
