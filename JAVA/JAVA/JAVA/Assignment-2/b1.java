import SY.*;
import TY.*;
import java.util.Scanner;
public class b1

{
	public int rno;
	public String name,grade;
	public float gt,per,syt,tyt;
	public void get()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter rollno:");
		rno=sc.nextInt();
		System.out.println("enter name:");
		sc.nextLine();
		name=sc.nextLine();
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int i,n;
		System.out.println("enter no of students:");
		n=sc.nextInt();
		b1 s[]=new b1[n];
		symarks sy[]=new symarks[n];
		tymarks ty[]=new tymarks[n];
		System.out.println("enter "+n+" student information: ");
		for(i=0;i<n;i++)
		{
			s[i]=new b1();
			sy[i]=new symarks();
			ty[i]=new tymarks();
			s[i].get();
			sy[i].get();
			ty[i].get();
			s[i].syt=sy[i].ct+sy[i].mt+sy[i].et;
			s[i].tyt=ty[i].tm+ty[i].pm;
			s[i].gt=s[i].syt+s[i].tyt;
			s[i].per=(s[i].gt/1200)*100;
			if(s[i].per>=70)
				s[i].grade="A";
			else if(s[i].per>=60)
				s[i].grade="B";
			else if(s[i].per>=50)
				s[i].grade="C";
			else if(s[i].per>=40)
				s[i].grade="Pass";
			else 
				s[i].grade="Fail";
		}
		System.out.println("\nStudent record is:\nRollno\tNameSY total\tTY total\tGrand total\tPercentage\tGrade\n");
		System.out.println("---------------------------");
		for(i=0;i<n;i++)
		{
			System.out.println("\n"+s[i].rno+"\t"+s[i].name+"\t"+s[i].syt+"\t"+s[i].tyt+"\t"+s[i].gt+"\t"+s[i].per+"\t"+s[i].grade+"\n");
		}
	}
}
		
						
		
