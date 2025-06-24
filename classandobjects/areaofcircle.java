package classandobjects;

public class areaofcircle {
    double radius;
    areaofcircle(double radius){
        this.radius=radius;
    }
    double getArea(){
        return Math.PI*radius*radius;
    }
    double getCircumference(){
        return 2*Math.PI*radius;
    }
    void display(){
        System.out.println("Radius is : "+ radius);
        System.out.println("Area of circle is "+getArea());
        System.out.println("Circumference of circle is "+getCircumference());
    }
    public static void main(String[] args) {
        areaofcircle c1=new areaofcircle(5);
        c1.display();
    }
}
