package Encapsulation;

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

// Abstract class Employee
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Department implementation
    public void assignDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentDetails() {
        return department;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Concrete method to display details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println("--------------------------");
    }
}

// Subclass: FullTimeEmployee
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

// Subclass: PartTimeEmployee
class PartTimeEmployee extends Employee {
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }
}

// Main class
class Employeesinfo{
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(1, "Alice", 30000, 5000);
        emp1.assignDepartment("HR");

        Employee emp2 = new PartTimeEmployee(2, "Bob", 10000, 40, 200);
        emp2.assignDepartment("IT");

        Employee emp3 = new FullTimeEmployee(3, "Charlie", 35000, 8000);
        emp3.assignDepartment("Finance");

        // Polymorphic list
        Employee[] employees = {emp1, emp2, emp3};

        System.out.println("----- Employee Details -----");
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
