import java.util.Scanner;

public class sumofnnatural {
    public static int recursiveSum(int n) {
        if (n <= 1) return n;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number (n > 0).");
            return;
        }

        int sumRecursive = recursiveSum(n);
        int sumFormula = formulaSum(n);

        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula:   " + sumFormula);
        System.out.println("Are both results equal? " + (sumRecursive == sumFormula));
    }
}
