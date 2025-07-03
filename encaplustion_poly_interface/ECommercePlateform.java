package encaplustion_poly_interface;

// public class ECommercePlateform {
    
// }
// Interface for Taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method for discount
    public abstract double calculateDiscount();
}

// Electronics - implements Taxable
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Tax (18% GST): " + calculateTax();
    }
}

// Clothing - implements Taxable
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public String getTaxDetails() {
        return "Tax (12% GST): " + calculateTax();
    }
}

// Groceries - not taxable
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class ECommercePlateform {
    public static void main(String[] args) {
        Product[] cart = new Product[] {
            new Electronics(101, "Smartphone", 20000),
            new Clothing(102, "Jeans", 1500),
            new Groceries(103, "Rice 10kg", 800)
        };

        System.out.println("=== Shopping Cart Summary ===");
        for (Product p : cart) {
            printFinalDetails(p);
        }
    } 

    // Polymorphic method to calculate and display final price
    public static void printFinalDetails(Product product) {
        System.out.println("Product: " + product.getName());
        System.out.println("Base Price: " + product.getPrice());
        System.out.println("Discount: " + product.calculateDiscount());

        double tax = 0;
        if (product instanceof Taxable) {
            Taxable taxable = (Taxable) product;
            tax = taxable.calculateTax();
            System.out.println(taxable.getTaxDetails());
        }

        double finalPrice = product.getPrice() + tax - product.calculateDiscount();
        System.out.println("Final Price: " + finalPrice);
        System.out.println("---------------------------");
    }
}
