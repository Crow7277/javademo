package JavaBasic_02_if;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test1_ifDemo {
    public static void main(String[] args) {
        /*给定一个整数，判断是奇数还是偶数*/
        int i = 16;
        /*当括号中条件成立，则执行分支一的代码，否者执行分支二的代码*/
        if (i % 2 == 0) {
            System.out.println("是偶数");
        } else {
            System.out.println("是奇数");
        }
    }
}
