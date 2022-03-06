package com.crow.tree;

/**
 * User crow7
 * Date 2021/11/13.
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr = {1,3,6,8,10,14};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        System.out.println("前序遍历");
        arrayBinaryTree.preOrder(0);//1	2	4	5	3	6	7
        System.out.println("\n中序遍历");
        arrayBinaryTree.infixOrder(0);//4   2   5   1   6   3   7
        System.out.println("\n后序遍历");
        arrayBinaryTree.postOrder(0);//4    5   2   6   7   3   1
    }
}

//编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrayBinaryTree {
    private int[] arr;//存储数据结点数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写方法完成顺序存储二叉树的前序遍历
    //index = 数组下标
    public void preOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //输出当前元素
        System.out.print(arr[index] + "\t");
        //向左递归遍历
        if ((index * 2 + 1) < arr.length)
            preOrder(2 * index + 1);
        //向右递归比那里
        if ((index * 2 + 2) < arr.length)
            preOrder(2 * index + 2);
    }

    //编写方法完成顺序存储二叉树的中序遍历
    //index = 数组下标
    public void infixOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length)
            infixOrder(2 * index + 1);
        //输出当前元素
        System.out.print(arr[index] + "\t");
        //向右递归比那里
        if ((index * 2 + 2) < arr.length)
            infixOrder(2 * index + 2);

    }

    //编写方法完成顺序存储二叉树的后序遍历
    //index = 数组下标
    public void postOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length)
            postOrder(2 * index + 1);
        //向右递归比那里
        if ((index * 2 + 2) < arr.length)
            postOrder(2 * index + 2);
        //输出当前元素
        System.out.print(arr[index] + "\t");
    }
}