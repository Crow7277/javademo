package com.crow.stack;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/10/23.
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试栈
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show：显示栈");
            System.out.println("exit：退出栈");
            System.out.println("push：添加数据到栈");
            System.out.println("pop：从栈取出数据");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.showStack();
                    break;
                case "exiet":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数据");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已经退出");
    }
}

class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据放在该数组
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull())
            return;
        top++;
        stack[top] = value;
    }

    //出栈,将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            //抛出长
            throw new RuntimeException("当前栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈,需要从栈顶开始遍历
    public void showStack() {
        if (isEmpty()) return;
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}