import java.util.Scanner;
public class employee
{
	int id;
	String name;
	String dname;
	float salary;
	static int numberofobject=0;
	employee()
	{
	 id=0;
	name=" ";
	dname=" ";
	salary=0;
	}
	employee(int id,String name,String dname,float salary)
	{
		this.id=id;
		this.name=name;
		this.dname=dname;
		this.salary=salary;
		numberofobject++;
	}
	public void display()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("employee id:"+id);
		System.out.println("employee name:"+name);
		System.out.println("employee departname:"+dname);
		System.out.println("employee salary:"+salary);
	}
	public static void main(String args[])
	{
 		int n=0;
		Scanner s=new Scanner(System.in);
		System.out.println("how many employee you want:");
		n=s.nextInt();
		employee obj[]=new employee[n];
		for(int i=0;i<n;i++)
		{
			s=new Scanner(System.in);
			System.out.println("enter id"+(i+1)+":");
			int id=s.nextInt();
			System.out.println("enter name"+(i+1)+":");
			s.nextLine();
			String name=s.nextLine();
			System.out.println("enter deptname"+(i+1)+":");	
			String dname=s.nextLine();
			System.out.println("enter salary"+(i+1)+":");
			float salary=s.nextFloat();
			obj[i]=new employee(id,name,dname,salary);
			System.out.println("number of objects:"+numberofobject);
		}
		for(int i=0;i<n;i++)
		{
			obj[i].display();
		}
	}
}
