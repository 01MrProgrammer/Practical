import java.util.ArrayList;
import java.util.Scanner;

// Define the Department interface
interface Department {
    void printDepartmentDetails();
}

// Define the Hostel class
class Hostel {
    String hostelName;
    String hostelLocation;
    int numberOfRooms;

    public Hostel(String hostelName, String hostelLocation, int numberOfRooms) {
        this.hostelName = hostelName;
        this.hostelLocation = hostelLocation;
        this.numberOfRooms = numberOfRooms;
    }

    public void printHostelDetails() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Hostel Location: " + hostelLocation);
        System.out.println("Number of Rooms: " + numberOfRooms);
    }
}

// Define the Student class
class Student extends Hostel implements Department {
    String studentName;
    String regNo;
    String electiveSubject;
    double avgMarks;

    public Student(String hostelName, String hostelLocation, int numberOfRooms,
                   String studentName, String regNo, String electiveSubject, double avgMarks) {
        super(hostelName, hostelLocation, numberOfRooms);
        this.studentName = studentName;
        this.regNo = regNo;
        this.electiveSubject = electiveSubject;
        this.avgMarks = avgMarks;
    }

    @Override
    public void printHostelDetails() {
        super.printHostelDetails();
        System.out.println("Student Name: " + studentName);
        System.out.println("Registration Number: " + regNo);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks: " + avgMarks);
    }

    @Override
    public void printDepartmentDetails() {
        System.out.println("Department: Computer Science"); // Example department
    }

    public String getRegNo() {
        return regNo;
    }
}

// Define the HostelManagement class
public class c1 {//HostelManagement
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Admit new student");
            System.out.println("2. Migrate a student");
            System.out.println("3. Display details of a student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Hostel Name: ");
                    String hostelName = scanner.nextLine();
                    System.out.print("Enter Hostel Location: ");
                    String hostelLocation = scanner.nextLine();
                    System.out.print("Enter Number of Rooms: ");
                    int numberOfRooms = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Registration Number: ");
                    String regNo = scanner.nextLine();
                    System.out.print("Enter Elective Subject: ");
                    String electiveSubject = scanner.nextLine();
                    System.out.print("Enter Average Marks: ");
                    double avgMarks = scanner.nextDouble();

                    Student newStudent = new Student(hostelName, hostelLocation, numberOfRooms,
                            studentName, regNo, electiveSubject, avgMarks);
                    studentList.add(newStudent);
                    System.out.println("Student admitted successfully!");
                    break;
                case 2:
                    System.out.print("Enter Registration Number of the student to migrate: ");
                    String migrateRegNo = scanner.nextLine();
                    boolean migrated = false;

                    for (Student student : studentList) {
                        if (student.getRegNo().equals(migrateRegNo)) {
                            System.out.print("Enter New Hostel Name: ");
                            hostelName = scanner.nextLine();
                            System.out.print("Enter New Hostel Location: ");
                            hostelLocation = scanner.nextLine();
                            System.out.print("Enter New Number of Rooms: ");
                            numberOfRooms = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            student.hostelName = hostelName;
                            student.hostelLocation = hostelLocation;
                            student.numberOfRooms = numberOfRooms;

                            System.out.println("Student migrated successfully!");
                            migrated = true;
                            break;
                        }
                    }

                    if (!migrated) {
                        System.out.println("Student with Registration Number " + migrateRegNo + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Registration Number of the student to display details: ");
                    String searchRegNo = scanner.nextLine();
                    boolean found = false;

                    for (Student student : studentList) {
                        if (student.getRegNo().equals(searchRegNo)) {
                            student.printHostelDetails();
                            student.printDepartmentDetails();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student with Registration Number " + searchRegNo + " not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
