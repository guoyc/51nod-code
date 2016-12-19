package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 有N堆石子。A B两个人轮流拿，A先拿。每次只能从一堆中取若干个，可将一堆全取走，但不可不取，拿到最后1颗石子的人获胜。假设A B都非常聪明，拿石子的过程中不会出现失误。给出N及每堆石子的数量，问最后谁能赢得比赛。
 * 例如：3堆石子，每堆1颗。A拿1颗，B拿1颗，此时还剩1堆，所以A可以拿到最后1颗石子。
 * @author yc.guo@zuche.com on 2016/12/19.
 */
public class NO1069 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        int inputArr[] = new int[n];
        for(int i = 0; i < n; i++) {
            String inputStr = reader.readLine();
            inputArr[i] = Integer.parseInt(inputStr);
        }
        System.out.println(dealNim(inputArr));
    }


    /**
     * 很神奇的一个结论。为知笔记有写
     * 如果所有的数异或以后等于0, 那么对于先手来说是一个必输局
     * @param param
     * @return
     */
    private static String dealNim(int[] param) {
        int result = 0;
        for (Integer i : param) {
            result = result ^ i;
        }
        if (result == 0) {
            return "B";
        } else {
            return "A";
        }
    }
}
