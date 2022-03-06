package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test2_Method_Exercise04 {
    public static void main(String[] args) {
        double d = 1.23456;
        System.out.println(keepTwo(d));
    }

    /*
     * 定义一个方法返回一个浮点数保留两位小数，考虑四舍五入的结果
     * */
    public static double keepTwo(double d) {
        d *= 100;
        d += 0.5;
        int t = (int) d;
        return t / 100.0;
    }
}
