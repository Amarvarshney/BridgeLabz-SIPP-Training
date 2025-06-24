package classandobjects;

public class moblienumber {
    String brand;
    String model;
    double price;
    moblienumber(){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }
    void display(){
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Price: "+price);
    }
    public static void main(String[] args) {
        moblienumber m1=new moblienumber();
        m1.brand="Samsung";
        m1.model="SAMSUNG A8";
        m1.price=50000.0;
        m1.display();
    }

}
