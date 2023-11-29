import java.io.*;
import java.util.*;


public class setA_q3
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first file name: ");
		String file1 = sc.nextLine();
		
		System.out.println("Enter second file name: ");
		String file2 = sc.nextLine();
		
		FileReader src = new FileReader(file1);
		FileWriter target = new FileWriter(file2, true);
		
		int c;
		System.out.println("Copying .....");
		while((c = src.read()) != -1)
		{
			target.write(c);
		}
		src.close();
		target.close();
		System.out.println("End Of File");
	}
}
