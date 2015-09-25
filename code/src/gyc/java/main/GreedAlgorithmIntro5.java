package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 解决51nodcode中贪心入门中的第五道问题
 * 原题:有N个任务需要执行，第i个任务计算时占R[i]个空间，而后会释放一部分，最后储存计算结果需要占据O[i]个空间（O[i] < R[i]）。
 *     例如：执行需要5个空间，最后储存需要2个空间。给出N个任务执行和存储所需的空间，问执行所有任务最少需要多少空间。
 * 思路:可以把过程的需要的空间进行排序。
 * @author guoyc on 15-9-24.
 */
public class GreedAlgorithmIntro5 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        List<Integer[]> inputList = new ArrayList<>(n);
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
                if ((o1[0] - o1[1]) > (o2[0] - o2[1])) {
                    return -1;
                } else if ((o1[0] - o1[1]) < (o2[0] - o2[1])){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int used = 0;
        int max = 0;
        for (Integer[] integerArr : inputList) {
            used = used + integerArr[0];
            if (used > max) {
                max = used;
            }
            used = used - integerArr[0] + integerArr[1];
        }
        System.out.println(max);
    }
}
