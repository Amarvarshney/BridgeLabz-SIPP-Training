package Workshop;

import java.util.Scanner;

public class StudentGrades {

    static class Student {
        String name;
        int id;
        int[] grades;

        Student(String name, int id, int subjects) {
            this.name = name;
            this.id = id;
            this.grades = new int[subjects];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            int numStudents = sc.nextInt();
            System.out.print("Enter number of subjects: ");
            int numSubjects = sc.nextInt();

            Student[] students = new Student[numStudents];

            for (int i = 0; i < numStudents; i++) {
                sc.nextLine(); // consume newline
                System.out.println("Enter details for Student " + (i + 1));
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("ID: ");
                int id = sc.nextInt();

                students[i] = new Student(name, id, numSubjects);

                for (int j = 0; j < numSubjects; j++) {
                    boolean valid = false;
                    while (!valid) {
                        try {
                            System.out.print("Enter grade for Subject " + (j + 1) + ": ");
                            int grade = sc.nextInt();
                            if (grade < 0 || grade > 100) {
                                throw new IllegalArgumentException("Grade must be between 0 and 100");
                            }
                            students[i].grades[j] = grade;
                            valid = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }

            System.out.println("\n--- Student Totals & Averages ---");
            for (Student student : students) {
                int total = 0;
                int count = 0;
                for (int grade : student.grades) {
                    total += grade;
                    count++;
                }
                double average = (count == 0) ? 0 : (double) total / count;
                System.out.println("Student: " + student.name + ", ID: " + student.id);
                System.out.println("Total: " + total + ", Average: " + average);
            }

            System.out.println("\n--- Highest Grade in Each Subject ---");
            for (int j = 0; j < numSubjects; j++) {
                int highest = -1;
                for (Student student : students) {
                    if (j < student.grades.length) {
                        if (student.grades[j] > highest) {
                            highest = student.grades[j];
                        }
                    }
                }
                if (highest == -1) {
                    System.out.println("Subject " + (j + 1) + ": No records.");
                } else {
                    System.out.println("Subject " + (j + 1) + ": " + highest);
                }
            }

            System.out.println("\n--- Overall Class Average ---");
            int totalGrades = 0;
            int totalSubjects = 0;
            for (Student student : students) {
                for (int grade : student.grades) {
                    totalGrades += grade;
                    totalSubjects++;
                }
            }
            double classAverage = (totalSubjects == 0) ? 0 : (double) totalGrades / totalSubjects;
            System.out.println("Class Average: " + classAverage);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
