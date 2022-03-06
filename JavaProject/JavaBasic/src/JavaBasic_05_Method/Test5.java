package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test5 {
    public static void main(String[] args) {
        int x = 10;
        change(x);
        // 此时x仍然为10
        System.out.println(x);
    }
    public static void change(int a){
        a = 100;
    }
}
