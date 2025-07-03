package functions;

import java.util.Scanner;

public class maximumofthree {
    

    
    static int takeInput(Scanner sc, String label) {
        System.out.print("Enter " + label + " number: ");
        return sc.nextInt();
    }

    static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = takeInput(sc, "first");
        int b = takeInput(sc, "second");
        int c = takeInput(sc, "third");

        int max = findMax(a, b, c);
        System.out.println("Maximum number is: " + max);

        sc.close();
    }
}

