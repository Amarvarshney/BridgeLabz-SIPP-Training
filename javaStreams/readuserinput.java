package javaStreams;
import java.io.*;
import java.util.Scanner;
 class UserInputToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, language;
        int age;

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter your favorite programming language: ");
        language = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_info.txt"))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Age: " + age);
            writer.newLine();
            writer.write("Favorite Language: " + language);
            System.out.println("User information saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        scanner.close();
    }
}
