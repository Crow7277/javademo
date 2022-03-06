package com.crow.encapsulation2;
/**
 * User crow7
 * Date 2021/9/5.
 */
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        //此时因为在Person类中，name与age不是public，所以在包外不能访问
        //person.name = "张三";
        //person.age = 23;
        person.setAge(233333);
        person.setName("张三sdgfdsbsa");
        //person.show();
        System.out.println(person.getName()+"  "+person.getAge());
    }
}
