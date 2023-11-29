import java.util.*;
public class Q2
{
	String name;
	int no_of_innings,no_of_notout,total_runs;
	float batavg;
	public cricket()
	{}
	public void get()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name:");
	
		name=sc.nextLine();
		System.out.println("enter no of innings:");
		no_of_innings=sc.nextInt();
		System.out.println("enter notout:");
		no_of_notout=sc.nextInt();
		System.out.println("enter no of total runs:");
		total_runs=sc.nextInt();
	}
	void display()
	{
		System.out.println(name+"\t"+no_of_innings+"\t\t"+no_of_notout+"\t\t"+total_runs+"\t\t"+batavg+"\t");
	}
	public static void avg(int n,cricket c[])
	{
		for(int i=0;i<n;i++)
			c[i].batavg=c[i].total_runs/c[i].no_of_innings;
	}
	public static void sort(int n,cricket c[])
	{
		int i,j;
		cricket temp=new cricket();
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
			 if(c[i].batavg<c[j].batavg)
			 {
			 	temp=c[i];
			 	c[i]=c[j];
			 	c[j]=temp;
			 }
			}
		}
	}
	public static void main(String args[])
	{
		int i,n;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of players:");
		n=sc.nextInt();
		cricket c[]=new cricket[n];
		for(i=0;i<n;i++)
		{
			c[i]=new cricket();
			c[i].get();
		}
		cricket.avg(n,c);
		System.out.println("entered details are:\n");
		System.out.println("\nname\tno of innings\tno of notout\ttotal runs\tbatavg\n");
		for(i=0;i<n;i++)
		{
			c[i].display();
		}
		cricket.sort(n,c);
		System.out.println("\n after sorting:\n");
		System.out.println("\nname\tno of innings\tno of notout\ttotal runs\tbatavg\n");
		for(i=0;i<n;i++)
		{
			c[i].display();
		}
	}
}
