

import java.util.Scanner;

public class NameFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name (first middle last): ");
        String fullName = scanner.nextLine();

        String[] nameParts = fullName.split(" ");

        if (nameParts.length != 3) {
            System.out.println("Invalid input format. Please enter first, middle, and last names separated by spaces.");
            scanner.close();
            return;
        }

        String firstName = nameParts[0];
        String middleName = nameParts[1];
        String lastName = nameParts[2];


        char capitalizedMiddleInitial = Character.toUpperCase(middleName.charAt(0));
        middleName = capitalizedMiddleInitial + middleName.substring(1);


        System.out.println("Formatted name: " + lastName + ", " + firstName + ", " + middleName);

        scanner.close();
    }
}
/* 
Enter your full name (first middle last): John David Smith
Formatted name: Smith, John, David
*/

