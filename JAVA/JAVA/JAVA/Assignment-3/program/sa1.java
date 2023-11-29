import java.util.Scanner;
class continent
{
	String cont_name;
	continent()
	{}
	void accept()
	{
		System.out.println("enter continent name:");
		Scanner sc=new Scanner(System.in);
		cont_name=sc.nextLine();
	}
	void display()
	{
	System.out.println("entered details are:");
	System.out.println("\ncontinent="+cont_name);
	}
}
class country extends continent
{
	String country_name;
	country()
	{}
	void accept()
	{
		super.accept();
		System.out.println("enter country name:");
		Scanner sc=new Scanner(System.in);
		country_name=sc.nextLine();
	}
	void display()
	{
	super.display();
	System.out.println("country ="+country_name);
	}
}
class state extends country
{
	String st_name;
	state()
	{}
	void accept()
	{
		super.accept();
		System.out.println("enter state name:");
		Scanner sc=new Scanner(System.in);
		st_name=sc.nextLine();
	}
	void display()
	{
	super.display();
	System.out.println("state ="+st_name);
	}
}
class sa1
{
	public static void main(String args[])
	{
		String place;
		Scanner sc=new Scanner(System.in);
		state s=new state();
		s.accept();
		s.display();
	}
}

