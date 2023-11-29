import java.util.Date;
import java.text.SimpleDateFormat;
class Q2
{
	public static void main(String args[])
	{
		SimpleDateFormat sd=new SimpleDateFormat("dd/mm/yyyy");
		String d1=sd.format (new Date());
		System.out.println("Date:"+d1);

		sd=new SimpleDateFormat("mm-dd-yyyy");
	        d1=sd.format (new Date());
		System.out.println("Date:"+d1);

		sd=new SimpleDateFormat("EEEEEEEEE MMMMM dd yyyy");
		d1=sd.format (new Date());
		System.out.println("Date:"+d1);
		
		sd=new SimpleDateFormat("EEE MMMMM dd HH : mm : ss z yyyy");
		d1=sd.format (new Date());
		System.out.println("Date & time:"+d1);

		sd=new SimpleDateFormat("dd/mm/yyyy HH : mm : ss a SSSZ");
		 d1=sd.format (new Date());
		System.out.println("Date & time:"+d1);

		sd=new SimpleDateFormat("HH:mm:ss");
		d1=sd.format (new Date());
		System.out.println("TIME:"+d1);

		sd=new SimpleDateFormat("w");
		d1=sd.format (new Date());
		System.out.println("current week:"+d1);
		
		sd=new SimpleDateFormat("W");
		d1=sd.format (new Date());
		System.out.println("Week of the month:"+d1);	
		
		sd=new SimpleDateFormat("D");
		d1=sd.format (new Date());
		System.out.println("dAY OF THE year:"+d1);
	}
}

