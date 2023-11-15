import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of cities:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        String[] cities = new String[n];
        System.out.println("Enter the names of the cities:");
        for (int i = 0; i < n; i++) {
            cities[i] = scanner.nextLine();
        }

        Arrays.sort(cities);

        System.out.println("Cities in ascending order:");
        for (String city : cities) {
            System.out.println(city);
        }
    }
}

