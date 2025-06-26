public class shoppingcart {
    static double discount = 10.0;
    final int productID;
    String productName;
    double price;
    int quantity;

    shoppingcart(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayProduct() {
        if (this instanceof shoppingcart) {
            System.out.println(productName + " - Rs." + price + ", Qty: " + quantity + ", Discount: " + discount + "%");
        }
    }
}
