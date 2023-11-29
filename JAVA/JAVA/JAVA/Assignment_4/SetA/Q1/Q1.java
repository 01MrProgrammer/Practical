import java.io.*;
import java.util.*;

class patient
{
	String p_name;
	int age;
	int oxylvlrep;
	int HRCTrep;
	patient(String p_name,int age,int oxylvlrep,int HRCTrep)
	{
		this.p_name=p_name;
		this.age=age;
		this.oxylvlrep=oxylvlrep;
		this.HRCTrep=HRCTrep;
	}
	void display()
	{
		System.out.println("Patient Name: "+p_name);
		System.out.println("Age: "+age);
		System.out.println("Oxygen Level Report: "+oxylvlrep);
		System.out.println("HRCT report: "+HRCTrep);
	}
}
	class Q1 extends Exception
	{
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter How Many Patients: ");
			int n=sc.nextInt();
			patient p[]=new patient[n];
			System.out.println("Enter the details of Patients: ");
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter the Name of Patient: ");	
				sc.nextLine();				
				String p_name=sc.nextLine();
				System.out.println("Enter the Age of Patient: ");
				int age=sc.nextInt();
				System.out.println("Enter the Oxygen Level Report of Patient: ");
				int oxylvlrep=sc.nextInt();
				System.out.println("Enter the HRCT report: ");
				int HRCTrep=sc.nextInt();
				p[i]=new patient(p_name,age,oxylvlrep,HRCTrep);
			}
			System.out.println("Patient Details");
			for(int i=0;i<n;i++)
			{
				p[i].display();
				try
				{
					if(p[i].oxylvlrep<95 && p[i].HRCTrep>10)
					throw new NullPointerException("\n");
				}
				catch(Exception e)
				{
					System.out.println("Patient is Covid Positive & Need to Hospitalise");
				}
				
			}
		}
	}

