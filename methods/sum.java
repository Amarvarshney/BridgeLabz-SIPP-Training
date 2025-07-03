public class sum {
     public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] getDigitsArray(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
            digits[i] = str.charAt(i) - '0';
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;
        
        int count = 0;
        for (int f : freq) if (f > 0) count++;

        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void printFrequency(int[][] freq) {
        System.out.println("Digit | Frequency");
        for (int[] row : freq) {
            System.out.println("  " + row[0] + "    |    " + row[1]);
        }
    }

    public static void main(String[] args) {
        int number = 1729; // Change as needed
        int[] digits = getDigitsArray(number);

        System.out.println("Number: " + number);
        System.out.println("Count of Digits: " + countDigits(number));
        System.out.println("Sum of Digits: " + sumOfDigits(digits));
        System.out.printf("Sum of Squares: %.2f\n", sumOfSquares(digits));
        System.out.println("Is Harshad: " + isHarshad(number, digits));
        printFrequency(digitFrequency(digits));
    }
}
