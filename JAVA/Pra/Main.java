import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Number of Cities.");
        int n= scanner.nextInt();
        scanner.nextLine();

        String[] cities = new String[n];
        System.out.println("Enter the name of Cities:");
        for(int i=0;i<n;i++){
            cities[i]=scanner.nextLine();
        }
        Arrays.sort(cities);

        System.out.println("Cities Name in Acending Order:");
        for(String city : cities){
            System.out.println(city);
        }
    }
}