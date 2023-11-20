import student.*;
import java.util.*;

public class S10Q2
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Rollno: ");
        int rno=sc.nextInt();
        System.out.println("Enter the Class: ");
        sc.nextLine();
        String sclass=sc.nextLine();
        double totalmarks=0.0;
        for(int i=1;i<=6;i++)
        {
            System.out.println("Enter MArks for Subject "+i+":");
            float marks=sc.nextFloat();
            totalmarks=totalmarks+marks;
        }
        double perc=(totalmarks/600)*100;
        sc.close();
        studentinfo s=new studentinfo(rno,sclass,perc);
        s.display();
    }
}
