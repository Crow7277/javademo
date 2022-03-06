package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test11_overload {
    public static void main(String[] args) {
        a();
        a(10);
    }
    /*
    * 在一个类中，让多个方法同名是允许的，但是有条件
    * */
    public static void a(){
        System.out.println("方法一");
    }
    public static void a(int i){
        System.out.println("方法二");
    }
    public static void b(int[] arr){}
    public static void b(int arr){}
}
