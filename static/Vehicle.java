public class Vehicle {
     static double registrationFee = 1500.0;
    final String registrationNumber;
    String ownerName, vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void displayVehicle() {
        if (this instanceof Vehicle) {
            System.out.println(vehicleType + " owned by " + ownerName + ", Reg#: " + registrationNumber + ", Fee: " + registrationFee);
        }
    }
}
