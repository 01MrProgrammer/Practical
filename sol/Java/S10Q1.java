
import java.io.*;
import java.util.*;
interface CubeNum
{
    int cube(int number);
}

public class S10Q1 
{
    public static void main(String args[])
    {
        int number;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Value: ");
        number=sc.nextInt();
        CubeNum CN = (n)-> n*n*n;
        int result=CN.cube(number);
        System.out.println("The Cube of a number is: "+result);
    }
}
