package JavaBasic_03_while_for;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test5_for {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        /*求阶乘*/
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        System.out.println("输入的数字是：" + num);
        int sum = 1;
        for (int i = 1; i <= num; i++) {
            sum *= i;
        }
        System.out.println("阶乘为：" + sum);
    }
}
