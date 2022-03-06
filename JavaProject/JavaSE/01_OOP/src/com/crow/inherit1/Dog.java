package com.crow.inherit1;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Dog extends Animal {//继承Animal类
    private String nickName; //昵称  Dog类特有

    public Dog() {
        super();//可以省略
    }

    public Dog(String color, int age, String nickName) {
        //因为父类中的成员变量为private属性所以无法直接访问，此时可以将private改为protected
        //或者通过父类的构造方法进行赋值，因为其构造方法为public，此时可以使用super访问父类
        super(color, age);
        this.nickName = nickName;
    }

    public void guard() {
        System.out.println("Dog guarding....");
    }

    @Override
    public void introduce() {
        super.introduce();//通过super调用父类的方法
        System.out.println("nickName = " + nickName);
    }
}

