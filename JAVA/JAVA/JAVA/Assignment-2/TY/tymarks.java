package TY;
import java.util.Scanner;
public class tymarks
{
	public int tm,pm;
	public void get()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("\nenter total marks of theory out of 400 and practicals out of 200: ");
		tm=s.nextInt();
		pm=s.nextInt();
		
	}
}
