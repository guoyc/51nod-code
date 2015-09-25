package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 解决51nodcode中贪心入门中的第四道问题
 * 原题:n个人，已知每个人体重。独木舟承重固定，每只独木舟最多坐两个人，可以坐一个人或者两个人。
 *     显然要求总重量不超过独木舟承重，假设每个人体重也不超过独木舟承重，问最少需要几只独木舟？
 * 思路:如果最重的人加上最轻的人可以用一个独木舟,则独木舟加1,把他们2人踢出队列
 *     反之独木舟加1,把最重的人踢出队列。
 *     遍历所有队列即可
 * @author guoyc on 15-9-24.
 */
public class GreedAlgorithmIntro4 {



    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        String n = reader.readLine();
        String[] strArr = n.split(" ");
        int personNum = Integer.parseInt(strArr[0]);
        int limitWeight = Integer.parseInt(strArr[1]);
        List<Integer> personWeight = new ArrayList<>();
        for(int i = 0; i < personNum; i++) {
            personWeight.add(Integer.parseInt(reader.readLine()));
        }
        Collections.sort(personWeight, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        int start = 0; //最轻的人的索引
        int end = personWeight.size() - 1; //最重的人的索引
        int res = 0;
        while(start < personWeight.size() && end > 0 && start < end) {
            if (personWeight.get(end) + personWeight.get(start) <= limitWeight) {
                res++;
                start++;
                end--;
            } else {
                res++;
                end--;
            }
        }
        if (start == end) {
            res ++;
        }
        System.out.print(res);
    }
}
