package com.crow.queue;

import java.util.Scanner;

/**
 * 环形队列
 * User crow7
 * Date 2021/10/20.
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试
        //创建一个队列对象
        //队列最大有效数据为3，因为有一个空间是用来做约定的
        CircleArray arrayQueue = new CircleArray(4);
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

class CircleArray {
    private int maxSize;//表示数组的最大容量
    //front指向队列的第一个元素，arr[front]表示表示队列的第一个元素
    private int front;//指向队列头，初始值为0
    //rear指向队列的最后一个元素的后一个位置
    private int rear;//指向队列尾，初始值为0
    private int[] arr;//存放数据，模拟队列

    //创建队列的构造器
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;//指向队列头部，指向队列的第一个元素
        rear = 0;//指向队列尾部，指向队列的最后一个元素的后一个位置
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //将rear后移，但是因为是环形队列，所以应该取模运算
        rear = (rear + 1) % maxSize;
    }

    //出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列为空，不能取出数据");
        }
        //front指向队列的一个元素
        //1.先把front对应的值保留到一个临时变量value中
        int value = arr[front];
        //2.将front后移
        front = (front + 1) % maxSize;
        //3.返回value
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }
}
