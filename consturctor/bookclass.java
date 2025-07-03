package consturctor;

public class bookclass {
    String title;
    String author;
    double price;
    bookclass(){
        title = "No title";
        author = "No author";
        price = 0.0;
    }
    bookclass(String title, String author, double price){
        this.title = title;
        this.author=author;
        this.price=price;
    }
    void display(){
        System.out.println("Title: "+title + "\nAuthor: "+author+"\nPrice: Rs "+price);
    }
    public static void main(String[] args) {
        bookclass b1 = new bookclass();
        
        b1.display();
        bookclass b2=new bookclass("harry porter", "amar", 10000);
        b2.display();
    }
}
