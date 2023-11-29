import P1.*;
import java.util.Scanner;
public class string
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first string:");
		String s1=sc.nextLine();
		System.out.println("enter second string:");
		String s2=sc.nextLine();
		con c1=new con();
		comp c2=new comp();
		c1.strcon(s1,s2);
		c2.strcomp(s1,s2);
	}
}

