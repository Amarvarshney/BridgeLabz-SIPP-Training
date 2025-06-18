package Arrays;

import java.util.Scanner;

public class frequencyofeachdigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] frequency = new int[10];

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        while (number != 0) {
            int digit = number % 10;
            frequency[digit]++;
            number /= 10;
        }

        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
    }
}
