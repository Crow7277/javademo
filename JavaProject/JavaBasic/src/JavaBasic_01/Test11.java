package JavaBasic_01;

/**
 * User crow7
 * Date 2021/8/28.
 */
public class Test11 {
    public static void main(String[] args) {
        /*
         * ++ 自增运算符
         * -- 自减运算符
         * 前置时，先让变量自增/自减，然后在使用变量参与运算
         * 后置时，先使用变量参与运算，然后在让比那里自增/自减
         * */
        int i = 10;
        int b = i++;
        int b1 = i--;
        int j = 5;
        //先让j=5进行11+5运算  然后再让j-1变为4
        int b2 = ++i + j--;
        System.out.println(b); //10
        System.out.println(b1);//11
        System.out.println(b2);//16

//        int i = 10;
//        int j = 20;
//        System.out.println(i > j ? i : j);//谁大输出谁，此时输出为 j

    }
}
