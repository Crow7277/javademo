package com.crow.linkedlist;

import java.util.Stack;

/**
 * stack栈的基本使用
 * User crow7
 * Date 2021/10/21.
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        //入栈
        stack.add("jack");
        stack.add("smith");
        stack.add("tom");
        //出栈
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
