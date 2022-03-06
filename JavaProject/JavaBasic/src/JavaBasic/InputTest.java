package JavaBasic;

import java.util.Date;
import java.util.Scanner;

/**
 * This program demonstrates console input
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        //get second input
        System.out.print("How old are you? ");
        int age = in.nextInt();

        //System.out.printf("年纪是%d",age);
        System.out.printf("%,.2f\n", 10000.0 / 3.0);
        System.out.printf("%1$s %2$tB %2$te, %2$tY", "Due date: ", new Date());
        //display out on console
        System.out.println("\nHello, " + name + ". Next year, you'll be " + (age + 1));

        String performance;
        int yourSales = 0;
        int target = 1;
        int bouns;

        if (yourSales >= 2 * target) {
            performance = "Excellent";
            bouns = 1000;
        } else if (yourSales >= 1.5 * target) {
            performance = "Fine";
            bouns = 500;
        } else if (yourSales >= target) {
            performance = "Satisfactory";
            bouns = 100;
        } else {
            System.out.println("You're fired");
        }
    }
}
