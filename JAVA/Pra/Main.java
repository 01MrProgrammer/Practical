import java.util.Date;
import java.text.SimpleDateFormat;
class Main{
    public static void main(String args[])
    {
        SimpleDateFormat sd=new SimpleDateFormat("dd/mm/yyyy");
        String d1=sd.format(new Date());
        System.out.println("Date:"+d1);

        sd=new SimpleDateFormat("dd-mm-yyyy");
        d1= sd.format(new Date());
        System.out.println("Date:"+d1);

        sd=new SimpleDateFormat("EEEEEEEEE MMMMM dd yyyy");
        d1=sd.format(new Date());
        System.out.println("Date:"+d1);

        sd= new SimpleDateFormat("EEE MMMMM dd HH:mm:ss z yyyy");
        d1=sd.format(new Date());
        System.out.println("Date:"+d1);

        sd= new SimpleDateFormat("dd/mm/yy HH:mm:ss a SSSZ");
        d1=sd.format(new Date());
        System.out.println("Date:"+d1);
    }
}