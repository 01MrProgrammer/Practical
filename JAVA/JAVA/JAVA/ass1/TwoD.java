import java.util.Scanner;

public class TwoD {//TwoDArrayOperations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] arr = new int[rows][columns];

        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Sum of diagonal elements");
            System.out.println("2. Sum of upper diagonal elements");
            System.out.println("3. Sum of lower diagonal elements");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int diagonalSum = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            if (i == j) {
                                diagonalSum += arr[i][j];
                            }
                        }
                    }
                    System.out.println("Sum of diagonal elements: " + diagonalSum);
                    break;

                case 2:
                    int upperDiagonalSum = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = i + 1; j < columns; j++) {
                            upperDiagonalSum += arr[i][j];
                        }
                    }
                    System.out.println("Sum of upper diagonal elements: " + upperDiagonalSum);
                    break;

                case 3:
                    int lowerDiagonalSum = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < i; j++) {
                            lowerDiagonalSum += arr[i][j];
                        }
                    }
                    System.out.println("Sum of lower diagonal elements: " + lowerDiagonalSum);
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid choice (1-4).");
            }

        } while (choice != 4);

        scanner.close();
    }
}


