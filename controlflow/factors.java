package controlflow;

import java.util.Scanner;

public class factors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
