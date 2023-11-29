import java.util.Scanner;
interface operation
{
  final static double PI=3.142;
  abstract void area();
  abstract void volume(); 
}

class cylinder implements operation
{
    float radius,height;
    public void input()
    {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the radius and Height: ");
	radius=sc.nextFloat();
	height=sc.nextFloat();
    }
	public void area()
	{
		double a=(2*PI*radius*height)+(2*PI*radius*radius);
 		
		System.out.println("Area Of Cylinder:"+a);
	}
	public void volume()
	{
		double v=PI*radius*height;
   		
		System.out.println("Volume Of Cylinder:"+v);
	
         }

}


public class seta_3
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
			cylinder c1=new cylinder();
			c1.input();
	                c1.area();
			c1.volume();
	}
}
