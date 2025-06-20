import java.util.Scanner;

public class Athlete {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distanceToRun = 5000; // 5 km in meters
        return distanceToRun / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 of triangle in meters: ");
        double s1 = sc.nextDouble();
        System.out.print("Enter side 2 of triangle in meters: ");
        double s2 = sc.nextDouble();
        System.out.print("Enter side 3 of triangle in meters: ");
        double s3 = sc.nextDouble();

        double rounds = calculateRounds(s1, s2, s3);
        System.out.printf("The athlete must complete %.2f rounds to run 5km.\n", rounds);
    }
}
