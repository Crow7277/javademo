package com.crow.linkedlist;

/**
 * User crow7
 * Date 2021/10/21.
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//        doubleLinkedList.showlist();
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.showlist();
        System.out.println();
        //修改
        HeroNode2 hero5 = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(hero5);
        doubleLinkedList.showlist();
        System.out.println();
        //删除
        doubleLinkedList.del(3);
        doubleLinkedList.showlist();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //初始化一个头结点，头结点不动
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void showlist() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //遍历
        for (HeroNode2 i = head.next; i != null; i = i.next) {
            System.out.println(i.toString());
        }
    }

    /**
     * 添加节点到单向链表
     */
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此需要一个辅助指针
        HeroNode2 temp = head;//temp指针指向了head
        //变量链表找到最后
        while (true) {
            if (temp.next == null)
                break;
            //如果不是temp后移一位
            temp = temp.next;
        }
        //退出while循环的时候，temp指向了链表最后
        //将最后这个节点的next指向新的节点\
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改节点的信息，根据编号修改，也就是编号不变
    //根据newHeroNode.no来修改
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null)
            System.out.println("链表为空");
        //找到需要修改的结点
        HeroNode2 temp = head.next;
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
     * 对于双向链表，可以直接找到要删除的结点
     * 找到之后自我删除即可
     */
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//标识是否找到待删除节点
        while (true) {
            if (temp.next == null)//已经好到链表最后
                break;
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //这里的代码是有风险的
            //如果删除的是最后一个结点，就不需要执行下面这句代码，否则会出现空指针异常
            if (temp.next != null)
                temp.next.pre = temp.pre;
        } else
            System.out.println("未找到，无法删除");
    }
    //按照指定序号进行加入
    public void addByOrder(HeroNode2 heroNode) {
        //因为头节点不能动，因此仍然通过辅助指针来帮助找到添加的位置
        //因为是单链表，因此找的temp是位于添加位置的前一个节点，否则无法插入
        HeroNode2 temp = head;
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
            heroNode.pre = temp;
        }
    }

}

//创建一个双向链表的属性类
//定义一个Node，每个Node对象就是一个结点
class HeroNode2 {
    public int no;//英雄编号
    public String name;//英雄名称
    public String nickName;//英雄你成
    public HeroNode2 next;//指向一个结点，默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null


    //构造器
    public HeroNode2(int no, String name, String nickName) {
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
