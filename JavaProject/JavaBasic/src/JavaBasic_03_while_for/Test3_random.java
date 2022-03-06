package JavaBasic_03_while_for;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test3_random {
    public static void main(String[] args) {
        /*可以使用 Math.random来生成一个0.000000000000到0.99999999999的随机数*/
        int value = (int)(Math.random()*10);
        System.out.println(value);
    }
}
