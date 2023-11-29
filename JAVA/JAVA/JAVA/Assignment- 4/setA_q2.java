import java.io.*;
import java.util.*;

public class setA_q2
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fis = new FileInputStream("sample.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int filesize = fis.available();
		
		for(int i=filesize-1; i>=0; i--)
		{
			bis.mark(i);
			bis.skip(i);
			char ch = (char)bis.read();
			System.out.print(Character.toUpperCase(ch));
			bis.reset();
		}
		bis.close();
	}
}
		
