import java.io.*;
import java.util.*;

abstract class staff
{
	protected int id;
	protected String name;
	staff(int sid,String sname)
	{
		id=sid;
		name=sname;
	}
}

class OfficeStaff extends staff
{
	String dept;
	OfficeStaff(int id,String name,String dept_name)
	{
		super(id,name);
		dept=dept_name;
	}
	void display()
	{
		System.out.println("Enter ID: " +id);
		System.out.println("Enter NAME: " +name);
		System.out.println("Enter DEPARTMENT name: " +dept);
	}
}

class SetA_Q2
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n,i;
		System.out.println("Enter the value of n: ");
		n=sc.nextInt();
		OfficeStaff[] s=new OfficeStaff[n];
		for(i=0;i<n;i++)
		{
			System.out.println("Enter ID: ");
			int id=sc.nextInt();
			System.out.println("Enter NAME: ");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Enter DEPARTMENT: ");
			String dept_name=sc.nextLine();
			
			s[i]=new OfficeStaff(id,name,dept_name);
		}
		System.out.println("Staff Details are: ");
		for(i=0;i<n;i++)
		{
			s[i].display();
		}
	}
}
