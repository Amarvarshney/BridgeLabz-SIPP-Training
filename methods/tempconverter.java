public class tempconverter {
     public static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        System.out.println("98°F in Celsius: " + convertFahrenheitToCelsius(98));
        System.out.println("37°C in Fahrenheit: " + convertCelsiusToFahrenheit(37));
        System.out.println("10 pounds in kilograms: " + convertPoundsToKilograms(10));
        System.out.println("5 kg in pounds: " + convertKilogramsToPounds(5));
        System.out.println("3 gallons in liters: " + convertGallonsToLiters(3));
        System.out.println("10 liters in gallons: " + convertLitersToGallons(10));
    }
}
