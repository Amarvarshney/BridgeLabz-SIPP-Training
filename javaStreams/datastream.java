package javaStreams;
import java.io.*;

 class StudentDataStream {
    public static void main(String[] args) {
        String filePath = "student_data.dat";

        // Writing data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);
            System.out.println("Student data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

        // Reading data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.printf("Roll No: %d, Name: %s, GPA: %.2f%n", rollNo, name, gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
