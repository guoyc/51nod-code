package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 解决51nodcode中贪心入门中的第三道问题
 * 原题:有若干个活动，第i个开始时间和结束时间是[Si,fi)，活动之间不能交叠，要把活动都安排完，至少需要几个教室？
 * 思路:可否可以用上一道题解决
 * 可以举出反例:(1,5),(1,3),(3,4),(5,7)
 * 如果按照上一题的思路则会出现如下分配方式
 * (1,3),(3,4)
 * (1,5)
 * (5,7)
 * 思考: 由于上一题只有一个教室。所以排出的针对一个教室的最优解,而本题可以有多个教室。需要求多个教室的多个最优解
 * 新思路:因为只需要求出数量即可,所以可以简化如下:
 * 1. 如果活动可以放在目前的教室中,则教室数不变
 * 2. 如果不能放入.则教室数加1
 * 代码思路：
 * 把所有活动的时间排序.并记录时开始时间还是结束时间
 * 遍历所有活动.如果遇到开始时间教师数加1,遇到结束时间教室数减1,求教室数最大值
 * 思考:
 * 可否求出每个教室的安排的活动?
 * @author guoyc on 15-9-24.
 */
public class GreedAlgorithmIntro3 {

    public static class Node {
        public int value;
        // 0 代表开始时间 1 代表结束时间
        public int type;
        public Node(int value, int type) {
            this.value = value;
            this.type = type;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        List<Node> inputList = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            String inputStr = reader.readLine();
            String[] inputStrArr = inputStr.split(" ");
            Integer[] inputIntArr = new Integer[inputStrArr.length];
            inputIntArr[0] = Integer.parseInt(inputStrArr[0]);
            inputIntArr[1] = Integer.parseInt(inputStrArr[1]);
            Node startNode = new Node(inputIntArr[0], 0);
            Node endNode = new Node(inputIntArr[1], 1);
            inputList.add(startNode);
            inputList.add(endNode);
        }

        Collections.sort(inputList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (Integer.compare(o1.value, o2.value) == 0) {
                    return Integer.compare(o2.type, o1.type);
                }
                return Integer.compare(o1.value, o2.value);
            }
        });
        int max = 0;
        int now = 0;
        for (Node node : inputList) {
            if (node.type == 0) {
                now++;
            } else {
                now--;
            }
            if (now > max) {
                max = now;
            }
        }
        System.out.print(max);
    }
}
