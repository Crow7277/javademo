package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test16 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 6},
                {7, 8, 9}
        };
        int[][] arr1 = new int[3][3];
        int[][] arr2 = new int[3][];
        arr2[0] = new int[2];
        arr2[1] = new int[3];
        arr2[2] = new int[4];
        System.out.println(arr2.length);
        System.out.println(arr2[0].length);
        System.out.println(arr2[1].length);
        System.out.println(arr2[2].length);
        /*二维数组遍历*/
        /*从arr中取出每个小数组*/
        for (int i = 0; i < arr.length; i++) {
            /*从每个小数组中取出元素*/
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        /*foreach*/
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
