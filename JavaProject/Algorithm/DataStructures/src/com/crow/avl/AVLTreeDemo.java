package com.crow.avl;

/**
 * User crow7
 * Date 2021/11/27.
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        //int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        //int[] arr = {2, 1, 6, 5, 7, 3};
        //创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("平衡处理");
        System.out.println("树的高度 = " + avlTree.getRoot().height());//4
        System.out.println("树的左子树高度 = " + avlTree.getRoot().leftHeight());//1
        System.out.println("树的右子树高度 = " + avlTree.getRoot().rightHeight());//3
        System.out.println("当前根节点 = " + avlTree.getRoot());
        System.out.println("根结点的左子结点 = " + avlTree.getRoot().right.left);
    }
}

//创建AVL树
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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
}

//创建Node结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) return 0;
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) return 0;
        return right.height();
    }

    //返回以该结点为根结点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转方法
    private void leftRotate() {
        //创建新的结点，为当前根节点的
        Node newNode = new Node(value);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = this.left;
        //把新的结点的右子树设置成当前结点右子树的左子树
        newNode.right = this.right.left;
        //把当前结点的值替换成其右子树的值
        this.value = this.right.value;
        //把当前结点的右子树设置成当前节点的右子树的右子树
        this.right = this.right.right;
        //把当前结点左子树设置成新的结点
        this.left = newNode;
    }

    //右旋方法
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
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

        //当添加完一个结点后，如果：右子树的高度 - 左子树的高度 > 1 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果当前结点右子树的左子树的高度大于它的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子树进行右旋
                right.rightRotate();
                //再对当前结点进行左旋
                leftRotate();
            } else leftRotate();
            //当添加完一个结点后，如果：左子树的高度 - 右子树的高度 > 1 右旋转
        } else if (leftHeight() - rightHeight() > 1) {
            //如果当前节点左子树的右子树的高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对左子树进行左旋
                left.leftRotate();
                //在对当前结点进行右旋
                rightRotate();
            } else rightRotate();
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