import java.util.Scanner;

public class Celsius {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " degree");
        
    }
}