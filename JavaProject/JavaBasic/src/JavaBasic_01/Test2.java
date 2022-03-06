package JavaBasic_01;

/**
 * User crow7
 * Date 2021/8/28.
 */
public class Test2 {
    //成员变量 至少可以在当前类的所有方法中使用
    static int z = 100;
    public static void main(String[] args) {
        //局部变量 声明在方法中，当前方法内部
        int i = 10;

        for (int x = 1; x >= 10; x++) {
            //局部变量 声明在循环结构内部，仅仅在当前循环内部可以使用
            int y = 10;
        }
    }
}
