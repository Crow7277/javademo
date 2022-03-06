package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test8 {
    public static void main(String[] args) {
        /*在下面数组后追加一个元素 9 */
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] newArray = new int[arr.length + 1];

        /*将原数组复制到新数组*/
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        /*将新元素加入数组*/
        newArray[newArray.length - 1] = 9;

        for (int i : newArray) {
            System.out.print(i + "\t");
        }
        System.out.println();
        //将newArray对于堆内存地址的引用赋值给 a
        arr = newArray;
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
