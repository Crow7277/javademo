package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test2_Method_Exercise01 {
    public static void main(String[] args) {
        print99();
    }
    /*
     * 定义一个方法输出九九乘法表
     * */
    public static void print99() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
