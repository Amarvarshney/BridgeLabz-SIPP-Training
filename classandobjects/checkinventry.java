package classandobjects;

public class checkinventry {
    int itemCode;
    String itemName;
    double price;
    checkinventry(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price=price;
    }
    double calculatePrice(int quantity) {
        return price * quantity;
    }
    void display() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        checkinventry item1 = new checkinventry(1, "Apple",10);
        item1.display();
        int quantity = 3;
        System.out.println("Total Cost for " + quantity + " items: $" + item1.calculatePrice(quantity));
        System.out.println("Price of 2 items: " + item1.calculatePrice(2));
    }

}
