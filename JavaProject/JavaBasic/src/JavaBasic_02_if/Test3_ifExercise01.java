package JavaBasic_02_if;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test3_ifExercise01 {
    /*
     * if-else练习
     * 春季播种
     * 夏季吃烧烤
     * 秋季秋收
     * 冬季睡觉
     * */
    public static void main(String[] args) {
        int mounth = 12;
        if (mounth > 0 && mounth <= 3) {
            System.out.println("睡觉");
        } else if (mounth > 3 && mounth <= 6) {
            System.out.println("播种");
        } else if (mounth > 6 && mounth <= 9) {
            System.out.println("吃烧烤");
        } else if (mounth > 9 && mounth <= 12) {
            System.out.println("秋收");
        } else {
            System.out.println("请输入正确的月份");
        }
    }
}
