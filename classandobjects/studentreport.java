package classandobjects;

public class studentreport {
    String name;
    int rollno;
    double marks;
    public studentreport(String name,int rollno,double marks){
        this.name=name;
        this.rollno=rollno;
        this.marks=marks;
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Roll No: "+rollno);
        System.out.println("Marks: "+marks);
        System.out.println("Grade obtained according to marks: "+ getGrade());
        System.out.println();
    }
    String getGrade(){
        if(marks>=90) return "A";
        else if(marks>=75) return "B";
        else if(marks>=60) return "C";
        else if(marks>=40) return "D";
        else return "F";
    }
    public static void main(String[] args) {
        studentreport s1=new studentreport("Rahul",1,85.0);
        studentreport s2=new studentreport("amar",6,98.0);
        s1.display();
        s2.display();
    }
    

}
