package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/30.
 */
public class Test7 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        for (int arr : c) {
            System.out.println(arr);
        }
    }
}
