package gyc.java.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * bash游戏
 * 有一堆石子共有N个。A B两个人轮流拿，A先拿。每次最少拿1颗，最多拿K颗，拿到最后1颗石子的人获胜。假设A B都非常聪明，拿石子的过程中不会出现失误。给出N和K，问最后谁能赢得比赛。
 * 例如N = 3，K = 2。无论A如何拿，B都可以拿到最后1颗石子。
 * 分析情况
 * 当K = 2的时候
 * N = 3时
 * A输
 * 类似找出规律
 * 当 N = m(K + 1)时 m = 1, 2, 3, 4 .....
 * A输 否则 A赢
 * @author yc.guo@zuche.com on 2016/12/26.
 */
public class NO1066 {

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
            writer.write(dealBash(input) + "\r\n");
        }
        writer.flush();
//        int[] param = {61, 5};
//        System.out.println(dealBash(param));
    }


    private static String dealBash(int[] param) {
        if (param[0] % (param[1] + 1) == 0) {
            return "B";
        } else {
            return "A";
        }
    }
}
