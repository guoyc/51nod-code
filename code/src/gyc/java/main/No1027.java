package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author guoyc on 2016/1/24.
 */
public class No1027 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        String[] strInput = new String[2];
        for (int i = 0; i < 2; i++) {
            strInput[i] = reader.readLine();
        }
    }
}
