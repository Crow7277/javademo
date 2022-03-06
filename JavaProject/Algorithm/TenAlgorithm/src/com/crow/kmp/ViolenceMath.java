package com.crow.kmp;

public class ViolenceMath {
    public static void main(String[] args) {
        String str1 = "abcdabcd";
        String str2 = "bcd";
        int index = violenceMatch(str1, str2);
        System.out.println(index);
        System.out.println(strStr(str1, str2));
    }

    //暴力匹配
    public static int violenceMatch(String str1, String str2) {
        //解法1：使用暴力递归
        //遍历haystack，对每一位分别判断是否满足needle
        int n = str1.length();
        int m = str2.length();
        char[] sh = str1.toCharArray();
        char[] nh = str2.toCharArray();
        //由于每次遍历的时候都要比哪里nh长度的位置，所以要在sh长度 - nh长度处停止
        for (int i = 0; i <= n - m; i++) {
            int a = i;//指向sh的指针
            int b = 0;//指向nh的指针
            while (b < m && sh[a] == nh[b]) {
                a++;
                b++;
            }
            if (b == m) return i;
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        //KMP法
        int[] next = new int[needle.length()];
        //获取next数组
        getNext(next, needle);
        //通过next数组进行匹配
        char[] sh = haystack.toCharArray();
        char[] nh = needle.toCharArray();
        int j = -1;
        //i遍历原字符串，为了书写方便这里将字符串变成了字符数组
        for (int i = 0; i < sh.length; i++) {
            //不同时需要对模式串的j进行回退
            while (j >= 0 && nh[j + 1] != sh[i]) {
                j = next[j];
            }
            //相同时
            if (nh[j + 1] == sh[i]) {
                j++;
            }
            //如果j到达了字符串末尾说明完全匹配返回索引即可
            if (j == nh.length - 1) {
                return i - j;
            }
        }
        return -1;
    }

    //获取next数组
    public static void getNext(int[] next, String str) {
        //将str字符串转换成一个字符数组便于操作
        char[] s = str.toCharArray();
        //1.初始化，次数使用前缀表减一的写法
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length; i++) {
            //2.处理前后缀不同的情况
            //当前后缀不同的时候，需要将j进行回退
            while (j >= 0 && s[j + 1] != s[i]) {
                j = next[j];
            }
            //3.处理前后缀相同的情况
            if (s[j + 1] == s[i]) {
                j++;
            }
            next[i] = j;
        }
    }
}
