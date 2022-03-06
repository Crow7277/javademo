package com.crow.linkedlist;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.Stack;

/**
 * User crow7
 * Date 2021/10/20.
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        //singleLinkedList.add(hero1);
        //singleLinkedList.add(hero2);
        //singleLinkedList.add(hero3);
        //singleLinkedList.add(hero4);

        //按照编号顺序加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.showlist();
        System.out.println();

        //测试逆序打印
        System.out.println("逆序打印");
        reversePrint(singleLinkedList.getHead());
        System.out.println();

        //测试翻转链表
        System.out.println("翻转链表");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.showlist();

        //测试修改节点的代码
        System.out.println();
        HeroNode node = new HeroNode(2, "小李", "玉麒麟~~");
        singleLinkedList.update(node);
        singleLinkedList.showlist();
        System.out.println();

        //测试删除结点
        singleLinkedList.del(1);
        singleLinkedList.showlist();

        //测试求单链表有效个数
        System.out.println(getLength(singleLinkedList.getHead()));

        //测试是否得到倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println(res);
    }

    /**
     * 使用stack实现链表的逆序打印
     */
    public static void reversePrint(HeroNode head) {
        if (head == null)
            return;
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0)
            System.out.println(stack.pop());
    }

    /**
     * 单链表进行翻转
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有几个节点，无序翻转，直接返回
        if (head.next == null || head.next.next == null)
            return;
        //定义一个辅助指针，帮助遍历链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点就将其取出，从头插入reverseHead
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的头部
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur指向原链表的下一个节点
        }
        //将head.next指向新链表的头部
        head.next = reverseHead.next;
    }

    /**
     * 1. 编写一个方法接收head节点，同时接收一个index
     * 2. index表示的是倒数第index个节点
     * 3. 遍历链表得到单链表的节点个数
     * 4. 得到节点个数后，从链表开始遍历，遍历到（节点数 - index）
     * 5. 如果找到，返回结点，否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的节点数
        int size = getLength(head);
        //第二次变量，size - index 位置，就是倒数第k个节点
        //首先做一个index的校验
        if (index <= 0 || index > size)
            return null;
        //定义一个辅助变量
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取单链表的节点的个数
     * 如果是带头结点的链表，不需要统计头结点
     *
     * @param head 链表头结点
     * @return 返回节点有效个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null)
            return 0;
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

//定义SingleLinkedList管理英雄
class SingleLinkedList {
    //初始化一个头结点，头结点不动
    private HeroNode head = new HeroNode(0, "", "");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * 思路：当不考虑编号顺序的时候
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此需要一个辅助指针
        HeroNode temp = head;//temp指针指向了head
        //变量链表找到最后
        while (true) {
            if (temp.next == null)
                break;
            //如果不是temp后移一位
            temp = temp.next;
        }
        //退出while循环的时候，temp指向了链表最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //按照指定序号进行加入
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此仍然通过辅助指针来帮助找到添加的位置
        //因为是单链表，因此找的temp是位于添加位置的前一个节点，否则无法插入
        HeroNode temp = head;
        boolean flag = false;//标识添加的编号是否存在，默认为false
        while (true) {
            //temp已经在链表最后
            if (temp.next == null) {
                break;
            }
            //位置找到，在temp的下一个节点
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                //希望添加的编号已经存在
                flag = true;//变化存在
                break;
            }
            temp = temp.next;//后移
        }
        if (flag) {//说明编号已经存在不能添加
            System.out.printf("准备插入的英雄编号%d已经存在，不能添加\n", heroNode.no);
        } else {
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据编号修改，也就是编号不变
    //根据newHeroNode.no来修改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null)
            System.out.println("链表为空");
        //找到需要修改的结点
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该结点
        while (true) {
            if (temp == null)
                break;//遍历结束
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的结点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else
            System.out.printf("没有找到编号%d的结点，不能修改", newHeroNode.no);
    }

    /**
     * 删除结点
     * 思路
     * 1.head不能动，因此需要一个temp辅助结点找到待删除节点的前一个节点
     * 2.在比较时，是temp.next.no和需要少吃的no比较
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标识是否找到待删除节点
        while (true) {
            if (temp.next == null)
                break;
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag)
            temp.next = temp.next.next;
        else
            System.out.println("未找到，无法删除");
    }

    //显示链表（遍历）
    public void showlist() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //遍历
        for (HeroNode i = head.next; i != null; i = i.next) {
            System.out.println(i.toString());
        }
    }
}

//定义一个Node，每个Node对象就是一个结点
class HeroNode {
    public int no;//英雄编号
    public String name;//英雄名称
    public String nickName;//英雄你成
    public HeroNode next;//指向一个结点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //为了显示方便，重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

