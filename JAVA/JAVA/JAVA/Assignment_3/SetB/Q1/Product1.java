import java.io.*;
import java.util.Scanner;

abstract class Order
{
	int id;
	String discryptn;
	Order(int Oid,String Odiscryptn)
	{
		id=Oid;
		discryptn=Odiscryptn;
	}
	void display()
	{
		System.out.println("Enter the Order ID=" +id);
		System.out.println("Enter the Order Description=" +discryptn);
	}
}
class Purchase_Order extends Order
{
	String c_name;
	Purchase_Order(int Oid,String Odiscryptn,String cname)
	{
		super(Oid,Odiscryptn);
		c_name=cname;
	}
	void display1()
	{
		super.display();
		System.out.println("Enter the Customer Name: "+c_name);
	}
}
class Sales_Order extends Order
{
	String v_name;
	Sales_Order(int Oid,String Odiscryptn,String vname)
	{
		super(Oid,Odiscryptn);
		v_name=vname;
	}
	void display2()
	{
		super.display();
		System.out.println("Enter the Vendor Name: " +v_name);
	}
}

class Product1
{
	public static void main(String args[])
	{	
		int Oid,i;
		String cname,vname,Odiscryptn;		
		Scanner sc=new Scanner(System.in);
		Purchase_Order[] P=new Purchase_Order[3];
		Sales_Order[] S=new Sales_Order[3];
		System.out.println("Enter the 3 Orders of Purchase & Sales for Each");
		System.out.println("Enter the Purchase Order: ");
		for(i=0;i<3;i++)	
		{
			System.out.println("Enter the Order Id: ");
			Oid=sc.nextInt();
			System.out.println("Enter the Order Discryption: ");
			sc.nextLine();	
			Odiscryptn=sc.nextLine();
			System.out.println("Enter the Customer Name: ");
			cname=sc.nextLine();
			P[i]=new Purchase_Order(Oid,Odiscryptn,cname);
		}
		System.out.println("Enter the Sales Order: ");
		for(i=0;i<3;i++)
		{
			System.out.println("Enter the Order Id: ");
			Oid=sc.nextInt();
			System.out.println("Enter the Order Discryption: ");
			sc.nextLine();			
			Odiscryptn=sc.nextLine();
			System.out.println("Enter the Vendor Name: ");
			vname=sc.nextLine();
			S[i]=new Sales_Order(Oid,Odiscryptn,vname);
		}
		System.out.println("\nStored Data is: ");
		System.out.println("------------Purchase Order Data-----------------");
		for(i=0;i<3;i++)
		{
			P[i].display1();
		}
		System.out.println("------------Sales Order Data--------------------");
		for(i=0;i<3;i++)
		{	
			S[i].display2();
		}
	}
}
