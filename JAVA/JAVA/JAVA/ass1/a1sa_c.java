

import java.util.Scanner;
 public class a1sa_c
{
   public static void main(String args[])
   {
        int ch,r,h;
        Scanner s=new Scanner(System.in);
	do
	  {
            System.out.println("1:volume\n2:factorial\n3:armstrong\n4:exit\nenter your choice:");
	    ch=s.nextInt();
            switch(ch)
 		{
                     case 1: System.out.println("enter radius:");
                             r=s.nextInt();
                             System.out.println("enter height:");
             		     h=s.nextInt();
                             double volume=3.14*r*r*h;
                             System.out.println("volume is:"+volume);
                             break;
           
                     case 2: 
                     System.out.println("enter number:");
                             int n=s.nextInt();    
                             int i=1,fact=1;
                             while(i<=n)
				{
				 fact*=i;
				 i++;
                                }
                             System.out.println("factorial of number = "+fact);
                             break;
                    case 3: System.out.println("enter number:");
                            n=s.nextInt(); 
                            int temp=n;
                            int sum=0,digit;
                            while(n>0)
                            {
                              digit=n%10;
                              sum+=(digit*digit*digit);
                              n/=10;
                            }
                            if(sum==temp)                         
                                System.out.println("number is armstrong.");
                            else
                                System.out.println("number is not armstrong.");
                           break;      
                   }
       }while(ch!=4);
   }
}
        
