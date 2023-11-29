import java.io.*;
import java.util.Scanner;
interface operation
{
	final static double PI=3.142;
	abstract void area();
	abstract void volume();
}
class cylinder implements operation
{
	double r,h;
	void input()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the radius:");
	r=sc.nextInt();
	System.out.println("enter the height:");
	h=sc.nextFloat();
}
	public void area()
	{
		double a=(2*PI*r*h)+(2*PI*r*r);
		System.out.println("area of cylinder:"+a);
	}
	public void volume()
	{
		double v=(PI*r*r*h);
		System.out.println("volume of the cylinder is:"+v);
	}
}
class setAc
{
	public static void main(String[] args)
	{
		cylinder C1=new cylinder();
		C1.input();
		C1.area();
		C1.volume();
	}
}
	
