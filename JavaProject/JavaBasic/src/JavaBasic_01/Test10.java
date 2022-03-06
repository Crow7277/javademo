package JavaBasic_01;

/**
 * User crow7
 * Date 2021/8/28.
 */
public class Test10 {
    public static void main(String[] args) {
        System.out.println(24 % 7);
        System.out.println(10.6 % 5.0);

        /*
         * 练习：
         * 准备一个任意四位整数倒叙输出
         * */
        int value = 1234;
        int anser = 0;
        for (int i = 0; i < 4; i++) {
            anser += value % 10;
            value = value / 10;
            anser = anser *10;
        }
        anser /= 10;
        System.out.println(anser);

    }
}
