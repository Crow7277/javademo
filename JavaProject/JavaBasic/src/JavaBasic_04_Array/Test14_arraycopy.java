package JavaBasic_04_Array;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test14_arraycopy {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        /*使用arraycopy进行复制
         * 要求从arr1的底9号元素，也就是元素10开始复制
         * 复制的内容要求从arr2的2号位置，也就是索引为1出开始复制
         * */
        int[] arr2 = new int[10];
        System.arraycopy(arr1, 9, arr2, 1, 5);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
