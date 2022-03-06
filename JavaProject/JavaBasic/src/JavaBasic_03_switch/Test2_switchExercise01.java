package JavaBasic_03_switch;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test2_switchExercise01 {
    public static void main(String[] args) {
        /*switch语句*/
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = sc.nextInt();
        System.out.println("请输入月份");
        int month = sc.nextInt();
        System.out.println("输入的日期是" + year + "年" + month + "月");
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30天");
                break;
            case 2:
                if (year % 4 == 0) {
                    System.out.println("29天");
                } else {
                    System.out.println("28天");
                }
                break;
            default:
                System.out.println("月份有误");
                break;
        }

        sc.close();
    }
}
