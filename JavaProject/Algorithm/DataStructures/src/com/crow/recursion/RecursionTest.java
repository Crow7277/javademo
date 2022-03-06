package com.crow.recursion;

/**
 * User crow7
 * Date 2021/10/28.
 */
public class RecursionTest {
    //通过打印问题，回顾递归的调用机制
    public static void main(String[] args) {
        test(10);
        System.out.println(factorial(5));
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else
            return factorial(n - 1) * n;
    }
}
