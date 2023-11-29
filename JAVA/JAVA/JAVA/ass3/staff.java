import java.util.*;

abstract class staff1
{
	protected int id;
	protected String name;
	staff1(int sid,String sname)
	{
		id=sid;
		name=sname;
	}
	void display();
}


class officestaff extends staff
{
	String d_name;
	officestaff(int sid,String sname,String dname)
	{
		super(sid,sname);
		d_name=dname;
	}
	void display()
	{
		System.out.println("ID="+sid);
	
		System.out.println("name="+sname);

		System.out.println("Dept="+d_name);
	}
}



class staff
{
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter teh Id ,name,departmnet of staff");
			int id=sc.nextInt();
			String name=sc.nextLine();
			String d_name=nextLine();
			p[i]=new officestaff(id,name,d_name);
		
		}
		System.out.println("staff details are :");
		for(int i=0;i<n;i++)
		{
			p[i].display();
		}
	}
}
