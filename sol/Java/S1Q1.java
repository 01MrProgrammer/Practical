public class S1Q1 {
    // Function to check if a number is prime
    static boolean isPrime(int num) {
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

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java PrimeNumbersInArray <num1> <num2> <num3> ...");
            return;
        }

        System.out.println("Prime numbers in the array:");

        for (String arg : args) {
            int num = Integer.parseInt(arg);
            if (isPrime(num)) {
                System.out.println(num);
            }
        }
    }
}
