package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/8/31.
 */
public class Test2_Method_Exercise05 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(getArraySum(arr));
        System.out.println(getArrayMax(arr));
        System.out.println(getArrayMin(arr));
        System.out.println(getArrayAvg(arr));
    }

    /*
     * 定义一个方法返回一个整数数组元素的和
     * */
    public static int getArraySum(int[] arr) {
        int sum = 0;
        for (int x:arr){
            sum += x;
        }
        return sum;
    }
    /*
    * 定义一个方法返回这个整数数组元素最大值
    * */
    public static int getArrayMax(int[] arr) {
        int max = arr[0];
        for (int x : arr){
            if (max < x){
                max = x;
            }
        }
        return max;
    }
    /*
     * 定义一个方法返回这个整数数组元素最小值
     * */
    public static int getArrayMin(int[] arr) {
        int min = arr[0];
        for (int x : arr){
            if (min < x){
                min = x;
            }
        }
        return min;
    }
    /*
     * 定义一个方法返回这个整数数组元素的平均值
     * */
    public static double getArrayAvg(int[] arr) {
        int sum = getArraySum(arr);
        return sum/arr.length;
    }
}
