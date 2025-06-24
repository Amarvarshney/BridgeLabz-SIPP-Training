package classandobjects;

import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<cartItem> items = new ArrayList<>();

    void addItem(String name, double price, int quantity) {
        items.add(new cartItem(name, price, quantity));
        System.out.println(name + " added to cart.");
    }

    void removeItem(String name) {
        boolean removed = items.removeIf(item -> item.itemName.equalsIgnoreCase(name));
        if (removed) {
            System.out.println(name + " removed from cart.");
        } else {
            System.out.println("Item not found.");
        }
    }

    void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = 0;
        System.out.println("Items in Cart:");
        for (cartItem item : items) {
            item.display();
            total += item.totalcost();
        }
        System.out.println("Total Cost: Rs " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 50000, 1);
        cart.addItem("Mouse", 500, 2);
        cart.displayCart();
        cart.removeItem("Mouse");
        cart.displayCart();
    }
}
