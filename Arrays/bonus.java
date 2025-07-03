package Arrays;

import java.util.Scanner;

public class bonus {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int EMP_COUNT = 10;
        
        double[] salaries = new double[EMP_COUNT];
        double[] years = new double[EMP_COUNT];
        double[] bonuses = new double[EMP_COUNT];
        double[] newSalaries = new double[EMP_COUNT];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < EMP_COUNT; ) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            double salary = sc.nextDouble();
            System.out.print("Enter years of service of employee " + (i + 1) + ": ");
            double year = sc.nextDouble();

            if (salary <= 0 || year < 0) {
                System.out.println("Invalid input. Please re-enter.");
                continue;
            }

            salaries[i] = salary;
            years[i] = year;
            i++;
        }

        for (int i = 0; i < EMP_COUNT; i++) {
            double bonus = (years[i] > 5) ? salaries[i] * 0.05 : salaries[i] * 0.02;
            bonuses[i] = bonus;
            newSalaries[i] = salaries[i] + bonus;

            totalBonus += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\n--- Bonus Summary ---");
        System.out.println("Total Bonus Paid: ₹" + totalBonus);
        System.out.println("Total Old Salary: ₹" + totalOldSalary);
        System.out.println("Total New Salary: ₹" + totalNewSalary);
    }
}
