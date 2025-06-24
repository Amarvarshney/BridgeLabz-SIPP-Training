package consturctor;

public class radius {
    double radius;
    radius(){
        this(1.0);
    }
    radius(double radius){
        this.radius = radius;
    }
    void display(){
        System.out.println("Radius is: "+this.radius);
    }
    public static void main(String[] args) {
        radius r1 = new radius();
        r1.display();
        radius r2 = new radius(5.0);
        r2.display();
    }
}
