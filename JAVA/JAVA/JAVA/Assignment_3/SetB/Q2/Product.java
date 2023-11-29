//SetB_q2
import java.io.*;
import java.util.*;

interface marker
{}
public class Product implements marker
{
	int pid;
	String pname;
	int pcost;
	int pquantity;
	Product()	
	{}
	Product(int p_id,String p_name,int p_cost,int p_quantity)
	{
		this.pid=p_id;
		this.pname=p_name;
		this.pcost=p_cost;
		this.pquantity=p_quantity;
	}
	void display()
	{
		System.out.println("Product ID:"+pid);
		System.out.println("Product Name: "+pname);
		System.out.println("Product Cost: "+pcost);
		System.out.println("Product Quantity: "+pquantity);
	}
	public static void main(String args[])
	{	
		int pid,n,i,pcost,pquantity;
		String pname;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter How Many Objects: ");
		n=sc.nextInt();
		Product[] P=new Product[n];
		System.out.println("Enter the Data: ");
		for(i=0;i<n;i++)
		{
			System.out.println("Enter the Product ID: ");
			pid=sc.nextInt();
			System.out.println("Enter the Product Name: ");
			sc.nextLine();
			pname=sc.nextLine();
			System.out.println("Enter the Product Cost: ");
			pcost=sc.nextInt();
			System.out.println("Enter the Product Quantity: ");
			pquantity=sc.nextInt();
			P[i]=new Product(pid,pname,pcost,pquantity);
		}
		System.out.println("-------------Stored Product Data----------------");
		for(i=0;i<n;i++)
		{
			P[i].display();
		}
	}
}
