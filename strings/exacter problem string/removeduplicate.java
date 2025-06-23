public class removeduplicate {
    

     public static void main(String[] args) {
        String str = "programming";
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (result.indexOf(String.valueOf(ch)) == -1) {
                result.append(ch);
            }
        }
        
        System.out.println("Modified String: " + result);
    }
}
