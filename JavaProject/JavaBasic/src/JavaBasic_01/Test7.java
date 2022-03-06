package JavaBasic_01;

/**
 * User crow7
 * Date 2021/8/28.
 */
public class Test7 {
    public static void main(String[] args) {
        //字符型
        //使用char可以放一个字符，可以是一个英文字母，一个汉字等，但是只能存储一个，使用单引号包裹字符
        char c = 'n';
        System.out.println(c);
        //转义字符虽然写法上位多个符号，存储上认为单个字符
        //单引号
        char a = '\'';
        //反斜线
        a = '\\';
        //横向条格，对应tab制表符
        a = '\t';
        System.out.println("asfgwqgw\tdagaba");
        //删除
        System.out.println("asfgwqgw\bdagaba");
        //光标回到最前
        System.out.println("asfgwqgw\rdagaba");
        //换行
        System.out.println("asfgwqgw\ndagaba");
    }
}