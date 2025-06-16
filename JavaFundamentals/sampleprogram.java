import java.util.Scanner;

public class sampleprogram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter from city: ");
        String fromCity = input.nextLine();

        System.out.print("Enter via city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter to city: ");
        String toCity = input.nextLine();

        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = input.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = input.nextDouble();

        System.out.print("Enter time from " + fromCity + " to " + viaCity + ": ");
        double timeFromToVia = input.nextDouble();

        System.out.print("Enter time from " + viaCity + " to " + toCity + ": ");
        double timeViaToFinalCity = input.nextDouble();

        double totalDistanceMiles = fromToVia + viaToFinalCity;
        double totalDistanceKm = totalDistanceMiles * 1.6;
        double totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " +
                toCity + " via " + viaCity + " is " + totalDistanceKm + " km and total time taken is " + totalTime + " hrs");
    }
}
