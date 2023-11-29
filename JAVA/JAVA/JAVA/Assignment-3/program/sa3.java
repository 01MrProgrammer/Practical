import java.util.Scanner;
interface operation
{
	final static double PI = 3.142;
	abstract void area();
	abstract void volume();
}
class cylinder implements operation
{
	double r,h;
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius ");
		r = sc.nextDouble();
		System.out.println("Enter height:");
		h = sc.nextDouble();
	}
	public void area()
	{
		double a = 2*((PI*r*h)+(PI*r*r));
		System.out.println("Area of Cylinder :"+a);
	}
	public void volume()
	{
		double v = PI*r*r*h;
		System.out.println("Volume of Cylinder :"+v);
	}
}
public class sa3
{
	public static void main(String args[])
	{
		cylinder c1 = new cylinder();
		c1.input();
		c1.area();
		c1.volume();
	}
}

