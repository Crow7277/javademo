package JavaBasic_02_if;

/*导入Scanner包*/
import java.util.Scanner;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test4_input {
    public static void main(String[] args) {
        /*创建一个扫描仪对象*/
        Scanner sc = new Scanner(System.in);

        /*用键盘输入*/
        /*用键盘接受一个整数*/
        System.out.println("请输入一个整数：");
        int b = sc.nextInt();
        System.out.println("现在输入的是：" + b);

        /*用键盘输入一个浮点数*/
        System.out.println("请输入一个小数：");
        double d = sc.nextDouble();
        System.out.println("现在输入的是："+d);

        /*键盘输入一个文字*/
        System.out.println("请输入一段文字：");
        String s = sc.next();
        System.out.println("现在输入的是：");

        /*输入文字带入空格*/
        /*但是nextLine需要在最头部接收，前面不能有任何输出语句*/
        System.out.println("请输入一段文字：");
        String s1 = sc.nextLine();
        System.out.println("现在输入的是：");

        /*释放资源，关闭扫描仪*/
        sc.close();
    }
}
