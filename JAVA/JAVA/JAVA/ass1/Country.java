
import java.util.Scanner;
import java.util.Arrays;

public class Country { //CountryNamesDescendingOrder
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of countries: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        String[] countries = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of country " + (i + 1) + ": ");
            countries[i] = scanner.nextLine();
        }

        Arrays.sort(countries, (a, b) -> b.compareToIgnoreCase(a));

        System.out.println("Countries in descending order:");
        for (String country : countries) {
            System.out.println(country);
        }

        scanner.close();
    }
}
/*
import java.util.Scanner;
import java.util.Arrays;

public class CountryNamesDescendingOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of countries: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer

        String[] countries = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of country " + (i + 1) + ": ");
            countries[i] = scanner.nextLine();
        }

        Arrays.sort(countries, (a, b) -> b.compareToIgnoreCase(a));

        System.out.println("Countries in descending order:");
        for (String country : countries) {
            System.out.println(country);
        }

        scanner.close();
    }
}

*/
