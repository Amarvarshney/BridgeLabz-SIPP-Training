import java.util.Scanner;

public class feeanddiscountpercentagetoamount
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the fee: ");
        int fee = sc.nextInt();
        System.out.println("Enter the discount percentage: ");
        int discount = sc.nextInt();
        double discountamount = (double) (fee * discount) / 100;
        double finalfee = fee - discountamount;
        System.out.println("> The discount amount is INR "+discountamount+"and final discounted fee is INR "+ finalfee);

    }
}