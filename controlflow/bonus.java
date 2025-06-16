package controlflow;

import java.util.Scanner;

public class bonus {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter your years of service: ");
        int years = input.nextInt();

        if (years > 5) {
            double bonus = 0.05 * salary;
            System.out.println("You are eligible for a bonus of INR " + bonus);
        } else {
            System.out.println("You are not eligible for a bonus.");
        }
    }
}
