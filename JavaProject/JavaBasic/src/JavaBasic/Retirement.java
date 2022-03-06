package JavaBasic;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/7/13.
 */
public class Retirement {
    public static void main(String[] args) {
        //read inputs
        //构建Scanner对象并与System.in关联
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        //update account balance while goal isn't reached
        while (balance < goal) {
            //add this year's payment and interest
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
        }

        System.out.println("You can retire in " + year + "years.");
    }
}
