package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test11 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 7, 3, 4, 6, 8, 2, 1, 5};
        /*删除数组中索引为6的元素*/
        /*创建新数组方案*/
        int delIndex = 6;

        /*创建新数组*/
        int[] newArr = new int[arr.length - 1];
        /*处理目标索引之前的数据*/
        for (int i = 0; i < delIndex; i++) {
            newArr[i] = arr[i];
        }
        /*处理目标索引之后的数据*/
        for (int i = delIndex; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + "\t");
        }
        System.out.println();

        /*让arr在栈内存存储的引用地址和newArr相同*/
        arr = newArr;
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
