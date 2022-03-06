package JavaBasic_02_if;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test2_ifDemo {
    public static void main(String[] args) {
        /*给定一个整数，如果是3的倍数输出乒，如果是5的倍数输出乓，如果是3和5的倍数，输出乒乓，否则输出数字本身*/
        int i = 13;
        /*当括号中条件成立，则执行分支一的代码，否者执行分支二的代码*/
        if (i % 3 == 0) {
            System.out.println("乓");
        } else if (i % 5 == 0) {
            System.out.println("乒");
        } else if (i % 3 == 0 && i % 5 == 0) {
            System.out.println("乒乓");
        } else {
            System.out.println(i);
        }
    }
}
