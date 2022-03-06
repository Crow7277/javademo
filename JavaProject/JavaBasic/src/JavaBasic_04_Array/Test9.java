package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test9 {
    public static void main(String[] args) {
        /*在任意索引处插入一个元素*/
        int[] arr = {5, 7, 6, 10, 4, 2, 3, 1, 8, 9};
        /*要插入元素索引的位置*/
        int x = 3;
        /*要插入的元素*/
        int value = 100;
        int j = 0;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i == x) {
                newArr[j] = value;
                j++;
            }
            newArr[j] = arr[i];
            j++;
        }
        for (int i : newArr) {
            System.out.print(i + "\t");
        }

        System.out.println();

        arr = newArr;
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
