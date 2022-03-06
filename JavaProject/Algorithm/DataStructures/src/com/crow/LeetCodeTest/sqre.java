package com.crow.LeetCodeTest;

/**
 * User crow7
 * Date 2021/11/1.
 */
public class sqre {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
    public static boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1)
            return true;
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;//防止越界，相当于(left + right)
            if (mid == num / mid) {
                return true;
            } else if (mid < num / mid) {
                //由于mid * mid小于num，因此num的平方根应该在[mid,right]
                left = mid + 1;
            }
            if (mid > num / mid) {
                //由于mid * mid小于num，因此num的平方根应该在[left,mid]
                right = mid - 1;
            }
        }
        return false;
    }
}

