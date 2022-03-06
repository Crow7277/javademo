package JavaBasic_03_switch;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test1_switch {
    public static void main(String[] args) {
        /*switch语句*/
        int month = 10;
        switch (month) {
            case 1:
            case 3:
            case 2:
                System.out.println("冬季");
                break;
            case 4:
            case 6:
            case 5:
                System.out.println("春季");
                break;
            case 7:
            case 9:
            case 8:
                System.out.println("夏季");
                break;
            case 10:
            case 12:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("月份有误");
                break;
        }
    }
}
