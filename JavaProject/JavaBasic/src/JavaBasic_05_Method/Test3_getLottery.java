package JavaBasic_05_Method;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test3_getLottery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLottery()));
    }

    public static int[] getLottery() {
        int[] lottery = new int[6];
        for (int i = 0; i < 6; i++) {
            int num = (int) (Math.random() * 33 + 1);
            //判断是否包含
            while (isContain(lottery, num)) {
                /*重新生成数字*/
                num = (int) (Math.random() * 33 + 1);
            }
            lottery[i] = num;
        }
        Arrays.sort(lottery);
        int[] lottery2 = new int[7];
        System.arraycopy(lottery, 0, lottery2, 0, 6);
        lottery2[6] = (int) (Math.random() * 16 + 1);
        return lottery2;
    }

    /**
     * 用于判断给定的数组中是否包含指定的元素
     *
     * @param arr 给定的数组
     * @param b   要查找的元素
     * @return 找到返回true，未找到返回false
     */
    public static boolean isContain(int[] arr, int b) {
        for (int i : arr) {
            if (i == b) {
                return true;
            }
        }
        return false;
    }
}
