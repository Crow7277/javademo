package com.crow.tree;

import java.security.PrivateKey;

/**
 * User crow7
 * Date 2021/11/12.
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HerNode root = new HerNode(1, "宋江");//root结点
        HerNode node2 = new HerNode(2, "吴用");
        HerNode node3 = new HerNode(3, "卢俊义");
        HerNode node4 = new HerNode(4, "林冲");
        HerNode node5 = new HerNode(5, "关胜");
        //说明：这里手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //测试删除结点
        System.out.println("删除前：");
        binaryTree.preOrder();
        binaryTree.deNode(5);
        System.out.println("删除后");
        binaryTree.preOrder();

//        System.out.println("前序遍历");//1,2,3,5,4
//        binaryTree.preOrder();
//        System.out.println("中序遍历");//2,1,5,3,4
//        binaryTree.infixOrder();
//        System.out.println("后序遍历");//2,5,4,3,1
//        binaryTree.postOrder();
//
//        System.out.println("前序查找");
//        HerNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("找到了信息为no = %d name = %s\n", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄\n", 5);
//        }
//
//        System.out.println("中序查找");
//        resNode = binaryTree.infixOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("找到了信息为no = %d name = %s\n", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄\n", 5);
//        }
//
//        System.out.println("后序查找");
//        resNode = binaryTree.postOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("找到了信息为no = %d name = %s\n", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄\n", 5);
//        }
    }
}

//定义二叉树
class BinaryTree {
    private HerNode root;

    public void setRoot(HerNode root) {
        this.root = root;
    }

    //删除结点
    public void deNode(int no) {
        if (root != null) {
            //如果只有i一个root，需要判断这个root是否为要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HerNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HerNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HerNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

}

//先创建HeroNode结点
class HerNode {
    private int no;
    private String name;
    private HerNode left;//默认为null
    private HerNode right;//默认为null

    public HerNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HerNode getLeft() {
        return left;
    }

    public void setLeft(HerNode left) {
        this.left = left;
    }

    public HerNode getRight() {
        return right;
    }

    public void setRight(HerNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除结点
    //1.如果是子节点，则删除当前结点
    //2.如果是父节点，则删除子树
    public void delNode(int no) {
        //如果当前左子结点不为空且左子结点是要删除结点，将左子结点置空，并返回
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //如果当前右子结点不为空且右子结点是要删除结点，将右子结点置空，并返回
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //如果之前没有删除，则需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //如果之前没有删除，则需要向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);//优先输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //编写中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//输出父节点
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //编写后序遍历
    public void postOrder() {

        //递归向左子树后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);//输出父节点
    }

    //前序遍历查找
    public HerNode preOrderSearch(int no) {
        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        //判断当前姐弟啊你的左子节点是否为空，如果不为空，则递归前序查找
        HerNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {//说明左子树找到
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HerNode infixOrderSearch(int no) {

        //判断当前姐弟啊你的左子节点是否为空，如果不为空，则递归前序查找
        HerNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {//说明左子树找到
            return resNode;
        }
        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HerNode postOrderSearch(int no) {
        //判断当前姐弟啊你的左子节点是否为空，如果不为空，则递归前序查找
        HerNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {//说明左子树找到
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {//说明右子树找到
            return resNode;
        }
        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}


