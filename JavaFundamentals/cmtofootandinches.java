package dailypratice1;

import java.util.Scanner;

public class cmtofootandinches {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the value in centimeter");
        int cm = sc.nextInt();
        double inch = (double) (cm * 1) / 2.54;
        double foot = (double) (inch)/12;
        System.out.println("Your Height in cm is " +cm + " while in feet is " +foot+ " and inches is " +inch);       
    }
}