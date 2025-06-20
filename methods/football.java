import java.util.Random;

public class football {
    
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + rand.nextInt(101); // from 150 to 250
        }
        return heights;
    }

    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int value : array) sum += value;
        return sum;
    }

    public static double calculateMean(int[] array) {
        return (double) calculateSum(array) / array.length;
    }

    public static int findShortest(int[] array) {
        int min = array[0];
        for (int value : array) if (value < min) min = value;
        return min;
    }

    public static int findTallest(int[] array) {
        int max = array[0];
        for (int value : array) if (value > max) max = value;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);
        System.out.print("Player Heights (in cm): ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println();

        System.out.println("Shortest Height: " + findShortest(heights) + " cm");
        System.out.println("Tallest Height: " + findTallest(heights) + " cm");
        System.out.printf("Mean Height: %.2f cm\n", calculateMean(heights));
    }
}
