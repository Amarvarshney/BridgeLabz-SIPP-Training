package consturctor;

public class carRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 1500.0;

    carRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    void displayDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        carRental rental = new carRental("Priya", "Honda City", 5);
        rental.displayDetails();
    }
}
