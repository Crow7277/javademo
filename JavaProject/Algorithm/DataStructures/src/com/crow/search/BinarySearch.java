package com.crow.search;

import java.util.ArrayList;

/**
 * User crow7
 * Date 2021/11/3.
 */
public class BinarySearch {
    //二分查找要求必须是有序数组
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int resIndex = binarySearch(arr, 0, arr.length - 1, 11);
        System.out.println(resIndex);
        int[] arr2 = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        ArrayList arrayList = binarySearch2(arr2, 0, arr2.length - 1, 1000);
        System.out.println(arrayList);
    }

    /**
     * 二分查找
     *
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 要查找的值
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当left > right说明没有找到此时返回-1
        if (left > right) return -1;
        int mid = left + (right - left) / 2;//相当于（left + right） / 2; 这种写法是为了防止数组越界
        int midVal = arr[mid];
        if (findVal > midVal) {//向右边递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal > midVal) {//向左边递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    /**
     * {1,8,10,89,1000,1000,1234}
     * 当一个有序数组中存在多个相同的数值时，将所有数值都查找到
     * <p>
     * 思路：
     * 1.在找到mid时，不马上返回
     * 2.向mid索引值的左边扫描，将所有满足查找值的下标加入到一个集合中
     * 3.向mid所有值的右边哨兵，将所有满足查找值的下标加入到一个集合中
     */
    public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal) {
        //当left > right说明没有找到此时返回-1
        if (left > right) return new ArrayList<Integer>();
        int mid = left + (right - left) / 2;//相当于（left + right） / 2; 这种写法是为了防止数组越界
        int midVal = arr[mid];
        if (findVal > midVal) {//向右边递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal > midVal) {//向左边递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向mid左边扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;//temp左移
            }
            resIndexList.add(mid);
            //向mid右边扫描
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;//temp右移
            }
            return resIndexList;
        }
    }
}
