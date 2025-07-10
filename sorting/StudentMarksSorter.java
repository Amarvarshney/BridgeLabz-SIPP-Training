package sorting;

import java.util.Arrays;

public class StudentMarksSorter {

    // Bubble Sort Implementation
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap if out of order
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: Stop if no swaps in this pass
            if (!swapped) break;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] studentMarks = {85, 74, 91, 66, 78, 89, 92};

        System.out.println("Original Marks: " + Arrays.toString(studentMarks));

        bubbleSort(studentMarks);

        System.out.println("Sorted Marks (Ascending): " + Arrays.toString(studentMarks));
    }
}

