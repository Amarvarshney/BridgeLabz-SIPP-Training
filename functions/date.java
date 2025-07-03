package functions;

import java.time.LocalDate;

public class date {
    

     public static void main(String[] args) {
        LocalDate date = LocalDate.of(2023, 6, 23);

        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2);
        result = result.minusWeeks(3);
        
        System.out.println("Original Date: " + date);
        System.out.println("Modified Date: " + result);
    }
}
