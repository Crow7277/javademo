package com.crow.stack;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/10/23.
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        //测试栈
        LinkedListStack arrayStack = new LinkedListStack();
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
                case "exit":
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

class LinkedListStack {
    //创建头结点
    private Node head = new Node();

    //栈空
    public boolean isEmpty() {
        return head.next == null;
    }

    //入栈 头插法
    public void push(int value) {
        Node nodeValue = new Node(value);
        Node temp = head;
        nodeValue.next = temp.next;
        temp.next = nodeValue;
    }

    //出栈
    public int pop() {
        if (isEmpty())
            throw new RuntimeException("当前栈为空");
        int value;
        Node temp = head;
        value = temp.next.getNum();
        temp.next = temp.next.next;
        return value;
    }

    //遍历栈
    public void showStack() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //遍历
        for (Node i = head.next; i != null; i = i.next) {
            System.out.println(i.getNum());
        }
    }

}

class Node {
    private int num;
    public Node next;

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int num) {
        this.num = num;
    }

    public Node() {
    }
}
