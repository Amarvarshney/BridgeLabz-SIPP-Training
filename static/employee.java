public class employee {
     static String companyName = "TechCorp";
    static int totalEmployees = 0;
    final int id;
    String name, designation;

    employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails() {
        if (this instanceof employee) {
            System.out.println(name + " (" + id + ") - " + designation);
        }
    }
}
