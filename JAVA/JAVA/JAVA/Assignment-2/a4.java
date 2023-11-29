import java.util.*;
 public class a4
  {
  	String fname,mname,lname,a,b,c;
  	int l; 
  	public void get()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first name:");
	 	fname=sc.nextLine();
		System.out.println("enter  middle name:");
		mname=sc.nextLine();
		System.out.println("enter last name:");
		lname=sc.nextLine();
		l=mname.length();
		a=mname.substring(0,1);
		c=a.toUpperCase();
		b=mname.substring(1,l);
		mname=c+b;
	}
	void display()
	{
		System.out.println("name in format last first middle name:\n");
		System.out.println(lname+"\t"+fname+"\t"+mname);
	}
	public static void main(String args[])
	{
		a4 obj=new a4();
		obj.get();
		obj.display();
	}
 }
		
	
