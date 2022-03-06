package JavaBasic_01;

/**
 * User crow7
 * Date 2021/8/28.
 */
public class Test1 {
    public static void main(String[] args) {
        //声明变量的同时赋值
        int i = 10;
        //如果等号右边为一个表达式，则先计算表达式结果在赋值
        int a  = 10 + 10;
        //一次可以声明多个变量
        int c, d, e;
        int g = 1 , f = 2;

        //变量的值可以反复修改
        int  x = 11;
        System.out.println(x);
        //变量值声明一次类型即可，后面直接使用变量不需要反复声明其类型
        x = 12;
        System.out.println(x);
    }
}
