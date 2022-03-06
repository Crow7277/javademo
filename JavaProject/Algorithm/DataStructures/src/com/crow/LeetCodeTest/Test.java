package com.crow.LeetCodeTest;

import java.util.HashMap;

/**
 * User crow7
 * Date 2021/11/5.
 */
public class Test {
}

class Solution3 {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0)
            return 0;
        //使用滑动窗口
        int left = 0;
        int result = 0;//最多的长度
        //使用哈希表记录，水果，key为水果的种类，value为出现的频度
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            //右边界
            //map.getOrDefault表示获取key对应的value，如果不存在这个key，使用默认值defaultValue
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {//当map中key的个数超过了两个，此时需要移动左边界
                map.put(fruits[left], map.get(fruits[left]) - 1);//将此时left对应的这个水果的种类-1，之后移动left
                if (map.get(fruits[left]) == 0) {//如果left所在种类对应的频度为0，直接删除这个种类（滑动窗口）
                    map.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);//取最大值
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

//滑动窗口
class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;//左指针
        int sum = 0;//当前窗口的和
        int len = 0;//数组长度
        int result = Integer.MAX_VALUE;//最终长度
        for (int right = 0; right < nums.length; right++) {//右指针向右遍历
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);//这里的代码相当于下面取最小值
                //此时需要将左指针移动，就像是一个窗口一样
                //因此在移动左指针的时候，需要减去当前左指针所在位置，然后在移动
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

//暴力求解
class Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        //准备两个for循环，遍历出符合结果子数组
        int len = 0;//当前满足条件长度
        int minLen = nums.length;//最小长度子串
        boolean flag = false;//判断minLen是否改变
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp >= target) {
                    len = j - i + 1;
                    if (len <= minLen) {
                        minLen = len;
                        flag = true;
                    }
                    break;
                }
            }
        }
        if (flag)
            return minLen;
        else
            return 0;
    }
}