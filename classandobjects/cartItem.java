package classandobjects;

import java.util.ArrayList;
public class cartItem {
    String itemName;
    double price;
    int quantity;
    cartItem(String name, double cost, int quantity) {
        this.itemName = name;
        this.price = cost;
        this.quantity = quantity;
    }
    double totalcost(){
        return price*quantity;
    }
    void display(){
        System.out.println("Item Name: "+itemName+" Price: "+price+" Quantity: "+quantity+ " total cost is :Rs "+totalcost());
    }
}
