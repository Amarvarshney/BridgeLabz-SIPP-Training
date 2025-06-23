package classandobjects;

import java.util.Scanner;

public class resturant {

    private String name;
    private String location;
    private String[] foodItems;

    // Constructor
    public resturant(String name, String location, String[] foodItems) {
        this.name = name;
        this.location = location;
        this.foodItems = foodItems;
    }

    // Method to display restaurant details
    public void displayDetails() {
        System.out.println("Restaurant Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Food Items:");
        for (String item : foodItems) {
            System.out.println("- " + item);
        }
    }

    // Method to check if a food item is available
    public boolean isFoodAvailable(String food) {
        for (String item : foodItems) {
            if (item.equalsIgnoreCase(food)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String[] items = {"Pizza", "Burger", "Pasta", "Fries"};
        resturant myRestaurant = new resturant("Tasty Bites", "Mumbai", items);

        myRestaurant.displayDetails();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the food item to check availability: ");
        String userFood = sc.nextLine();

        if (myRestaurant.isFoodAvailable(userFood)) {
            System.out.println(userFood + " is available.");
        } else {
            System.out.println(userFood + " is not available.");
        }

        sc.close();
    }
}
