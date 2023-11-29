import java.util.*;
import java.io.*;

interface Product1 {

}

public class sb2 implements Product1
{
	int id, quantity;
	String name;
	double cost;
	
	sb2(int id, String name, double cost, int quantity)
	{
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}
	
	public static void main(String args[])
	{
		int n, i, count=0;
		int id, quantity;
		String name;
		double cost;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of product: ");
		n = sc.nextInt();
		sb2 p[] = new sb2[n];
		
		for(i=0; i<n; i++)
		{
			System.out.println("Enter product id: ");
			id = sc.nextInt();
			
			System.out.println("Enter product name: ");
			sc.nextLine();
			name = sc.nextLine();
			
			System.out.println("Enter product quantity: ");
			quantity = sc.nextInt();
			
			System.out.println("Enter the cost: ");
			cost = sc.nextDouble();
			
			p[i] = new sb2(id, name, cost, quantity);
			count++;
		}
		
		if(p[0] instanceof Product1)
			System.out.println("Product Marker Interface");
			
		System.out.println("Id\tName\tCost\tQuantity\n");
		
		for(sb2 p1:p)
			System.out.println(p1.id + "\t" + p1.name + "\t" + p1.cost + "\t" + p1.quantity);
		
		System.out.println("Object Count: " + count);
	}
}

