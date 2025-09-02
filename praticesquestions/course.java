public class course extends Exception{
    public course(String name){
        super("The current "+name+" course is full. Please try next time.");
    }
}