

import java.util.Scanner;
 public class a1sb_c
{
   public static void main(String args[])
   {
	int sum=0;
	int ch;
	 int r1,r2,c1,c2,i,j;
	 int m1[][],m2[][],m3[][];
	Scanner s=new Scanner(System.in);
	
	System.out.println("enter rows & colmn  of array 1:");
	r1=s.nextInt();
	c1=s.nextInt();
	 m3=new int[r1][c1];
			  m1=new int[r1][c1];
			  System.out.println("Enter array elements:");
			  for(i=0;i<r1;i++)
		 	   {
			     for(j=0;j<c1;j++)
			     {

				   m1[i][j]=s.nextInt();
			      }
			  }
			 System.out.println("enter rows & colmn  of array 2:");
			r2=s.nextInt();
			c2=s.nextInt();
			m2=new int[r2][c2];
			System.out.println("Enter array elements:");
			for(i=0;i<r2;i++)
		 	 {
			    for(j=0;j<c2;j++)
			     {

				   m2[i][j]=s.nextInt();
			      }
			  }

                      
	do
	{
	    System.out.println("1.Addition\n2.Multilication\n3.Transpose\n4.exit\nenter yur choice:");
	     ch=s.nextInt();
	    switch(ch)
	    {
		case 1:
			 
	
			  if((r1==r2) &&( c1==c2))
			{
                          
			   for(i=0;i<r1;i++)
				for(j=0;j<c1;j++)
					m3[i][j]=m1[i][j]+m2[i][j];
			}
			else
				System.out.println("Addition is not possible.");
  			System.out.println("Addition is :");			
			for(i=0;i<r1;i++)
			{
				for(j=0;j<c1;j++)
				{
					System.out.print(m3[i][j]+"\t");

				}
				System.out.println(" ");
		        }
                         break;
        case 2:
			if(c2==r1)
			{
				for(i=0;i<r1;i++)
				{
					for(j=0;j<c2;j++)
					{			   
						for(int k=0;k<r2;k++)
						{
							 sum+=m1[i][k]*m2[k][j];
						}
						m3[i][j]=sum;
						sum=0;
					}
				}
			}
			else
			   System.out.println("multiplication is not possible.");
  			System.out.println("Multiplication is :");			
			for(i=0;i<r1;i++)
			{
				for(j=0;j<c1;j++)
				{
					System.out.print(m3[i][j]+"\t");

				}
				System.out.println(" ");
		        }
                         break;
		
		case 3:System.out.println("Transpose is:");
			for(i=0;i<r1;i++)
			{
				for(j=0;j<c1;j++)
				{
					m3[j][i]=m1[i][j];
					

				}
				System.out.println(" ");
		        }
			for(i=0;i<r1;i++)
			{
				for(j=0;j<c1;j++)
				{
					System.out.print(m3[i][j]+" ");
					

				}
				System.out.println(" ");
		        }
                         break;	

            }
       }while(ch!=4);
}
}
