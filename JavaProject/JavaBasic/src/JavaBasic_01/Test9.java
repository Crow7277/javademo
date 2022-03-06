package JavaBasic_01;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * User crow7
 * Date 2021/8/28.
 */
public class Test9 {
    public static void main(String[] args) {
        //从小到大，正常转换
//        byte b = 10; //0000 1010
//        short s = b;//0000 0000 0000 1010
//        System.out.println(b);
//        int i = s;//0000 0000 0000 0000 0000 0000 0000 1010
//        System.out.println(i);
//        long l = i;//0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1010
//        System.out.println(l);
//        float f = l;
//        System.out.println(f);
//        double d = f;
//        System.out.println(d);
//
//        //将字符转为int时，会转为ASCII码
//        char c = 'b';//b >> unicode >> 00000000 10101010
//        int x = c;// 00000000 00000000 00000000 10101010 >> 十进制
//        System.out.println(x);

        //从大到小转换，为了尽量避免数据损失，应该让大的变量的值在小的变量的范围之内
        short s = 300; // 00100100 00001010
        byte b = (byte) s;//00001010 -127~128 此时只会截取后四位，最后输出位44
        System.out.println(b);

        //int ro char
        int a = 98;
        char c = (char) a;//此时会转为字符，b
        System.out.println(c);

        //浮点数和整数之间的强制转换
        double p = 1.1415;
        long l = (long) p;//取整
        System.out.println(l);//输出位3

        double value = 3.1415926;
        double v2 = value * 100;
        System.out.println(v2);
        int v3 = (int) v2;
        value = (double) v3 / 100.0;
        System.out.println(value);
    }
}
