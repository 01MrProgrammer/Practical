import java.io.*;
import java.util.*;

public class Q2
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fis=new FileInputStream("sample.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		System.out.println("File Content in Reverse Order: ");
		int size=fis.available();
		for(int i=size-1;i>=0;i--)
		{
			bis.mark(i);
			bis.skip(i);
			char c=(char)bis.read();
			System.out.print(Character.toUpperCase(c));
			bis.reset();
		}
		System.out.println();
		bis.close();
	}
}
