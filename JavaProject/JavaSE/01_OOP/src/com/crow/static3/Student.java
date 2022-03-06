package com.crow.static3;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/9/4.
 */
public class Student {
    int sno = 10;//成员变量
    static String waterMachine = "meidi";

    public Student() {
        System.out.println("----------------------------");
    }
    //静态代码块
    static {
        System.out.println("static code1");
        waterMachine = "Haier";
    }

    //成员代码块，兄弟：成员变量，成员方法，构造方法
    {
        System.out.println("========code block1=========");
    }

    public void show() {
        int sno = 10;//局部变量
        System.out.println(sno);
        //局部代码块：在方法中，可以有多个，依次执行，定义的变量作用范围是当前局部代码块
        {
            int age = 40;
            System.out.println(age);
            System.out.println(sno);
            System.out.println(this.sno);
        }
        System.out.println(this.sno);
        //局部代码块：在方法中，可以有多个，一次执行
        {
            //此时因为age是之前的代码块定义的所以不能访问
            //System.out.println(age);
            System.out.println(sno);
            System.out.println(this.sno);
        }
    }

    {
        System.out.println("========code block2=========");
    }

    public static void main(String[] args) {
        Student stu = new Student();
        //stu.show();
        Student stu2 = new Student();

        Scanner input = new Scanner(System.in);
    }

    {
        System.out.println("========code block3=========");
    }
    //静态代码块
    static {
        System.out.println("static code1");
    }
}
