import java.util.Scanner;
//kilo
public class ConvertKilometersMiles {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the distance in kilometers: ");
        double km = sc.nextDouble();
        double miles = km * 0.621371;
        System.out.println("The distance in miles is: "+miles);
    }
}
