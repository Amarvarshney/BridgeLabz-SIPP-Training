import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class courseManger {
    private static final int max_student=50;
    private Map<String ,List<Integer>> enrollment=new HashMap<>();
    private Set<String> fullCourses = new HashSet<>();
    public void enrollStudent(int studentId, String courseName) throws course {
        List<Integer> students =enrollment.getOrDefault(courseName, new ArrayList<>());

        if (students.size() >=max_student ) {
            fullCourses.add(courseName);
            throw new course(courseName);
        }

        students.add(studentId);
        enrollment.put(courseName, students);
    }
     public void processEnrollmentFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(",");
                if (parts.length != 2) continue;

                int studentId = Integer.parseInt(parts[0].trim());
                String courseName = parts[1].trim();

                try {
                    enrollStudent(studentId, courseName);
                } catch (course e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading enrollment file: " + e.getMessage());
        }
    }
    public void writeFullCourses(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String course : fullCourses) {
                bw.write(course);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing full courses: " + e.getMessage());
        }
    }


}
