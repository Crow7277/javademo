package JavaBasic_05_Method;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test2_Method_Exercise03 {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        long result = pow(a, b);
        System.out.println(result);
    }

    /*
     * 定义一个方法返回 a 的 b次方
     * */
    public static long pow(int a, int b) {
        long p = 1;
        for (int i = 1; i <= b; i++) {
            p *= a;
        }
        return p;
    }
}
