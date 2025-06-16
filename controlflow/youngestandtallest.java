package controlflow;

import java.util.Scanner;

public class youngestandtallest {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ages
        System.out.print("Enter Amar's age: ");
        int ageAmar = input.nextInt();
        System.out.print("Enter Akbar's age: ");
        int ageAkbar = input.nextInt();
        System.out.print("Enter Anthony's age: ");
        int ageAnthony = input.nextInt();

        // Heights
        System.out.print("Enter Amar's height: ");
        double heightAmar = input.nextDouble();
        System.out.print("Enter Akbar's height: ");
        double heightAkbar = input.nextDouble();
        System.out.print("Enter Anthony's height: ");
        double heightAnthony = input.nextDouble();

        // Youngest
        String youngest;
        int minAge = ageAmar;
        youngest = "Amar";
        if (ageAkbar < minAge) {
            minAge = ageAkbar;
            youngest = "Akbar";
        }
        if (ageAnthony < minAge) {
            minAge = ageAnthony;
            youngest = "Anthony";
        }

        // Tallest
        String tallest;
        double maxHeight = heightAmar;
        tallest = "Amar";
        if (heightAkbar > maxHeight) {
            maxHeight = heightAkbar;
            tallest = "Akbar";
        }
        if (heightAnthony > maxHeight) {
            maxHeight = heightAnthony;
            tallest = "Anthony";
        }

        System.out.println("The youngest friend is " + youngest + " with age " + minAge);
        System.out.println("The tallest friend is " + tallest + " with height " + maxHeight);
    }
}
