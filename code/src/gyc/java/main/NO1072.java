package gyc.java.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 有2堆石子。A B两个人轮流拿，A先拿。每次可以从一堆中取任意个或从2堆中取相同数量的石子，但不可不取。拿到最后1颗石子的人获胜。假设A B都非常聪明，拿石子的过程中不会出现失误。给出2堆石子的数量，问最后谁能赢得比赛。
 * 例如：2堆石子分别为3颗和5颗。那么不论A怎样拿，B都有对应的方法拿到最后1颗。
 * @author yc.guo@zuche.com on 2016/12/26.
 */
public class NO1072 {

    private static final double GOLD_NUMBER = (Math.sqrt(5.0) + 1) / 2.0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        int[][] inputArr = new int[n][2];
        for(int i = 0; i < n; i++) {
            String inputStr = reader.readLine();
            String[] inputString = inputStr.split(" ");
            inputArr[i][0] = Integer.parseInt(inputString[0]);
            inputArr[i][1] = Integer.parseInt(inputString[1]);
        }
        for (int[] input : inputArr) {
            writer.write(dealWythoff(input) + "\r\n");
        }
        writer.flush();
    }

    private static String dealWythoff(int[] param) {
        if (param[0] > param[1]) {
            int a = param[0];
            param[0] = param[1];
            param[1] = a;
        }
        // 这里使用param[1]减去param[0]是为了找K值, 如果为必输局, 则K必等于param[1]减去param[0]
        if (param[0] == (int)((param[1] - param[0]) * GOLD_NUMBER)) {
            return "B";
        } else {
            return "A";
        }
    }
}
