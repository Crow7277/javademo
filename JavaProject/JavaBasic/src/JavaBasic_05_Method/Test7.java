package JavaBasic_05_Method;

import java.util.Arrays;
import JavaBasic_04_Array.Test17_MyUitl;
import JavaBasic_04_Array.*;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test7 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,4,2,8,6,1,74,5};
        Test8_MyArrays.sort(arr);
        //Test17_MyUitl.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
