package JavaBasic_05_Method;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test2_Method_Exercise02 {
    public static void main(String[] args) {
        /*就键盘输入要计算的数*/
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要计算的阶乘数：");
        int i = sc.nextInt();
        int result = factorial(i);
        System.out.println(i + "的阶乘为：" + result);
    }

    /*
     * 向控制台输出一个证书的阶乘
     * */
    public static int factorial(int i) {
        int sum = 1;
        for (int j = 1; j <= i; j++) {
            sum *= j;
        }
        return sum;
    }
}
