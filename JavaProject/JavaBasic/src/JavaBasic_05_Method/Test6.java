package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test6 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        change(x);
        // 此时x[0]为100
        System.out.println(x[0]);
    }
    public static void change(int[] a) {
        a[0] = 100;
    }
}
