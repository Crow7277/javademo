package JavaBasic_04_Array;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test3 {
    public static void main(String[] args) {
        int arr[] = new int[]{56, 51, 42, 39, 50, 30, 82, 95};
        /*
         * 数组的索引
         * 索引：多个数据虽然使用一个标识符，但是每个数据都有自己的编号
         * 索引由数组自动生成并维护，默认第一个元素的索引为0，后面的依次递增
         * */
        System.out.println(arr[3]);

        // 取出元素给其他变量赋值
        int i = arr[2];

        // 修改数组中的元素
        arr[2] = 100;

        // 确定索引的范围
        // 使用数组长度属性
        int count = arr.length;
        System.out.println("数组的最大索引：" + (count - 1));
    }
}
