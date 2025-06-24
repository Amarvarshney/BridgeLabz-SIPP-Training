package consturctor;

public class hotelbooking {
     String guestName;
    String roomType;
    int nights;

    // Default constructor
    hotelbooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    hotelbooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    hotelbooking(hotelbooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }

    public static void main(String[] args) {
        hotelbooking booking1 = new hotelbooking("Vikram", "Deluxe", 3);
        hotelbooking booking2 = new hotelbooking(booking1); // copied
        booking1.display();
        booking2.display();
    }
}
