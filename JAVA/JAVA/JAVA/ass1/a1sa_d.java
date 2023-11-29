
import java.util.Scanner;
 public class a1sa_d
{
   public static void main(String args[])
   {
	int n,i, a[];
	Scanner s=new Scanner(System.in);
	System.out.println("enter size of array:");
	n=s.nextInt();
	a=new int[n];
	System.out.println("Enter array elements:");
	for(i=0;i<n;i++)
	   a[i]=s.nextInt();
	System.out.println("Reverse array:");
	for(i=n-1;i>=0;i--)
	   System.out.print(a[i]+" ");
   }
}
