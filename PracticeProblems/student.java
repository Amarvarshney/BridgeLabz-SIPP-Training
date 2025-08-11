import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class student implements Serializable{
    public int id;
    public String name;
    public String surname;
    student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname=surname;
    }
    @Override
    public String toString() { 
        return "student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        '}';
    }
}
class Main{
    public static void main(String[] args) {
        student s=new student(01,"amar","varshney");
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Rahul\\OneDrive\\Desktop\\BridgeLabz_SIP_Training\\PracticeProblems\\student.sar"));
            os.writeObject(s);
            ObjectInputStream io=new ObjectInputStream(new FileInputStream("C:\\Users\\Rahul\\OneDrive\\Desktop\\BridgeLabz_SIP_Training\\PracticeProblems\\student.sar"));
            student s1=(student)io.readObject();
            System.out.println(s1.toString());
            System.out.println("Serialized object is saved");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
