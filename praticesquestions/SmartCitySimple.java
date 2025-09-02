import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


// interface TransportService {
//     String getId();
//     String getType();
//     double getFare();
//     LocalDateTime getDepartureTime();
// }


// @FunctionalInterface
// interface FareCalculator {
//     double calculateFare(TransportService service);
// }


public class SmartCitySimple {
    public static void main(String[] args) {
       
        List<TransportService> services = Arrays.asList(
            new Service("Bus1", "Bus", 2.5, LocalDateTime.now().plusMinutes(10)),
            new Service("Metro1", "Metro", 3.0, LocalDateTime.now().plusMinutes(5)),
            new Service("Taxi1", "Taxi", 5.0, LocalDateTime.now().plusMinutes(15)),
            new Service("Bus2", "Bus", 2.0, LocalDateTime.now().plusMinutes(20))
        );

      
        System.out.println("=== Buses sorted by departure time ===");
        services.stream()
            .filter(s -> s.getType().equals("Bus"))
            .sorted(Comparator.comparing(TransportService::getDepartureTime))
            .forEach(s -> System.out.println(s.getId() + " - $" + s.getFare() + " at " + s.getDepartureTime()));

    
        FareCalculator taxCalculator = s -> s.getFare() * 1.1;
        System.out.println("\n=== Fare with 10% Tax ===");
        for (TransportService s : services) {
            System.out.println(s.getId() + ": $" + taxCalculator.calculateFare(s));
        }

        
        double totalRevenue = services.stream()
            .mapToDouble(TransportService::getFare)
            .sum();
        System.out.println("\nTotal Revenue: $" + totalRevenue);
    }

  
    static class Service implements TransportService {
        private String id, type;
        private double fare;
        private LocalDateTime time;

        Service(String id, String type, double fare, LocalDateTime time) {
            this.id = id;
            this.type = type;
            this.fare = fare;
            this.time = time;
        }

        public String getId() { return id; }
        public String getType() { return type; }
        public double getFare() { return fare; }
        public LocalDateTime getDepartureTime() { return time; }
    }
}
