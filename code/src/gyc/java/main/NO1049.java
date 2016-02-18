package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N个整数组成的序列a[1],a[2],a[3],…,a[n]，求该序列如a[i]+a[i+1]+…+a[j]的连续子段和的最大值。当所给的整数均为负数时和为0。
 * 例如：-2,11,-4,13,-5,-2，和最大的子段为：11,-4,13。和为20。
 * 题解: 从题目中可以发现可能需要用动态规划来做。因为题目中需要求长度为N的字段和的最大值,那么可以把问题变成求N-1的字段和的最大值
 * 参考N的值,如果N的值为负数那么最大值不变,如果N的值为整数则加上N的值。
 * 那么状态转义方程描述如下：
 * if (d(n - 1) > 0) {
 *     d(n) = d(n - 1) + v(n)
 * } else {
 *     d(n) = v(n)
 * }
 * @author guoyc on 16-2-18.
 */
public class NO1049 {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        int inputArr[] = new int[n];
        for(int i = 0; i < n; i++) {
            String inputStr = reader.readLine();
            inputArr[i] = Integer.parseInt(inputStr);
        }
        // 记录每次子段的和(这个和可能不是最大的,但是如果是整数的话就会保证下一个数如果是正数的话就可以求出更大的字段和,
        // 从而求出结果)
        // 一定要注意越界问题
        long res[] = new long[n + 1];
        // 最终结果
        long max = 0;
        for (int i = 1; i < inputArr.length + 1; i ++) {
            if (res[i - 1] > 0) {
                res[i] = res[i - 1] + inputArr[i - 1];
            } else {
                res[i] = inputArr[i - 1];
            }
            if (max < res[i]) {
                max = res[i];
            }
        }
        System.out.println(max);
    }
}
