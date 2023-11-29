
import java.util.Arrays;

public class CommandLineSort {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Please provide exactly 5 numbers as command-line arguments.");
            return;
        }

        double[] numbers = new double[5];
        for (int i = 0; i < 5; i++) {
            try {
                numbers[i] = Double.parseDouble(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide numeric values only.");
                return;
            }
        }

        Arrays.sort(numbers);

        System.out.println("Sorted numbers in ascending order:");
        for (double num : numbers) {
            System.out.print(num + " ");
        }
    }
}

/* 
javac CommandLineSort.java
java CommandLineSort 5.4 2.7 1.2 4.8 3.1

Sorted numbers in ascending order:
1.2 2.7 3.1 4.8 5.4

*/
