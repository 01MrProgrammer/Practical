public class Q1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide an array of integers as command line arguments.");
            return;
        }

        int n = args.length;
        int[] numbers = new int[n];

        // Convert command line arguments to integers
        for (int i = 0; i < n; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide valid integers.");
                return;
            }
        }

        System.out.println("Prime numbers in the array:");

        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }

    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
