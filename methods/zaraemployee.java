import java.util.Random;

public class zaraemployee {
    public static int[][] generateEmployeeData(int size) {
        int[][] data = new int[size][2]; // [][0] = salary, [][1] = years of service
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // 5-digit salary
            data[i][1] = rand.nextInt(11); // 0 to 10 years
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(int[][] employees) {
        double[][] updated = new double[employees.length][2]; // [][0] = new salary, [][1] = bonus
        for (int i = 0; i < employees.length; i++) {
            int salary = employees[i][0];
            int years = employees[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            updated[i][1] = bonus;
            updated[i][0] = salary + bonus;
        }
        return updated;
    }

    public static void displayReport(int[][] oldData, double[][] newData) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s\n", "ID", "OldSal", "Years", "Bonus", "NewSal");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            int oldSalary = oldData[i][0];
            int years = oldData[i][1];
            double bonus = newData[i][1];
            double newSalary = newData[i][0];

            totalOld += oldSalary;
            totalBonus += bonus;
            totalNew += newSalary;

            System.out.printf("%-5d %-10d %-10d %-10.2f %-10.2f\n", (i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("Total  %-10.0f %-10s %-10.2f %-10.2f\n", totalOld, "", totalBonus, totalNew);
    }

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData(10);
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        displayReport(employeeData, updatedData);
    }
}
