import java.io.*;
import java.util.*;


class Patient
{
	String p_name;
	int p_age;
	int oxylvl;
	int HRCTreport;
	
	Patient(String name, int age, int oxyl, int hrctr)
	{
		p_name = name;
		p_age = age;
		oxylvl = oxyl;
		HRCTreport = hrctr;
	}
	
	void display()
	{
		for(int i=0; i<20; i++, System.out.print("-"));
		System.out.println();
		System.out.println("patient name: " + p_name);
		System.out.println("patient age: " + p_age);
		System.out.println("patient oxygen level: " + oxylvl);
		System.out.println("patient HRCT report: " + HRCTreport);
	}
}


public class setA_q1 extends Exception
{
	public static void main(String args[])
	{
		String p_name;
		int p_age;
		int oxylvl;
		int hrct_report;
		int n;
			
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter how many patients: ");
		n = sc.nextInt();
		
		Patient p[] = new Patient[n];
			
		// take n reports
		for(int i = 0; i<n; i++)
		{
			System.out.println();
			System.out.println("Whats the patient name: ");
			sc.nextLine();
			p_name = sc.nextLine();
			
			System.out.println("Whats is the patient age: ");
			p_age = sc.nextInt();
			
			System.out.println("Whats is the patient oxygen level: ");
			oxylvl = sc.nextInt();
			
			System.out.println("Whats is the patient HRCT report: ");
			hrct_report = sc.nextInt();
			
			p[i] = new Patient(p_name, p_age, oxylvl, hrct_report);
		}
		
		try
		{
			for(int i=0; i<n; i++)
			{
				p[i].display();
				if(p[i].oxylvl < 95 && p[i].HRCTreport > 10)
					throw new NullPointerException("\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("The patien is covid posiive (+) and need treatment.");
		}
	}
}


				
			
			
