import java.util.Scanner;

public class athlete {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side1 in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side2 in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side3 in meters: ");
        double side3 = input.nextDouble();

        double perimeter = side1 + side2 + side3;
        double totalDistanceMeters = 5000;

        double rounds = totalDistanceMeters / perimeter;

        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }
}
