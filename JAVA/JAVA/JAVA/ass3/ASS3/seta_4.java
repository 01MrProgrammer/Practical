import java.util.*;
import java.io.*;
@FunctionalInterface
interface printNumber
{
void print(int n);
}
public class seta_4
{
public static void main(String args[])throws IOException
{
Scanner Scanner=new Scanner(System.in);
System.out.println("enter number to find :");
int inputNumber=Scanner.nextInt();
printNumber p =n->System.out.println("cube is:"+n*n*n);
p.print(inputNumber);
}
}

