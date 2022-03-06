package com.crow.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User crow7
 * Date 2021/11/22.
 */
public class HuffMenTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = creatHuffmanTree(arr);
        //使用前序遍历遍历
        preOrder(node);//67 29 38 15 7 8 23 10 4 1 3 6 13
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("为空树");
        }
    }

    //创建霍夫曼树

    /**
     * 创建霍夫曼树
     *
     * @param arr 需要创建霍夫曼树的数组
     * @return 霍夫曼树的root节点
     */
    public static Node creatHuffmanTree(int[] arr) {
        //为了操作方便
        //1.遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        //处理的过程是一个循环的过程
        //霍夫曼树形成之后，再ArrayList中因该只有67这个根节点其他的都是他的子树
        //因此，node.size()为1的时候就说明已经生成了霍夫曼树
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);
            //取出根节点权值最小的二叉树
            //(1).取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //(2).取出第二小的结点（二叉树）
            Node rightNode = nodes.get(1);
            //(3)。构建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //(4).从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5).将parent加入到nodes
            nodes.add(parent);
        }
        //返回霍夫曼树的root结点
        return nodes.get(0);
    }
}

//创建结点类
//为了让Node对象支持排序Collections集合排序，需要Node实现Comparable接口
class Node implements Comparable<Node> {
    int value;//结点的权值
    Node left;//左子结点
    Node right;//右子结点

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从从小到大排序
        return this.value - o.value;
    }
}
