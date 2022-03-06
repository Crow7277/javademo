package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Test12_overLoad_Exercise {
    public static void main(String[] args) {
        double perimeter = lCicle(10, 10);
        System.out.println(perimeter);
        double areas = sCicle(3, 4, 5);
        System.out.println(areas);
    }

    //圆的周长
    public static double lCicle(int r) {
        return 2 * Math.PI * r;
    }

    //圆的面积
    public static double sCicle(int r) {
        return Math.PI * r * r;
    }

    //矩形周长
    public static double lCicle(int a, int b) {
        return 2 * a + 2 * b;
    }

    //矩形面积
    public static double sCicle(int a, int b) {
        return a * b;
    }

    //三角形周长
    public static double lCicle(int a, int b, int c) {
        //三角形两边之和大于第三边
        if (a + b > c && a + c > b && b + c > a) return a + b + c;
        return -1;
    }

    //三角形面积
    public static double sCicle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            double p = (a + b + c) / 2.0;
            double s = p * (p - a) * (p - b) * (p - c);
            return Math.sqrt(s);
        }
        return -1;
    }

}
