package com.crow.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User crow7
 * Date 2021/10/23.
 */
public class PolandNotation {
    public static void main(String[] args) {
        /**
         * 完成将中缀表达式转换为后缀表达式的功能
         * 1.1+((2+3)*4)-5 转换成 1 2 3 + 4 * + 5 -
         * 2.因为直接对字符串进行操作不方便，因此需要先将字符串转成一个中缀表达式对应的List
         *   即1+((2+3)*4)-5 -> ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
         * 3.将得到的中缀表达式对应的List转换为后缀表达式对应的List
         *   即ArrayList[1, 2, 3, +, 4, *, +, 5, -](小括号被消除了)
         */
        String expression = "1+((2+3)*4)-5";
        System.out.println("中缀表达式对应的list");
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        System.out.println("后缀表达式对应的list");
        list = parseSuffixExpressionList(list);
        System.out.println(list);



/*
        //先定义一个逆波兰表达式
        //(3+4)x5-6
        //为了方便，逆波兰表达式中的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1.先将"3 4 + 5 * 6 -"放入到ArrayList中
        //2.将ArrayList传递给一个方法，遍历ArrayLis，配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        int res = calculate(rpnList);
        System.out.println(res)
 */
    }

    //方法：将得到的中缀表达式List转换为对应的后缀表达式List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>();//符号栈
        //存储中间结果的栈，由于s2在整个转换过程并没有出现弹栈（pop）操作，
        //而且还要进行逆序输出，因此可以使用ArrayList代替
        //Stack<String> s2 =new Stack<String >();
        List<String> s2 = new ArrayList<String>();
        //遍历ls
        for (String item : ls) {
            //如果是一个数字，入栈s2，此处使用正则表达式实现
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号，依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号位置，此时将括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将左括号弹出，消除括号
            } else {
                //item的优先级 <= 栈顶运算符的优先
                //将s1栈顶运算符弹出压入到s2,再重新与栈顶晕渲法优先级进行对比
                //自定义Operation类来返回运算符的优先级
                while (s1.size() != 0 &&
                        Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈顶
                s1.push(item);
            }
        }
        //将s1剩余的元素依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        //因为存放在List中，所以直接顺序遍历就是逆波兰表达式
        return s2;
    }

    //将中缀表达式转换为List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List存放中缀表达式对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0;//这是一个指针，用于遍历中缀表达式字符串
        String str;//做对多为数的拼接工作
        char c;//每遍历到一个循环，就放入到c
        do {
            //如果c是一个非数字，就需要加入到ls中
            if (((c = s.charAt(i)) < 48) || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {//如果是一个数，需要考虑多位数的问题
                str = "";//先将str置为空串
                //判断数字是否为多位数
                //判断条件，i<字符串的长度 且 i 是数字，就一直循环下去直到i超过字符串长度或者为符号
                //因为式子中不可能存在数字和数字连续的，如果数字和数字连续，那一定是一个多位数
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //将一个逆波兰表达式，依次将数据和运算符让入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
    //完成对逆波兰表达式的运算

    /**
     * 1. 从左至右扫描，将3和4压入堆栈
     * 2. 遇到+运算符，弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得到7，将7入栈
     * 3. 将5入栈
     * 4. x运算符，因此弹出5和7，计算出7 x 5 = 35，将35入栈
     * 5. 将6入栈
     * 6. 最后是 - 运算符，计算出35 - 6的值，即29，得出最终结果
     */
    public static int calculate(List<String> ls) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历List
        for (String item : ls) {
            //使用正则表达式取出数,/d表示匹配一个数字，是0-9的简写，+表示 表示匹配一个或多个数字
            if (item.matches("\\d+")) {//匹配多位数
                //入栈
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类，返回运算符对应优先级
class Operation {
    private static int ADD = 1;// +
    private static int SUB = 1;// -
    private static int MUL = 2;// *
    private static int DIV = 2;// /

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在运算符");
                break;
        }
        return result;
    }
}
