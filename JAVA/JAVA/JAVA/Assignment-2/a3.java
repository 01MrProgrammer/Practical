import java.io.*;
import java.util.*;
public class a3
{
  public static void main(String args[])
  {
	int a[],i,j;
	Scanner sc=new Scanner(System.in);
	a=new int[5];
	for(i=0;i<5;i++)
	{
		a[i]=Integer.parseInt(args[i]);
	}
	System.out.println("Accepted array is:");
	for(i=0;i<5;i++)
	{
		System.out.println(a[i]+"\t");
	}
	for(i=1;i<=5;i++)
	{
		for(j=0;j<5-i;j++)
		{
			if(a[j]>a[j+1])
			{
				int t=a[j+1];
				a[j+1]=a[j];
				a[j]=t;
			}
		}
	}
	System.out.println("sorted array is:");
	for(i=0;i<5;i++)
	{
		System.out.println(a[i]+"\t");
	}
  }
}
		
	
