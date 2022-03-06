package com.crow.LeetCodeTest;

/**
 * User crow7
 * Date 2021/11/2.
 */
public class Arraytest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int j = removeElement(nums, 2);
        for (int i = 0; i < j; i++) {
            System.out.println(nums[i]);
        }

    }

    public static int removeDuplicates(int[] nums) {
        //使用快慢指着
        int slow = 0;
        //首先快指针和慢指针同时指向一个元素
        for (int fast = 0; fast < nums.length; fast++) {
            //当元素快指针和慢指针元素相等时，只移动快指针
            //当元素不等时，先将慢指针加一，然后将快指针的元素copy过去
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        //由于是先移动慢指针，再进行数据平移，所以slow所指位置为最后一个元素的位置，
        //而非元素的总个数，因为是从0开始数的，因此为了返回总个数需要将slow+1
        return slow + 1;
    }

    public static int removeElement(int[] nums, int val) {
        //使用快慢指针
        int fast = 0;//快指针
        int slow = 0;//慢指针
        //快指针遍历数组
        for (fast = 0; fast < nums.length; fast++) {
            //当找不到目标值的时候，快慢指针一起向后遍历
            //当找到目标值时，快指针继续遍历，慢指针停留在目标值处
            //用快指针覆盖慢指针，完成数组的平移也就是删除，之后继续一起遍历
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        //慢指针所在位置就是新数组的长度
        return slow;
    }
}