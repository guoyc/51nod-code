package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 解决51nodcode中贪心入门中的第二道问题
 * 原题:
 * 有若干个活动，第i个开始时间和结束时间是[Si,fi)，只有一个教室，活动之间不能交叠，求最多安排多少个活动？
 * 思路：
 * 可以简化成多条线段不相交的问题。
 * 可以提出贪心策略:结束时间早的优先
 * 验证贪心策略
 * 假设最优解为:a(1), a(2)...a(m)
 * 贪心解为:b(1), b(2)....b(n)
 * 只要证明当a(1) = b(1), a(2) = b(2)。。。a(k) = b(k)的情况下, a(k+1) = b(k+1)即可
 * 考虑反例: 1: b(k+1)在a(1), a(2)...a(m)中冲突----不可能,因为已知b(k)的结束时间小于b(K+1)的开始时间而b(k) = a(k)
 *          2: b(k+1)在a(k+2), a(k+3)...a(k+m)中冲突----因为已知a(k+1)是最优解,所以a(k+1)的结束时间一定小于a(K+2),
 *                                                     而b(k+1)正是结束时间最小的那个
 *          3: b(k+1)在a(k+2), a(k+3)...a(k+m)出现原因同上
 * 所以贪心策略成立
 * @author guoyc on 15-9-24.
 */
public class GreedAlgorithmIntro2 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        List<Integer[]> inputList = new ArrayList<>(n);
        List<Integer[]> res = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            String inputStr = reader.readLine();
            String[] inputStrArr = inputStr.split(" ");
            Integer[] inputIntArr = new Integer[inputStrArr.length];
            inputIntArr[0] = Integer.parseInt(inputStrArr[0]);
            inputIntArr[1] = Integer.parseInt(inputStrArr[1]);
            inputList.add(inputIntArr);
        }

        Collections.sort(inputList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1].equals(o2[1]) && o1[0].equals(o2[0])) {
                    return 0;
                }
                if (o1[1] < o2[1]) {
                    return -1;
                }
                if (o1[1].equals(o2[1]) && o1[0] > o2[0]) {
                    return -1;
                }
                return 1;
            }
        });
        res.add(inputList.get(0));
        int max = inputList.get(0)[1];
        inputList.remove(0);

        for (Integer[] integerArr : inputList) {
            if (max <= integerArr[0]) {
                res.add(integerArr);
                max = integerArr[1];
            }
        }
        System.out.print(res.size());
    }
}
