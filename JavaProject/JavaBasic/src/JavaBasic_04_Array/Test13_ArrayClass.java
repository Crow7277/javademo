package JavaBasic_04_Array;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test13_ArrayClass {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 4, 5, 6, 85, 54, 74, 95, 65, 82, 26, 34};
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        /*排序功能*/
        Arrays.sort(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        /*
         * 快速查询功能（二分查找）
         * 在数组中快速的查询给定元素出现的位置
         * 如果找到元素，返回当前元素所在位置的索引
         * 如果查询元素不存在，会返回一个负数
         * 数组必须为升序排列
         * */
        int index = Arrays.binarySearch(arr, 74);
        System.out.println(index + "\n");

        /*
         * 快速遍历数组
         * 输出格式为字符串
         * */
        String s = Arrays.toString(arr);
        System.out.println(s);

        /*
         * 数组复制
         * */
        int[] arr1 = {1, 2, 3, 4, 5};
        /*
         * 下面的代码并不是复制，它只是将arr1的引用地址复制给了arr2
         * 也就是说，当arr1中的元素值发生改变后arr2也会跟着改变
         * */
        int[] arr2 = arr1;
        /*
         * 使用Arrays.copyOf进行复制
         * 此时是复制出来了一个独立的数组
         * */
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr3));
    }
}
