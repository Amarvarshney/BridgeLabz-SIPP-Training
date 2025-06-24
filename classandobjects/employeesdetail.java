package classandobjects;

public class employeesdetail {
    String name;
    int id;
    double salary;

    // Constructor
    employeesdetail(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }

    public static void main(String[] args) {
        employeesdetail emp = new employeesdetail("Ravi Kumar", 101, 50000.0);
        emp.displayDetails();
    }
}
