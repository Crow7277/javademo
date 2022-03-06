package JavaBasic_01;

/**
 * User crow7
 * Date 2021/8/28.
 */
public class Test5 {
    public static void main(String[] args) {
        //单精度浮点数，小数点后有7位，如果超过会四舍五入
        //在输入单精度浮点数时，需要在数字后面加f
        float f = 1.123456f;
        System.out.println(f);
        //双精度浮点数
        //Java中默认存储浮点数的格式为double
        double b = 1.232536725615151;
        System.out.println(b);

        //科学计数法
        double d = 1.123456e2;
        System.out.println(d);
    }
}
