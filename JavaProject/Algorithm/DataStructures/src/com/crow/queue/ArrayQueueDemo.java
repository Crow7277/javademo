package com.crow.queue;

import java.util.Scanner;

/**
 * 队列的数组实现
 * User crow7
 * Date 2021/10/19.
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个队列对象
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头部数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    //因为getQueue存在异常抛出，所以用try-catch来处理
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列的头数据是%d\n", res);
                    } catch (RuntimeException e) {
                        System.out.println(e);
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列 - 编写一个ArrayQueue的类
class ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//指向队列头
    private int rear;//指向队列尾
    private int[] arr;//存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾部，指向队列尾部的数据（就是对吼一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断是否满
        if (isFull()) {
            System.out.println("队列已满，无法加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列为空，不能取出数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }
}
