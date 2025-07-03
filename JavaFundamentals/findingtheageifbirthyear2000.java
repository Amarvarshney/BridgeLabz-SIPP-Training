import java.util.Scanner;

public class findingtheageifbirthyear2000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your birth year");
        int birthYear = sc.nextInt();
        int currentYear = 2024;
        int age = currentYear - birthYear;
        System.out.println("Your age is " + age);
    }
}