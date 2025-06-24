package classandobjects;

public class movieticketbooking {
    String movieName;
    int seatNumber;
    double price;
    movieticketbooking() {
        this.movieName="";
        this.seatNumber=-1;
        this.price=0.0;
    }

    void bookingTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price=price;
        if(seatNumber!=-1){
            System.out.println("Ticket is sussesfully booked for movie "+movieName+" at seat number "+seatNumber+" with price "+price);
        }
    }

    void display(){
        if(seatNumber!=-1){
            System.out.println("Movie Name: "+movieName);
            System.out.println("Seat Number: "+seatNumber);
            System.out.println("Price: "+price);
        }else{
            System.out.println("No ticket is booked");
        }
    }
    public static void main(String[] args) {
        movieticketbooking ticket = new movieticketbooking();
        ticket.bookingTicket("Avengers", 10, 200.0);
        ticket.display();
    }
    

}
