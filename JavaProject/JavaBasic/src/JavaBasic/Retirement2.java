package JavaBasic;

import java.util.Scanner;

/**
 * User crow7
 * Date 2021/7/13.
 */
public class Retirement2 {
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
        String input;

        //update account balance while goal isn't reached
        do {
            //add this year's payment and interest
            balance -= payment;
            double interest = balance * interestRate / 100;
            balance -= interest;
            year++;

            //print current balance
            System.out.printf("After year %d, your balance is %,.2f%n", year, balance);

            //ask if ready to retire and get inpu
            System.out.print("Read to retire?(Y/N) ");
            input = in.next();
        } while (input.equals("N"));

        System.out.println("You can retire in " + year + "years.");
    }
}
