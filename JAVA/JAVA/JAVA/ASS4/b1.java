import java.io.*;
import java.util.Scanner;

class Book {
    int bookId;
    String bookName;
    double bookPrice;
    int bookQty;

    public Book(int bookId, String bookName, double bookPrice, int bookQty) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookQty = bookQty;
    }
    
    // Method to write book data to a random access file
    public void writeData(RandomAccessFile file) throws IOException {
        file.writeInt(bookId);
        file.writeUTF(bookName);
        file.writeDouble(bookPrice);
        file.writeInt(bookQty);
    }

    // Method to read book data from a random access file
    public static Book readData(RandomAccessFile file) throws IOException {
        int bookId = file.readInt();
        String bookName = file.readUTF();
        double bookPrice = file.readDouble();
        int bookQty = file.readInt();
        return new Book(bookId, bookName, bookPrice, bookQty);
    }
}

public class /*BookStore*/b1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "book.dat";

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Search for a book by name");
                System.out.println("2. Display all books and total cost");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter the book name to search: ");
                        String searchName = scanner.nextLine();
                        searchBookByName(file, searchName);
                        break;
                    case 2:
                        displayAllBooks(file);
                        break;
                    case 3:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to search for a book by name
    private static void searchBookByName(RandomAccessFile file, String name) throws IOException {
        file.seek(0);

        while (file.getFilePointer() < file.length()) {
            Book book = Book.readData(file);
            if (book.bookName.equalsIgnoreCase(name)) {
                System.out.println("Book found: " + book.bookName + " (ID: " + book.bookId + ")");
                System.out.println("Price: $" + book.bookPrice);
                System.out.println("Quantity: " + book.bookQty);
                return;
            }
        }
        System.out.println("Book not found with the given name.");
    }

    // Method to display all books and total cost
    private static void displayAllBooks(RandomAccessFile file) throws IOException {
        file.seek(0);
        double totalCost = 0;

        System.out.println("\nAll Books:");
        while (file.getFilePointer() < file.length()) {
            Book book = Book.readData(file);
            System.out.println("Book Name: " + book.bookName);
            System.out.println("Book ID: " + book.bookId);
            System.out.println("Price: $" + book.bookPrice);
            System.out.println("Quantity: " + book.bookQty);
            totalCost += (book.bookPrice * book.bookQty);
            System.out.println();
        }
        System.out.println("Total Cost of all Books: $" + totalCost);
    }
}
