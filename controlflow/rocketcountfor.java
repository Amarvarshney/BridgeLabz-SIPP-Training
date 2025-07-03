package controlflow;

import java.util.Scanner;

public class rocketcountfor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter countdown start number: ");
        int counter = input.nextInt();

        for(int i=counter;i>=0;i--) {
            System.out.println(i);
          
        }

        System.out.println("Liftoff!");
    }
}
