import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class emplyessdata {
    public static void main(String[] args) {
         List<employee> employees = Arrays.asList(
            new employee(1, "Alice", "HR", 48000, 29),
            new employee(2, "Bob", "Engineering", 75000, 35),
            new employee(3, "Charlie", "Engineering", 50000, 42),
            new employee(4, "Diana", "HR", 51000, 45),
            new employee(5, "Eve", "Sales", 47000, 31),
            new employee(6, "Frank", "Sales", 55000, 38),
            new employee(7, "Grace", "Engineering", 88000, 41),
            new employee(8, "Heidi", "HR", 60000, 52)
        );
        System.out.println("1. Highest-paid employee in each department:");
        Map<String, Optional<employee>> highestPaid = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.maxBy(Comparator.comparingDouble(e -> e.salary))
            ));
        highestPaid.forEach((dept, emp) ->
            System.out.println(dept + ": " + emp.get().name + " with salary " + emp.get().salary)
        );

        System.out.println("\n2. Average salary department-wise:");
        Map<String, Double> averageSalary = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.averagingDouble(e -> e.salary)
            ));
        averageSalary.forEach((dept, avg) ->
            System.out.printf("%s: Average Salary = %.2f%n", dept, avg)
        );
    }
}
