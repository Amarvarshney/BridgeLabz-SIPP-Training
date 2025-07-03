package Arrays;

import java.util.Scanner;

public class largestand {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int INITIAL_CAPACITY = 10;

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = INITIAL_CAPACITY;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits and handle dynamic resizing
        while (number != 0) {
            if (index == maxDigit) {
                maxDigit *= 2;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < index; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }

            digits[index] = number % 10;
            number /= 10;
            index++;
        }

        // Find largest and second largest
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + (secondLargest == -1 ? "None" : secondLargest));
    }
}
