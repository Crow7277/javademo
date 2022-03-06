package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test12 {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 4, 5, 6, 85, 54, 74, 95, 65, 82, 26, 34};
        /*先计算出arr中偶数与奇数的个数*/
        int osCount = 0, jsCount = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                osCount++;
            } else {
                jsCount++;
            }
        }
        /*偶数数组*/
        int[] os = new int[osCount];
        /*奇数数组*/
        int[] js = new int[jsCount];
        int a = 0, b = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                os[a] = i;
                a++;
            } else {
                js[b] = i;
                b++;
            }
        }
        /*遍历奇数与偶数数组*/
        for (int i : os) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i : js) {
            System.out.print(i + "\t");
        }
    }
}
