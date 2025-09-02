public class employee {
    int id;
    String name;
    String department;
    double salary;
    int age;
    public employee(int id,String name,String department, double salary,int age){
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
        this.age=age;
    }   
    public String toString() {
        return name + " (Salary: " + salary + ")";
    }

}


// Employee Management System
// You have a list of Employee objects with fields:
// id, name, department, salary, age.
// Find the highest-paid employee in each department.
// Find the average salary of employees department-wise.
// Group employees into age brackets: <30, 30-40, 40-50, >50.
// Create a comma-separated string of employee names in HR department.
// Partition employees into “High earners” (salary > 50k) and “Low earners” (salary <= 50k).
