package Arrays;

import java.util.Scanner;

public class fizzbizz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number > 0) {
            String[] results = new String[number + 1];

            for (int i = 0; i <= number; i++) {
                if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                    results[i] = "FizzBuzz";
                } else if (i % 3 == 0 && i != 0) {
                    results[i] = "Fizz";
                } else if (i % 5 == 0 && i != 0) {
                    results[i] = "Buzz";
                } else {
                    results[i] = Integer.toString(i);
                }
            }

            for (int i = 1; i <= number; i++) {
                System.out.println("Position " + i + " = " + results[i]);
            }
        } else {
            System.out.println("Enter a positive number.");
        }
    }
}
