public class university {
    static String universityName = "Global University";
    static int totalStudents = 0;
    final int rollNumber;
    String name;
    char grade;

    university(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayStudent() {
        if (this instanceof university) {
            System.out.println(name + " (Roll No: " + rollNumber + ") - Grade: " + grade);
        }
    }
}
