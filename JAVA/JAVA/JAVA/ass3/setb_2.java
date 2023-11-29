import java.io.Serializable;
import java.util.Scanner;

interface Countable extends Serializable
 {
 }


class Product implements Countable {
    private int productId;
    private String productName;
    private double productCost;
    private int productQuantity;
    private static int objectCount = 0;
  
    public Product() {
        objectCount++; 
    }

   
    public Product(int productId, String productName, double productCost, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.productQuantity = productQuantity;
        objectCount++; 
    }

   
    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Product Cost: $" + productCost);
        System.out.println("Product Quantity: " + productQuantity);
    }

    
    public static int getObjectCount() {
        return objectCount;
    }
}

public class setb_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 


        Product[] products = new Product[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product #" + (i + 1));
            System.out.print("Enter Product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter Product Cost: ");
            double productCost = scanner.nextDouble();
            System.out.print("Enter Product Quantity: ");
            int productQuantity = scanner.nextInt();
            scanner.nextLine(); 

            products[i] = new Product(productId, productName, productCost, productQuantity);
        }

      
        System.out.println("\nProduct Details:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nDetails for Product #" + (i + 1));
            products[i].displayProduct();
        }

  
        System.out.println("\nTotal Number of Product Objects Created: " + Product.getObjectCount());

        scanner.close();
    }
}
