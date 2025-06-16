package controlflow;

import java.util.Scanner;

public class sumofnnatural {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            return;
        }

        // Sum using formula
        int formulaSum = n * (n + 1) / 2;

        // Sum using for loop
        int loopSum = 0;
        for (int i = 1; i <= n; i++) {
            loopSum += i;
        }

        System.out.println("Sum using loop: " + loopSum);
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Both results are " + (loopSum == formulaSum ? "equal." : "not equal."));
    }
}
