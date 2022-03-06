package com.crow.linkedlist;

/**
 * User crow7
 * Date 2021/10/22.
 */
public class Joseph {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//价格五个小孩节点
        circleSingleLinkedList.show();
        //测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

//创建一个单向环形链表
class CircleSingleLinkedList {
    //创建一个first节点，当前无标号
    private Boy first = new Boy(-1);

    //添加小孩节点构建环形链表
    public void addBoy(int nums) {
        //nums要做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据标号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                //构成换，此时由于next为private所以需要通过set方法调用
                //相当于first.next = first;
                first.setNext(first);
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);//curBoy.next = boy
                boy.setNext(first);//boy.next = first
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void show() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("当前链表为空");
            return;
        }
        //因为first不能动，因此仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的标号 %d\n", curBoy.getNo());
            if (curBoy.getNext() == first)
                break;
            curBoy = curBoy.getNext();//后移一位
        }
    }


    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNUm 表示数几下
     * @param nums     表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNUm, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //让helper指向环形链表指向first的前一个节点
        while (true) {
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();
        }
        //当小孩报数之前，先让first和helper移动startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次，然后后出圈
        //这是一个循环，直到圈中只有一个小孩
        while (true) {
            //判断圈中是否只有一个人
            if (helper == first) {
                break;
            }
            //让first和helper指针同时移动countNUm-1次
            for (int i = 0; i < countNUm - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点就是要除权的小孩的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //此时将first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号为%d\n", first.getNo());
    }
}

//创建一个boy类，表示一个结点
class Boy {
    private int no;//标号
    private Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}