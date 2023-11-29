import java.io.*;
import java.util.Scanner;
abstract class order
{
	int id;
	String ds;
	order(int o_id,String des)
	{
		id=o_id;
		ds=des;
	}
}

class purchaseorder extends order
{
	String c_name;
	purchaseorder(int i,String d,String cst)
	{
		super(i,d);
		c_name=cst;
	}
	void display()
	{
		System.out.println("id="+id);
		System.out.println("description="+ds);
		System.out.println("customer name="+c_name);
	}
}
class salesorder extends order
{
	String v_name;
	salesorder(int i,String d,String vnd)
	{
		super(i,d);
		v_name=vnd;
	}
	void display()
	{
		System.out.println("\n id="+id);
		System.out.println("\n description="+ds);
		System.out.println("\n vendor name="+v_name);
	}
}	
class sb1
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		purchaseorder s1[]=new purchaseorder[3];
		System.out.println("enter customer details:");
		for(int i=0;i<3;i++)
		{
			System.out.println("\nenter id:");
			int id=s.nextInt();
			System.out.println("\nenter description:");
			s.nextLine();
			String ds=s.nextLine();	
			System.out.println("\nenter custname:");
			String c_name=s.nextLine();
			s1[i]=new purchaseorder(id,ds,c_name);
		}
		salesorder s2[]=new salesorder[3];
		System.out.println("enter vendor details:");
		for(int i=0;i<3;i++)
		{
			System.out.println("\nenter id:");
			int id=s.nextInt();
			System.out.println("\nenter description:");
			s.nextLine();
			String ds=s.nextLine();
			System.out.println("\nenter custname:");
			String v_name=s.nextLine();
			s2[i]=new salesorder(id,ds,v_name);
		}
	
		System.out.println("\n porder details are:");
		for(int i=0;i<3;i++)
		{
			s1[i].display();
			
		}
		System.out.println("\n saleorder details are:");
		for(int i=0;i<3;i++)
		{
			s2[i].display();
			
		}
	}
}

