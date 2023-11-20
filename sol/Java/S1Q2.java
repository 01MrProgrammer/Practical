import java.util.Scanner;

abstract class Staff {
    protected int id;
    protected String name;

    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayDetails();
}

class OfficeStaff extends Staff {
    private String department;

    public OfficeStaff(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}

public class S1Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of OfficeStaff objects: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        OfficeStaff[] officeStaffArray = new OfficeStaff[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for OfficeStaff #" + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            officeStaffArray[i] = new OfficeStaff(id, name, department);
        }

        System.out.println("\nDetails of OfficeStaff:");
        for (OfficeStaff staff : officeStaffArray) {
            staff.displayDetails();
            System.out.println();
        }

        scanner.close();
    }
}
