package JavaBasic_02_if;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test3_ifExercise02 {
    /*给定月份和年份 输入当月天数*/
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入年份：");
        int year = sc.nextInt();

        System.out.println("请输入月份：");
        int month = sc.nextInt();

        System.out.println("输入的日期是：" + year + "年" + month + "月");

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.println("这个月31天");
        } else if (month == 2) {
            if (year % 4 == 0)
                System.out.println("这个月29天");
            else
                System.out.println("这个月28天");
        } else {
            System.out.println("这个月30天");
        }

        sc.close();
    }
}
