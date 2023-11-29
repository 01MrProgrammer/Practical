import java.util.Scanner;
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
class officestaff extends staff
{
	String dept;
	officestaff(int i,String s,String d)
	{
		super(i,s);
		dept=d;
	}
	void display()
	{
		System.out.println("Id:"+id);
		System.out.println("Name:"+name);
		System.out.println("deptname:"+dept);
	}
}
class sa2
{
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	officestaff s1[]=new officestaff[2];
	System.out.println("enter details of officestaff:");
	for(int i=0;i<2;i++)
	{
	System.out.println("enter id:");
	int id=sc.nextInt();
	System.out.println("enter name:");
	sc.nextLine();
	String name=sc.nextLine();
	System.out.println("enter dept name:");
	String dept=sc.nextLine();
	s1[i]=new officestaff(id,name,dept);
	}
	System.out.println("\nentered details are:");
	for(int i=0;i<2;i++)
	{
		
		s1[i].display();
	}
}
}
