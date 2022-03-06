package JavaBasic_05_Method;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test10 {
    public static void main(String[] args) {
            showArray(10,11,1,11,3,4);
    }
    /*可变参数必须使参数列表中的最后一个参数*/
    public static void showArray(int a, int... arr){
        System.out.println("a: "+a);
        System.out.println("arr: "+ Arrays.toString(arr));
    }
}
