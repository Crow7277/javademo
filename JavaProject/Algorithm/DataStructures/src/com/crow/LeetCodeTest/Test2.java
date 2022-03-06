package com.crow.LeetCodeTest;

import java.util.HashMap;
import java.util.Map;

/**
 * User crow7
 * Date 2021/11/6.
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int left = 0;//左指针
        int right = 0;//右指针
        int len = Integer.MAX_VALUE;//记录最短长度
        int startlen = 0;//截断起始位置
        //使用哈希表来存储t字符串，此时，Key为t字符串中所存在的元素
        //Value为出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        //将字符串s的元素存放到HashMap中
        for (int i = 0; i < t.length(); i++) {
            //让t中出现的字符对应的value都为1
            //当右指针指到一次对应字符时，就让其加一，移动左边指针移动过存在的字符时就让对应的减一
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            // map.containsKey(key)方法判断是否有对应key的Value
            if (map.containsKey(s.charAt(right))) {
                //如果存在的话，将其值减一
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
            }
            right++;
            //判断窗口是否已经包含所有的元素
            //此时创建一个方法check来检查是否已经包含所有元素，由于元素有可能重复
            //所以Value可能为负数，但是当其大于0的时候相当于没有包含素有元素
            //也就是说，当所有的key对应的value<=0时，包含所有元素，当其任意一个于零时就没有包含所有元素
            while (check(map)) {
                //当窗口包含所有的元素时
                //由于最后要截断窗口，所以需要窗口起始位置
                //此处由于len最终是用于截取，所以不需要额外减一
                if (len > right - left) {
                    len = right - left;
                    //由于之后left要向右移动所以此时将left赋值给起始位置
                    startlen = left;
                }
                if (map.containsKey(s.charAt(left))) {
                    //将left所在元素
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(startlen, startlen + len);
    }

    //检查窗口是否把字符串t中的所有字符都覆盖了，如果map中所有
    // value的值都不大于0，则表示全部覆盖
    private static boolean check(HashMap<Character, Integer> map) {
        for (int value : map.values()) {
            //注意这里的value是可以为负数的，为负数的情况就是，相同的字符右
            // 指针扫描的要比t中的多，比如t是"ABC"，窗口中的字符是"ABBC"
            if (value > 0)
                return false;
        }
        return true;
    }
}


