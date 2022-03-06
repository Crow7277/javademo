package JavaBasic_03_while_for;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test4_dowhile {
    public static void main(String[] args){
        /*do-while 先执行后循环*/
        int i = 0;
        do {
            System.out.println(i);
            i++;
        }while (i<10);
    }
}
