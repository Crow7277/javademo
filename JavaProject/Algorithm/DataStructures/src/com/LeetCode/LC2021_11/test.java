package com.LeetCode.LC2021_11;

import org.testng.annotations.Test;

/**
 * User crow7
 * Date 2021/11/15.
 */
public class test {
    public static void main(String[] args) {
//        boolean n = isHappy(19);
//        System.out.println(n);
        String str = "hello world";
        System.out.println(str.length());
        str += "   ";
        System.out.println(str.length());
    }

    //求每个位上的数字的平方和
    public static int getSum(int n) {
        int res = 0;
        while (n > 0) {
            //取出一位
            int temp = n % 10;
            //如果n位多位数，将n缩小一位
            n /= 10;
            res += temp * temp;
        }
        return res;
    }

    public static boolean isHappy(int n) {
        //使用快慢指针方法
        //getSum可以看作链表的next，这时，如果是快乐数，那么快指针一定会到达1
        //如果不是快乐数，那么就是死循环，也就代表了链表有环
        //判断链表是否有环可以使用快慢指针， 如果两个指针相等，则证明有环
        int fast = n;//快指针
        int slow = n;//慢指针

        while (fast != slow && fast != 1) {
            System.out.println("check");
            slow = getSum(slow);
            System.out.println(fast);
            fast = getSum(getSum(fast));
        }
        return fast == 1;
    }

    @Test
    public void test1() {
        int a = 65;
        a |= 3;
        System.out.println(a);
    }
}






