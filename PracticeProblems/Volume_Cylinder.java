import java.util.Scanner;

public class Volume_Cylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of cylinder: ");
        double r = sc.nextDouble();
        System.out.println("Enter height of cylinder: ");
        double h = sc.nextDouble();
        double volume = (22/7)*r*r*h;
        System.out.println("Volume of cylinder is: "+volume);
        
    }
}
