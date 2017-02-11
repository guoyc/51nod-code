package gyc.java.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author guoyc on 2016/1/19.
 */
public class BigNumberAdd {

    public static int add(char number1, char number2, int extra) {
        return Integer.parseInt(number1 + "") + Integer.parseInt(number2 + "") + extra;
    }

    public static int subtract(char number1, char number2) {
        return Integer.parseInt(number1 + "") - Integer.parseInt(number2 + "");
    }

    public static void subtract(char[] number1Arr, char[] number2Arr, int[] resArr) {
        int i = 0;
        for (; i < number1Arr.length - number2Arr.length; i ++) {
            resArr[i] = subtract(number1Arr[i], '0');
        }
        for (int j = 0; j < number2Arr.length; j ++) {
            int tempRes = subtract(number1Arr[i + j], number2Arr[j]);
            if (tempRes < 0) {
                for (int k = i + j - 1; k >=0; k--) {
                    if (resArr[k] > 0) {
                        resArr[k] = resArr[k] - 1;
                        k++;
                        for (; k <= i + j - 1; k ++) {
                            resArr[k] = 9;
                        }
                        break;
                    }
                }
                tempRes = 10 + tempRes;
            }
            resArr[i + j] = tempRes;
        }
    }

    public static int[] add (char[] number1Arr, char[] number2Arr) {
        int[] resArr = new int[Math.max(number1Arr.length, number2Arr.length) + 1];
        int extra = 0;
        for (int i = 0; i < resArr.length - 1; i++) {
            int tempRes = 0;
            if (i > number1Arr.length - 1) {
                tempRes = add(number2Arr[number2Arr.length - 1 - i], '0', extra);
            } else if (i > number2Arr.length - 1) {
                tempRes = add(number1Arr[number1Arr.length - 1 - i], '0', extra);
            } else {
                tempRes = add(number1Arr[number1Arr.length - 1 - i], number2Arr[number2Arr.length - 1 - i], extra);
            }
            if (tempRes >= 10) {
                tempRes = tempRes - 10;
                extra = 1;
            } else {
                extra = 0;
            }
            resArr[i] = tempRes;
        }
        if (extra == 1) {
            resArr[resArr.length - 1] = 1;
        }
        return resArr;
    }

    public static int[] subtract(char[] number1Arr, char[] number2Arr) {
        int[] resArr = new int[Math.max(number1Arr.length, number2Arr.length) + 1];
        if (number1Arr.length > number2Arr.length) {
            subtract(number1Arr, number2Arr, resArr);
            resArr[resArr.length - 1] = 0;
        } else if (number2Arr.length > number1Arr.length) {
            subtract(number2Arr, number1Arr, resArr);
            resArr[resArr.length - 1] = -1;
        } else {
            int i = 0;
            for (; i < number1Arr.length; i++) {
                int tempRes = subtract(number1Arr[i], number2Arr[i]);
                if (tempRes < 0) {
                    int k = i - 1;
                    for (; k >=0; k--) {
                        if (resArr[k] > 0) {
                            resArr[k] = resArr[k] - 1;
                            k++;
                            for (; k <= i - 1; k ++) {
                                resArr[k] = 9;
                            }
                            tempRes = tempRes + 10;
                            break;
                        }
                    }
                    if (k < 0) {
                        resArr[resArr.length - 1] = -1;
                        break;
                    }
                }
                resArr[i] = tempRes;
            }
            for (; i < number2Arr.length; i ++) {
                int tempRes = subtract(number2Arr[i], number1Arr[i]);
                if (tempRes < 0) {
                    int k = i - 1;
                    for (; k >=0; k--) {
                        if (resArr[k] > 0) {
                            resArr[k] = resArr[k] - 1;
                            k++;
                            for (; k <= i - 1; k ++) {
                                resArr[k] = 9;
                            }
                            tempRes = tempRes + 10;
                            break;
                        }
                    }
                }
                resArr[i] = tempRes;
            }
        }
        return resArr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        String[] strInput = new String[2];
        for (int i = 0; i < 2; i++) {
            strInput[i] = reader.readLine();
        }
        StringBuilder resBuilder = new StringBuilder();
        String res = "";
        if (strInput[0].startsWith("-") && strInput[1].startsWith("-")) {
            char[] number1Arr = strInput[0].substring(1).toCharArray();
            char[] number2Arr = strInput[1].substring(1).toCharArray();
            int[] resArr = add(number1Arr, number2Arr);
            for (int i = 0; i < resArr.length; i ++) {
                if (resArr[resArr.length - 1 - i] == 0 && i == 0) {
                    continue;
                }
                resBuilder.append(resArr[resArr.length - 1 - i]);
            }
            res = "-" + resBuilder.toString();
        } else if (strInput[0].startsWith("-")) {
            char[] number1Arr = strInput[0].substring(1).toCharArray();
            char[] number2Arr = strInput[1].toCharArray();
            int[] resArr = subtract(number2Arr, number1Arr);
            boolean start = false;
            for (int i = 0; i < resArr.length - 1; i ++ ) {
                if (resArr[i] == 0 && !start) {
                    continue;
                }
                if (resArr[i] > 0) {
                    start = true;
                    resBuilder.append(resArr[i]);
                } else {
                    resBuilder.append(resArr[i]);
                }
            }
            if (!start) {
                res = 0 + "";
            } else if (resArr[resArr.length - 1] == -1) {
                res = "-" + resBuilder.toString();
            } else {
                res = resBuilder.toString();
            }
        } else if (strInput[1].startsWith("-")) {
            char[] number1Arr = strInput[0].toCharArray();
            char[] number2Arr = strInput[1].substring(1).toCharArray();
            int[] resArr = subtract(number1Arr, number2Arr);
            boolean start = false;
            for (int i = 0; i < resArr.length - 1; i ++ ) {
                if (resArr[i] == 0 && !start) {
                    continue;
                }
                if (resArr[i] > 0) {
                    start = true;
                    resBuilder.append(resArr[i]);
                } else {
                    resBuilder.append(resArr[i]);
                }
            }
            if (!start) {
                res = 0 + "";
            } else if (resArr[resArr.length - 1] == -1) {
                res = "-" + resBuilder.toString();
            } else {
                res = resBuilder.toString();
            }
        } else {
            int[] resArr = add(strInput[0].toCharArray(), strInput[1].toCharArray());
            if (resArr[resArr.length - 1] == 1) {
                resBuilder.append(1);
            }
            for (int i = 1; i < resArr.length; i ++) {
                resBuilder.append(resArr[resArr.length - 1 - i]);
            }
            res = resBuilder.toString();
        }
        System.out.println(res);
    }
}
