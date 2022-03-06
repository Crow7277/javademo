package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test1 {
    public static void main(String[] args) {
        /*
         * 方法调用
         * 通过方法名调用方法，同时传入参数
         * */
        int sum = getSum(10, 20);
        System.out.println(sum);
    }

    /*
     * 定义一个方法：返回两个整数的和
     * 分析：
     * 使用范围       public
     * 返回值类型     int
     * 方法名        getSum
     * 参数列表      int a,int b
     * 方法体        求和和运算，并返回结果
     * */
    public static int getSum(int a, int b) {
        return a + b;
    }
}
