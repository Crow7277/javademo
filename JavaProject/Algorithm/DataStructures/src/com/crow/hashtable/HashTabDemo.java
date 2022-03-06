package com.crow.hashtable;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/11/4.
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建一个哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Employee employee = new Employee(id, name);
                    hashTab.add(employee);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmployeeById(id);
                    break;
                case "del":
                    System.out.println("请输入要删除的id");
                    id = scanner.nextInt();
                    hashTab.del(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//雇员类
class Employee {
    public int id;
    public String name;
    public Employee next;//next默认为空

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建哈希表，管理多条链表
class HashTab {
    private EmployeeLinkedList[] employeeLinkedListArray;
    private final int size;//表示有多少跳链表

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化链表数组，此时仅仅是创建了大小为size的数组空间
        //因为是哈希表，所以每个数组空间对应元素都应该是一条链表，因此，每一条链表也需要初始化
        employeeLinkedListArray = new EmployeeLinkedList[size];
        //需要初始化每一条链表
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    //添加雇员
    public void add(Employee emp) {
        //根据员工id，得到该员工应该添加到哪条链表中
        int empLikedListNO = hashFun(emp.id);
        //添加到对应链表中
        employeeLinkedListArray[empLikedListNO].add(emp);
    }

    //遍历所有链表，也就是遍历哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i].list(i);
        }
    }

    //编写一个散列函数，此处使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }

    //根据输入的id查找雇员
    public void findEmployeeById(int id) {
        int empLinkedListNO = hashFun(id);
        Employee employee = employeeLinkedListArray[empLinkedListNO].findEmployeeById(id);
        if (employee != null) {
            System.out.printf("在第%d条链表中找到雇员，id = %d\n", empLinkedListNO, employee.id);
        } else {
            System.out.println("在哈希表中没有找到");
        }
    }

    //根据输入的id删除雇员
    public void del(int id) {
        int eNo = hashFun(id);
        employeeLinkedListArray[eNo].del(id);
    }
}

//链表类
class EmployeeLinkedList {
    //头指针，执行第一个Employee，因此指向第一个Employee
    private Employee head;//默认为null

    //添加雇员到链表
    //1.假定，当添加雇员时，id自增长，id分配重视从小到大，因此将该雇员直接加入到本链表的最后即可
    public void add(Employee emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个复制指针帮助定位到最后
        Employee curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp加入到链表
        curEmp.next = emp;
    }

    //遍历雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.print("第" + no + "条链表的信息为：");
        Employee curEmp = head;
        while (true) {
            System.out.printf("=> id = %d name = %s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id查找雇员
    //如果查找到返回Employee，如果没有返回null
    public Employee findEmployeeById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                //说明未找到，将curEmp置空
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    //删除指定雇员（根据id）
    public void del(int id) {
        if (head == null) {
            System.out.println("当前链表为空");
            return;
        }
        Employee p = head;//快指针
        Employee q = head;//慢指针
        while (true) {
            if (p.id == id) {//当当前指针的id为指定id时退出循环
                break;
            }else if (p.next == null) {//当查找到最后一个元素仍然不是时，退出循环
                System.out.println("未找到要删除的雇员");
                return;
            }
            q = p;//慢指针指向p
            p = p.next;//p指向下一个指针
        }
        //如果头结点为所指需要删除结点，将头结点指向p.next，这时如果后面有，就指向了之后的，如果没有就是null
        if (head == p){
            head = p.next;
        }
        //删除目标元素
        q.next = p.next;
    }
}

