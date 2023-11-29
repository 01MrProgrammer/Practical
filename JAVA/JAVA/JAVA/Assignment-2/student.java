import java.util.Scanner;
class student
{
   int rollno;
   String name;
   float percentage;
   static int no=0;
   student()
   {}
  student(int rollno,String name,float per)
  {
	this.rollno=rollno;
	this.name=name;
	this.percentage=per;
	no++;
  }
   public void display() 
  {
  	System.out.println(rollno+"\t"+name+"\t"+"\t"+percentage+"\n");
  }
}
 public class student
  {
  	public static void main(String args[])
	{
 		int i,n;
		Scanner sc=new Scanner(System.in);
		System.out.println("how many student you want:");
		n=sc.nextInt();
		student s[]=new student[n];
		for( i=0;i<n;i++)
		{
			//s=new Scanner(System.in);
			System.out.println("enter rollno:");
			int rollno=sc.nextInt();
			System.out.println("enter name:");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("enter percentage:");	
			float per=sc.nextFloat();
			s[i]=new student(rollno,name,per);
			System.out.println("number of objects:"+s[i].no);
		}
		System.out.println("entered details are \nrollno\t name\tpercentage\n ");
		for(i=0;i<n;i++)
		{
			s[i].display();
		}
		for(i=0;i<n;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(s[j].percentage<s[j+1].percentage)
				{
					student t=s[j];
					s[j]=s[j+1];
					s[j+1]=t;
				}
			}
		}
		System.out.println("sorted details are \nrollno\t name\tpercentage\n ");
		for(i=0;i<n;i++)
		{
			s[i].display();
		}
	}
  }					
