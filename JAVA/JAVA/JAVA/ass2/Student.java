
import java.util.Scanner;

public class Student {
    private int rollNo;
    private String name;
    private double percentage;

    public Student(int rollNo, String name, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.percentage = percentage;
    }


    public static void sortStudent(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].percentage < students[j + 1].percentage) {
                    // Swap students[j] and students[j+1]
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Percentage: ");
            double percentage = scanner.nextDouble();

            students[i] = new Student(rollNo, name, percentage);
        }

        
        sortStudent(students);

        System.out.println("\nStudents sorted by percentage (descending order):");
        for (Student student : students) {
            System.out.println("Roll No: " + student.rollNo + ", Name: " + student.name + ", Percentage: " + student.percentage);
        }

        scanner.close();
    }
}


