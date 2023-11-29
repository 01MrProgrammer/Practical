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
   abstract void display();
 
}

class officestaff extends staff
{
	String department;
	 officestaff(int si,String sn,String dep)
	{
		super(si,sn);
		department=dep;
	}
	void display()
	{
		System.out.println("Id is: "+id);
		System.out.println("Name is: "+name);
		System.out.println("Department is: "+department);
	}
}

class seta_2
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		officestaff s1[]=new officestaff[5];
		for(int i=0;i<5;i++)
	{
		System.out.println("Enter the ID,Name,Department is: ");
		int id=sc.nextInt();
		sc.nextLine();
		String name=sc.nextLine();
		String department=sc.nextLine();
		s1[i]=new officestaff(id,name,department);
         }
		System.out.println("staff details: ");
		for(int i=0;i<5;i++)
			{
				s1[i].display();
			}
	}
	
}
