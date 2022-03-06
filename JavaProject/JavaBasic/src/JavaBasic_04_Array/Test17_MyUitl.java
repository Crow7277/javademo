package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test17_MyUitl {
    /**
     * 冒泡排序
     *
     * @param x 传入要进行排序的int类型数组
     */
    public static void sort(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }
}
