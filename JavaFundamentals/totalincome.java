import java.util.Scanner;

public class totalincome {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter salary in INR: ");
        double salary = input.nextDouble();

        System.out.print("Enter bonus in INR: ");
        double bonus = input.nextDouble();

        double totalIncome = salary + bonus;

        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus +
                           ". Hence Total Income is INR " + totalIncome);
    }
}
