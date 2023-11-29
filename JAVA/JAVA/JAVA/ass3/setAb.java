import java.util.*;
import java .lang.String;
abstract class staff
{
	protected int id;
	protected String name;
	staff(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
}


class officestaff extends staff
{
	String dept;
	officestaff(int id,String name,String dept)
	{
		super(id,name);
		this.dept=dept;
	}
	void display()
	{
		System.out.println("ID="+id);
	
		System.out.println("name="+name);

		System.out.println("Dept="+dept);
	}
}
class setAb 
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter staff members");
		int n = sc.nextInt();
		officestaff p[]=new officestaff[n];
		for(int i=0;i<n;i++)
		{
			p[i].display();
		}
	}
}
