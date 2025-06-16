package controlflow;

import java.util.Scanner;

public class factorialwhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Please enter a natural number (> 0).");
            return;
        }

        int sum = 0, i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }

        int formulaSum = n * (n + 1) / 2;

        System.out.println("Sum using while loop: " + sum);
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Both results are " + (sum == formulaSum ? "correct and equal." : "not equal."));
    }
}
