package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test9 {
    // 定义一个方法 遍历一个整数数组
    public static void showArray(int... arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 3, 5, 6, 71, 51};
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        showArray();//不放参数也可以执行
        showArray(a, b, c, d, e, f);
        System.out.println();
        showArray(arr);
    }
}
