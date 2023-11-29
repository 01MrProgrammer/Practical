@FunctionalInterface
interface setAd1
{
	public void print(int num);
}
		public class setAd{
		public static void main(String args[])
		{
			setAd1 c1=(n)->{System.out.println("Cube="+n*n*n);};
			c1.print(3);
		}
 }
