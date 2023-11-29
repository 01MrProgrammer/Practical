import java.util.*;
import java.io.*;

@FunctionalInterface
interface cube
{
	int calculate(int x);
}

class sa4
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to find cube of: ");
		int x = sc.nextInt();
		cube c = (int n)->n*n*n;
		System.out.println("Cube: " + c.calculate(x));
	}
}
