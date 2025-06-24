package classandobjects;

public class palindromestring {
    String text;
    public palindromestring(String text) {
        this.text = text;
    }
    boolean ispalindrome() {
        // String reversed = new StringBuilder(text).reverse().toString();
        // return text.equals(reversed);

        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(cleaned).reverse();
        return cleaned.equals(reversed.toString());
    }
    void display(){
        System.out.println("The input string is: "+text);
        System.out.println("Is the string a palindrome? "+ispalindrome());

    }
    public static void main(String[] args) {
        palindromestring p = new palindromestring("madaam");
        p.display();

    }
}
