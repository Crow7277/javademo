package com.crow.tree.threadedbinarytree;

/**
 * User crow7
 * Date 2021/11/13.
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        //二叉树手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        //测试：以10号做测试
        System.out.println(node5.getLeft());//前驱结点
        System.out.println(node5.getRight());//后继结点
        System.out.println(node4.getLeft());//前驱结点
        System.out.println(node4.getRight());//后继结点
        System.out.println(node4.getLeftType());//后继结点

        System.out.println("使用线索化的方式遍历线索化二叉树");
        threadedBinaryTree.threadList();
    }
}

//二叉树类
//定义二叉树
class ThreadedBinaryTree {
    private HeroNode root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归线索化时，pre总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载线索化方法让其调用更简单
    public void threadedNodes() {
        threadedNodes(root);
    }

    //遍历线索化二叉树的方法
    public void threadList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType = 1的结点，第一个找到的是8这个结点
            //后面随着遍历而变化，因为当leftType = 1时，说明该结点是按照线索化处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType() == 1) {
                //获取当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换遍历的结点
            node = node.getRight();
        }
    }

    //编写对二叉树进行中序线索化的方法
    //对node结点进行线索化
    public void threadedNodes(HeroNode node) {
        //如果当前节点为空，无法进行线索化
        if (node == null) {
            return;
        }
        //1.线索化左子树
        threadedNodes(node.getLeft());
        //2.线索化当前节点
        //先处理当前节点的前驱结点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的类型，指向前驱结点
            node.setLeftType(1);
        }
        //处理当前结点的后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点，修改前驱结点的右指针类型
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //3.线索化右子树
        threadedNodes(node.getRight());
    }
}

//创建节点
//先创建HeroNode结点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//默认为null
    private HeroNode right;//默认为null
    //说明
    //1.如果left == 0表示指向的是左子树，如果是1，则表示指向前驱结点
    //1.如果right == 0表示指向的是右子树，如果是1，则表示指向后继结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

