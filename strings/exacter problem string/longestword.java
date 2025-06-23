public class longestword {
    

     public static void main(String[] args) {
        String sentence = "Java is an amazing programming language";
        String[] words = sentence.split(" ");
        String longest = "";
        
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        
        System.out.println("Longest Word: " + longest);
    }
}
