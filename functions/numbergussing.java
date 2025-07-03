package functions;

import java.util.Scanner;

public class numbergussing {
    

    static int generateGuess(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }

    static String getUserFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "? (Enter: 'low', 'high', 'correct')");
        return sc.nextLine().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        boolean found = false;

        System.out.println("Think of a number between 1 and 100. I will try to guess it!");

        while (!found && low <= high) {
            int guess = generateGuess(low, high);
            String feedback = getUserFeedback(sc, guess);

            switch (feedback) {
                case "low":
                    low = guess + 1;
                    break;
                case "high":
                    high = guess - 1;
                    break;
                case "correct":
                    System.out.println("Yay! I guessed your number: " + guess);
                    found = true;
                    break;
                default:
                    System.out.println("Please enter 'low', 'high', or 'correct'.");
            }
        }

        if (!found) {
            System.out.println("Hmm... something went wrong!");
        }

        sc.close();
    }
}
