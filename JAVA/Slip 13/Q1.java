import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q1 {//WordAndLineCounter
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a file name as an argument.");
            return;
        }

        String fileName = args[0];
        int wordCount = 0;
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        System.out.println("Number of lines: " + lineCount);
        System.out.println("Number of words: " + wordCount);
    }
}
