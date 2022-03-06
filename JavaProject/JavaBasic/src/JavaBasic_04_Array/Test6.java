package JavaBasic_04_Array;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0, min = 999, maxIndex = 0, minIndex = 0;
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "名同学的成绩：");
            scores[i] = sc.nextInt();
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            } else if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }
        System.out.println("最大值为:" + max + "，其索引为:"
                + maxIndex + "\n" + "最小值为：" + min + "，其索引为：" + minIndex);
        sc.close();
    }
}
