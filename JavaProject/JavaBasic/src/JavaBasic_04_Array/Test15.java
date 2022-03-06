package JavaBasic_04_Array;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test15 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 6, 9, 1, 8, 7, 2};
        /*遍历数组*/
        System.out.println(Arrays.toString(arr));
        /*冒泡排序*/
        for (int i = 0; i < arr.length - 1; i++) {
            /*创建有序标记，如果已经排序完成则不需要执行之后的排序操作*/
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        System.out.println("冒泡排序");
        System.out.println(Arrays.toString(arr));
    }
}
