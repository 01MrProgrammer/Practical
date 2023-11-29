
import java.util.Scanner;
 public class a1sa_b
{
   public static void main(String args[])
   {
      int l,b,peri,area;
      Scanner sc=new Scanner(System.in);
      System.out.print("enter length:");
      l=sc.nextInt();
      System.out.print("enter breadth:");
      b=sc.nextInt();
      area=l*b;
      peri=2*(l+b);
      System.out.println("area is:"+area);
      System.out.println("perimeter is:"+peri);
   }
}
