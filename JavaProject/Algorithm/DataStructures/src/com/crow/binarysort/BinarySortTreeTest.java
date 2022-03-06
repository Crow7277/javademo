package com.crow.binarysort;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * User crow7
 * Date 2021/11/25.
 */
public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        //添加结点
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历
        binarySortTree.infixOrder();//1 2 3 5 7 9 10 12

        //删除叶子结点
//        binarySortTree.delNode(2);
//        binarySortTree.delNode(5);
        binarySortTree.delNode(7);
        System.out.println("删除结点后：");
        binarySortTree.infixOrder();
    }
}


//创建二叉排序树
class BinarySortTree {
    private Node root;

    //添加接待结点的方法
    public void add(Node node) {
        if (root == null) {
            //如果root为空，则直接让root指向node
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("此树为空");
        } else {
            root.infixOrder();
        }
    }

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) return null;
        else return root.search(value);
    }

    //查找要删除结点的父结点
    public Node searchParent(int value) {
        if (root == null) return null;
        else return root.searchParent(value);
    }

    /**
     * 返回的是以node为根结点的二叉排序树的最小结点的值并删除
     *
     * @param node 传入的结点，当做二叉排序树的根结点
     * @return 返回的是以node为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环查找左子结点
        while (target.left != null) {
            target = target.left;
        }
        //此时target指向最小接待
        //删除最小结点
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) return;
        else {
            //找到要删除的结点
            Node targetNode = search(value);
            //如果没有找到停止
            if (targetNode == null) return;

            //当前二叉排序树只有一个结点
            if (root.left == null && root.left == null) {
                root = null;
                return;
            }
            //找到目标值的父结点
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {//删除叶子结点
                if (parent.left != null && parent.left.value == value)
                    parent.left = null;
                else if (parent.right != null && parent.right.value == value)
                    parent.right = null;
            } else if (targetNode.left != null && targetNode.right != null) {//删除有两棵子树的结点
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            } else {//删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果targetNode是parent的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            //说明targetNode是parent的右子结点
                            parent.right = targetNode.left;
                        }
                    } else root = targetNode.left;

                } else {//要删除的结点有右子结点
                    if (parent != null) {
                        //如果targetNode是parent的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else root = targetNode.right;
                }
            }
        }
    }
}

//创建Node结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到，返回该结点，否则返回null
     */
    public Node search(int value) {
        //找到该节点
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) return null;
            return this.left.search(value);
        } else {
            if (this.right == null) return null;
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除结点的父节点
     *
     * @param value 要找的结点的值
     * @return 返回删除结点的父结点，如果没有返回null
     */
    public Node searchParent(int value) {
        //如果当且结点就是要删除的父节点，就返回父节点
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值，且当前结点的左子结点不为空
            if (value < this.value && this.left != null)
                return this.left.searchParent(value);//向左子树递归查找
            else if (value >= this.value && this.right != null)
                return this.right.searchParent(value);//向右子树递归查找
            else return null;//没有父节点
        }
    }

    //通过添加结点的方法，需要满足二叉排序数的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的结点的值和当前子树的根结点的值的关系
        if (node.value < this.value) {
            //判断左子树是否为空
            if (this.left == null) this.left = node;
            else this.left.add(node);
        } else {
            //判断右子树是否为空
            if (this.right == null) this.right = node;
            else this.right.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

