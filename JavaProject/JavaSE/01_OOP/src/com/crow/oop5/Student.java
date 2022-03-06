package com.crow.oop5;

/**
 * User crow7
 * Date 2021/9/4.
 */
public class Student {
    String name;
    int age;
    int sno;

    public Student() {
    }

    public Student(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    public Student(int sno, String name, int age) {
        //此时下面的这两个语句和上面的重复了
//        this.sno = sno;
//        this.name = name;
        //所以可以使用下面的写法，使用this调用上面的那个构造方法
        this(name,sno);

        this.age = age;
        //this(name,sno);此时会报错，需要将这个放到第一个语句
    }

    public void show() {
        int sno = 0;
        String name = "123";
        //此时如果不加this，就是调用show方法的局部变量，如果加了this就是调用了成员变量
        System.out.println("sno = " + sno + ",name = " + this.name);
    }
    public void study(){
        //此时下面的代码也是出现了代码重复
        //System.out.println("sno = " + sno + ",name = " + this.name);
        //可以使用this.show调用成员方法
        show();//this可以省略，this.show()
        System.out.println("好好学习天天向上");
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.sno = 1;
        stu.name = "李四";
        stu.age =22;
        stu.study();

        Student stu2 = new Student(2,"李四",23);
        stu2.study();
    }
}
