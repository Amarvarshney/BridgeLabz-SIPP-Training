package consturctor;

public class person {
    String name;
    int age;

    // Parameterized constructor
    person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    person(person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        person p1 = new person("Anjali", 28);
        person p2 = new person(p1); // Copying
        p1.display();
        p2.display();
    }
}
