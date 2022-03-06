package JavaBasic_03_while_for;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test2_whileExercise01 {
    public static void main(String[] args) {
        /*输出1-100以内所有偶数，奇数*/
        int i = 1;
        while (i <= 100) {
            if (i % 2 == 0) {
                System.out.print("偶数：" + i + " ");
            } else {
                System.out.print("奇数" + i + " ");
            }
            i++;
        }
        System.out.println();

        /*输出1-100以内所有奇数的和*/
        int i1 = 1;
        int sum = 0;
        while (i1 <= 100) {
            sum += i1;
            i1 += 2;
        }
        System.out.println("奇数和：" + sum);
        System.out.println();

        /*输出1-100以内所有5的倍数*/
        int i2 = 5;
        while (i2 <= 100) {
            System.out.print("5的倍数：" + i2 + " ");
            i2 += 5;
        }
        System.out.println();

        /*从键盘录入任意整数倒序输出*/
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int i3 = sc.nextInt();
        System.out.println("输入的数字为：" + i3);
        while (i3 > 0) {
            System.out.print(i3 + " ");
            i3--;
        }
    }
}
