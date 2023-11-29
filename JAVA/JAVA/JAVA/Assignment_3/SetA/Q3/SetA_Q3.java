import java.io.*;
import java.util.*;

interface Operation
{
	static double PI=3.142;
	abstract void area();
	abstract void volume();
}

class Cylinder implements Operation
{
	float r,h;
	void get()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the radius: ");
		r=sc.nextFloat();
		System.out.println("Enter the height: ");
		h=sc.nextFloat();
	}
	public void area()
	{
		double a=((2*PI*r*h)+(2*PI*r*r));	
		System.out.println("Area of Cylinder is: "+a);		
	}
	public void volume()
	{
		double v=(PI*r*r*h);
		System.out.println("Volume of Cylinder is: "+v);
	}
	
}

class SetA_Q3
{
	public static void main(String args[])
	{
		Cylinder c=new Cylinder();
		c.get();
		c.area();
		c.volume();
	}
}
	
