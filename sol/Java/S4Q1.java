import java.util.Scanner;

public class S4Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create a 2D array
        int[][] originalArray = new int[rows][columns];

        // Input elements into the array
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + i + ", " + j + "): ");
                originalArray[i][j] = scanner.nextInt();
            }
        }

        // Transpose the array (swap rows and columns)
        int[][] transposedArray = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedArray[j][i] = originalArray[i][j];
            }
        }

        // Print the original array
        System.out.println("Original Array:");
        printArray(originalArray);

        // Print the transposed array
        System.out.println("Array after changing rows and columns:");
        printArray(transposedArray);

        scanner.close();
    }

    // Helper method to print a 2D array
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
