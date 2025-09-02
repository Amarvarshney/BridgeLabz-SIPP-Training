import java.time.LocalDateTime;
interface TransportService {
    String getId();
    String getType();
    double getFare();
    LocalDateTime getDepartureTime();
}


@FunctionalInterface
interface FareCalculator {
    double calculateFare(TransportService service);
}

