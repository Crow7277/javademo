package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test10 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 7, 3, 4, 6, 8, 2, 1, 5};
        /*删除数组中索引为6的元素*/
        /*移动元素方案*/
        int delIndex = 6;
        /*准备一个有效元素统计变量*/
        int size = arr.length;
        /*从删除的位置开始向前移动元素*/
        for (int i = delIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        /*将最后一个闲置元素位置为0*/
        arr[arr.length - 1] = 0;
        size--;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
