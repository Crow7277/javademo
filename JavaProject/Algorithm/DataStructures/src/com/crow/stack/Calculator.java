package com.crow.stack;

/**
 * User crow7
 * Date 2021/10/23.
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-2";
        //创建两个栈
        //数栈
        ArrayStack2 numStack = new ArrayStack2(10);
        //运算符栈
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到吃中

        String keepNum = "";//用于拼接多位数

        //开始用while循环扫描expression
        while (true) {
            //一次得到expression每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么做相应的处理
            if (operStack.isOper(ch)) {
                //如果是运算符
                //判断当前符号栈是否为空
                if (!operStack.isEmpty()) {//如果不为空
                    //如果当前操作符优先级小于或等于栈中的操作符，就需要从数栈中pop出两个数，在从符号栈pop出一个运算符进行运算
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //运算的结果入数栈
                        numStack.push(res);
                        //当前符号入运算符栈
                        operStack.push(ch);
                    } else {
                        //如果当前操作符的优先级大于栈中的操作符，直接入运算符栈
                        operStack.push(ch);
                    }
                } else {
                    //如果为空，入符号栈
                    operStack.push(ch);
                }
            } else {//如果是数字，直接入数栈
                //因为字符的在ASCII表中从49开始，所以ch-48就是当前ASCII对应的数字
                //numStack.push(ch - 48);
                /**
                 * 当处理多为数时，不能发现一个数就立即入栈，因为他可能是多位数
                 * 因此在处理数字时，需要想expression的表达式的index后在看一位
                 * 如果是数字就继续扫描
                 * 如果是符号就入栈
                 * 因此需要定义一个变量字符串，用于拼接
                 */
                //处理多位数
                keepNum += ch;
                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是继续扫码，如果不是就入栈
                    //因为是看后一位，所以index不可以++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //情况keepNum
                        keepNum = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当扫描完毕后，顺序的从数栈和运算符栈中pop出相应的数和符号，并运算
        while (true) {
            //如果运算符栈为空，则计算到最后的结果，数栈中只有一个数字
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("表达式是%s = %d\n", expression, numStack.pop());
    }
}

//创建一个栈，直接使用前面创建好的
//需要扩展功能
//1.判断符号优先级
//2.判断扫描的是符号还是运算符
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据放在该数组
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull())
            return;
        top++;
        stack[top] = value;
    }

    //出栈,将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            //抛出长
            throw new RuntimeException("当前栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //返回栈顶
    public int peek() {
        return stack[top];
    }

    //遍历栈,需要从栈顶开始遍历
    public void showStack() {
        if (isEmpty()) return;
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级可以使用数字表示，数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {//目前假定表达式只有加减乘除没有小括号
            return -1;
        }
    }

    //判断是否为运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;//用来存放计算机的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}