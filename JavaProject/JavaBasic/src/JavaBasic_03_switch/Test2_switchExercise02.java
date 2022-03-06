package JavaBasic_03_switch;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test2_switchExercise02 {
    public static void main(String[] args) {
        /*switch语句*/
        /*
        * 练习题
        * 输入学生分数，按分数给学生分数分级
        * 60以下不及格
        * 60-70几个
        * 70-80一般
        * 80-90良好
        * 90以上优秀
        * */
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生分数：");
        int result = sc.nextInt();
        System.out.println("该名学生的成绩为："+result+"分");
        int grade = result/10;
        switch (grade){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("F");
                break;
            case 6:
                System.out.println("E");
                break;
            case 7:
                System.out.println("D");
                break;
            case 8:
                System.out.println("B");
                break;
            case 9:
            case 10:
                System.out.println("A");
                break;
            default:
                break;
        }
    }
}
