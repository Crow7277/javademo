package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test4 {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        /*实际传递的参数*/
        int sum = add(i, j);
    }
    /*
     * 方法的参数列表叫做形式上的参数
     * 仅仅是形式上的占位，他引导者我们传入数据在方法体中如何使用
     * */
    public static int add(int a, int b) {
        return a + b;
    }
}
