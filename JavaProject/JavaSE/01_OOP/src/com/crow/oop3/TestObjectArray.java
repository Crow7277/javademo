package com.crow.oop3;

/**
 * User crow7
 * Date 2021/9/4.
 */
public class TestObjectArray {
    public static void main(String[] args) {
        //基本数据类型的数组
        int[] arr;
        arr = new int[4];
        arr[0] = 45;
        arr[1] = 67;
        arr[2] = 61;
        arr[3] = 63;
        for (int i : arr) {
            System.out.println(i);
        }

        //引用数据类型的数组（对象数组）
        Computer[] arr2 = new Computer[4];
        arr2[0] = new Computer("Intel", "华硕", "金士顿", "雷蛇");
        arr2[1] = new Computer("AMD", "技嘉", "金士顿", "罗技");
        arr2[2] = new Computer("Intel", "华硕", "金士顿", "雷蛇");
        arr2[3] = new Computer("Intel", "技嘉", "三星", "双飞燕");
        for (Computer com : arr2) {
            com.show();
        }
    }
}
