package JavaBasic_03_while_for;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test6_break {
    public static void main(String[] args) {
        o:
        for (int j = 1; j <= 9; j++) {
            if (j == 5) {
                //此处退出到做标记的o处
                break o;
            }
        }
    }
}
