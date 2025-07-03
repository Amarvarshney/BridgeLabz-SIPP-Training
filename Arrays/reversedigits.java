package Arrays;

import java.util.Scanner;

public class reversedigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Count digits
        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];

        // Store digits in array
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Display array in reverse order (i.e., original number reversed)
        System.out.print("Reversed number using array: ");
        for (int digit : digits) {
            System.out.print(digit);
        }
    }
}
