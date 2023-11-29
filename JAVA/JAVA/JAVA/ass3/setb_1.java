import java.util.Scanner;


abstract class Order {
    protected int id;
    protected String description;

    public Order(int id, String description) {
        this.id = id;
        this.description = description;
    }

   
    public abstract void accept();
    public abstract void display();
}


class PurchaseOrder extends Order {
    private String customerName;

    public PurchaseOrder(int id, String description, String customerName) {
        super(id, description);
        this.customerName = customerName;
    }

    
    public void accept() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        customerName = scanner.nextLine();
    }

    
    public void display() {
        System.out.println("Purchase Order ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Customer Name: " + customerName);
    }
}


class SalesOrder extends Order {
    private String vendorName;

    public SalesOrder(int id, String description, String vendorName) {
        super(id, description);
        this.vendorName = vendorName;
    }

   
    public void accept() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Vendor Name: ");
        vendorName = scanner.nextLine();
    }

  
    public void display() {
        System.out.println("Sales Order ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Vendor Name: " + vendorName);
    }
}

public class setb_1 {
    public static void main(String[] args) {
       
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, "Computer Parts", "");
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(2, "Office Supplies", "");
        PurchaseOrder purchaseOrder3 = new PurchaseOrder(3, "Electronics", "");

        
        purchaseOrder1.accept();
        purchaseOrder1.display();

        purchaseOrder2.accept();
        purchaseOrder2.display();

        purchaseOrder3.accept();
        purchaseOrder3.display();

       
        SalesOrder salesOrder1 = new SalesOrder(101, "Laptops", "");
        SalesOrder salesOrder2 = new SalesOrder(102, "Smartphones", "");
        SalesOrder salesOrder3 = new SalesOrder(103, "Tablets", "");

       
        salesOrder1.accept();
        salesOrder1.display();

        salesOrder2.accept();
        salesOrder2.display();

        salesOrder3.accept();
        salesOrder3.display();
    }
}
