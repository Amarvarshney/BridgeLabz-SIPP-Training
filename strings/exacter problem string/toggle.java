public class toggle {
    

    public static void main(String[] args) {
        String str = "Hello World";
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch))
                result.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch))
                result.append(Character.toUpperCase(ch));
            else
                result.append(ch);
        }
        
        System.out.println("Toggled: " + result);
    }
}
