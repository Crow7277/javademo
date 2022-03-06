package JavaBasic_01;

/**
 * User crow7
 * Date 2021/8/28
 */
public class Test4 {
    public static void main(String[] args) {
        byte b = 1;                     //字节型整数，使用8bit存储整数，-128~127
        short c = 1;                    //短整型整数，使用16bit存储整数，-32768~23767
        int i = 10;                      //整数型，使用32bit存储整数，-2147483648~2147483647  默认存储整数常量的类型
        long l = 211111111111111111L;    //长整型，使用64bit存储整数，-2^63~2^63-1，使用长整型时需要在数字后加大写的L
        System.out.println(b);
        System.out.println(c);
        System.out.println(i);
        System.out.println(l);
    }
}
