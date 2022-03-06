package JavaBasic_05_Method;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class TestArraysUtil {
    public static void main(String[] args) {
        // 定义一个方法可以升序排列一个数组
        double[] arr = {5,1,4,8,5,3,6,7,1,6,9};
        ArraysUtil.sortASC(arr);
        System.out.println(Arrays.toString(arr));
        // 定义一个方法可以降序排列一个数组
        ArraysUtil.sortDESC(arr);
        System.out.println(Arrays.toString(arr));
        /*判断给定数组中是否包含指定元素，如果包含返回索引，如果不包含返回1*/
        int [] arr1 = {5,1,4,8,5,3,6,7,1,6,9};
        int i = ArraysUtil.indexOf(arr1,6);

    }
}
