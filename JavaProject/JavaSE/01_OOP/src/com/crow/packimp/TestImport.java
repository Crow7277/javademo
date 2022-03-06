package com.crow.packimp;

import static java.lang.Math.*;
//静态导入static import导入的不是类和接口，导入的是静态方法和静态属性

/**
 * User crow7
 * Date 2021/9/5.
 */
public class TestImport {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.random());
        System.out.println(Math.abs(-5));
        System.out.println(Math.max(10, 20));

        System.out.println(PI);
        System.out.println(random());
        System.out.println(abs(-5));
        System.out.println(max(10, 20));
    }
}
