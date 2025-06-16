package controlflow;

import java.util.Scanner;

public class factorofanumberwhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0) {
            int counter = 1;
            System.out.println("Factors of " + number + " are:");
            while (counter <= number) {
                if (number % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
        } else {
            System.out.println("Enter a positive integer.");
        }
    }
}
