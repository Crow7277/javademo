package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test5 {
    public static void main(String[] args) {
        int arr[] = new int[]{56, 51, 42, 39, 50, 30, 82, 95};
        /*数组的遍历*/
        /*使用for循环*/
        for (int i = 0;i<=arr.length-1;i++){
            System.out.println(arr[i]);
        }

        System.out.println("==========================");

        /*
        * 使用增强型for循环遍历
        *
        * for each循环，针对数组的for循环，简化for循环
        * for（数据类型 临时变量名：数组名）
        * */
        for(int a : arr){
            System.out.println(a);
        }

    }
}
