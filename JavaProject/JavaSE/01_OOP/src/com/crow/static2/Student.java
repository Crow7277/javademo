package com.crow.static2;

/**
 * User crow7
 * Date 2021/9/4.
 */

/**
 * static方法
 */
public class Student {
    String name;
    int age;
    int sno;
    String cup;//水杯
    //String waterMachine; 饮水机  如果只是这样定义，饮水机就代表每创建一个对象都会生成一个饮水机
    /*使用static关键字创建饮水机*/
    static String waterMachine;

    public static void showWaterMachine() {
        System.out.println("waterMachine = " + waterMachine);
        //静态方法中不可以访问非静态方法
        //show();
        //静态方法中不可以访问非静态变量
        //System.out.println(cup);
    }

    public static void setWaterMachine(String waterMachine) {
        //静态方法中不可以使用this关键字，所以在成员变量和局部变量重名时要通过类名来方法成员变量
        Student.waterMachine = waterMachine;
    }

    public void show() {
        //非静态方法中可以访问静态变量
        System.out.println("sno = " + sno + ",name = " + this.name + "饮水机：" + waterMachine);
        //非静态方法中可以访问静态方法
        showWaterMachine();
    }

    public static void main(String[] args) {
        //通过类名调用
        Student.showWaterMachine();
        Student.setWaterMachine("美的");
        Student.showWaterMachine();

        //通过对象名调用
        Student stu = new Student();
        stu.showWaterMachine();

        stu.show();
    }
}
