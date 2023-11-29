import java.io.*;
import java.util.*;

class continent
{
	Scanner sc=new Scanner(System.in);
	String cname;	
	void get()
	{
		System.out.println("Enter the name of Continent: ");
		cname=sc.nextLine();
	}
	void display()
	{
		System.out.println("Continent Name: "+cname);
	}
}
	
class country extends continent
{
	Scanner sc=new Scanner(System.in);
	String country_name;
	void get()
	{
		super.get();
		System.out.println("Enter the name of Country: ");
		country_name=sc.nextLine();
	}
	void display()
	{
		super.display();
		System.out.println("Country Name: "+country_name);
	}
}

class state extends country
{
	Scanner sc=new Scanner(System.in);	
	String state_name;
	void get()
	{
		super.get();
		System.out.println("Enter the name of State: ");
		state_name=sc.nextLine();
	}
	void display()
	{
		super.display();
		System.out.println("State Name: "+state_name);
	}
}

class SetA_Q1
{
	public static void main(String args[])
	{
		state s=new state();
		s.get();
		s.display();
	}
}

