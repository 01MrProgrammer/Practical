//SetA_Q4
import java.io.*;
import java.util.*;

interface Cubenum
{
	abstract void cube(int num);
}

class Cube implements Cubenum
{
	public void cube(int n)
	{
		System.out.println("Cube="+n*n*n);
	}
	public static void main(String args[])
	{
		Cube c=new Cube();
		c.cube(5);
	}
}
